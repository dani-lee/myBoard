package com.myBoard.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.myBoard.command.SearchCriteria;
import com.myBoard.dto.NoticeVO;

public class NoticeDAOImpl implements NoticeDAO{

	@Override
	public List<NoticeVO> selectNoticeList(SqlSession session, SearchCriteria cri) throws Exception {
		int offset = cri.getStartRowNum();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset,limit);
		
		List<NoticeVO> noticeList = session.selectList("Notice-Mapper.selectNoticeList", cri, rowBounds);
		
		return noticeList;
	}

	@Override
	public int selectNoticeListCount(SqlSession session) throws Exception {
		int totalCount = session.selectOne("Notice-Mapper.selectNoticeListCount");
		return totalCount;
	}

	@Override
	public List<NoticeVO> selectPointNotice(SqlSession session) throws Exception {
		List<NoticeVO> pointList = session.selectList("Notice-Mapper.selectPointNotice");
		return pointList;
	}

}
