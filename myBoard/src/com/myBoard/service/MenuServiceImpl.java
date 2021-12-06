package com.myBoard.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.myBoard.dao.MenuDAO;
import com.myBoard.dto.MenuVO;

public class MenuServiceImpl implements MenuService {

	private MenuDAO menuDAO;// = new MenuDAOImpl();

	public void setMenuDAO(MenuDAO menuDAO) {
		this.menuDAO = menuDAO;
	}

	private SqlSessionFactory sqlSessionFactory;// = new OracleMyBatisSqlSessionFactory();

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public List<MenuVO> getMainMenuList() throws SQLException {

		List<MenuVO> menuList = null;
		SqlSession session = sqlSessionFactory.openSession();
		try {
			menuList = menuDAO.selectMainMenu(session);
		} finally {
			session.close();
		}

		return menuList;
	}

	@Override
	public List<MenuVO> getSubMenuList(String mCode) throws SQLException {

		List<MenuVO> menuList = null;
		SqlSession session = sqlSessionFactory.openSession();
		try {
			menuList = menuDAO.selectSubMenu(session, mCode);
		} finally {
			session.close();
		}

		return menuList;
	}

	@Override
	public MenuVO getMenuByMcode(String mCode) throws SQLException {
		MenuVO menu = null;

		SqlSession session = sqlSessionFactory.openSession();
		try {
			menu = menuDAO.selectMenuByMcode(session, mCode);
		} finally {
			session.close();
		}

		return menu;
	}

	@Override
	public MenuVO getMenuByMname(String mName) throws SQLException {
		MenuVO menu = null;

		SqlSession session = sqlSessionFactory.openSession();
		try {
			menu = menuDAO.selectMenuByMname(session, mName);
		} finally {
			session.close();
		}

		return menu;
	}
	
}
