package com.myBoard.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.myBoard.command.Criteria;
import com.myBoard.command.SearchCriteria;
import com.myBoard.dto.MemberVO;

public class MemberDAOImpl implements MemberDAO {

	@Override
	public List<MemberVO> selectMemberList(SqlSession session, Criteria cri) throws Exception {
		int offset = cri.getStartRowNum();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset,limit);
		
		List<MemberVO> memberList = session.selectList("Member-Mapper.selectMemberList", cri,rowBounds);
		return memberList;
	}

	@Override
	public int selectMemberListCount(SqlSession session) throws Exception {
		int totalCount = session.selectOne("Member-Mapper.selectMemberListCount");
		return totalCount;
	}

	
	@Override
	public List<MemberVO> selectSearchMemberList(SqlSession session, SearchCriteria cri) throws Exception {
		int offset = cri.getStartRowNum();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset,limit);
		
		List<MemberVO> memberList = session.selectList("Member-Mapper.selectSearchMemberList", cri, rowBounds);
		return memberList;
	}

	@Override
	public int getSearchTotalCount(SqlSession session, SearchCriteria cri) throws Exception {
		int totalCount = session.selectOne("Member-Mapper.selectSearchMemberListCount", cri);
		return totalCount;
	}
	
	
	@Override
	public MemberVO selectMemberById(SqlSession session, String id) throws Exception {
		MemberVO member = session.selectOne("Member-Mapper.selectMemberById",id);
		return member;
	}

	
	
	@Override
	public void insertMember(SqlSession session, MemberVO member) throws Exception {
		session.insert("Member-Mapper.insertMember", member);
	}


	@Override
	public int deleteMember(SqlSession session, String id) throws Exception {
		int cnt = session.delete("Member-Mapper.deleteMember", id);
		return cnt;
	}

	@Override
	public void updateMember(SqlSession session, MemberVO member) throws SQLException {
		session.update("Member-Mapper.updateMember", member);
	}




	
}
