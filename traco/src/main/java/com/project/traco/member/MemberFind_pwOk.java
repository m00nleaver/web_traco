package com.project.traco.member;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/memberfind_pwok.do")
public class MemberFind_pwOk extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

		String member_id = req.getParameter("member_id");
		String member_email = req.getParameter("member_email");
		
		MemberDAO dao = new MemberDAO();
		
		MemberDTO dto = new MemberDTO();
		
		dto.setMember_id(member_id);
		dto.setMember_email(member_email);
		
		String memberfind_pw = dao.findPw(dto);
//		System.out.println(memberfind_id);
		req.setAttribute("memberfind_pw", memberfind_pw);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/member/memberfind_pwok.jsp");

		dispatcher.forward(req, resp);
	}
}
