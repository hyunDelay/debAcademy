package com.ncs.test.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ncs.test.member.model.service.MemberService;
import com.ncs.test.member.model.vo.Member;

@Controller
public class MemberController {
	
	
	private final MemberService service;
	
	@Autowired
	public MemberController(MemberService service) {
		this.service = service;
	}

	// 로그인 화면
	@GetMapping("/")
	public String memberLogin() {
		return "index";
	}
	
	// 로그인 처리
	@PostMapping("login")
	public String memberLogin(Member vo, Model model, HttpSession session) {
		
		Member loginMember = service.memberLogin(vo);
		
		if(loginMember == null) {
			System.out.println("로그인 실패");
			model.addAttribute("msg", "로그인 실패");
			return "errorPage";
		} else {
			session.setAttribute("loginMember", loginMember);
			return "redirect:/";			
		}
		
		
	}
	
}
