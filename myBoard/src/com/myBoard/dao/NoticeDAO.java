package com.myBoard.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.myBoard.command.SearchCriteria;
import com.myBoard.dto.NoticeVO;

public interface NoticeDAO {

	public List<NoticeVO> selectNoticeList(SqlSession session,SearchCriteria cri) throws Exception;
	public List<NoticeVO> selectPointNotice(SqlSession session) throws Exception;
	public int selectNoticeListCount(SqlSession session) throws Exception;
	public NoticeVO selectNoticeByNno(SqlSession session, int nno) throws Exception;
}
