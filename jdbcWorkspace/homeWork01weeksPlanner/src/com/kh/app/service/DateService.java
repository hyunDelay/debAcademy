package com.kh.app.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.app.dao.DateDao;
import com.kh.app.jdbc.JDBCTemplate;
import com.kh.app.vo.DateVo;
import com.kh.app.vo.MemberVo;

public class DateService {

	// 필드 == 멤버변수
	private final DateDao dao;

	public DateService() {
		dao = new DateDao();
	}
	
	public int addPlanner(DateVo vo) throws Exception {
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// DAO 호출
		int result = dao.addPlanner(conn, vo);
		
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

	public int delectPlanner(String date) throws Exception {
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// DAO 호출
		int result = dao.delectPlanner(conn, date);
		
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

	public ArrayList<DateVo> getShowPlanner() throws Exception {
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// DAO
		ArrayList<DateVo> voList = dao.getShowPlanner(conn);
		
		// tx
		
		// close
		JDBCTemplate.close(conn);
		
		return voList;
	}

	public ArrayList<DateVo> weekShow() throws Exception {
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// DAO
		ArrayList<DateVo> voList = dao.weekShow(conn);
		
		// tx
		
		// close
		JDBCTemplate.close(conn);
		
		return voList;
	}

}
