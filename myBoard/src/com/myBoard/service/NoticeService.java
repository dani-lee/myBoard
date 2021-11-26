package com.myBoard.service;

import java.util.Map;

import com.myBoard.command.SearchCriteria;

public interface NoticeService {

//	public List<NoticeVO> getNoticeList(Criteria cri) throws Exception;
	public Map<String,Object> getNoticeListPage(SearchCriteria cri) throws Exception;
}
