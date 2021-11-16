package com.myBoard.service;

import java.util.List;

import com.myBoard.dto.MemberVO;

public interface MemberService {

	public List<MemberVO> getMemberList() throws Exception;
}
