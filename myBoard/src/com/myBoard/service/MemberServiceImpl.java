package com.myBoard.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.myBoard.dao.MemberDAO;
import com.myBoard.dto.MemberVO;

public class MemberServiceImpl implements MemberService {

	private SqlSessionFactory sqlSessionFactory;
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	private MemberDAO memberDAO;
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	@Override
	public List<MemberVO> getMemberList() throws Exception {
		
		SqlSession session = sqlSessionFactory.openSession(false);
		
		List<MemberVO> memberList = new ArrayList<MemberVO>();
		
		try {
			memberList = memberDAO.selectMemberList(session);
			
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

}
