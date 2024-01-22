package com.kh.app.board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.app.board.vo.BoardVo;

public interface BoardDao {
	
	int insert(SqlSessionTemplate sst, BoardVo vo);
	
	List<BoardVo> list(SqlSessionTemplate sst);
	
	BoardVo detail(SqlSessionTemplate sst, BoardVo vo);

	// 게시글 삭제
	int delete(SqlSessionTemplate sst, BoardVo vo);

	// 게시글 수정
	int edit(SqlSessionTemplate sst, BoardVo vo);
	
	int increaseHit(SqlSessionTemplate sst, String no);
	
}
