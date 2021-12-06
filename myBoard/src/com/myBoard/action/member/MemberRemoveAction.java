package com.myBoard.action.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myBoard.action.Action;
import com.myBoard.service.MemberServiceForModify;

public class MemberRemoveAction implements Action {
	
	private MemberServiceForModify memberServiceForModify;
	public void setMemberService(MemberServiceForModify memberServiceForModify) {
		this.memberServiceForModify = memberServiceForModify;
	}

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String url = null;
		
		String id = request.getParameter("id");
		
		try {
			memberServiceForModify.removeMember(id);
			
			response.setContentType("text/html;charset=utf-8;");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('"+id+"님이 삭제되었습니다.');");
			out.println("window.opener.location.href='"+request.getContextPath()+"/member/list';");
			out.println("window.close();");
			out.println("</script>");
			
			
		} catch (Exception e) {
			e.printStackTrace();
			response.sendError(response.SC_INTERNAL_SERVER_ERROR);
			url = null;
		}
		
		return url;
	}

}
