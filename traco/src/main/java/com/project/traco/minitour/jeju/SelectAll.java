package com.project.traco.minitour.jeju;


	
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/minitour/miniall.do")
public class SelectAll extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		


		
		MiniPackageDAO dao = new MiniPackageDAO();
		ArrayList<MiniPackageDTO> alist = dao.alist();
		
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
		
		for (MiniPackageDTO dto : alist) {
			temp += "{";
				temp += String.format("\"seq\": \"%s\",", dto.getMINIPM_SEQ());
				temp += String.format("\"name\": \"%s\",", dto.getMINIPM_NAME());
				temp += String.format("\"quantity\": \"%s\",", dto.getMINIPM_COUNT());
				temp += String.format("\"startdate\": \"%s\",", dto.getMINIPM_START());
				temp += String.format("\"enddate\": \"%s\",", dto.getMINIPM_END());
				temp += String.format("\"adultprice\": \"%s\",", dto.getMINIPM_PRICE1());
				temp += String.format("\"kidprice\": \"%s\",", dto.getMINIPM_PRICE2());
				temp += String.format("\"toddlerprice\": \"%s\",", dto.getMINIPM_PRICE3());
				temp += String.format("\"thumbseq\": \"%s\",", dto.getTHUMBNAILI_SEQ());
				temp += String.format("\"imageseq\": \"%s\",", dto.getIMAGEM_SEQ());
				temp += String.format("\"tag\": \"%s\",", dto.getHASHTAG_NAME());
				temp += String.format("\"status\": \"%s\"", dto.getMSTATUS());
			temp += "},";
		}
		
		temp = temp.substring(0, temp.length() - 1);
		
		temp += "]";
		
		writer.print(temp);
		writer.close();
		
		
		System.out.println(temp);
		
		
		
		
		
		
	}
}

	

