package com.myBoard.service;

import java.util.List;

import com.myBoard.dto.MemberVO;
import com.myBoard.dto.PagingVO;

public interface MemberService {

	public List<MemberVO> getMemberList() throws Exception;
	
	//회원 리스트
	public List<MemberVO> getAllMember(PagingVO pagingVO) throws Exception;
	//전체회원수 조회
	public int getTotalCount() throws Exception;
	
	//회원등록
	public int insertMember(MemberVO memberVO) throws Exception;
	
	//상세정보 조회
	public MemberVO getDetailMember(String id) throws Exception;
	
	//회원삭제
	public int deleteMember(String id) throws Exception;
	
	//회원정보 수정
	public int updateMember(MemberVO memberVO) throws Exception;
	
	//검색
	public List<MemberVO> searchMember(MemberVO memberVO) throws Exception;
}
