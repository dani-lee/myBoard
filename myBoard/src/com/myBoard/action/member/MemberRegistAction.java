package com.myBoard.action.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myBoard.action.Action;
import com.myBoard.command.MemberRegistCommand;
import com.myBoard.controller.HttpRequestParameterAdapter;
import com.myBoard.dto.MemberVO;
import com.myBoard.service.MemberService;

public class MemberRegistAction implements Action {

	private MemberService memberService;
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		String url = "/member/regist_success";
		
		MemberVO member = null;
		
		try {
			MemberRegistCommand registData = (MemberRegistCommand) HttpRequestParameterAdapter.execute(request, MemberRegistCommand.class);
			member = registData.toMemberVO();
			memberService.registMember(member);
			
			request.setAttribute("member", member);
		
		} catch (Exception e) {
			e.printStackTrace();
			url = "/member/regist_fail.jsp";
		}
		
		return url;
	}

}
