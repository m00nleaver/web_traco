package com.project.traco.community;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/community/communityview.do")
public class CommunityView extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String column = req.getParameter("column");
		String word = req.getParameter("word");
		String searchmode = "n";

		if ((column == null && word == null) || (column.equals("") && word.equals(""))) {
			searchmode = "n";
		} else {
			searchmode = "y";
		}

		String boardm_seq = req.getParameter("boardm_seq");
		

		CommunityDAO dao = new CommunityDAO();

		HttpSession session = req.getSession();
	
		
		if (session.getAttribute("boardm_view") != null && session.getAttribute("boardm_view").toString().equals("n")) {
			dao.addReadCount(boardm_seq);
			session.setAttribute("boardm_view", "y");
		}
	

		CommunityDTO dto = dao.get(boardm_seq);

		// 제목과 내용에 들어있는 태그를 비활성화
		dto.setPostm_title(dto.getPostm_title().replace("<", "&lt;").replace(">", "&gt;"));
		dto.setBoardm_content(dto.getBoardm_content().replace("<", "&lt;").replace(">", "&gt;"));

		// 개행 문자 처리
		dto.setBoardm_content(dto.getBoardm_content().replace("\r\n", "<br>"));

		// 내용에서 검색 중 > 검색어 강조!!
		if (searchmode.equals("y") && column.equals("boardm_content")) {

			// 안녕하세요. 홍길동입니다.
			// 안녕하세요. <span style="">홍길동</span>입니다.
			dto.setBoardm_content(dto.getBoardm_content().replace(word,
					"<span style='background-color:yellow;color:tomato;'>" + word + "</span>"));
		}

		ArrayList<CommentDTO> clist = dao.listComment(boardm_seq);

		Calendar now = Calendar.getInstance();
		String strNow = String.format("%tF", now); // "2022-01-13"

		for (CommentDTO cdto : clist) {
			// 날짜 자르기
			if (cdto.getCommentm_date().startsWith(strNow)) {
				cdto.setCommentm_date(cdto.getCommentm_date().substring(11));
			} else {
				cdto.setCommentm_date(cdto.getCommentm_date().substring(0, 10));
			}
			// 댓글 개행문자 처리
			cdto.setCommentm_content(cdto.getCommentm_content().replace("\r\n", "<br>"));
		}

		req.setAttribute("dto", dto);

		req.setAttribute("column", column);
		req.setAttribute("word", word);

		req.setAttribute("clist", clist);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/community/communityview.jsp");

		dispatcher.forward(req, resp);
	}

}