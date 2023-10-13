package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintStream;

public class Main {

	public static void main(String[] args) throws Exception {

		System.out.println("===== 스트림 =====");
		
		File f = new File("D:\\dev\\hellow.txt");
//		f.delete(); // 파일 삭제
//		// 1byte 단위로 처리
//		FileOutputStream fos = new FileOutputStream(f);
//		fos.write(70);
		
//		FileWriter fw = new FileWriter(f);
//		fw.write("글자한번써볼게요");
//		fw.flush();
		
//		PrintStream ps = new PrintStream(f);
//		ps.println("테스트입니다 ");
		
		//==============================================
		
//		FileInputStream fis = new FileInputStream(f);
//		for(int i = 0; i < 3; i++) {
//			int result = fis.read();
//			char x = (char)result;
//			System.out.println(x);
//		}
		
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr); // Reader타입객체 글자모아주는 바구니역할
		String result = br.readLine(); // 줄바꿈 직전까지만 읽어옴
		System.out.println(result);
		String result2 = br.readLine();
		System.out.println(result2);
		
		
	}

}
