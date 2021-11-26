package com.myBoard.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.myBoard.command.Criteria;
import com.myBoard.command.PageMaker;
import com.myBoard.command.SearchCriteria;
import com.myBoard.dto.MemberVO;

public class SearchMemberServiceImpl extends MemberServiceImpl {
	
	@Override
	public Map<String,Object> getMemberListPage(Criteria cri) throws Exception {	
		
		Map<String,Object> dataMap = null;
		SqlSession session = sqlSessionFactory.openSession(false);
		try {
			SearchCriteria searchCri = (SearchCriteria)cri;
			List<MemberVO> memberList = null;
			PageMaker pageMaker = null;
			
			memberList = memberDAO.selectSearchMemberList(session, searchCri);
			pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(memberDAO.getSearchTotalCount(session, searchCri));
			
			dataMap = new HashMap<>();
			dataMap.put("memberList", memberList);
			dataMap.put("pageMaker", pageMaker);
			
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
			//...
			throw e;
		}finally {
			session.close();
		}
		
		return dataMap;
	}

	@Override
	public MemberVO getMember(String id) throws Exception {
		SqlSession session = sqlSessionFactory.openSession(false);
		
		try {
			MemberVO member = memberDAO.selectMemberById(session, id);
			return member;
		} finally {
			session.close();
		}
		
	}
	
}
