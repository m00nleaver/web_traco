package com.project.traco.packagetour;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.test.jdbc.DBUtil;

public class JejuDAO {

	private Connection conn;
	private Statement stat; //매개변수X
	private PreparedStatement pstat; //매개변수O
	private ResultSet rs;
	
	public JejuDAO() {
		
		try {
			
			conn = DBUtil.open();
			stat = conn.createStatement();
			
			
		} catch (Exception e) {
			System.out.println("JejuDAO.JejuDAO()");
			e.printStackTrace();
		}
		
	}
	
	
}