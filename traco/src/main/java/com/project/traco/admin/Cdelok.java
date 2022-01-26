package com.project.traco.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/cdelok.do")
public class Cdelok extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String seq = req.getParameter("seq");
		String tcseq = req.getParameter("tcseq");
		
		AdminPDAO pdao = new AdminPDAO();
		//System.out.println(seq);
		//System.out.println(tcseq);
		int tccresult=1;
		int tcresult=1;
		if(tcseq.equals("")) {
			tccresult = pdao.tccdel(tcseq);
			tcresult = pdao.tcdel(seq);
		}
		
		int bresult = pdao.boarddel(seq);
		//System.out.println(tccresult);
		//System.out.println(tcresult);
		//System.out.println(bresult);
		int result = tccresult + tcresult + bresult;
		
		req.setAttribute("result", result);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/cdelok.jsp");

		dispatcher.forward(req, resp);
	}
}
