package com.project.traco.flightticket;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.traco.packagetour.jeju.MembersDTO;

@WebServlet("/flightMember.do")
public class FlightMember extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		String memberSeq = req.getParameter("memberSeq");
		
		FlightDAO dao = new FlightDAO();
		
		MembersDTO dto = dao.getMember(memberSeq);
		
		//MemberDTO -> (형식? : JSON) -> ajax
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		PrintWriter writer = resp.getWriter();
		
		/*
		
			{
				"seq": "1",
				"name": "홍길동",
				"birth": "25",
				"email": "aaa@naver.com",
				"gender": "m"
			}
		
		*/
		int year = Calendar.getInstance().get(Calendar.YEAR);
		
		
		
		String age =
		(year+ 1 
				- Integer.parseInt(
						("19"+dto.getBirth().substring(0, 2))
						))+"";
		
		dto.setBirth(age);
		try {
			String temp = "";
			
			temp += "{";
			temp += String.format("\"seq\": \"%s\",", dto.getSeq());
			temp += String.format("\"name\": \"%s\",", dto.getName());
			temp += String.format("\"birth\": \"%s\",", dto.getBirth());
			temp += String.format("\"email\": \"%s\",", dto.getEmail());
			temp += String.format("\"gender\": \"%s\"", dto.getGender());		
			temp += "}";
			
			writer.print(temp);
			writer.close();
			
			
			System.out.println(temp);
		} catch (Exception e) {
			System.out.println("d");
			e.printStackTrace();
		
		}
		
		
		
		
		
	}
}
