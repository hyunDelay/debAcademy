package com.kh.app.member.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("member")
public class MemberController {
	
	private final MemberService service;
	
	// 회원가입
	@PostMapping("join")
	public void join(MemberVo vo) {
		int result = service.join(vo);
		System.out.println("회원가입 결과 : " + result);
	}
	
	// 회원 목록 조회
	@GetMapping("list")
	public void list(Model model) {
		List<MemberVo> voList = service.list();
		
		for (MemberVo vo : voList) {
			System.out.println(vo);
		}
		
		// 화면에 데이터 전달
		model.addAttribute("model", voList);
	}
	
	// 회원 상세 조회
	@GetMapping("detail")
	public void detail(String no) {
		System.out.println(no);
		MemberVo vo = service.detail(no);
		System.out.println(vo);
	}
	
	// 회원 삭제
	@GetMapping("delete")
	public void delete(String no) {
		int result = service.delete(no);
		System.out.println("회원 삭제 결과 : " + result);
	}
	
	// 회원 수정
	@PostMapping("edit")
	public void edit(MemberVo vo) {
		int result = service.edit(vo);
		System.out.println("회원 수정 결과 : " + result);
	}
}
