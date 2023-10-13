package main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		// 소수 판별
		
		// 정수 입력받기
		Scanner sc = new Scanner(System.in); // 스캐너 객체 준비
		int num = sc.nextInt();
		
		// 소수인지 판단
		// - 약수가 2개 (1과 자기자신)
		// ==> 1, 자신 빼고 다른수로 나누어지면 안됨
		
		// 2 ~ num-1 중 num과 나눴을때 나누어 떨어지는지 여부 판단
		boolean isPrime = true;
		for(int i = 2; i < num; i++) {
			if(num % i == 0) {
				isPrime = false;
			}
		}

		// 결과 출력
		String str = "prime";
		str = isPrime ? "prime" : "not prime";
		if(num == 1) {
			System.out.println("not prime");
		} else {
			System.out.println(str);
		}

	}

}
