package com.myBoard.dao;

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



	
}
