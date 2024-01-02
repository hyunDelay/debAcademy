package com.kh.app.member.controller;

import java.util.HashMap;
import java.util.Map;

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
		int result = service.join(vo);
		
		Map<String, String> map = new HashMap<String, String>();
		if(result == 1) {
			map.put("msg", "good");			
		} else {
			map.put("msg", "bad");	
		}
		
		return map;
	}
}
