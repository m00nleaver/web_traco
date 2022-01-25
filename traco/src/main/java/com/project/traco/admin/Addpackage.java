package com.project.traco.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/addpackage.do")
public class Addpackage extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//할일
		//1. DB 작업 > select > DAO 위임
		//2. 반환값 전달 + JSP 호출
		
		AdminPDAO pdao = new AdminPDAO();
		ArrayList<AdminPDTO> hlist = pdao.hlist(); //해시태그 리스트
		ArrayList<AdminPDTO> alist = pdao.alist(); //지역리스트
		
		req.setAttribute("hlist", hlist);
		req.setAttribute("alist", alist);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/addpackage.jsp");

		dispatcher.forward(req, resp);
	}
}
