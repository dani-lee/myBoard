package com.myBoard.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.myBoard.dto.MemberVO;

public interface MemberDAO {

	List<MemberVO> selectMemberList(SqlSession session) throws Exception;
}
