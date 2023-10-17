package com.kh.mini.member.service;

import java.sql.Connection;

import com.kh.jdbc.JDBCTemplate;
import com.kh.mini.member.dao.MemberDao;
import com.kh.mini.member.vo.MemberVo;

public class MemberService {

	private final MemberDao dao;

	public MemberService() {
		dao = new MemberDao();
	}
	
	/*
	 * conn
	 * dao 호출
	 * tx
	 * close
	 * */



	// 회원가입
	public int join(MemberVo vo) throws Exception {
		
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao 호출
		int result = dao.join(vo, conn);
		
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
	public MemberVo login(MemberVo vo) throws Exception {
		
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		MemberVo x = dao.login(conn, vo);
		
		// close
		JDBCTemplate.close(conn);
		
		
		return x;
		
	}

	// 회원탈퇴
	public int quit(String no) throws Exception {
		
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		int result = dao.quit(conn, no);
		
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

}
