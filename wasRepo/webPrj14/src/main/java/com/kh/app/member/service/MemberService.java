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
		MemberVo result = dao.login(conn, vo);
		
		// tx
		
		// close
		JDBCTemplate.close(conn);
		
		return result;
	}
	

}
