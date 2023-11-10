package calculator;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/divide")
public class DivideServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html; charset=utf-8;");
		PrintWriter pw = resp.getWriter();
		pw.write("<h1>divide페이지</h1>");
		
		String num1 = req.getParameter("num1");
		String num2 = req.getParameter("num2");
		
		int result = Integer.parseInt(num1) / Integer.parseInt(num2);
		
		pw.write("<h2>나누기 :: " + result + "</h2>");
		
	}

}
