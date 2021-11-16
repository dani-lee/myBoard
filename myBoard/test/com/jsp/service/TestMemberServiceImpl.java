package com.jsp.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.myBoard.dto.MemberVO;
import com.myBoard.service.MemberService;
import com.myBoard.service.MemberServiceImpl;

public class TestMemberServiceImpl {

	private MemberService memberService = new MemberServiceImpl();
	{
		((MemberServiceImpl)memberService).setMemberDAO(new MockMemberDAOImpl());
	}
	
	@Test
	public void testGetMemberList()	throws Exception{
		List<MemberVO> memberList = memberService.getMemberList();
		
		Assert.assertEquals(10, memberList.size());
		Assert.assertEquals("kk0", memberList.get(0).getId());
	}
}
	