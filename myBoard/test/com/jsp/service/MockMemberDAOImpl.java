package com.jsp.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

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

	

}