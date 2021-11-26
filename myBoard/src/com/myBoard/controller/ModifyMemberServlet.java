package com.myBoard.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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


@WebServlet("/updatemember")
public class ModifyMemberServlet extends HttpServlet{
	
	private MemberService memberService;
	
	{
		memberService = new SearchMemberServiceImpl();
		SqlSessionFactory factory = new OracleMyBatisSqlSessionFactory();
		MemberDAO memberDAO = new MemberDAOImpl();
		((MemberServiceImpl)memberService).setSqlSessionFactory(factory);
		((MemberServiceImpl)memberService).setMemberDAO(memberDAO);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		
		
		MemberVO vo = null;
		try {
//			vo = memberService.getDetailMember(id);
			req.setAttribute("member", vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		req.getRequestDispatcher("/member/UpdateMember.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		MemberVO memberVO = new MemberVO();
		
		try {
			DateTimeConverter dtConverter = new DateConverter();
			dtConverter.setPattern("yyyy-MM-dd");
			ConvertUtils.register(dtConverter, Date.class);
			
			BeanUtils.populate(memberVO, req.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		
		int cnt;
		try {
			cnt = memberService.modifyMember(memberVO);
			
			String redirectUrl = req.getContextPath() + "/memberlist";
			
			if(cnt > 0) {
				resp.sendRedirect(redirectUrl);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
