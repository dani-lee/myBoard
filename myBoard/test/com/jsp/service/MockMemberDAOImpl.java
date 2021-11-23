package com.jsp.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.myBoard.command.Criteria;
import com.myBoard.dao.MemberDAO;
import com.myBoard.dto.MemberVO;

public class MockMemberDAOImpl implements MemberDAO{

	@Override
	public List<MemberVO> selectMemberList(SqlSession session) throws Exception {
		
		List<MemberVO> memberList = new ArrayList<>();
		
		for(int i = 0; i < 10; i++) {
			memberList.add(new MemberVO("kk"+i, "kk"+i));
		}
		return memberList;
	}

	@Override
	public int getTotalCount(SqlSession session) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertMember(SqlSession session, MemberVO memberVO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MemberVO getDetailMember(SqlSession session, String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteMember(SqlSession session, String id) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateMember(SqlSession session, MemberVO memberVO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<MemberVO> searchMember(SqlSession session, MemberVO memberVO) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MemberVO> selectMemberList(SqlSession session, Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MemberVO> searchMember(SqlSession session, MemberVO memberVO, Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	

}
