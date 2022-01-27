package com.project.traco.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/mconfirm.do")
public class Mconfirm extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		AdminPDAO pdao = new AdminPDAO();
		
		ArrayList<AdminPDTO> list = pdao.milist();
		
		for (AdminPDTO pdto : list) {
			
		
			
			//제목이 길면 자르기
			if (pdto.getPname().length() > 15) {
				pdto.setPname(pdto.getPname().substring(0, 15) + "..");
			}
			
			
		}
		
		req.setAttribute("list", list);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/mconfirm.jsp");

		dispatcher.forward(req, resp);
	}
}