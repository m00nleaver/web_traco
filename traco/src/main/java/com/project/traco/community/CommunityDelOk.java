package com.project.traco.community;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/community/communitydelok.do")
public class CommunityDelOk extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		String boardm_seq = req.getParameter("boardm_seq");

	
		CommunityDAO dao = new CommunityDAO();
		
		//현재 글에 달린 댓글 삭제하기
		dao.CommentdelAll(boardm_seq);

		int result = dao.Communitydel(boardm_seq); // 1,0
//		System.out.println(result);
	
		req.setAttribute("result", result);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/community/communitydelok.jsp");

		dispatcher.forward(req, resp);
	}

}
