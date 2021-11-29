package com.myBoard.controller.notice;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSessionFactory;

import com.myBoard.dao.NoticeDAO;
import com.myBoard.dao.NoticeDAOImpl;
import com.myBoard.dataSource.OracleMyBatisSqlSessionFactory;
import com.myBoard.service.NoticeService;
import com.myBoard.service.NoticeServiceImpl;

@WebServlet("/notice/regist")
public class NoticeRegistServlet extends HttpServlet {
	
	private NoticeService noticeService;
	
	{
		noticeService = new NoticeServiceImpl();
		SqlSessionFactory factory = new OracleMyBatisSqlSessionFactory();
		NoticeDAO noticeDAO = new NoticeDAOImpl();
		((NoticeServiceImpl)noticeService).setSqlSessionFactory(factory);
		((NoticeServiceImpl)noticeService).setNoticeDAO(noticeDAO);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/notice/registNotice.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
