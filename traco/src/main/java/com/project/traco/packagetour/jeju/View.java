package com.project.traco.packagetour.jeju;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/packagetour/jeju/view.do")
public class View extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String pkSeq = req.getParameter("pkSeq");
		
		//임시 회원번호
		String memberSeq = "3";
		
		String daterange = req.getParameter("daterange");
		
		System.out.println("패키지 상품번호: " + pkSeq);
		System.out.println("날짜: " + daterange);
		
		
		
		//개별상품의 데이터 가져오기
		//DB조회를 수행할 DAO 생성
		//DAO에게 상품번호만 있는 DTO 넘겨주고, 다른 정보들 꽉채워서 받기
		
		PackageDAO itemDao = new PackageDAO();

		
		PackageDTO itemDto = itemDao.item(pkSeq);
		
		
		
		
		
		//문의사항 리스트 출력

		qnaDAO qnaDao = new qnaDAO();
		
		ArrayList<qnaDTO> qnaList = qnaDao.list(pkSeq);
		
		
		//문의사항 추가
		
		
		
		
		
		
		
		req.setAttribute("memberSeq", memberSeq);
		
		req.setAttribute("itemdto", itemDto);
		
		req.setAttribute("pkSeq", pkSeq);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/packagetour/jeju/view.jsp");

		dispatcher.forward(req, resp);
	}

	private void qnaList(HttpServletRequest req, HttpServletResponse resp) {
		
		String pkSeq = req.getParameter("pkSeq");
		
		String memberSeq = "3";
		
		System.out.println(pkSeq);
		
		
		
	}
}

