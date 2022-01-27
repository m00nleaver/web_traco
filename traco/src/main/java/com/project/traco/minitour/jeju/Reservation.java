package com.project.traco.minitour.jeju;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/minitour/jeju/minireservation.do")
public class Reservation extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String miniSeq = req.getParameter("miniSeq");
		String memberSeq = req.getParameter("memberSeq");
		String daterange = req.getParameter("daterange");
		String quantity = req.getParameter("quantity");
		String start = req.getParameter("start");
		String end = req.getParameter("end");
		
		
		System.out.println(start);
		System.out.println(end);
		
		System.out.println(miniSeq);
		System.out.println(memberSeq);
		System.out.println(daterange);
		System.out.println(quantity);
		
		
		MiniPackageDAO itemDao = new MiniPackageDAO();
		MiniPackageDTO itemDto = itemDao.item(miniSeq);
		
		
		String quant = ""+(Integer.parseInt(quantity)-1);
		
		String date = daterange.split(" - ")[0];
		
		date = date.split("/")[2].substring(2,4)+"/"+date.split("/")[0]+"/"+date.split("/")[1];
		
		System.out.println(date);
		
		req.setAttribute("memberSeq", memberSeq);
		req.setAttribute("miniSeq", miniSeq);
		req.setAttribute("itemdto", itemDto);
		req.setAttribute("quantity", quant);
		req.setAttribute("date", date);
		req.setAttribute("start", start);
		req.setAttribute("end", end);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/minitour/jeju/reservation.jsp");

		dispatcher.forward(req, resp);
	}
}

