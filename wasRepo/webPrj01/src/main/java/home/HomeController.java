package home;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class HomeController extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 클라이언트가 보낸 데이터 받기
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		String nick = req.getParameter("nick");
		
		System.out.println("아이디 : " + id);
		System.out.println("패스워드 : " + pwd);
		System.out.println("닉네임 : " + nick);
		System.out.println("home이라는 요청 받음");
		
		resp.setContentType("text/html; charset=utf-8;");
		PrintWriter pw = resp.getWriter();
		
		pw.write("<!DOCTYPE HTML>");
		pw.write("<html>");
		pw.write("<head>");
		pw.write("<title>문서제목</title>");
		pw.write("<style>");
		pw.write("h1 {background-color: lightgray;}");
		pw.write("</style>");
		pw.write("</head>");
		pw.write("<body>");
		pw.write("<h1>home page홈페이지</h1>");
		pw.write("<span>" + nick + "님 환영합니다.</span>");
		pw.write("<script>");
		pw.write("alert('" + nick + "님 환영합니다.')");
		pw.write("</script>");
		pw.write("</body>");
		pw.write("</html>");
		
	}
	
}
