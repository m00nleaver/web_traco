package com.project.traco.community;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/community/commentdelok.do")
public class CommentDelOk extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String commentm_seq = req.getParameter("commentm_seq"); //삭제할 댓글 번호
		String boardm_seq = req.getParameter("boardm_seq"); //돌아갈 게시물(부모글) 번호
		
		//2.
		CommunityDAO dao = new CommunityDAO();
		int result = dao.Commentdel(commentm_seq); //1,0
		
		//3.
		if (result == 1) {
			resp.sendRedirect("/traco/community/communityview.do?boardm_seq=" + boardm_seq);
		} else {
			PrintWriter writer = resp.getWriter();
			writer.println("<html><body><script>");
			writer.println("alert('failed'); history.back();");
			writer.println("</script></body></html>");
			writer.close();
		}
	}

}
