package com.kh.app.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.app.board.vo.BoardVo;
import com.kh.app.db.util.JDBCTemplate;

public class BoardDao {

	// 게시글 목록 조회
	public List<BoardVo> selectBoardList(SqlSession session) throws Exception {

		return session.selectList("BoardMapper.selectBoardList");
//		// sql
//		String sql = "SELECT * FROM BOARD_TEMP";
//		PreparedStatement pstmt = session.prepareStatement(sql);
//		ResultSet rs = pstmt.executeQuery();
//		
//		// rs
//		List<BoardVo> voList = new ArrayList<BoardVo>();
//		while(rs.next()) {
//			String title = rs.getString("TITLE");
//			String content = rs.getString("CONTENT");
//			String enrollDate = rs.getString("ENROLL_DATE");
//			
//			BoardVo vo = new BoardVo(title, content, enrollDate);
//			
//			voList.add(vo);
//			
//		}
//		
//		// close
//		JDBCTemplate.close(rs);
//		JDBCTemplate.close(pstmt);
		
		
		
//		return voList;
	}

	// 게시글 등록하기
	public int write(SqlSession session, BoardVo vo) throws Exception {
		
		
		return session.insert("BoardMapper.insertBoard", vo);
//		// sql
//		String sql = "INSERT INTO BOARD_TEMP(TITLE, CONTENT) VALUES(?, ?)";
//		PreparedStatement pstmt = conn.prepareStatement(sql);
//		pstmt.setString(1, vo.getTitle());
//		pstmt.setString(2, vo.getContent());
//		int result = pstmt.executeUpdate();
//		
//		// close
//		JDBCTemplate.close(pstmt);
//		
//		return result;
	}

}
