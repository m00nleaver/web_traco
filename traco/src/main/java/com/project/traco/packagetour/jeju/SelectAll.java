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

@WebServlet("/tour/all.do")
public class SelectAll extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		


		
		PackageDAO dao = new PackageDAO();
		ArrayList<PackageDTO> alist = dao.alist();
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		
		
		PrintWriter writer = resp.getWriter();
		
		

		
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
		
		for (PackageDTO dto : alist) {
			temp += "{";
				temp += String.format("\"seq\": \"%s\",", dto.getPkSeq());
				temp += String.format("\"name\": \"%s\",", dto.getPkName());
				temp += String.format("\"quantity\": \"%s\",", dto.getPkQuantity());
				temp += String.format("\"startdate\": \"%s\",", dto.getPkStartDate());
				temp += String.format("\"enddate\": \"%s\",", dto.getPkEndDate());
				temp += String.format("\"adultprice\": \"%s\",", dto.getAdultPrice());
				temp += String.format("\"kidprice\": \"%s\",", dto.getKidPrice());
				temp += String.format("\"toddlerprice\": \"%s\",", dto.getToddlerPrice());
				temp += String.format("\"thumbseq\": \"%s\",", dto.getPkThumbSeq());
				temp += String.format("\"imageseq\": \"%s\",", dto.getPkImageSeq());
				temp += String.format("\"period\": \"%s\",", dto.getPkPeriod());
				temp += String.format("\"tag\": \"%s\",", dto.getPkTagName());
				temp += String.format("\"status\": \"%s\"", dto.getPkStatus());
			temp += "},";
		}
		
		temp = temp.substring(0, temp.length() - 1);
		
		temp += "]";
		
		writer.print(temp);
		writer.close();
		
		
		System.out.println(temp);
		
		
		
		
		
		
	}
}

	

