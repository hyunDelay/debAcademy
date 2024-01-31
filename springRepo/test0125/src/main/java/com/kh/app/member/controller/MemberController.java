package com.kh.app.member.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class MemberController {
	
	private final MemberService service;
	
	// join
	@PostMapping("member")
	public Map<String, String> join(@RequestBody MemberVo vo) {
		
		// 클라이언트가 보낸 데이터를 받아서 출력
		System.out.println(vo);
		
		// 비즈니스 로직 실행결과에 따라 응답
		int result = service.join(vo);
		
		// 응답 데이터는 성공 실패 여부를 알 수 있게 작성
		Map<String, String> map = new HashMap<>();
		map.put("msg", "good");
		if(result != 1) {
			map.put("msg", "bad");
		}
		return map;
	}
}
