package com.project.traco.flightticket;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/flightidcheck.do")
public class Flightidcheck extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//할일
		//1. 데이터 가져오기(id)
		//2. DB 작업 > select > DAO 위임
		//3. 결과 > 피드백(반환)
		String id = req.getParameter("id");
		//이름
		String rez_name = req.getParameter("rez_name");		
		//이메일
		String rez_email = req.getParameter("rez_email");
		//생년월일
		String rez_date = req.getParameter("rez_date");
		//성별
		String rez_gender = req.getParameter("rez_gender");
		
		FlightDAO dao = new FlightDAO();
		
		int result = dao.check(id);
		
		PrintWriter writer = resp.getWriter();
		writer.print(result);
		writer.close();

	}

}