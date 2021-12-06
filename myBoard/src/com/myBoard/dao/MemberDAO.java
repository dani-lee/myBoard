package com.myBoard.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.myBoard.command.Criteria;
import com.myBoard.command.SearchCriteria;
import com.myBoard.dto.MemberVO;

public interface MemberDAO {
	
	//회원 리스트
//	List<MemberVO> selectMemberList(SqlSession session) throws Exception;
	public List<MemberVO> selectMemberList(SqlSession session,Criteria cri) throws Exception;
	//전체회원수 조회
	public int selectMemberListCount(SqlSession session) throws Exception;
	
	//검색
	public List<MemberVO> selectSearchMemberList(SqlSession session, SearchCriteria cri) throws Exception;
	//검색 리스트 회원수 조회
	public int getSearchTotalCount(SqlSession session, SearchCriteria cri) throws Exception;
	
	//id 중복체크 && 디테일
	public MemberVO selectMemberById(SqlSession session, String id) throws Exception;
	
	//회원등록
	public void insertMember(SqlSession session, MemberVO member) throws Exception;
	
	//회원정보 수정
	public void updateMember(SqlSession session, MemberVO member) throws SQLException;
	
	//회원삭제
	public void deleteMember(SqlSession session, String id) throws SQLException;
			
	//enabled 수정(활성화)
	public void enabledMember(SqlSession session, String id, int enabled) throws SQLException;
		
	
}
