package com.kh.app.board.service;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kh.app.board.dao.BoardDao;
import com.kh.app.board.vo.BoardVo;
import com.kh.app.board.vo.CategoryVo;
import com.kh.app.db.util.JDBCTemplate;
import com.kh.app.page.vo.PageVo;

public class BoardService {

	// 게시글 목록 조회
	public List<BoardVo> selectBoardList(PageVo pvo) throws Exception {
		
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		BoardDao dao = new BoardDao();
		List<BoardVo> boardVoList = dao.selectBoardList(conn, pvo);
		
		// close
		JDBCTemplate.close(conn);
		
		return boardVoList;
	}

	// 게시글 작성하기
	public int write(BoardVo vo) throws Exception {
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		BoardDao dao = new BoardDao();
		int result = dao.write(conn, vo);
		
		// tx
		if(result == 1) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		// close
		JDBCTemplate.close(conn);
		
		return result;
	}

	// 게시글 1개 조회 ( + 조회수 증가)
	public BoardVo selectBoardByNo(String no) throws Exception {
		
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		BoardDao dao = new BoardDao();
		int result = dao.increaseHit(conn, no);
		BoardVo vo = null;
		if(result == 1) {
			vo = dao.selectBoardByNo(conn, no);
		} 
		
		// tx
		if(result == 1) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		// close
		JDBCTemplate.close(conn);
		
		return vo;
	}

	// 게시글 삭제
	public int delete(String no, String memberNo) throws Exception {
		
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		BoardDao dao = new BoardDao();
		int result = dao.delete(conn, no, memberNo);
		
		// tx
		if(result == 1) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		// close
		JDBCTemplate.close(conn);
		
		return result;
	}

	// 전체 게시글 갯수 조회
	public int selectBoardCount() throws Exception {
			
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		BoardDao dao = new BoardDao();
		int cnt = dao.selectBoardCount(conn);
		
		// close
		JDBCTemplate.close(conn);
		
		return cnt;
			
	}//selectBoardCount

	// 게시글 수정 화면
	public Map<String, Object> boardEdit(String no) throws Exception {
		
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		BoardDao dao = new BoardDao();
		BoardVo vo = dao.selectBoardByNo(conn, no);
		List<CategoryVo> cateVoList = dao.getCategoryList(conn);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("vo", vo);
		map.put("categoryVoList", cateVoList);
		
		// close
		JDBCTemplate.close(conn);
		
		return map;
	}
	
	// 카테고리 리스트 조회
	public List<CategoryVo> getCategoryList() throws Exception{
		
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		BoardDao dao = new BoardDao();
		List<CategoryVo> voList = dao.getCategoryList(conn);
		
		// close
		JDBCTemplate.close(conn);
		
		return voList;
	}

	// 게시글 수정하기
	public int boardEdit(BoardVo vo) throws Exception {
		
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		BoardDao dao = new BoardDao();
		int result = dao.updateBoardByNo(conn, vo);
		
		// tx
		if(result == 1) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		// close
		JDBCTemplate.close(conn);
		
		return result;
	}

}
