package com.kh.app.board.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("board")
public class BoardController {
	
	@GetMapping("write")
	public void write() {
		log.info("작성하기 메소드 호출됨 ...");
		//int x = 1/0;
		String str = null;
		str.indexOf("z");
	}
	
}
