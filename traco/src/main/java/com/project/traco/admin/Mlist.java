package com.project.traco.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/mlist.do")
public class Mlist extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		AdminPDAO pdao = new AdminPDAO();
		
		ArrayList<AdminPDTO> mlist = pdao.mlist();
		
		for (AdminPDTO pdto : mlist) {
			
			//날짜 자르기
			pdto.setPstart(pdto.getPstart().substring(2,10));
			pdto.setPend(pdto.getPend().substring(2,10));
			
			
			
			//제목이 길면 자르기
			if (pdto.getPname().length() > 17) {
				pdto.setPname(pdto.getPname().substring(0, 17) + "..");
			}
			
			
		}
		
		req.setAttribute("mlist", mlist);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/mlist.jsp");

		dispatcher.forward(req, resp);
	}
}
