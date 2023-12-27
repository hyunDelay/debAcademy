package com.kh.app.board.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.app.board.service.BoardService;
import com.kh.app.board.vo.BoardVo;
import com.kh.app.member.service.MemberService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("board")
@RequiredArgsConstructor
public class BoardController {
	
	private final BoardService service;
	
	// 게시글 작성
	@PostMapping("insert")
	public String insert(BoardVo vo) throws Exception {
		
		int result = service.insert(vo);
		
		if(result != 1) {
			throw new Exception("게시글 작성이 실패했습니다.");
		}
		
		return "redirect:/board/list";
	}
	
	// 게시글 목록 조회
	@GetMapping("list")
	public String list(Model model) {
		List<BoardVo> voList = service.list();
		model.addAttribute("boardVoList", voList);
		System.out.println(voList);
		return "board/list";
	}
	
	// 게시글 상세 조회 (번호)
	@GetMapping("detail")
	public String detail(BoardVo vo, Model model) {
		BoardVo boardVo = service.detail(vo);
		model.addAttribute("boardVo", boardVo);
		return "board/detail";
	}
	
	// 게시글 삭제 (번호)
	@GetMapping("delete")
	public String delete(BoardVo vo) throws Exception {
		int result = service.delete(vo);
		if(result != 1) {
			throw new Exception("게시글 삭제를 실패했습니다.");
		}
		return "redirect:/board/list";
	}
	
	// 게시글 수정 (제목, 내용)
	@PostMapping("edit")
	public String edit(BoardVo vo, Model model) {
		int result = service.edit(vo);
		
		return "board/detail?no=" + vo.getNo();
	}

}
