package com.myBoard.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.myBoard.dao.MemberDAO;
import com.myBoard.dto.MemberVO;
import com.myBoard.dto.PagingVO;

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

	@Override
	public List<MemberVO> getAllMember(PagingVO pagingVO) throws Exception {
		SqlSession session = sqlSessionFactory.openSession(false);
		
		List<MemberVO> memberList = new ArrayList<MemberVO>();
		
		try {
			memberList = memberDAO.getAllMember(session, pagingVO);
			
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
	public int getTotalCount() throws Exception {
		SqlSession session = sqlSessionFactory.openSession(false);
		
		int totalCount = 0;
		
		try {
			totalCount = memberDAO.getTotalCount(session);
			
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
			//...
			throw e;
		}finally {
			session.close();
		}
		
		return totalCount;
	}

	@Override
	public int insertMember(MemberVO memberVO) throws Exception {
		SqlSession session = sqlSessionFactory.openSession(false);
		
		int cnt = 0;
		
		try {
			cnt = memberDAO.insertMember(session, memberVO);
			
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
			//...
			throw e;
		}finally {
			session.close();
		}
		
		return cnt;
	}

	@Override
	public MemberVO getDetailMember(String id) throws Exception {
		SqlSession session = sqlSessionFactory.openSession(false);
		
		MemberVO memberVO = new MemberVO();
		
		try {
			memberVO = memberDAO.getDetailMember(session, id);
			
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
			//...
			throw e;
		}finally {
			session.close();
		}
		
		return memberVO;
	}

	@Override
	public int deleteMember(String id) throws Exception {
		SqlSession session = sqlSessionFactory.openSession(false);
		
		int cnt = 0;
		
		try {
			cnt = memberDAO.deleteMember(session, id);
			
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
			//...
			throw e;
		}finally {
			session.close();
		}
		
		return cnt;
	}

	@Override
	public int updateMember(MemberVO memberVO) throws Exception {
		SqlSession session = sqlSessionFactory.openSession(false);
		
		int cnt = 0;
		
		try {
			cnt = memberDAO.updateMember(session, memberVO);
			
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
			//...
			throw e;
		}finally {
			session.close();
		}
		
		return cnt;
	}

	@Override
	public List<MemberVO> searchMember(MemberVO memberVO) throws Exception {
		SqlSession session = sqlSessionFactory.openSession(false);
		
		List<MemberVO> searchList = new ArrayList<MemberVO>();
		
		try {
			searchList = memberDAO.searchMember(session, memberVO);
			
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
			//...
			throw e;
		}finally {
			session.close();
		}
		
		return searchList;
	}

	
}
