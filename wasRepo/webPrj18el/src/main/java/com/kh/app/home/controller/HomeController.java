package com.kh.app.home.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.home.vo.BoardVo;

@WebServlet("/home")
public class HomeController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setAttribute("x", "안녕하세요");
		
		List<BoardVo> boardVoList = new ArrayList<BoardVo>();
		boardVoList.add(new BoardVo("게시글제목1", "작성자1", "482"));
		boardVoList.add(new BoardVo("게시글제목2", "작성자1", "53"));
		boardVoList.add(new BoardVo("게시글제목3", "작성자1", "26"));
		boardVoList.add(new BoardVo("게시글제목4", "작성자1", "4388"));
		boardVoList.add(new BoardVo("게시글제목5", "작성자1", "7"));
		boardVoList.add(new BoardVo("게시글제목6", "작성자1", "586"));
		
		req.setAttribute("voList", boardVoList);
		
		req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req, resp);
	}
}
