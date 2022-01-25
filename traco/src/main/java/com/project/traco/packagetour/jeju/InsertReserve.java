package com.project.traco.packagetour.jeju;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/packagetour/jeju/insert/reserve.do")
public class InsertReserve extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

		String pkgpm_seq = req.getParameter("pkgpm_seq");
		String rez_date = req.getParameter("rez_date");
		String rez_adultcnt = req.getParameter("rez_adultcnt");
		String rez_kidcnt = req.getParameter("rez_kidcnt");
		String rez_toddlercnt = req.getParameter("rez_toddlercnt");
		String member_seq = req.getParameter("member_seq");
		String bankm_name = req.getParameter("bankm_name");

		System.out.println(pkgpm_seq);
		System.out.println(rez_date);
		System.out.println(rez_adultcnt);
		System.out.println(rez_kidcnt);
		System.out.println(rez_toddlercnt);
		System.out.println(member_seq);
		System.out.println(bankm_name);

//		MemberDTO dto = new MemberDTO();
//		dto.setId(id);
//		dto.setPw(pw);
//		dto.setName(name);
//		
//		AjaxDAO dao = new AjaxDAO();
//		
//		int result = dao.add(dto);
//		
//		resp.setCharacterEncoding("UTF-8");
//		resp.setContentType("application/json");
//		PrintWriter writer = resp.getWriter();
//		
//		// { "result": 1 }
//		writer.printf("{ \"result\": %d }", result);
//		
//		writer.close();

	}
}
