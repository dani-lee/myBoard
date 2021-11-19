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

@WebServlet("/search")
public class SearchMember extends HttpServlet {
	
	private MemberService memberService;
	
	{
		memberService = new MemberServiceImpl();
		SqlSessionFactory factory = new OracleMyBatisSqlSessionFactory();
		MemberDAO memberDAO = new MemberDAOImpl();
		((MemberServiceImpl)memberService).setSqlSessionFactory(factory);
		((MemberServiceImpl)memberService).setMemberDAO(memberDAO);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		int pageNo = req.getParameter("pageNo") == null ? 1 : Integer.parseInt(req.getParameter("pageNo"));
		
		String searchType = req.getParameter("searchType");
		String keyword = req.getParameter("keyword");
		MemberVO memberVO = new MemberVO();
		
		System.out.println(searchType);
		System.out.println(keyword);
		
	
		if(searchType.equals("id")) {
			memberVO.setId(keyword);
		}else if(searchType.equals("name")){
			memberVO.setName(keyword);
		}else if(searchType.equals("phone")){
			memberVO.setPhone(keyword);
		}else if(searchType.equals("email")){
			memberVO.setEmail(keyword);
		}
		
		List<MemberVO> searchList;
		try {
			searchList = memberService.searchMember(memberVO);
			
			int totalCnt = memberService.getTotalCount();
			PagingVO pagingVo = new PagingVO();
			pagingVo.setCountPerPage(10);
			pagingVo.setCurrentPageNo(pageNo);
			pagingVo.setPageSize(10);
			pagingVo.setTotalCount(totalCnt);
			
			req.setAttribute("searchList", searchList);
			req.setAttribute("pagingVo", pagingVo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		req.getRequestDispatcher("/member/SearchMember.jsp").forward(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
