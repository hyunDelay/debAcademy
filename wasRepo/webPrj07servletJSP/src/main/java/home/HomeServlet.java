package home;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 데이터 준비
		
		// 비즈니스 로직
		
		// 결과처리 == 문자열 내보내기
//		resp.setContentType("text/html; charset=utf-8;");
//		PrintWriter out = resp.getWriter();
//		out.write("<h1>webPrj07servletJSP 홈페이지</h1>");
		
		req.setAttribute("k01", "v01");
		req.setAttribute("color", "red");
		req.getRequestDispatcher("WEB-INF/views/home.jsp").forward(req, resp);
		
	}
	
}
