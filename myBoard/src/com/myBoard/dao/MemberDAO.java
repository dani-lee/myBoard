package com.myBoard.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.myBoard.dto.MemberVO;
import com.myBoard.dto.PagingVO;

public interface MemberDAO {

	List<MemberVO> selectMemberList(SqlSession session) throws Exception;
	
	//회원 리스트
	public List<MemberVO> getAllMember(SqlSession session,PagingVO pagingVO) throws Exception;
	//전체회원수 조회
	public int getTotalCount(SqlSession session) throws Exception;
	
	//회원등록
	public int insertMember(SqlSession session, MemberVO memberVO) throws Exception;
	
	//상세정보 조회
	public MemberVO getDetailMember(SqlSession session, String id) throws Exception;
	
	//회원삭제
	public int deleteMember(SqlSession session,String id) throws Exception;
	
	//회원정보 수정
	public int updateMember(SqlSession session,MemberVO memberVO) throws Exception;
	
	//검색
	public List<MemberVO> searchMember(SqlSession session, MemberVO memberVO) throws Exception;
}
