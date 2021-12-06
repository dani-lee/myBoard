package com.myBoard.service;

import org.apache.ibatis.session.SqlSession;

import com.myBoard.dto.MemberVO;
import com.myBoard.exception.InvaildPasswordException;
import com.myBoard.exception.NotFoundIDException;

public class MemberServiceForModifyImpl extends SearchMemberServiceImpl implements MemberServiceForModify{

	@Override
	public void modifyMember(MemberVO member) throws Exception {
		SqlSession session = sqlSessionFactory.openSession(false);
		
		try {
			memberDAO.updateMember(session, member);
			
			session.commit();
		} finally {
			session.close();
		}
	}

	@Override
	public void removeMember(String id) throws Exception {
		SqlSession session = sqlSessionFactory.openSession(false);
		
		try {
			memberDAO.deleteMember(session, id);
			
			session.commit();
		} finally {
			session.close();
		}
	}

	@Override
	public void modifyEnabled(String id, int enabled) throws Exception {
		SqlSession session = sqlSessionFactory.openSession(false);
		
		try {
			memberDAO.enabledMember(session, id, enabled);
			
			session.commit();
		} finally {
			session.close();
		}
	}

	@Override
	public void login(String id, String pwd) throws NotFoundIDException, InvaildPasswordException, Exception {
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			MemberVO member = memberDAO.selectMemberById(session, id);
			if(member == null) throw new NotFoundIDException();
			if(!pwd.equals(member.getPwd())) throw new InvaildPasswordException();
		} finally {
			session.close();
		}
		
	}
}
