package com.kh.app.board.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.app.board.service.BoardService;
import com.kh.app.board.vo.BoardVo;

// @Controller---
// @ResponseBody 두개 합쳐놓은것
@RestController
public class BoardController {
	
	private final BoardService bs;
	
	public BoardController(BoardService bs) {
		this.bs = bs;
	}
	
	// 게시글 작성하기
	@GetMapping("board/write")
	public String write() {
		return "board/write";
	}
	
	// 게시글 작성하기
	@PostMapping("board/write")
	public HashMap<String, String> write(BoardVo vo, HttpServletResponse resp) {
		int result = bs.write(vo);
		System.out.println("게시글작성 result" + result);
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("uj", "윤지님");
		map.put("km", "경민님");
		
		return map;
	}
	
}
