package com.kh.app.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.app.board.service.BoardService;
import com.kh.app.board.vo.BoardVo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("api/board")
@RequiredArgsConstructor
@CrossOrigin("*")
@RestController
@Slf4j
public class BoardApiControllor {
	
	private final BoardService service;
	
	// 게시글 목록조회
	@GetMapping("list")
	public List<BoardVo> loadBoardList() {
//		String vo = "gew1";
//		String vo2 = "gew2";
//		String vo3 = "gew3";
//		log.error("BoardController 클래스의 list 메소드 호출됨 ...");
//		log.info("vo값 : {}, 다른값 : {}, 다른값 : {}", vo, vo2, vo3);
		return service.list(); 
	}
	
	// 게시글 작성하기
	@PostMapping("write")
	public Map<String, String> write(@RequestBody BoardVo vo, HttpSession session) {
		
		Map<String, String> map = new HashMap<String, String>();
		
		int result = service.insert(vo);
		
		if(result == 1) {
			map.put("msg", "good");
		} else {			
			map.put("msg", "bad");
		}
		
		return map;
	}
}
