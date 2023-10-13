package practice;

public class ControlTest {
	
	/*
	 * 제어문 :: 프로그램의 흐름을 제어
	 * 
	 * - 조건문 (분기점)
	 * if, else if, else
	 * switch
	 * 삼항연산자
	 * 
	 * - 반복문 
	 * while - 무한반복할때
	 * for - 조건에따라 반복할때
	 * do-while - 무조건 한번은 실행할때
	 * break, continue
	 * 
	 * */
	
	public void test() {
		
		// 조건문 (양수/음수/제로)
		int num = 44;
		if(num == 0) {
			System.out.println("Zero");
		} else if(num > 0) {
			System.out.println("양수");
		} else {
			System.out.println("음수");
		}
		
		// 반복문 (무한반복출력, 1~100 출력)
		for(int i = 1; i <= 100; i++) {
			System.out.println(i);
		}
		
	}

}
