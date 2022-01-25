package com.project.traco.member;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.traco.community.CommunityDAO;
import com.project.traco.community.CommunityDTO;

@WebServlet("/member/memberaddok.do")
public class MemberAddOk extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		
		String member_id = req.getParameter("member_id");
		String member_pw = req.getParameter("member_pw");
		String member_name = req.getParameter("member_name");
		String member_birth = req.getParameter("member_birth");
		String member_gender = req.getParameter("member_gender");
		String member_email = req.getParameter("member_email");
		
		HttpSession session = req.getSession();
	
		MemberDAO dao = new MemberDAO();
		
		MemberDTO dto = new MemberDTO();
			
		dto.setMember_id(member_id);
		dto.setMember_pw(member_pw);
		dto.setMember_name(member_name);
		dto.setMember_birth(member_birth);
		dto.setMember_gender(member_gender);
		dto.setMember_email(member_email);
		
		int result = dao.Memberadd(dto); //1, 0
		
		//4.
		req.setAttribute("result", result);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/member/memberaddok.jsp");

		dispatcher.forward(req, resp);
	}

}