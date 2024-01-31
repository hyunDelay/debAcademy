package com.kh.app.board.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.app.board.vo.BoardVo;

@Repository
public class BoardDao {

	public int write(SqlSessionTemplate sst, BoardVo vo) {
		System.out.println("게시글작성 dao");
		return 1;
	}

}
