package main;

public class Main {

	public static void main(String[] args) {
		System.out.println("===== 쓰레드 =====");
		
		Thread t0 = Thread.currentThread();
		
//		String t0name = t0.getName();
//		System.out.println(t0.getName());
//		System.out.println(t0name);
		
		// 쓰레드 생성
		Thread t1 = new Thread(new khClass());
		t1.setName("내가만든쓰레드");
		t1.start();
		
	}

}
