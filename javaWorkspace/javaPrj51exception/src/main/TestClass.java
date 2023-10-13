package main;

public class TestClass {

	public void method01() {
		System.out.println("method01 start");
		method02();
		System.out.println("method01 end");
	}
	
	public void method02() {
		System.out.println("method02 start");
		try {
//			throw new Exception("ㅋㅋㅋ");
			throw new khException();
		} catch(Exception e) {
			System.out.println("예외발생");
			System.out.println(e.getMessage());
		}
		method03();
		System.out.println("method02 end");
	}
	
	public void method_02() {
		System.out.println("method_02 start");
		
		try {
			// 예외발생 의심코드
			System.out.println("111111111");
			int x = 1 / 1;
			System.out.println("222222222");
		} catch(Exception e) { // 잡으려는 예외 타입
			System.out.println("예외발생");
//			System.out.println(e);
//			System.out.println(e.getMessage());
//			e.printStackTrace();
		} finally {
			System.out.println("finally 블록");
		}
		
		method03();
		System.out.println("method_02 end");
	}
	public void method03() {
		System.out.println("method03 start");
		System.out.println("method03 end");
	}
	
}
