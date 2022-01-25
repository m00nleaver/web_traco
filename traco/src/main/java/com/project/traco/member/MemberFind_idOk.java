package com.project.traco.member;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/memberfind_idok.do")
public class MemberFind_idOk extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

		String member_name = req.getParameter("member_name");
		String member_email = req.getParameter("member_email");
		
		MemberDAO dao = new MemberDAO();
		
		MemberDTO dto = new MemberDTO();
		
		dto.setMember_name(member_name);
		dto.setMember_email(member_email);
		
		String memberfind_id = dao.findId(dto);
//		System.out.println(memberfind_id);
		req.setAttribute("memberfind_id", memberfind_id);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/member/memberfind_idok.jsp");

		dispatcher.forward(req, resp);
	}
}
