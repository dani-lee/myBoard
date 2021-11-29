package com.myBoard.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.myBoard.command.Criteria;
import com.myBoard.command.PageMaker;
import com.myBoard.command.SearchCriteria;
import com.myBoard.dao.NoticeDAO;
import com.myBoard.dto.MemberVO;
import com.myBoard.dto.NoticeVO;

public class NoticeServiceImpl implements NoticeService{

	protected SqlSessionFactory sqlSessionFactory;
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	protected NoticeDAO noticeDAO;
	public void setNoticeDAO(NoticeDAO noticeDAO) {
		this.noticeDAO = noticeDAO;
	}
	
	@Override
	public Map<String, Object> getNoticeListPage(SearchCriteria cri) throws Exception {
		Map<String,Object> dataMap = null;
		SqlSession session = sqlSessionFactory.openSession(false);
		try {
			List<NoticeVO> noticeList = null;
			List<NoticeVO> pointList = null;
			PageMaker pageMaker = null;
			
			noticeList = noticeDAO.selectNoticeList(session, cri);
			pointList = noticeDAO.selectPointNotice(session);
			pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(noticeDAO.selectNoticeListCount(session));
			
			dataMap = new HashMap<>();
			dataMap.put("noticeList", noticeList);
			dataMap.put("pointList", pointList);
			dataMap.put("pageMaker", pageMaker);
			
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
			//...
			throw e;
		}finally {
			session.close();
		}
		
		return dataMap;
	}

	@Override
	public NoticeVO getNotice(int nno) throws Exception {
		SqlSession session = sqlSessionFactory.openSession(false);
		
		try {
			NoticeVO notice = noticeDAO.selectNoticeByNno(session, nno);
			return notice;
		} finally {
			session.close();
		}
		
	}

}
