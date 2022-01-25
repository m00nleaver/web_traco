package com.project.traco.packagetour.jeju;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/packagetour/jeju/totalview.do")
public class TotalView extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String region = req.getParameter("region");
		String hashtag = req.getParameter("hashtag");
		String price = req.getParameter("price");
		String startdate = req.getParameter("startdate");
		String quantity = req.getParameter("quantity");
		String qorder = req.getParameter("qorder");
		String ploworder = req.getParameter("ploworder");
		String phighorder = req.getParameter("phighorder");
		String dateorder = req.getParameter("dateorder");
		
		
		System.out.println(hashtag);
		System.out.println(startdate);
		System.out.println(price);
		System.out.println(qorder);
		System.out.println(ploworder);
		System.out.println(phighorder);
		System.out.println(dateorder);

		
		//검색어 및 정렬 필터링을 위한 map 생성
		HashMap<String,String> map = new HashMap<String,String>();

		map.put("quantity", quantity);
		map.put("startdate", startdate);
		map.put("price", price);
		map.put("hashtag", hashtag);
		map.put("region", region);
		map.put("qorder", qorder);
		map.put("ploworder",ploworder);
		map.put("phighorder",phighorder);
		map.put("dateorder",dateorder);
		
		PackageDAO tagDao = new PackageDAO();
		
		ArrayList<TagDTO> tagList = tagDao.tagList();
		
		
		
		//전체상품 검색
		//DAO생성
		//상품정보를 DTO로 하는 ArrayList 생성 + where조건 중첩
		
		PackageDAO searchDao = new PackageDAO();
		
		ArrayList<PackageDTO> searchList = searchDao.searchList(map);
		
		
//		System.out.println(searchList.size());
		
		
		
		String hello = "whos there";
		
		req.setAttribute("tagList", tagList);
		req.setAttribute("searchList", searchList);
		req.setAttribute("hello", hello);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/packagetour/jeju/totalview.jsp");

		dispatcher.forward(req, resp);
	}
}
