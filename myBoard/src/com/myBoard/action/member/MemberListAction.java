package com.myBoard.action.member;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myBoard.action.Action;
import com.myBoard.command.SearchCriteria;
import com.myBoard.exception.NotNumberException;
import com.myBoard.service.MemberService;

public class MemberListAction implements Action {

	private MemberService memberService;
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}


	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String url = "/member/list";
		
		String pageParam = request.getParameter("page");
		String perPageNumParam = request.getParameter("perPageNum"); 
		String searchType = request.getParameter("searchType");
		String keyword = request.getParameter("keyword");
		
		try {
			SearchCriteria cri = null;
			if(pageParam != null && perPageNumParam != null) {
				cri = new SearchCriteria(pageParam, perPageNumParam, searchType, keyword);
			}else {
				cri = new SearchCriteria();
			}
			/*List<MemberVO> memberList = memberService.getMemberList(cri);
			request.setAttribute("memberList", memberList);*/
		
			Map<String,Object> dataMap = memberService.getMemberListPage(cri);
			request.setAttribute("dataMap", dataMap);
			
			//if(true) throw new IOException();
		
		}catch(NotNumberException e) {
			request.setAttribute("exception", e);
			url = "/error/message.jsp";
		
		} catch (Exception e) {
			//url = "/error/500.jsp";
			response.sendError(response.SC_INTERNAL_SERVER_ERROR);
		}
		
		
		return url;
		
	}

}
