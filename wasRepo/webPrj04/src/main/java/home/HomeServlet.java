package home;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/home", displayName = "뭔데")
public class HomeServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 데이터 준비
		String nick = req.getParameter("nick");
		
		// 비즈니스 로직 == 서비스 로직
		// ~~~~~~~~~~~~~~~~~~~~~~
		
		// 결과 == 문자열 내보내기
//		resp.setContentType("text/html; charset=utf-8;");
//		PrintWriter pw = resp.getWriter();
//		pw.write("<h1>" + nick + "님 안녕하세요!</h1>");
		req.getRequestDispatcher("WEB-INF/abc.jsp").forward(req, resp);
		
	}
}
