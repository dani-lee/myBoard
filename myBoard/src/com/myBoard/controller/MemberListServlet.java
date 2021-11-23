package com.myBoard.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSessionFactory;

import com.myBoard.command.Criteria;
import com.myBoard.command.SearchCriteria;
import com.myBoard.dao.MemberDAO;
import com.myBoard.dao.MemberDAOImpl;
import com.myBoard.dataSource.OracleMyBatisSqlSessionFactory;
import com.myBoard.exception.NotNumberException;
import com.myBoard.service.MemberService;
import com.myBoard.service.MemberServiceImpl;
import com.myBoard.service.SearchMemberServiceImpl;


public class MemberListServlet extends HttpServlet {
    
	private MemberService memberService;
	
	{
		memberService = new SearchMemberServiceImpl();
		SqlSessionFactory factory = new OracleMyBatisSqlSessionFactory();
		MemberDAO memberDAO = new MemberDAOImpl();
		((MemberServiceImpl)memberService).setSqlSessionFactory(factory);
		((MemberServiceImpl)memberService).setMemberDAO(memberDAO);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "/member/memberList.jsp";
		
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
			
			Map<String,Object> dataMap = memberService.getMemberListPage(cri);
			request.setAttribute("dataMap", dataMap);
			
		}catch(NotNumberException e) {
			request.setAttribute("exception", e);
			url = "/error/message.jsp";
		
		} catch (Exception e) {
			url = "/error/500.jsp";
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
