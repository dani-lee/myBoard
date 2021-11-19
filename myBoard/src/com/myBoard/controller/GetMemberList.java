package com.myBoard.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSessionFactory;

import com.myBoard.dao.MemberDAO;
import com.myBoard.dao.MemberDAOImpl;
import com.myBoard.dataSource.OracleMyBatisSqlSessionFactory;
import com.myBoard.dto.MemberVO;
import com.myBoard.dto.PagingVO;
import com.myBoard.service.MemberService;
import com.myBoard.service.MemberServiceImpl;

@WebServlet("/memberlist")
public class GetMemberList extends HttpServlet{
	
	private MemberService memberService;
	
	{
		memberService = new MemberServiceImpl();
		SqlSessionFactory factory = new OracleMyBatisSqlSessionFactory();
		MemberDAO memberDAO = new MemberDAOImpl();
		((MemberServiceImpl)memberService).setSqlSessionFactory(factory);
		((MemberServiceImpl)memberService).setMemberDAO(memberDAO);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int pageNo = req.getParameter("pageNo") == null ? 1 : Integer.parseInt(req.getParameter("pageNo"));
		
		int totalCnt;
		
		String url = "/member/MemberList.jsp";
		
		try {
			totalCnt = memberService.getTotalCount();
			PagingVO pagingVo = new PagingVO();
			pagingVo.setCountPerPage(10);
			pagingVo.setCurrentPageNo(pageNo);
			pagingVo.setPageSize(10);
			pagingVo.setTotalCount(totalCnt);
			
			List<MemberVO> memberList = memberService.getAllMember(pagingVo);
			req.setAttribute("memberList", memberList);
			req.setAttribute("pagingVo", pagingVo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		req.getRequestDispatcher(url).forward(req, resp);
	}

}
