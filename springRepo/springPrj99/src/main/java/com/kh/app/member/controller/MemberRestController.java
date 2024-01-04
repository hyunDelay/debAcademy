package com.kh.app.member.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("rest/member")
@RequiredArgsConstructor
@ResponseBody
@CrossOrigin("*")
public class MemberRestController {
	
	private final MemberService service;
	
	@PostMapping("join")
	public Map<String, String> join(@RequestBody MemberVo vo) throws Exception {
		
		Thread.sleep(3000);
		
		int result = service.join(vo);
		
		Map<String, String> map = new HashMap<String, String>();
		if(result == 1) {
			map.put("msg", "good");			
		} else {
			map.put("msg", "bad");	
		}
		
		return map;
	}
	
	@PostMapping("login")
	public Map<String, Object> login(@RequestBody MemberVo vo, HttpSession session) throws Exception {
		System.out.println(vo);
		MemberVo loginMember = service.login(vo);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		if(loginMember == null) {
			map.put("msg", "bad");
		} 
		map.put("msg", "good");	
		map.put("loginMember", loginMember);
		System.out.println("마지막 :" + loginMember);
		
		session.setAttribute("loginMember", loginMember);
		
		return map;
	} 
}
