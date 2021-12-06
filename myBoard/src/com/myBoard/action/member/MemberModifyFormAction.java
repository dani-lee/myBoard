package com.myBoard.action.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myBoard.action.Action;
import com.myBoard.dto.MemberVO;
import com.myBoard.service.MemberServiceForModify;

public class MemberModifyFormAction implements Action {

	private MemberServiceForModify memberServiceForModify;
	public void setMemberService(MemberServiceForModify memberServiceForModify) {
		this.memberServiceForModify = memberServiceForModify;
	}

	
	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		String url = "/member/modify";

		String id = request.getParameter("id");

		try {
			MemberVO member = memberServiceForModify.getMember(id);
			request.setAttribute("member", member);

			request.getRequestDispatcher(url).forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			response.sendError(response.SC_INTERNAL_SERVER_ERROR);
			url = null;
		}
		
		return url;
	}

}
