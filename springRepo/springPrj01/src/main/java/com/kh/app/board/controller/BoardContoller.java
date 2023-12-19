package com.kh.app.board.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kh.app.board.vo.BoardVo;

@Controller
public class BoardContoller {
	
	// 게시글 목록
//	@RequestMapping(value = "board/list", method = RequestMethod.GET)
	@GetMapping("board/list")
	public String getBoardList() {
		System.out.println("게시글 목록 보여주기");
		return "board/list";
	}
	
	// 게시글 작성하기 화면
	@GetMapping("board/write")
	public String insertBoard() {
		return "board/write";
	}
	
	// 게시글 작성하기 처리
	@PostMapping("board/write")
	public void insertBoard(BoardVo vo) {
		
		// data
		System.out.println(vo.getContent());
		System.out.println(vo.getTitle());
		System.out.println(vo.getWriter());
		
	}
	
	
}
