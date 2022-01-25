package com.project.traco.community;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/community/communitydel.do")
public class CommunityDel extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String boardm_seq = req.getParameter("boardm_seq");
//		System.out.println(boardm_seq);
		
		CommunityDAO dao = new CommunityDAO();
		CommunityDTO dto = dao.get(boardm_seq);
		HttpSession session = req.getSession();
		
		if (session.getAttribute("member_id") == null 
				|| !session.getAttribute("member_id").toString().equals(dto.getMember_id())) {
			resp.sendRedirect("/traco/member/member.do");
			return;
		}
		
		req.setAttribute("boardm_seq", boardm_seq);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/community/communitydel.jsp");
		dispatcher.forward(req, resp);
	}

}
