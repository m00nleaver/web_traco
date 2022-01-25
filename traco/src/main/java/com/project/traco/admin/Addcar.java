package com.project.traco.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/addcar.do")
public class Addcar extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		AdminPDAO pdao = new AdminPDAO();
		ArrayList<AdminPDTO> mlist = pdao.manulist(); //제조사리스트
		ArrayList<AdminPDTO> flist = pdao.fuellist(); //연료리스트
		ArrayList<AdminPDTO> klist = pdao.kindlist(); //크기리스트
		
		
		
		
		
 		req.setAttribute("klist", klist);
		req.setAttribute("mlist", mlist);
		req.setAttribute("flist", flist);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/addcar.jsp");

		dispatcher.forward(req, resp);
	}
}
