package com.myBoard.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.myBoard.dto.MemberVO;
import com.myBoard.dto.PagingVO;

public class MemberDAOImpl implements MemberDAO {

	@Override
	public List<MemberVO> selectMemberList(SqlSession session) throws Exception {

		List<MemberVO> memberList = session.selectList("Member-Mapper.selectMemberList");
				
		return memberList;
	}

	@Override
	public List<MemberVO> getAllMember(SqlSession session, PagingVO pagingVO) throws Exception {
		List<MemberVO> memberList = session.selectList("Member-Mapper.getAllMember", pagingVO);
		return memberList;
	}

	@Override
	public int getTotalCount(SqlSession session) throws Exception {
		int totalCount = session.selectOne("Member-Mapper.getTotalCount");
		return totalCount;
	}

	@Override
	public int insertMember(SqlSession session, MemberVO memberVO) throws Exception {
		int cnt = session.insert("Member-Mapper.insertMember", memberVO);
		return cnt;
	}

	@Override
	public MemberVO getDetailMember(SqlSession session, String id) throws Exception {
		MemberVO memberVO = session.selectOne("Member-Mapper.getDetailMember", id);
		return memberVO;
	}

	@Override
	public int deleteMember(SqlSession session, String id) throws Exception {
		int cnt = session.delete("Member-Mapper.deleteMember", id);
		return cnt;
	}

	@Override
	public int updateMember(SqlSession session, MemberVO memberVO) throws Exception {
		int cnt = session.update("Member-Mapper.updateMember", memberVO);
		return cnt;
	}

	@Override
	public List<MemberVO> searchMember(SqlSession session, MemberVO memberVO) throws Exception {
		List<MemberVO> searchList = session.selectList("Member-Mapper.searchMember", memberVO);
		return searchList;
	}

	
}
