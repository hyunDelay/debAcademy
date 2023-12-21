package com.kh.app.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.kh.app.board.vo.BoardVo;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService bs;
	
	// 게시글 목록 조회
	@GetMapping("board/list")
	public String getBoardList() {
		
		List<BoardVo> voList = bs.getBoardList();
		System.out.println(voList);
		
		return "board/list";
	}
	String write = "board/write";
	// 게시글 작성하기
	@GetMapping("board/write")
	public String showBoardList() {
		return "board/write";
	}
	
}
