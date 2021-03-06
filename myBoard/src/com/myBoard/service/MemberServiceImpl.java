package com.myBoard.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.myBoard.command.Criteria;
import com.myBoard.command.PageMaker;
import com.myBoard.dao.MemberDAO;
import com.myBoard.dto.MemberVO;

public abstract class MemberServiceImpl implements MemberService {

	protected SqlSessionFactory sqlSessionFactory;
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	protected MemberDAO memberDAO;
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	@Override
	public List<MemberVO> getMemberList(Criteria cri) throws Exception {
		SqlSession session = sqlSessionFactory.openSession(false);
		
		List<MemberVO> memberList = new ArrayList<MemberVO>();
		
		try {
			memberList = memberDAO.selectMemberList(session, cri);
			
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
			//...
			throw e;
		}finally {
			session.close();
		}
		
		return memberList;
	}

	@Override
	public Map<String,Object> getMemberListPage(Criteria cri) throws Exception {	
		
		Map<String,Object> dataMap = null;
		SqlSession session = sqlSessionFactory.openSession(false);
		try {
			List<MemberVO> memberList = null;
			PageMaker pageMaker = null;
			
			memberList = memberDAO.selectMemberList(session, cri);
			pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(memberDAO.selectMemberListCount(session));
			
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
	public abstract MemberVO getMember(String id) throws Exception;


	
}
