package com.kh.app.board.service;

import java.io.InputStream;
import java.sql.Connection;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.kh.app.board.dao.BoardDao;
import com.kh.app.board.vo.BoardVo;
import com.kh.app.db.util.JDBCTemplate;

public class BoardService {
	
	private BoardDao dao = null;
	public BoardService() {
		dao = new BoardDao();
	}

	// 게시글 목록 조회
	public List<BoardVo> selectBoardList() throws Exception {
		
		// conn
		// Connection conn = JDBCTemplate.getConnection();
		
		// session
		SqlSession session = JDBCTemplate.getSqlSession();
		
		// dao
		List<BoardVo> voList = dao.selectBoardList(session);
		
		// close
		session.close();
		
		
		return voList;
		
	}

	// 게시글 등록하기
	public int write(BoardVo vo) throws Exception {
		
		// conn
//		Connection conn = JDBCTemplate.getConnection();
		
		// session
		SqlSession session = JDBCTemplate.getSqlSession();
		
		// dao
		int result = dao.write(session, vo);
		
		// tx
		if(result == 1) {
			session.commit();
		} else {
			session.rollback();
		}
		
		// close
		session.close();
		
		return result;
	}

}
