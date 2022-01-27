package com.project.traco.flightticket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import org.w3c.dom.bootstrap.DOMImplementationRegistry;

import com.project.traco.packagetour.jeju.MembersDTO;
import com.test.jdbc.DBUtil;


public class FlightrezDAO {
	private Connection conn;
	private Statement stat; //매개변수X
	private ResultSet rs;
	private PreparedStatement pstat; //매개변수O
	private PreparedStatement pstat2; //매개변수O
	
	public FlightrezDAO() {
		try {
			conn=DBUtil.open();
			stat = conn.createStatement();
		} catch (Exception e) {
			System.out.println("FlightrezDAO.FlightrezDAO() DB오류");
			e.printStackTrace();
		}
	}

	public int add(FlightrezDTO dto) {
		try {
			String sql ="insert into tblRez"
					+ "(rez_seq,rez_date,rez_adultcnt,rez_toddlercnt,rez_kidcnt, bankm_seq,deposit_seq,member_seq,confirm) "
					+ "values (rez.nextval,default ,?,?, ?, ?, ?, ?, default)";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getRez_adultcnt());
			pstat.setString(2, dto.getRez_toddlercnt());
			pstat.setString(3, dto.getRez_kidcnt());
			pstat.setString(4, dto.getBankm_seq());
			pstat.setString(5, dto.getDeposit_seq());
			pstat.setString(6, dto.getMember_seq());
			
			//String sql2 = "insert into tblAirplanrez ()"
			//rez_seq nextval로 하면 계속 +1이니까..
			//airpalnp_seq는 음....어떻게 두개 다 넣지....음......
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("FlightrezDAO.add()");
			e.printStackTrace();
		}
		return 0;
	}


}
