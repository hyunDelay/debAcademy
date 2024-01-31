package com.kh.app.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.kh.app.board.service.BoardService;
import com.kh.app.board.vo.BoardVo;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BoardController {

	private final BoardService service;
	
//	@RequestMapping(value = "board/write", method = RequestMethod.POST)
	@PostMapping("board/write")
	public void write(BoardVo vo) {
		System.out.println("게시글작성 컨트롤러");
		int result = service.write(vo);
		
	}
	
}
