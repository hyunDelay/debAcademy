package com.kh.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.app.jdbc.JDBCTemplate;
import com.kh.app.vo.DateVo;
import com.kh.app.vo.MemberVo;

public class DateDao {

	public int addPlanner(Connection conn, DateVo vo) throws Exception {
		// SQL
		String sql = "INSERT INTO DAYEVENT (TITLE, DAYCAL) VALUES(?, ?)";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getTitle());
		pstmt.setString(2, vo.getDate());
		int result = pstmt.executeUpdate();
		
		// close
		JDBCTemplate.close(pstmt);
		
		return result;
	}

	public int delectPlanner(Connection conn, String date) throws Exception {
		// SQL
		String sql = "DELETE DAYEVENT WHERE DAYCAL = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, date);
		int result = pstmt.executeUpdate();
		
		// close
		JDBCTemplate.close(pstmt);
		
		return result;
	}

	public ArrayList<DateVo> getShowPlanner(Connection conn) throws Exception {
		// SQL
		String sql = "SELECT * FROM DAYEVENT ORDER BY DAYCAL ASC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		// rs
		ArrayList<DateVo> voList = new ArrayList<DateVo>();
		while(rs.next()) {
			String dbTitle = rs.getString("TITLE");
			String dbDate = rs.getString("DAYCAL");	
			
			DateVo vo = new DateVo();
			vo.setTitle(dbTitle);
			vo.setDate(dbDate);
			
			voList.add(vo);
		}
		
		// close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return voList;
	}

	public ArrayList<DateVo> weekShow(Connection conn) throws Exception {
		// SQL
		String sql = "SELECT * FROM DAYEVENT ORDER BY DAYCAL ASC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		// rs
		ArrayList<DateVo> voList = new ArrayList<DateVo>();
		while(rs.next()) {
			String dbTitle = rs.getString("TITLE");
			String dbDate = rs.getString("DAYCAL");	
			
			DateVo vo = new DateVo();
			vo.setTitle(dbTitle);
			vo.setDate(dbDate);
			
			voList.add(vo);
		}
		
		// close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return voList;
	}

}
