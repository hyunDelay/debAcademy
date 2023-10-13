package main;

public class TestClass {

	public void method01() {
		System.out.println("메소드 01 시작됨");
		method02();
		System.out.println("메소드 01 끝");
	}
	public void method02() {
		System.out.println("메소드 02 시작됨");
		System.out.println("메소드 02 끝");

		try {
			System.out.println(11111);
			int x = 3 / 0;
			System.out.println(22222);
		} catch(Exception e) {
			System.out.println("잡았죠?");
		}
//		catch(ArithmeticException y) {
//			System.out.println("0으로 나누려는거 잡았다 ㅎㅎ");
//		}
		
		method03();
	}
	
	public void method03() {
		System.out.println("메소드 03 시작됨");
		System.out.println("메소드 03 끝");
	}
	
}
