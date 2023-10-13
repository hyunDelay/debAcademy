package practice;

public class MethodTest {

	/*
	 * 메소드: 명령어 모아놓은 것
	 * 
	 * [문법]
	 * public void test(){명령;}
	 * 기본 :: 접근제한자 리턴타입 메소드명(){명령;}
	 * 
	 * 데이터를 받는 :: 접근제한자 리턴타입 메소드명(매개변수, ...){명령;}
	 * 
	 * 데이터를 반환하는 :: 접근제한자 리턴타입 메소드명(){명령; return 값;}
	 * 
	 * 데이터도 받고 반환도 하고 :: 접근제한자 리턴타입 메소드명(매개변수, ...){명령; return 값;}
	 * 
	 * */
	
	// 기본
	public void test(){
		System.out.println("생일축하합니다");
	}

	// 매개변수 있는 (1개)
	public void test01(int x) {
		System.out.println(x + 5);
	}
	
	// 매개변수 있는 (2개)
	public void test02(int x, int y) {
		int result = x + y;
		System.out.println(result * 3);
	}
	
	// 리턴값이 있는 (리턴값은 여러개 불가능)
	public int test03() {
		return 123;
	}
	
	// 매개변수, 리턴값이 있는
	public int test04(int a, int b) {
		int result = a + b;
		return result;
	}
}
