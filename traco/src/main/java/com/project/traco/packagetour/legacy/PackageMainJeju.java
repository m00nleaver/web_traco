package com.project.traco.packagetour;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/packagetour/packagemainjeju.do")
public class PackageMainJeju extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		String region = "jeju";
		String mode = "main";

		
		
		//할일
		//1. DB 조회 > select : DAO에게 위임
		//2. 결과 -> JSP에서 출력
		
		
		//조회조건 : HashMap
		HashMap<String, String> map = new HashMap<String, String>();
		
		
		
		
		//1
		PackageBoardDAO dao = new PackageBoardDAO();
		
		ArrayList<PackageBoardDTO> list = dao.list(map);
		
		
		
		req.setAttribute("list", list);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/packagetour/packagemainjeju.jsp");

		dispatcher.forward(req, resp);
	}
}
