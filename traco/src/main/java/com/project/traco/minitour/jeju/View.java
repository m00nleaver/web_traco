package com.project.traco.minitour.jeju;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/minitour/jeju/miniview.do")
public class View extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String miniSeq = req.getParameter("miniSeq");
		
		HttpSession session = req.getSession();
          
		try {
			String memberSeq = session.getAttribute("member_seq").toString();
			req.setAttribute("memberSeq", memberSeq);
			
		}catch(Exception e){ System.out.println("로그인 안되었지만, 일단 보세요."); }
		
		String daterange = req.getParameter("daterange");
		
		System.out.println("미니 상품번호: " + miniSeq);
		System.out.println("날짜: " + daterange);
		
		
		
		//개별상품의 데이터 가져오기
		//DB조회를 수행할 DAO 생성
		
		MiniPackageDAO itemDao = new MiniPackageDAO();

		
		MiniPackageDTO itemDto = itemDao.item(miniSeq);
		
		

		
		
		
		
		
		
		req.setAttribute("itemdto", itemDto);
		
		req.setAttribute("miniSeq", miniSeq);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/minitour/jeju/view.jsp");

		dispatcher.forward(req, resp);
	}

	private void qnaList(HttpServletRequest req, HttpServletResponse resp) {
		
		String pkSeq = req.getParameter("pkSeq");
		
		String memberSeq = "3";
		
		System.out.println(pkSeq);
		
		
		
	}
}

