package com.myBoard.service;

import java.util.Map;

import com.myBoard.command.SearchCriteria;
import com.myBoard.dto.NoticeForPrevNextVO;
import com.myBoard.dto.NoticeVO;

public interface NoticeService {

//	public List<NoticeVO> getNoticeList(Criteria cri) throws Exception;
	public Map<String,Object> getNoticeListPage(SearchCriteria cri) throws Exception;
	public NoticeVO getNotice(int nno) throws Exception;

	public NoticeForPrevNextVO getNotivePrevNextList(int nno) throws Exception;
}
