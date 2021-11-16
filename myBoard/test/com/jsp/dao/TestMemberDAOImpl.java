package com.jsp.dao;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.myBoard.dao.MemberDAO;
import com.myBoard.dao.MemberDAOImpl;
import com.myBoard.dataSource.OracleMyBatisSqlSessionFactory;
import com.myBoard.dto.MemberVO;


public class TestMemberDAOImpl {
	
	private SqlSessionFactory sqlSessionFactory = new OracleMyBatisSqlSessionFactory();
	private MemberDAO memberDAO = new MemberDAOImpl();
	private SqlSession session;
	
	{
		String config = "com/jsp/myBatis/config/sqlConfig.xml";
		
		try {
			Reader reader = Resources.getResourceAsReader(config);
			
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
			
			System.out.println("sqlSesscionFactory 성공");
		} catch (Exception e) {
			System.out.println("sqlSesscionFactory 실패");
		}
		
	}
	
	@Before
	public void initSqlSession() {
		session = sqlSessionFactory.openSession();
	}
	
	@Test
	public void testSelectMemberList() throws Exception{
		List<MemberVO> memberList = memberDAO.selectMemberList(session);
		
		Assert.assertEquals(7, memberList.size());
	}

	@After
	public void closeSqlSession() {
		session.close();
	}
}
