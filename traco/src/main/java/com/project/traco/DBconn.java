package com.project.traco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconn{
	public static void main(String[] args) {

		String url = "jdbc:oracle:thin:@orcl_medium?TNS_ADMIN=C://wallet_orcl";
		String userid =  "admin"; //c##추가
		String pwd = "2whWebproject"; //c##추가
	   
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로드 성공");
		}
		catch (ClassNotFoundException e) 
		{
		   e.printStackTrace();
		}
		
		//DBMS와 연결
		try 
		{
		   System.out.println("데이터베이스 연결 준비 .....");
		   Connection con = DriverManager.getConnection(url,userid,pwd);
		   if(con!=null) {System.out.println("데이터베이스 연결 성공");
		   		}
		   }catch (SQLException e) {
		   e.printStackTrace();
		}
	}
}