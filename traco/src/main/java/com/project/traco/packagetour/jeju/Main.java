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

@WebServlet("/packagetour/jeju/jejumain.do")
public class Main extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		String region = req.getParameter("region");
		String hashtag = req.getParameter("hashtag");
		String price = req.getParameter("price");
		String date = req.getParameter("date");
		String quantity = req.getParameter("quantity");
		

		
		System.out.println(hashtag);
		
		
		//검색어 및 정렬 필터링을 위한 map 생성
		HashMap<String,String> map = new HashMap<String,String>();

		map.put("quantity", quantity);
		map.put("date", date);
		map.put("price", price);
		map.put("hashtag", hashtag);
		map.put("region", region);
		
		
		//추천 리스트 생성
		//DAO생성 
		//추천상품에 해당되는 DTO들을 원소로 하는 ArrayList 생성
		
		
		PackageDAO recomDao = new PackageDAO();
		
		ArrayList<PackageDTO> recomList = recomDao.recomList();
		
		
		//해시태그 목록 리스트 생성
		//DAO생성
		//해시태그 이름을 DTO로 하는 ArrayList 생성  (왜냐면, for문 돌려야 되기 때문)
		
		
		PackageDAO tagDao = new PackageDAO();
		
		ArrayList<TagDTO> tagList = tagDao.tagList();
		
		
		
		//선택된 해시태그에 해당되는 목록 리스트 생성
		//DAO 생성
		//map을 넘겨야 함.
		//해시태그 해당 상품에 해당되는 DTO들을 원소로 하는 ArrayList 생성
		
		PackageDAO hashDao	= new PackageDAO();
		
		ArrayList<PackageDTO> hashList = hashDao.hashlist(map);
		
		
		
		
		
		
		
		req.setAttribute("recomList", recomList);
		req.setAttribute("tagList", tagList);
		req.setAttribute("hashList", hashList);
		
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/packagetour/jeju/main.jsp");

		dispatcher.forward(req, resp);
	}
}

