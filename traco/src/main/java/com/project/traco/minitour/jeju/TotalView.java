package com.project.traco.minitour.jeju;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/minitour/jeju/minitotalview.do")
public class TotalView extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		
		MiniPackageDAO tagDao = new MiniPackageDAO();
		
		ArrayList<TagDTO> tagList = tagDao.tagList();
		

		
		
		String hello = "whos there";
		
		req.setAttribute("tagList", tagList);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/minitour/jeju/totalview.jsp");

		dispatcher.forward(req, resp);
	}
}
