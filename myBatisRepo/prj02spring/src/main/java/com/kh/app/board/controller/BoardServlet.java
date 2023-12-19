package com.kh.app.board.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/*")
public class BoardServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		String method = req.getMethod();
		
		String data1 = req.getParameter("");
		
		Map<String, String> dataMap = new HashMap<String, String>();
		dataMap.put("title", data1);
		
		String result = "";
		if(uri.equals("/board/list") && method.equals("GET")) {
			result = new BoardController().selectList(req);
		} else if(uri.equals("/board/write") && method.equals("GET")) {
			result = new BoardController().showBoardWritePage(req);
		} else if(uri.equals("/board/write") && method.equals("POST")) {
			result = new BoardController().insertBoard(req);
		}
		
		// view resolve
		if(result.startsWith("redirect:")) {
			resp.sendRedirect(result);
		} else {
			String a = "/WEB-INF/views";
			String b = ".jsp";
			req.getRequestDispatcher(a + result + b).forward(req, resp);
		}
		
	}
}
