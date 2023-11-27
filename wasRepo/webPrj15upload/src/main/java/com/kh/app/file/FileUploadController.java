package com.kh.app.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig(
		maxFileSize = 1024 * 1024 * 10 		// 파일 하나당 크기
		, maxRequestSize = 1024 * 1024 * 50 	// 리퀘스트 전체 크기
		)
@WebServlet("/file/insert")
public class FileUploadController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// data
		Part img = req.getPart("img");
		
		// 읽기 준비
		InputStream in = img.getInputStream();
		
		String sep = File.separator;
		
		// 내보내기 준비
		String path = req.getServletContext().getRealPath(sep + "resources" + sep + "upload" + sep + "img");
		System.out.println(path);
		String fileName = sep + "abc.png";
		File target = new File(path + fileName);
		FileOutputStream out = new FileOutputStream(target);
		
//		int data = 0;
//		while((data = in.read()) != -1) {
//			out.write(data);
//		}
		byte[] buf = new byte[1024];
		int size = 0;
		while((size = in.read(buf)) != -1) {
			out.write(buf, 0, size);
		}
		
		// 정리
		in.close();
		out.close();
		
		// result
		
	}
}
