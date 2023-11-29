package home;

import java.io.File;
import java.io.FileInputStream;
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

import oracle.net.aso.b;

@MultipartConfig(
			fileSizeThreshold = 1024 * 1024 * 100 ,
			maxFileSize = 1024 * 1024 * 1000 ,
			maxRequestSize = 1024 * 1024 * 5000
		)
@WebServlet("/test")
public class TestServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Part f = req.getPart("file");
		
		String path = "/resources/upload/img"; 
		String realPath = req.getServletContext().getRealPath(path);
		String name = "/kh_" + (int)(Math.random() * 100000) + ".png";
		File target = new File(realPath + name);
		
		InputStream in = f.getInputStream();
		FileOutputStream out = new FileOutputStream(target);
		
		byte[] buf = new byte[1024];
		int size = 0;
		while( (size = in.read(buf)) != -1 ) {
			out.write(buf, 0 , size);
		}
		
		String root = req.getContextPath();
		String fileUrl = root + path + name;
		resp.getWriter().write(fileUrl);
		
	}

}























