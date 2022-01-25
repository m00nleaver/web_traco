package com.project.traco.community;

import java.io.IOException;
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

@WebServlet("/community/communityeditok.do")
public class CommunityEditOk extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		//2.
		String boardm_seq = req.getParameter("boardm_seq");
		String postm_title = req.getParameter("postm_title");
		String boardm_content = req.getParameter("boardm_content");
		
		//3.
		CommunityDAO dao = new CommunityDAO();
		
		CommunityDTO dto = new CommunityDTO();
		dto.setBoardm_seq(boardm_seq);
		dto.setPostm_title(postm_title);
		dto.setBoardm_content(boardm_content);
		
		int result = dao.Communityedit(dto); //1,0
		
		//4.
		req.setAttribute("result", result);
		req.setAttribute("boardm_seq", boardm_seq);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/community/communityeditok.jsp");

		dispatcher.forward(req, resp);
	}

}