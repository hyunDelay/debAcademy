package com.kh.app.member.service;

import java.sql.Connection;

import com.kh.app.db.util.JDBCTemplate;
import com.kh.app.member.dao.MemberDao;
import com.kh.app.member.vo.MemberVo;

public class MemberService {

	// 회원가입 처리
	public int join(MemberVo vo) throws Exception {
		
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// Business logic
		// 아이디 4~12 영문소문자+숫자
		String id = vo.getMemberId();
		boolean idOk = id.matches("[a-z0-9]{4,12}");
		if(!idOk) {
			throw new Exception("아이디 값이 잘못되었습니다.");
		}
		// 비밀번호 일치여부 체크
		if(!vo.getMemberPwd().equals(vo.getMemberPwd2())) {
			throw new Exception("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
		}
		// 비밀번호 4글자 이상
		if(vo.getMemberPwd().length() < 4) {
			throw new Exception("비밀번호가 4글자 미만입니다.");
		}
		// 닉네임에 admin 금지
		if(vo.getMemberNick().equalsIgnoreCase("admin")) {
			throw new Exception("닉네임에 부적절한 텍스트가 포함되어 있습니다.");
		}
		
		// dao
		MemberDao dao = new MemberDao();
		int result = dao.join(conn, vo);
		
		// tx
		if(result == 1) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		// close
		JDBCTemplate.close(conn);
		
		return result;
	}

	// 로그인 처리
	public MemberVo login(MemberVo vo) throws Exception {

		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		MemberDao dao = new MemberDao();
		MemberVo loginMember = dao.login(conn, vo);
		
		// close
		JDBCTemplate.close(conn);
		
		return loginMember;
	}

}
