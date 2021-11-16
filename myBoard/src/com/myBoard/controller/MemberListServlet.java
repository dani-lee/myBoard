package com.myBoard.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSessionFactory;

import com.myBoard.dao.MemberDAO;
import com.myBoard.dao.MemberDAOImpl;
import com.myBoard.dataSource.OracleMyBatisSqlSessionFactory;
import com.myBoard.dto.MemberVO;
import com.myBoard.service.MemberService;
import com.myBoard.service.MemberServiceImpl;


public class MemberListServlet extends HttpServlet {
       
	private MemberService memberService;
	
	{
		memberService = new MemberServiceImpl();
		SqlSessionFactory factory = new OracleMyBatisSqlSessionFactory();
		MemberDAO memberDAO = new MemberDAOImpl();
		((MemberServiceImpl)memberService).setSqlSessionFactory(factory);
		((MemberServiceImpl)memberService).setMemberDAO(memberDAO);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "/member/list.jsp";
		try {
			List<MemberVO> memberList = memberService.getMemberList();
			request.setAttribute("memberList", memberList);
			
		} catch (Exception e) {
			url = "/error/500.jsp";
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
