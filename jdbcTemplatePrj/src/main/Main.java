package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {

	public static void main(String[] args) throws Exception {
		
		System.out.println("메인메소드");
		
		File f = new File("info.txt");
		//BufferedReader br = new BufferedReader(new FileReader(f));
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		
		String url = br.readLine();
		String username = br.readLine();
		String pwd = br.readLine();
		
		System.out.println(url);
		System.out.println(username);
		System.out.println(pwd);
		
	}

}
