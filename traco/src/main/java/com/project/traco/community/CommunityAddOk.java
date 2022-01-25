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

@WebServlet("/community/communityaddok.do")
public class CommunityAddOk extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		
		String postm_title = req.getParameter("postm_title");
		String boardm_content = req.getParameter("boardm_content");
		String communityc_seq = req.getParameter("communityc_seq");
		
		HttpSession session = req.getSession();
	
		CommunityDAO dao = new CommunityDAO();
		
		CommunityDTO dto = new CommunityDTO();
			
		dto.setPostm_title(postm_title);
		dto.setBoardm_content(boardm_content);
		dto.setMemberm_seq(session.getAttribute("member_seq").toString());
		dto.setCommunityc_seq(communityc_seq);
		
		int result = dao.add(dto); //1, 0
		
		//4.
		req.setAttribute("result", result);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/community/communityaddok.jsp");

		dispatcher.forward(req, resp);
	}

}