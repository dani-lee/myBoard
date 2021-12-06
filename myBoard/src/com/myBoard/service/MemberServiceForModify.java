package com.myBoard.service;

import com.myBoard.dto.MemberVO;
import com.myBoard.exception.InvaildPasswordException;
import com.myBoard.exception.NotFoundIDException;

public interface MemberServiceForModify extends MemberService{
	
	public void modifyMember(MemberVO member) throws Exception;

	public void removeMember(String id) throws Exception;
	
	public void modifyEnabled(String id, int enabled) throws Exception;

	//회원 로그인
	public void login(String id, String pwd) throws NotFoundIDException, InvaildPasswordException, Exception;
	
}
