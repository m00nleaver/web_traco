package com.project.traco.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/medit.do")
public class Medit extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String seq = req.getParameter("seq");
		
		
		AdminPDAO pdao = new AdminPDAO();
		
		AdminPDTO pdto = pdao.mget(seq);
		
		AdminIDAO idao = new AdminIDAO();
		AdminIDTO idto = idao.imget(seq); //미니투어와 연결된 이미지번호 이름/ 썸네일 번호이름 가져오기 가져오기
		
		AdminIDTO idtoname = idao.getmtname(seq); //썸네일 이름
		AdminIDTO idtoiname = idao.getminame(seq); //이미지 이름
		
		ArrayList<AdminPDTO> alist = pdao.alist(); //지역리스트
		ArrayList<AdminPDTO> catlist = pdao.catlist(); //카테고리 리스트
		
		req.setAttribute("idtoiname", idtoiname);
		req.setAttribute("idtoname", idtoname);
		req.setAttribute("pdto", pdto);
		req.setAttribute("idto", idto);
		req.setAttribute("alist", alist);
		req.setAttribute("catlist", catlist);
		
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/medit.jsp");

		dispatcher.forward(req, resp);
	}
}
