package com.kh.app.board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.app.board.vo.BoardVo;

@Repository
public class BoardDao {

	// 게시글 작성하기
	public int insert(SqlSessionTemplate sst, BoardVo vo) {
		// sql
		return sst.insert("BoardMapper.insertBoard", vo);
		
	}

	// 게시글 목록 조회
	public List<BoardVo> getBoardList(SqlSessionTemplate sst) {
		return sst.selectList("BoardMapper.getBoardList");
	}

	// 게시글 상세 조회
	public BoardVo selectOne(SqlSessionTemplate sst, String no) {
		return sst.selectOne("BoardMapper.getBoardByNo", no);
	}

	// 게시글 삭제하기
	public int deleteBoardByNo(SqlSessionTemplate sst, String no) {
		return sst.delete("BoardMapper.deleteBoardByNo", no);
	}

	// 게시글 수정하기
	public int setBoardByNo(SqlSessionTemplate sst, BoardVo vo) {
		return sst.delete("BoardMapper.setBoardByNo", vo);
	}

}
