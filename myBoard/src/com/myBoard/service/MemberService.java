package com.myBoard.service;

import java.util.List;
import java.util.Map;

import com.myBoard.command.Criteria;
import com.myBoard.dto.MemberVO;

public interface MemberService {

//	public List<MemberVO> getMemberList() throws Exception;
	
	//회원 리스트
	public List<MemberVO> getMemberList(Criteria cri) throws Exception;
	//페이지
	public Map<String,Object> getMemberListPage(Criteria cri) throws Exception;
	
	//id중복체크 && 상세정보 조회
	public MemberVO getMember(String id) throws Exception;
	
	//회원등록
	public void registMember(MemberVO member) throws Exception;
	
	//회원정보 수정
	public void modifyMember(MemberVO member) throws Exception;
	
	//회원삭제
	public void removeMember(String id) throws Exception;
	
	//활성화&비활성화
	public void modifyEnabled(String id, int enabled) throws Exception;
	
	
	
}
