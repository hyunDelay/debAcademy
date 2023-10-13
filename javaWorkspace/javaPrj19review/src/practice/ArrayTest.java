package practice;

public class ArrayTest {
	
	/*
	 * 배열
	 * 
	 * type[] name = new type[size];
	 * 변수타입[] 변수이름 = new 변수타입[배열사이즈]
	 * int[] arr = new int[2];
	 * 
	 * 타입이 같은 변수 여러개를 한번에 만들어준다.
	 * [주의사항] :: 처음부터 사이즈를 지정해줘야 한다.
	 * 
	 * 다차원 배열
	 * int[][] arr = new int[3][3];
	 * 
	 * */
	
	public void test() {
		
		// 배열변수 선언
		int[] x;
		
		// 배열 생성 후 배열 변수에 할당
		x = new int[3];
		
		x[0] = 101; // 0번 인덱스 할당
		System.out.println(x[0]); // 0번 인덱스 출력
		
		
	}

}
