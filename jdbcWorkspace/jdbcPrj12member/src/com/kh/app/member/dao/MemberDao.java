package com.kh.app.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.app.db.JDBCTemplate;
import com.kh.app.member.vo.MemberVo;

public class MemberDao {
	
	// 회원가입
	public int join(Connection conn, MemberVo vo) throws Exception {
		// sql
		String sql = "INSERT INTO MEMBER(ID, PWD, NICK) VALUES(?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getId());
		pstmt.setString(2, vo.getPwd());
		pstmt.setString(3, vo.getNick());
		int result = pstmt.executeUpdate();
		
		// close
		JDBCTemplate.close(pstmt);
		
		return result;
	}
	
	// 로그인
	public MemberVo login(Connection conn, MemberVo vo) {
		// sql
		// rs
		// close
		return null;
	}
	
	// 전체 회원목록 조회
	public ArrayList<MemberVo> getMemberList(Connection conn) {
		// sql
		// rs
		// close
		return null;
	}
	
	// 회원탈퇴
	public int quit(Connection conn, MemberVo vo) throws Exception {
		// sql
		String sql = "DELETE FROM MEMBER WHERE ID = ? AND PWD = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getId());
		pstmt.setString(2, vo.getPwd());
		int result = pstmt.executeUpdate();
		
		// close
		JDBCTemplate.close(pstmt);
		
		return result;
	}
	
	// 비밀번호 변경
	public int editPwd(Connection conn, MemberVo vo, String newPwd) {
		// sql
		// rs
		// close
		return 0;
	}

}
