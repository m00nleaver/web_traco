package com.project.traco.community;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

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

@WebServlet("/community/communitylist.do")
public class CommunityList extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 호출
		String column = req.getParameter("column");
		String word = req.getParameter("word");
		String searchmode = "n";

		if ((column == null && word == null) || (column.equals("") && word.equals(""))) {
			searchmode = "n";
		} else {
			searchmode = "y";
		}

		// DTO > HashMap
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("column", column);
		map.put("word", word);
		map.put("searchmode", searchmode);

		// 페이징
		int nowPage = 0; // 현재 페이지 번호
		int totalCount = 0;
		int pageSize = 10; // 한페이지당 출력할 게시물 수
		int totalPage = 0;
		int begin = 0; // where 시작 위치
		int end = 0; // where 끝 위치
		int n = 0;
		int loop = 0;
		int blockSize = 10;

		// communitylist.do > communitylist.do?page=1
		// communitylist.do?page=3

		String page = req.getParameter("page");

		if (page == null || page == "")
			nowPage = 1;
		else
			nowPage = Integer.parseInt(page);

		// nowPage > 현재 보게될 페이지 번호
		// communitylist.do?page=1 > where rnum between 1 and 10
		// communitylist.do?page=2 > where rnum between 11 and 20
		// communitylist.do?page=3 > where rnum between 21 and 30
		begin = ((nowPage - 1) * pageSize) + 1;
		end = begin + pageSize - 1;

		map.put("begin", begin + "");
		map.put("end", end + "");

		// 할일
		// 1. DB 작업 > select > DAO 위임
		// 1.5 데이터 조작
		// 2. 반환값 전달 + JSP 호출
		// 1.
		CommunityDAO dao = new CommunityDAO();
		ArrayList<CommunityDTO> list = dao.list(map);

		// 1.5
		Calendar now = Calendar.getInstance();
		String strNow = String.format("%tF", now); // "2022-01-13"

		for (CommunityDTO dto : list) {

			// 날짜 자르기
			if (dto.getBoardm_date().startsWith(strNow)) {
				dto.setBoardm_date(dto.getBoardm_date().substring(11));
			} else {
				dto.setBoardm_date(dto.getBoardm_date().substring(0, 10));
			}

			// 제목이 길면 자르기
			if (dto.getPostm_title().length() > 20) {
				dto.setPostm_title(dto.getPostm_title().substring(0, 20) + "..");
			}
			// 제목에서 검색 중 > 검색어 강조!!
			if (searchmode.equals("y") && column.equals("postm_title")) {

				// 안녕하세요. 홍길동입니다.
				// 안녕하세요. <span style="">홍길동</span>입니다.
				dto.setPostm_title(dto.getPostm_title().replace(word,
						"<span style='background-color:yellow;color:tomato;'>" + word + "</span>"));
			}

			// 제목에서 검색 중 > 검색어 강조!!
			if (searchmode.equals("y") && column.equals("member_id")) {

				// 안녕하세요. 홍길동입니다.
				// 안녕하세요. <span style="">홍길동</span>입니다.
				dto.setMember_id(dto.getMember_id().replace(word,
						"<span style='background-color:yellow;color:tomato;'>" + word + "</span>"));
			}

		}

		// 조회수 증가 제어용 티켓
		HttpSession session = req.getSession();
		session.setAttribute("boardm_view", "n");

		// 페이지바

		// 총 게시물 수? > 164
		// 총 페이지 수? > 164 / 10 = 16.4페이지 > 17페이지

		totalCount = dao.getTotalCount(map);
		totalPage = (int) Math.ceil((double) totalCount / pageSize);

		String pagebar = "";

		loop = 1; // 루프변수(while)
		n = ((nowPage - 1) / blockSize) * blockSize + 1; // 페이지 번호

		pagebar += "<nav><ul class=\"pagination\">";

		if (n == 1) {
			pagebar += String.format(
					"<li class='disabled'><a href='#!' aria-label='Previous'><span aria-hidden='true'>&laquo;</span></a></li>");
		} else {
			pagebar += String.format(
					"<li><a href='/traco/community/communitylist.do?page=%d' aria-label='Previous'><span aria-hidden='true'>&laquo;</span></a></li>",
					n - 1);
		}

		while (!(loop > blockSize || n > totalPage)) {

			if (n == nowPage) {
				pagebar += String.format("<li class='active'><a href='#!'>%d</a></li>", n);
			} else {
				pagebar += String.format("<li><a href='/traco/community/communitylist.do?page=%d'>%d</a></li>", n, n);
			}

			loop++;
			n++;
		}

		if (n > totalPage) {
			pagebar += String.format(
					"<li class='disabled'><a href='#!' aria-label='Next'><span aria-hidden='true'>&raquo;</span></a></li>");
		} else {
			pagebar += String.format(
					"<li><a href='/traco/community/communitylist.do?page=%d' aria-label='Next'><span aria-hidden='true'>&raquo;</span></a></li>",
					n);
		}
		pagebar += "</ul></nav>";
		
		req.setAttribute("list", list);
		req.setAttribute("map", map);
		
		req.setAttribute("pagebar", pagebar);
		req.setAttribute("nowPage", nowPage);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/community/communitylist.jsp");

		dispatcher.forward(req, resp);
	}

}
