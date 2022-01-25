package com.project.traco.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/pedit.do")
public class Pedit extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//번호 가져와서 넘기기
		//System.out.println(req.getParameter("seq"));
		String seq = req.getParameter("seq"); //번호
		
		
		AdminPDAO pdao = new AdminPDAO();
		
		AdminPDTO pdto = pdao.pget(seq);
		
		AdminIDAO idao = new AdminIDAO();
		AdminIDTO idto = idao.iget(seq); //이미지번호 이름/ 썸네일 번호이름 가져오기 가져오기
		
		AdminIDTO idtoname = idao.gettname(seq); //썸네일 이름
		AdminIDTO idtoiname = idao.getiname(seq); //이미지 이름
		
		ArrayList<AdminPDTO> alist = pdao.alist(); //지역리스트
		
		req.setAttribute("idtoiname", idtoiname);
		req.setAttribute("idtoname", idtoname);
		req.setAttribute("pdto", pdto);
		req.setAttribute("idto", idto);
		req.setAttribute("alist", alist);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/pedit.jsp");

		dispatcher.forward(req, resp);
	}
}
