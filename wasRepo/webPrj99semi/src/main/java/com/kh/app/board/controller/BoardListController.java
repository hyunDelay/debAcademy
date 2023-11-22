package com.kh.app.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.board.service.BoardService;
import com.kh.app.board.vo.BoardVo;

@WebServlet("/board/list")
public class BoardListController extends HttpServlet {
	
	// 게시글 목록 화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			// data 페이징??
			
			// service
			BoardService bs = new BoardService();
			List<BoardVo> boardVoList = bs.selectBoardList();
			
			// result (==view)
			req.setAttribute("boardVoList", boardVoList);
			req.getRequestDispatcher("/WEB-INF/views/board/list.jsp").forward(req, resp);
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("[ERROR-B001] 게시글 목록 조회 중 예외 발생");
			req.setAttribute("errorMsg", "게시글 목록 조회 ");
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
		
	}
	
}
