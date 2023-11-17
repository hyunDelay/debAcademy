package com.kh.app.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kh.app.db.util.JDBCTemplate;

public class MemberDao {

	// 회원가입 처리
	public int join(Connection conn, MemberVo vo) throws Exception {
		
		// sql
		String sql = "INSERT INTO MEMBER(ID, PWD, NICK) VALUES(?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getMemberId());
		pstmt.setString(2, vo.getMemberPwd1());
		pstmt.setString(3, vo.getMemberNick());
		int result = pstmt.executeUpdate();
		
		// close
		JDBCTemplate.close(pstmt);
		
		return result;
	}

	// 로그인 처리
	public MemberVo login(Connection conn, MemberVo vo) throws Exception {
		
		// sql
		String sql = "SELECT * FROM MEMBER WHERE ID = ? AND PWD = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getMemberId());
		pstmt.setString(2, vo.getMemberPwd1());
		ResultSet rs = pstmt.executeQuery();
		
		// rs
		MemberVo loginMember = null;
		if(rs.next()) {
			String id = rs.getString("ID");
			String pwd = rs.getString("PWD");
			String nick = rs.getString("NICK");
			
			loginMember = new MemberVo();
			loginMember.setMemberId(id);
			loginMember.setMemberPwd1(pwd);
			loginMember.setMemberNick(nick);
		}
		System.out.println(loginMember.getMemberId());
		System.out.println(loginMember.getMemberNick());
		
		// close
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		
		return loginMember;
	}

}
