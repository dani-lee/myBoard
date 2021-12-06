package com.myBoard.action.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myBoard.action.Action;

public class MemberRegistFormAction implements Action {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String url = "/member/regist";
		
		return url;
	}

}
