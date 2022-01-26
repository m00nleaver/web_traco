package com.project.traco.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/hlistdata.do")
public class HlistData extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp){

		try {
			req.setCharacterEncoding("UTF-8");

			String hash = req.getParameter("hash");
			String hashseq = req.getParameter("hashseq");
			
			AdminPDTO pdto = new AdminPDTO();
			AdminPDAO pdao = new AdminPDAO();
			
			System.out.println(hash);
			System.out.println(hashseq);
			if(hash!=null && hashseq==null) {
				pdto.setHashtag(hash);
				int result = pdao.hadd(pdto); //해쉬태그 등록
				resp.setCharacterEncoding("UTF-8");
				resp.setContentType("application/json");
				
				PrintWriter writer = resp.getWriter();

				// { "result": 1 }
				writer.printf("{ \"result\": %d }", result);

				writer.close();
			}else if(hash==null && hashseq!=null) {
				System.out.println(hashseq);
				pdto.setHseq(hashseq);
				int result = pdao.hdel(pdto);
				resp.setCharacterEncoding("UTF-8");
				resp.setContentType("application/json");

				PrintWriter writer = resp.getWriter();

				// { "result": 1 }
				writer.printf("{ \"result\": %d }", result);

				writer.close();
			}

			

			
		} catch (Exception e) {
			System.out.println("hlistdata 해쉬태그등록과 삭제");
			e.printStackTrace();
		}

	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp){

		try {
			
			AdminPDAO pdao = new AdminPDAO();
			ArrayList<AdminPDTO> list = pdao.hlist(); // 해시태그 리스트

			resp.setCharacterEncoding("UTF-8");
			resp.setContentType("application/json");
			
			PrintWriter writer = resp.getWriter();

			String temp = "";

			temp += "[";

			for (AdminPDTO pdto : list) {
				//System.out.println(pdto.getHashtag());
				temp += "{";
				temp += String.format("\"hash\":\"%s\",", pdto.getHashtag().replace("\n", ""));
				temp += String.format("\"hashseq\":%s", pdto.getHseq());
				temp += "},";
			}

			temp = temp.substring(0, temp.length() - 1);
			
			temp += "]";
			
			writer.print(temp);
			writer.close();
			
		} catch (Exception e) 	{
			System.out.println("hlistdata 해쉬태그 불러오기");
			e.printStackTrace();
		}

	}
}
