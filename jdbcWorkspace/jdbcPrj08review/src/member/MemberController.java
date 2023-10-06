package member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import db.util.JDBCTemplate;

public class MemberController {

	// 멤버 변수
	private Scanner sc;

	// 기본 생성자
	public MemberController() {
		this.sc = new Scanner(System.in);
	}
	
	public void selectMenu() throws Exception {
		System.out.println("----- 메뉴선택 ------");
		System.out.println("1. 회원가입");
		System.out.println("2. 로그인");
		
		String num = sc.nextLine();
		
		switch(num) {
		case "1" : join(); break;
		case "2" : login(); break;
		}
	}

	public void join() {
		System.out.println("----- 회원 가입 -----");
		
		// 데이터 입력받기
		
		System.out.print("아이디 : ");
		String userId = sc.nextLine();
		System.out.print("비밀번호 : ");		
		String userPwd = sc.nextLine();
		
		PreparedStatement pstmt = null;
		Connection conn = null;
		try {
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
				System.out.println("회원가입 성공!");
			} else {
				conn.rollback();
				System.err.println("회원가입 실패...");
			}
		} catch(Exception e) {
			try {
				if(conn != null) {					
					conn.rollback();
				}
			} catch(Exception e1) {
				
			}
			System.err.println("회원가입 실패...");
		} finally {
			// 자원 반납
			try {
				if(pstmt != null && !pstmt.isClosed()) {					
					pstmt.close();
				}
			} catch(Exception e) {
				
			}
			try {
				if(conn != null && !conn.isClosed()) {					
					conn.close();
				}
			} catch(Exception e) {
				
			}
			
		}
		
	}
	
	public void login() {
		
		System.out.println("----- 로그인 -----");
		
		// 유저 입력
		System.out.print("아이디 : ");
		String inputId = sc.nextLine();
		System.out.print("비밀번호 : ");
		String inputPwd = sc.nextLine();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// conn 얻기
			conn = JDBCTemplate.getConnection();

			// 쿼리 실행
			String sql = "SELECT * FROM MEMBER WHERE ID = ? AND PWD = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, inputId);
			pstmt.setString(2, inputPwd);
			rs = pstmt.executeQuery();
			
			// 결과 처리
			if(rs.next()) {
				conn.commit();
				System.out.println("로그인 성공!");
			} else {
				conn.rollback();
				System.out.println("로그인 실패...");
			}
		} catch(Exception e) {
			
		} finally {
			// 자원 반납
			try {
				if(rs != null && !rs.isClosed()) {					
					rs.close();
				}
			} catch(Exception e) {
				
			}
			try {
				if(pstmt != null && !pstmt.isClosed()) {					
					pstmt.close();
				}
			} catch(Exception e) {
				
			}
			try {
				if(conn != null && !conn.isClosed()) {					
					conn.close();
				}
			} catch(Exception e) {
				
			}
		}
		
	}
	
}
