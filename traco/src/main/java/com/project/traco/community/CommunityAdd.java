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

@WebServlet("/community/communityadd.do")
public class CommunityAdd extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		if (session.getAttribute("member_id") == null) {
			resp.sendRedirect("/traco/member/member.do");
			return;
		}
		
		CommunityDAO dao = new CommunityDAO();
		ArrayList<CommunityDTO> Kategorie = dao.Kategorie();
		
	
		req.setAttribute("Kategorie", Kategorie);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/community/communityadd.jsp");

		dispatcher.forward(req, resp);
	}

}