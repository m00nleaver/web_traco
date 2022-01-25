package com.project.traco.packagetour.jeju;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/packagetour/jeju/viewqlist.do")
public class QnaList extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		//상품번호
		String pkSeq = req.getParameter("pkSeq");
				
		
		req.setCharacterEncoding("UTF-8");
		
		String addContent = req.getParameter("addContent");

		//daoQna
		qnaDAO daoQna = new qnaDAO();
		
		int rsQna = daoQna.addQna(addContent);
		
		//daoPkQna
		qnaDAO daoPkQna = new qnaDAO();

		int rsPkQna = daoPkQna.addPkQna(pkSeq);  

		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		PrintWriter writer = resp.getWriter();
		
		// { "result": 2 }
		writer.printf("{ \"result\": %d }", rsQna + rsPkQna);
		
		writer.close();
		
	}	
	
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		
		//상품번호
		String pkSeq = req.getParameter("pkSeq");
		
		//임시 회원번호
		String memberSeq = "3";
		
		
		
		//문의사항 리스트 출력

		qnaDAO qnaDao = new qnaDAO();
		
		ArrayList<qnaDTO> qnaList = qnaDao.list(pkSeq);
		
		
		
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		PrintWriter writer = resp.getWriter();
		
	
		
		String temp = "";
		
		temp += "[";
		
		for (qnaDTO dto : qnaList) {
			
			temp += "{";
				temp += String.format("\"pkSeq\": \"%s\",", dto.getPkSeq());
				temp += String.format("\"qnaSeq\": \"%s\",", dto.getQnaSeq());
				temp += String.format("\"qnaContent\": \"%s\",", dto.getQnaContent());
				temp += String.format("\"qnaComment\": \"%s\"", dto.getQnaComment());
			temp += "},";
		}
		
		temp = temp.substring(0, temp.length() - 1);
		
		temp += "]";
		
		System.out.println(temp);
		
		writer.print(temp);
		writer.close();
		
		
	}


}

