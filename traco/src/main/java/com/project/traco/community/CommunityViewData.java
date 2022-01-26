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

@WebServlet("/community/communityviewdata.do")
public class CommunityViewData extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		String boardm_seq = req.getParameter("boardm_seq");
		String member_id = session.getAttribute("member_id").toString();
		
		CommunityDAO dao = new CommunityDAO();
		
		int searchresult = dao.upstatussearch(boardm_seq,member_id);
		
		int upresult = 0;
		int downresult = 0;	
		
		if(searchresult == 0) {
			
			int addresult = dao.upstatusadd(boardm_seq,member_id);
			
			if(addresult == 1) {
				upresult = dao.addUpCount(boardm_seq);
				String temp = String.format("{ \"upresult\": %d, \"downresult\": %d }", upresult,downresult);
				PrintWriter writer = resp.getWriter();
				writer.print(temp);
				writer.close();
			}
		}else if(searchresult == 1) {
			
			int delresult = dao.upstatusdel(boardm_seq,member_id);
			
			if(delresult == 1) {
				downresult = dao.delUpCount(boardm_seq);
				String temp = String.format("{ \"upresult\": %d, \"downresult\": %d }", upresult,downresult);
				PrintWriter writer = resp.getWriter();
				writer.print(temp);
				writer.close();
			}
		}
	}
}