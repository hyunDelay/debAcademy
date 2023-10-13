package member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class MemberController {

	// 멤버 변수
	private Scanner sc;

	// 기본 생성자
	public MemberController() {
		this.sc = new Scanner(System.in);
	}

	public void join() throws Exception {
		System.out.println("----- 회원 가입 -----");
		
		// 연결 준비
		String url = "jdbc:oracle:thin@127.0.0.1:1521:xe";
		String username = "C##KH_JDBC";
		String pwd = "1234";
		
		// 디비 연결 == conn 얻기
		Connection conn = DriverManager.getConnection(url, username, pwd);
		
		// 데이터 입력받기
		
		System.out.print("아이디 : ");
		String userId = sc.nextLine();
		System.out.print("비밀번호 : ");		
		String userPwd = sc.nextLine();
		
		// 쿼리 실행
		String sql = "INSERT INTO MEMBER(ID, PWD) VALUES(?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, userId);
		pstmt.setString(2, userPwd);
		int result = pstmt.executeUpdate();
		
		// 결과 처리
		if(result == 1) {
			System.out.println("회원가입 성공");
		} else {
			System.err.println("회원가입 실패...");
		}
		
	}
	
	public void login() throws Exception {
		
		System.out.println("----- 로그인 -----");
		
		// 연결 준비
		String url = "jdbc:oracle:thin@127.0.0.1:1521:xe";
		String username = "C##KH_JDBC";
		String pwd = "1234";
		
		// 디비 연결 == conn 얻기
		Connection conn = DriverManager.getConnection(url, username, pwd);
		
		// 유저 입력
		System.out.print("아이디 : ");
		String inputId = sc.nextLine();
		System.out.print("비밀번호 : ");
		String inputPwd = sc.nextLine();

		// 쿼리 실행
		String sql = "SELECT * FROM MEMBER WHERE ID = ? AND PWD = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, inputId);
		pstmt.setString(2, inputPwd);
		ResultSet rs = pstmt.executeQuery(sql);
		
		// 결과 처리
		while(rs.next()) {
			
		}
	}
	
}
