package com.project.traco.packagetour.jeju;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/packagetour/jeju/insert/reserve/packager.do")
public class InsertPackageR extends HttpServlet {
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

		System.out.println("tblPackageR(패키지-예약) insert");
		System.out.println("번호: " + pkgpm_seq);
		System.out.println("날짜: " + rez_date);
		System.out.println("성인개수: " +rez_adultcnt);
		System.out.println("아동개수: "+ rez_kidcnt);
		System.out.println("유아개수: " +rez_toddlercnt);
		System.out.println("회원번호: " +member_seq);
		System.out.println("은행명: "+ bankm_name);

		
		ReserveDTO dto = new ReserveDTO();
		dto.setPkgpm_seq(pkgpm_seq);
		dto.setRez_date(rez_date);
		dto.setRez_adultcnt(rez_adultcnt);
		dto.setRez_kidcnt(rez_kidcnt);
		dto.setRez_toddlercnt(rez_toddlercnt);
		dto.setMember_seq(member_seq);
		
		PackageDAO dao = new PackageDAO();
		
		int result = dao.insertPackageR(dto);
		
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		PrintWriter writer = resp.getWriter();
		
		// { "result": 1 }
		writer.printf("{ \"result\": %d }", result);
		
		writer.close();
		

		

	}
}
