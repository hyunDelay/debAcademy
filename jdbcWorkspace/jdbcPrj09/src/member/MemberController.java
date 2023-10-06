package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import db.JDBCTemplate;

public class MemberController {
	
	// 필드 (멤버변수)
	private Scanner sc;
	
	// 기본 생성자
	public MemberController() {
		sc = new Scanner(System.in);
	}
	
	// 메뉴 선택
	public void selectMenu() {
		System.out.println("1. 회원가입");
		System.out.println("2. 로그인");
		
		String num = sc.nextLine();
		
		switch(num) {
		case "1" : join(); break;
		case "2" : login(); break;
		}
		
	}

	// 회원가입
	private void join() {
		// 데이터 입력받기 
		System.out.print("아이디 : ");
		String userId = sc.nextLine();
		System.out.print("비밀번호 : ");		
		String userPwd = sc.nextLine();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			// 디비 연결 == conn 얻기
			conn = JDBCTemplate.getConnection();
			
			// 쿼리 실행
			String sql = "INSERT INTO MEMBER(ID, PWD) VALUES(?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			int result = pstmt.executeUpdate();
			
			// 결과 처리
			if(result == 1) {
				conn.commit();
				System.out.println("회원가입 성공!!");
			} else {
				throw new Exception();
			}
			
		} catch(Exception e) {
			JDBCTemplate.rollback(conn);
			System.err.println("회원가입 실패...");
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
			JDBCTemplate.close(pstmt);
		}
		
	}
	
	// 로그인
	private void login() {
		// 데이터 입력받기
		System.out.print("아이디 : ");
		String userId = sc.nextLine();
		System.out.print("비밀번호 : ");		
		String userPwd = sc.nextLine();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// conn 얻기
			conn = JDBCTemplate.getConnection();
			
			// 쿼리 실행
			String sql = "SELECT * FROM MEMBER WHERE ID = ? AND PWD = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			rs = pstmt.executeQuery();
			
			// 결과 처리
			if(rs.next()) {
				System.out.println("로그인 성공 !!!");
			} else {
				throw new Exception();
			}
			
		} catch(Exception e) {
			System.out.println("로그인 실패...");
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		
	}
}
