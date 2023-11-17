package com.kh.app.member;

import java.sql.Connection;

import com.kh.app.db.util.JDBCTemplate;

public class MemberService {

	// 회원가입
	public int join(MemberVo vo) throws Exception {
		
		// business logic
		if(!vo.getMemberPwd1().equals(vo.getMemberPwd2())) {
			throw new Exception("[ERROR-M002] 비밀번호 일치하지 않음");
		}
		
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao 호출
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
	
}
