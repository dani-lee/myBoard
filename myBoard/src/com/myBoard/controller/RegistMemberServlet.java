package com.myBoard.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.tribes.util.Arrays;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DateTimeConverter;
import org.apache.ibatis.session.SqlSessionFactory;

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
		
		String url = "";
		
		MemberVO member = new MemberVO();
		
		String result = "";
		
		response.setContentType("texp/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		try {
			
			
			BeanUtils.populate(member, request.getParameterMap());
			
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		System.out.println(request.getParameter("id"));
		System.out.println(request.getParameter("pwd"));
		System.out.println(request.getParameter("name"));
		System.out.println(request.getParameter("picture"));
		System.out.println(request.getParameterValues("phone")[0]);
		System.out.println(request.getParameterValues("phone")[1]);
		System.out.println(request.getParameterValues("phone")[2]);
		
		
		String phone1 = request.getParameterValues("phone")[0];
		String phone2 = request.getParameterValues("phone")[1];
		String phone3 = request.getParameterValues("phone")[2];
		
		String phone = phone1 + "-" + phone2 + "-" + phone3;
		
		member.setPhone(phone);
		try {
			int cnt = memberService.registMember(member);
			if(cnt > 0) {
				result = "SUCCESS";
				out.print(result);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			response.sendError(response.SC_INTERNAL_SERVER_ERROR);
		}finally {
			out.close();
		}
		
		
	}
	/*DateTimeConverter dtConverter = new DateConverter();
	dtConverter.setPattern("yyyy-MM-dd");
	ConvertUtils.register(dtConverter, Date.class);*/
}