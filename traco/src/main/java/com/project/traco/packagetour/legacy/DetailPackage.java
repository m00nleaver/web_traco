package com.project.traco.packagetour;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/packagetour/detailpackage.do")
public class DetailPackage extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		//할일 
		//1. 데이터 가져오기 (title)
		//2. DB 작업 > select
		//3. 결과 -> 상세페이지로 이동
		
		//1. 
		
		req.setCharacterEncoding("UTF-8");
		
		String title = req.getParameter("title");
		
		
		System.out.println(title);
		
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/packagetour/detailpackage.jsp");

		dispatcher.forward(req, resp);
	}
}
