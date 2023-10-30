package com.kh.mini.member.service;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

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

	public List<MemberVo> memberList() throws Exception {
		
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		List<MemberVo> voList = dao.memberList(conn);
		
		// tx
		
		// close
		JDBCTemplate.close(conn);
		
		return voList;
		
	}

	// 닉네임 변경
	public int changeNick(MemberVo vo) throws Exception {

		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// DAO
		int result = dao.changeNick(conn, vo);
		
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

	public int changePwd(Map<String, String> m) throws Exception {
		
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		int result = dao.changePwd(conn, m);
		
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
