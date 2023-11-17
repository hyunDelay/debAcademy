package com.kh.app.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kh.app.db.util.JDBCTemplate;
import com.kh.app.member.vo.MemberVo;

public class MemberDao {

	// 회원가입 처리
	public int join(Connection conn, MemberVo vo) throws Exception {
		
		// sql
		String sql = "INSERT INTO MEMBER(ID, PWD, NICK) VALUES (?, ? ,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getMemberId());
		pstmt.setString(2, vo.getMemberPwd());
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
		pstmt.setString(2, vo.getMemberPwd());
		ResultSet rs = pstmt.executeQuery();
		
		// rs
		MemberVo loginMember = null;
		if(rs.next()) {
			String memberId = rs.getString("ID");
			String memberPwd = rs.getString("PWD");
			String memberNick = rs.getString("NICK");
			
			loginMember = new MemberVo();
			loginMember.setMemberId(memberId);
			loginMember.setMemberPwd(memberPwd);
			loginMember.setMemberNick(memberNick);
			
		}
		
		// close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return loginMember;
	}

}
