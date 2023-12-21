package com.kh.app.board.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.kh.app.board.dao.BoardDao;
import com.kh.app.board.vo.BoardVo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {

	private final BoardDao dao;
	private final SqlSessionTemplate sst;
	
	// 게시글 작성하기
	public int insert(BoardVo vo) {
		// dao
		return dao.insert(sst, vo);		
	}

	// 게시글 목록 조회
	public List<BoardVo> getBoardList() {
		return dao.getBoardList(sst);
	}

	// 게시글 상세 조회
	public BoardVo selectOne(String no) {
		return dao.selectOne(sst, no);
	}

	// 게시글 삭제하기
	public int deleteBoardByNo(String no) {
		return dao.deleteBoardByNo(sst, no);
	}

	// 게시글 수정하기
	public int setBoardByNo(BoardVo vo) {
		return dao.setBoardByNo(sst, vo);
	}

}
