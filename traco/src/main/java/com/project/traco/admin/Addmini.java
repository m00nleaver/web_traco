package com.project.traco.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/addmini.do")
public class Addmini extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		AdminPDAO pdao = new AdminPDAO();
		ArrayList<AdminPDTO> hlist = pdao.hlist(); //해시태그 리스트
		ArrayList<AdminPDTO> alist = pdao.alist(); //지역리스트
		ArrayList<AdminPDTO> catlist = pdao.catlist(); //카테고리 리스트
		
		req.setAttribute("hlist", hlist);
		req.setAttribute("alist", alist);
		req.setAttribute("catlist", catlist);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/addmini.jsp");

		dispatcher.forward(req, resp);
	}
}