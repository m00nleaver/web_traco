package com.project.traco.packagetour.jeju;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/tour/area.do")
public class SelectAreaList extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String big = req.getParameter("big");
		
		
		System.out.println(big);
		
		
		PackageDAO dao = new PackageDAO();
		ArrayList<AreaDTO> arealist = dao.arealist(big);
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		
		
		PrintWriter writer = resp.getWriter();
		
		
		for (AreaDTO dto : arealist) {
			
			dto.setAREA_SMALL(dto.getAREA_SMALL().split(" ")[1]);
			
		}
		
		/*
		[
			{
				"small": "서구",
			},
			{
				"id": "hong",
			}
		]	
		*/
		String temp = "";
		
		temp += "[";
		
		for (AreaDTO dto : arealist) {
			temp += "{";
				temp += String.format("\"small\": \"%s\"", dto.getAREA_SMALL());
			temp += "},";
		}
		
		temp = temp.substring(0, temp.length() - 1);
		
		temp += "]";
		
		writer.print(temp);
		writer.close();
		
		
		System.out.println(temp);
		
		
		
	}
}


