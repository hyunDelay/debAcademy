package com.kh.app.member.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.app.db.JDBCTemplate;
import com.kh.app.member.dao.MemberDao;
import com.kh.app.member.vo.MemberVo;

public class MemberService {
	
	// 필드 == 멤버변수
	private final MemberDao dao;
	
	// 기본생성자
	public MemberService() {
		dao = new MemberDao();
	}
	
	// 회원가입
	public int join(MemberVo vo) throws Exception {
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// DAO
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
	
	// 로그인
	public MemberVo login(MemberVo vo) {
		// conn
		// DAO
		// tx
		// close
		return null;
	}
	
	// 전체 회원목록 조회
	public ArrayList<MemberVo> getMemberList() {
		// conn
		// DAO
		// tx
		// close
		return null;
	}
	
	// 회원탈퇴
	public int quit(MemberVo vo) throws Exception {
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// DAO
		int result = dao.quit(conn, vo);
		
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
	
	// 비밀번호 변경
	public int editPwd(MemberVo vo, String newPwd) {
		// conn
		Connection conn = JDBCTemplate.getConnection();
		// DAO
		// tx
		// close
		return 0;
	}

}
