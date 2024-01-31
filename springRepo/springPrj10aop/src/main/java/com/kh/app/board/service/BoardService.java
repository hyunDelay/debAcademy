package com.kh.app.board.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.kh.app.board.dao.BoardDao;
import com.kh.app.board.vo.BoardVo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {
	
	private final BoardDao dao;
	private SqlSessionTemplate sst;
	
	public int write(BoardVo vo) {
		System.out.println("게시글작성 서비스");
		return dao.write(sst, vo);
	}
	
}
