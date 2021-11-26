package com.myBoard.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSessionFactory;

import com.myBoard.command.MemberRegistCommand;
import com.myBoard.dao.MemberDAO;
import com.myBoard.dao.MemberDAOImpl;
import com.myBoard.dataSource.OracleMyBatisSqlSessionFactory;
import com.myBoard.dto.MemberVO;
import com.myBoard.service.MemberService;
import com.myBoard.service.MemberServiceImpl;
import com.myBoard.service.SearchMemberServiceImpl;

@WebServlet("/member/regist")
public class RegistMemberServlet extends HttpServlet{
	
	private MemberService memberService;
	
	{
		memberService = new SearchMemberServiceImpl();
		SqlSessionFactory factory = new OracleMyBatisSqlSessionFactory();
		MemberDAO memberDAO = new MemberDAOImpl();
		((MemberServiceImpl)memberService).setSqlSessionFactory(factory);
		((MemberServiceImpl)memberService).setMemberDAO(memberDAO);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/member/registMember.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "/member/regist_success.jsp";
		
		MemberVO member = null;
		
		try {
			MemberRegistCommand registData = (MemberRegistCommand) HttpRequestParameterAdapter.execute(request, MemberRegistCommand.class);
			member = registData.toMemberVO();
			
		}  catch (Exception e) {
			e.printStackTrace();
			response.sendError(response.SC_BAD_REQUEST);
			return;
		}
		
		try {
			memberService.registMember(member);
		} catch (Exception e) {
			e.printStackTrace();
			url = "/member/regist_fail.jsp";
		}
		
		request.getRequestDispatcher(url).forward(request, response);
		
	}
		
	/*DateTimeConverter dtConverter = new DateConverter();
	dtConverter.setPattern("yyyy-MM-dd");
	ConvertUtils.register(dtConverter, Date.class);*/
}