package com.kh.app.board.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.kh.app.board.dao.BoardDao;
import com.kh.app.board.vo.BoardVo;

@Service
public class BoardService {

	private final SqlSessionTemplate sst;
	private final BoardDao dao;
	
	public BoardService(SqlSessionTemplate sst, BoardDao dao) {
		this.sst = sst;
		this.dao = dao;
	}
	
	// 게시글 작성하기
	public int write(BoardVo vo) {
		
		return dao.write(sst, vo);
		
	}

}
