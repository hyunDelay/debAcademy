package member;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MemberDao {

	// 멤버변수
	private File file;
	
	public MemberDao() {
		String fileName = "D:\\dev\\hello.txt";
		file = new File(fileName);
	}

	// 회원가입 (데이터 집어넣기)
	public boolean join(MemberData memberData) {
		// 파라미터로 받은 데이터를 저장공간에 담기
		
		// 파일 객체
		// 보내는 스트림 연결 객체
		FileWriter fw = null;
		try {
			fw = new FileWriter(file);
			
			// 데이터 가공 ID@PWD@NICK
			String dataStr = memberData.getId() + "@" + memberData.getPwd() + "@" + memberData.getNick();
			// 데이터 보내기
			fw.write(dataStr);
			
		} catch (IOException e) {
			System.err.println("파일 객체 만드려다 IO예외 발생");
			return false;
		} finally { // 무조건 실행 후 리턴됨
			try {
				fw.close();
			} catch (IOException e) {
				System.err.println("FileWriter close하려다 IO예외발생");
			}
		}
		
		// 결과리턴
		return true;
	}
	
	// 로그인 (데이터 꺼내오기)
	public boolean login(MemberData memberData) {
		// 저장공간에서 데이터 꺼내기
		
		// 파일 객체
		// 받는 스트림 연결 객체
		BufferedReader br = null;
		FileReader fr = null;
		boolean isSuccess = false;
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			
			// 데이터 읽기
			String str = br.readLine();

			// 비교 (입력받은거랑 꺼낸데이터 비교)
			String id = memberData.getId();
			String pwd = memberData.getPwd();
			
			String memoId = str.substring(0, str.indexOf("@"));
			
			// str에서 잘라서 자른걸 다시 str에 넣어서 처음과같이 처리되게함
			// firstIdx(str.indexOf("@"))부터 마지막까지 자동으로 처리됨
			str = str.substring(str.indexOf("@") + 1);
			String memoPwd = str.substring(0, str.indexOf("@"));
			
			isSuccess = id.equals(memoId) && pwd.equals(memoPwd);
			return isSuccess;
			
		} catch (IOException e) {
			System.out.println("IOException 예외 발생");
		} finally {
			try {if(fr != null) {fr.close();}} catch (IOException e) {}
			try {if(fr != null) {br.close();}} catch (IOException e) {}
		}
		
		// 결과 리턴
		return isSuccess;
	}
	
}
