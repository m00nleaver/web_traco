package com.project.traco.packagetour;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/packagetour/jeju.do")
public class Jeju extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//		할일 
//		1. DB 작업 : select > DAO에게 위임
		
		
		JejuDAO dao = new JejuDAO();
		ArrayList<JejuDTO> list = dao.list()
		
		
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/packagetour/jeju.jsp");

		dispatcher.forward(req, resp);
	}
}
