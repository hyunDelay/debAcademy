package kh.model.vo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class server {

	public void server() {
		int port = 3000;
		ServerSocket server;
		
		try {
			server = new ServerSocket(port);
			while(true) {
				Socket client = server.accept();
			}
		} catch(Exception e) {
			System.out.println("연결오류");
		}
		
	}
	
	public void output() {
		FileWriter fw = null;
		try {
			new File("D:\\")
			fw = new FileWriter("test.txt", true);
			fw.write(97);
			fw.write(65);
					
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
