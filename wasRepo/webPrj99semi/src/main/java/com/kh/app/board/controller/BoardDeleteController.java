package com.kh.app.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.board.service.BoardService;
import com.kh.app.member.vo.MemberVo;

@WebServlet("/board/delete")
public class BoardDeleteController extends HttpServlet {
	
	// 게시글 삭제
	// UPDATE BOARD SET STATUS = 'X' WHERE NO = ?
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			// data
			String no = req.getParameter("no");
			MemberVo loginMember = (MemberVo) req.getSession().getAttribute("loginMember");
			if(loginMember == null) {
				throw new Exception("잘못된 접근입니다. 로그인을 한 후 시도하세요.");
			}
			String memberNo = loginMember.getNo();
			
			// service
			BoardService bs = new BoardService();
			int result = bs.delete(no, memberNo);
			
			// result
			if(result != 1) {
				throw new Exception("게시글 삭제 중 에러발생");
			}
			
			// 게시글 삭제 성공 => 게시글 목록
			req.getSession().setAttribute("alertMsg", "게시글 삭제가 완료되었습니다.");
			resp.sendRedirect("/app99/board/list");
			
		} catch(Exception e) {
			System.out.println("[ERROR-B004] 게시글 삭제 중 에러 발생");
			e.printStackTrace();
			req.setAttribute("errorMsg", "게시글 삭제 중 에러 발생");
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
		
		
	}
	
}
