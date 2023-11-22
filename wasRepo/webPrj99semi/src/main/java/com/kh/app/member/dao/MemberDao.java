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
		String sql = "INSERT INTO MEMBER( NO , ID , PWD , NICK , PHONE , EMAIL , ADDRESS , HOBBYS ) VALUES ( SEQ_MEMBER_NO.NEXTVAL , ? , ? , ? , ? , ? , ? , ? )";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getMemberId());
		pstmt.setString(2, vo.getMemberPwd());
		pstmt.setString(3, vo.getMemberNick());
		pstmt.setString(4, vo.getMemberPhone());
		pstmt.setString(5, vo.getMemberEmail());
		pstmt.setString(6, vo.getMemberAddress());
		pstmt.setString(7, vo.getHobbyStr());
		int result = pstmt.executeUpdate();
		
		// close
		JDBCTemplate.close(pstmt);
		
		return result;
	}

	// 로그인 처리
	public MemberVo login(Connection conn, MemberVo vo) throws Exception {

		// sql
		String sql = "SELECT * FROM MEMBER WHERE ID = ? AND PWD = ? AND STATUS = 'O'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getMemberId());
		pstmt.setString(2, vo.getMemberPwd());
		ResultSet rs = pstmt.executeQuery();
		
		// rs
		MemberVo loginMember = null;
		if(rs.next()) {
			String no = rs.getString("NO");
			String id = rs.getString("ID");
			String pwd = rs.getString("PWD");
			String nick = rs.getString("NICK");
			String phone = rs.getString("PHONE");
			String email = rs.getString("EMAIL");
			String addr = rs.getString("ADDRESS");
			String hobbys = rs.getString("HOBBYS");
			String enrollDate = rs.getString("ENROLL_DATE");
			String modifyDate = rs.getString("MODIFY_DATE");
			String status = rs.getString("STATUS");
			
			loginMember = new MemberVo();
			loginMember.setNo(no);
			loginMember.setMemberId(id);
			loginMember.setMemberPwd(pwd);
			loginMember.setMemberNick(nick);
			loginMember.setMemberPhone(phone);
			loginMember.setMemberEmail(email);
			loginMember.setMemberAddress(addr);
			loginMember.setHobbyStr(hobbys);
			loginMember.setEnrollDate(enrollDate);
			loginMember.setModifyDate(modifyDate);
			loginMember.setStatus(status);
		}
		
		// close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return loginMember;
	}

}
