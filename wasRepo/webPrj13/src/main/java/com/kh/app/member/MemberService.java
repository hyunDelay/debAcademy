package com.kh.app.member;

import java.sql.Connection;

import com.kh.app.db.util.JDBCTemplate;

public class MemberService {

	// 회원가입 처리
	public int join(MemberVo vo) throws Exception {
		
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// 비즈니스 로직
		// 아이디 4글자 미만 ㄴㄴ
		if(vo.getMemberId().length() < 4) {
			throw new Exception("아이디가 4글자 미만입니다.");
		}
		// 비번 일치여부 체크
		if(!vo.getMemberPwd1().equals(vo.getMemberPwd2())) {
			throw new Exception("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
		}
		// 비번 4글자 미만 ㄴㄴ
		if(vo.getMemberPwd1().length() < 4) {
			throw new Exception("비밀번호가 4글자 미만입니다.");
		}
		// 닉네임에 관리자 불가능
		if(vo.getMemberNick().contains("관리자") || vo.getMemberNick().toLowerCase().contains("admin")) {
			throw new Exception("닉네임에 사용하실 수 없는 이름이 있습니다.");
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
		
		// 비즈니스로직
		
		// dao
		MemberDao dao = new MemberDao();
		MemberVo loginMember = dao.login(conn, vo);
		
		// tx 셀렉트라 할필요없음
		
		// close
		JDBCTemplate.close(conn);
		
		return loginMember;
	}

}
