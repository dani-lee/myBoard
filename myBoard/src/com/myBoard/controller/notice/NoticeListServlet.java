package com.myBoard.controller.notice;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSessionFactory;

import com.myBoard.command.SearchCriteria;
import com.myBoard.dao.NoticeDAO;
import com.myBoard.dao.NoticeDAOImpl;
import com.myBoard.dataSource.OracleMyBatisSqlSessionFactory;
import com.myBoard.exception.NotNumberException;
import com.myBoard.service.NoticeService;
import com.myBoard.service.NoticeServiceImpl;


@WebServlet("/notice/list")
public class NoticeListServlet extends HttpServlet {

	private NoticeService noticeService;
	
	{
		noticeService = new NoticeServiceImpl();
		SqlSessionFactory factory = new OracleMyBatisSqlSessionFactory();
		NoticeDAO noticeDAO = new NoticeDAOImpl();
		((NoticeServiceImpl)noticeService).setSqlSessionFactory(factory);
		((NoticeServiceImpl)noticeService).setNoticeDAO(noticeDAO);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "/notice/noticeList.jsp";
		
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
			
			Map<String,Object> dataMap = noticeService.getNoticeListPage(cri);
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
