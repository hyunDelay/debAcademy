package com.kh.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test")
public class TestServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("에이젝스 확인용");
		PrintWriter out = resp.getWriter();
		
		BoardVo vo = new BoardVo();
		vo.setTitle("titlegewfewgewgwegewㅋㅋㅋ");
		vo.setContent("contentfjkiojfwqjfwqokdowqfkowqjfowiqkdowqkf");
		
		String str = "{\"title\":\"ttt\",\"content\":\"ccc\"}";
		
		out.write(str);
	}

}
