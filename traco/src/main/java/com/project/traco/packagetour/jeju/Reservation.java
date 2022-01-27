package com.project.traco.packagetour.jeju;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/packagetour/jeju/reservation.do")
public class Reservation extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String pkSeq = req.getParameter("pkSeq");
		String memberSeq = req.getParameter("memberSeq");
		String daterange = req.getParameter("daterange");
		String quantity = req.getParameter("quantity");
		String start = req.getParameter("start");
		String end = req.getParameter("end");
		
		
		System.out.println(start);
		System.out.println(end);
		
		System.out.println(pkSeq);
		System.out.println(memberSeq);
		System.out.println(daterange);
		System.out.println(quantity);
		
		
		PackageDAO itemDao = new PackageDAO();
		PackageDTO itemDto = itemDao.item(pkSeq);
		
		
		String quant = ""+(Integer.parseInt(quantity)-1);
		
		String date = daterange.split(" - ")[0];
		
		date = date.split("/")[2].substring(2,4)+"/"+date.split("/")[0]+"/"+date.split("/")[1];
		
		System.out.println(date);
		
		req.setAttribute("memberSeq", memberSeq);
		req.setAttribute("pkSeq", pkSeq);
		req.setAttribute("itemdto", itemDto);
		req.setAttribute("quantity", quant);
		req.setAttribute("date", date);
		req.setAttribute("start", start);
		req.setAttribute("end", end);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/packagetour/jeju/reservation.jsp");

		dispatcher.forward(req, resp);
	}
}

