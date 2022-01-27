package com.project.traco.rentcar;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/rentcar/rentcarlist.do")
public class RentCarList extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RentCarDAO dao = new RentCarDAO();

        ArrayList<RentCarDTO> list = dao.Kategorie();
      
        req.setAttribute("list", list);
		

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/rentcar/rentcarlist.jsp");
		dispatcher.forward(req, resp);

	}
}
