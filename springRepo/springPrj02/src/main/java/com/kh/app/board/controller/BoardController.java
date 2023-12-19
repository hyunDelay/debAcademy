package com.kh.app.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.kh.app.board.vo.BoardVo;

@Controller
public class BoardController {
	
	
	// 게시글 목록
	@GetMapping("board/list")
	public String getBoardList() {
		return "board/list";
	}
	
	// 게시글 작성 화면
	@GetMapping("board/write")
	public String write() {
		return "board/write";
	}
	
	// 게시글 작성
	@PostMapping("board/write")
	public String write(BoardVo vo) {
		
		// data
		
		// service
		int result = 1;
		
		// result
		if(result == 1) {
			return "redirect:/board/list";
		} else {
			return "error"; // WEB-INF/views/error.jsp 포워딩
		}
		
	}
	
	// 게시글 수정 화면
	
	// 게시글 수정
	
	// 게시글 삭제
	
	// 게시글 상세조회
	
}
