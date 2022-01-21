package com.project.traco.community;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;

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

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/community/commentaddok.do")
public class CommentAddOk extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		
		//2.
		String commentm_content = req.getParameter("commentm_content");
		System.out.println(commentm_content);
		String boardm_seq = req.getParameter("boardm_seq");
		System.out.println(boardm_seq);
		
		HttpSession session = req.getSession();
		
		CommunityDAO dao = new CommunityDAO();
		
		CommentDTO cdto = new CommentDTO();
		cdto.setCommentm_content(commentm_content);
		cdto.setPostm_seq(boardm_seq);
		cdto.setMember_id(session.getAttribute("member_id").toString());
		cdto.setMemberm_seq(session.getAttribute("member_seq").toString());
		
		int result = dao.addComment(cdto); //1,0
		
		//4.
		if (result == 1) {
			resp.sendRedirect("/traco/community/communityview.do?boardm_seq=" + boardm_seq);
		} else {
			PrintWriter writer = resp.getWriter();
			writer.println("<html><body><script>");
			writer.println("alert('failed'); history.back();");
			writer.println("</script></body></html>");
			writer.close();
		}
		
	}

}