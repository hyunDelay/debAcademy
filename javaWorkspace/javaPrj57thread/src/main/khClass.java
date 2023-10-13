package main;

public class khClass implements Runnable {

	@Override
	public void run() {
		System.out.println("런메소드 실행");
		Thread x = Thread.currentThread();
		String str = x.getName();
		System.out.println(str);
	}

}
