package com.kh.app.test;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test")
public class Test extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doget called");
		String str = req.getParameter("str");
		resp.getWriter().write("{\"msg\":\"good\"}");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("dopost called");
		
		// body에 담긴 데이터 읽기
		BufferedReader br = req.getReader();
		String bodyData = "";
		String temp = "";
		while((temp = br.readLine()) != null) {
			bodyData += temp;		
		}
		System.out.println("bodyData : " + bodyData);
		
		resp.getWriter().write("{\"msg\":\"good\"}");
	}
}
