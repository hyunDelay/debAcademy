package com.kh.mini.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.kh.jdbc.JDBCTemplate;
import com.kh.mini.member.vo.MemberVo;

public class MemberDao {
	
	/*
	 * sql
	 * rs
	 * close
	 * */

	// 회원가입
	public int join(MemberVo vo, Connection conn) throws Exception {
		
		// sql
		String sql = "INSERT INTO MEMBER(NO, ID, PWD, NICK) VALUES(SEQ_MEMBER_NO.NEXTVAL, ?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getId());
		pstmt.setString(2, vo.getPwd());
		pstmt.setString(3, vo.getNick());
		int result = pstmt.executeUpdate();
		
		// close
		JDBCTemplate.close(conn);
		
		return result;
		
	}

	// 로그인
	public MemberVo login(Connection conn, MemberVo vo) throws Exception {
		
		// sql
		String sql = "SELECT * FROM MEMBER WHERE ID = ? AND PWD = ? AND DEL_YN = 'N'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getId());
		pstmt.setString(2, vo.getPwd());
		ResultSet rs = pstmt.executeQuery();
		
		// rs -> vo
		MemberVo dbVo = null;
		if(rs.next()) {
			String no = rs.getString("NO");
			String id = rs.getString("ID");
			String pwd = rs.getString("PWD");
			String nick = rs.getString("NICK");
			String enrollDate = rs.getString("ENROLL_DATE");
			String modifyDate = rs.getString("MODIFY_DATE");
			String delYn = rs.getString("DEL_YN");
			
			dbVo = new MemberVo();
			dbVo.setNo(no);
			dbVo.setId(id);
			dbVo.setPwd(pwd);
			dbVo.setNick(nick);
			dbVo.setEnrollDate(enrollDate);
			dbVo.setModifyDate(modifyDate);
			dbVo.setDelYn(delYn);
		}
		
		// close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return dbVo;
	}

	// 회원탈퇴
	public int quit(Connection conn, String no) throws Exception {
		
		// sql
		String sql = "UPDATE MEMBER SET DEL_YN = 'Y', MODIFY_DATE = SYSDATE WHERE NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		int result = pstmt.executeUpdate();
		
		// close
		JDBCTemplate.close(pstmt);
		
		return result;
	}

	// 전체 회원조회
	public List<MemberVo> memberList(Connection conn) throws Exception {
		
		// sql
		String sql = "SELECT ID, NICK, ENROLL_DATE, MODIFY_DATE, DEL_YN FROM MEMBER";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		ArrayList<MemberVo> voList = new ArrayList<MemberVo>();
		// rs
		while(rs.next()) {
			String id = rs.getString("ID");
			String nick = rs.getString("NICK");
			String enrollDate = rs.getString("ENROLL_DATE");
			String modifyDate = rs.getString("MODIFY_DATE");
			String delYn = rs.getString("DEL_YN");
			
			MemberVo vo = new MemberVo();
			vo.setId(id);
			vo.setNick(nick);
			vo.setEnrollDate(enrollDate);
			vo.setModifyDate(modifyDate);
			vo.setDelYn(delYn);
			
			voList.add(vo);
		}
		
		// close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return voList;
		
	}

	// 닉네임 변경
	public int changeNick(Connection conn, MemberVo vo) throws Exception {
		
		// sql
		String sql = "UPDATE MEMBER SET NICK = ? WHERE NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getNick());
		pstmt.setString(2, vo.getNo());
		int result = pstmt.executeUpdate();
		
		// close
		JDBCTemplate.close(pstmt);
		
		return result;
	}

	public int changePwd(Connection conn, Map<String, String> m) throws Exception {
		
		// sql
		String sql = "UPDATE MEMBER SET PWD = ? WHERE NO = ? AND PWD = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, m.get("newPwd"));
		pstmt.setString(2, m.get("loginMemberNo"));
		pstmt.setString(3, m.get("oldPwd"));
		int result = pstmt.executeUpdate();
		
		// close
		return result;
	}

}
