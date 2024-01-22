package com.kh.app.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kh.app.member.dao.MemberDao;
import com.kh.app.member.vo.MemberVo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {
	
	private final MemberDao dao;
	private final SqlSessionTemplate sst;
	private final BCryptPasswordEncoder encoder;
	
	// 회원가입
	public int join(MemberVo vo) {
		// vo에 담긴 pwd 암호화 하여서 저장할 것
		String newPwd = encoder.encode(vo.getPwd());
		System.out.println(newPwd);
		vo.setPwd(newPwd);
		return dao.join(sst, vo);
		
	}

	// 로그인
	public MemberVo login(MemberVo vo) {
		
		MemberVo dbVo = dao.login(sst, vo);
		
		// clientVo == dbVo ? 성공 : 실패
		boolean isOk = encoder.matches(vo.getPwd(), dbVo.getPwd());
		if(!isOk) {
			return null;
		} 
		return dbVo;
	}
	
	// 평문, 암호문 판단메소드
	private boolean checkPwd(String raw, String enc) {
		String newRaw = raw + "abc";
		return newRaw.equals(enc);
	}
	
}
