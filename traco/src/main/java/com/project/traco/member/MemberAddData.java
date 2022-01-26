package com.project.traco.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/memberadddata.do")
public class MemberAddData extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String member_id = req.getParameter("member_id");
		System.out.println(member_id);
		MemberDAO dao = new MemberDAO();
		
		int result = dao.idcheck(member_id);
		
		PrintWriter writer = resp.getWriter();
		writer.print(result);
		writer.close();
		
	}

}