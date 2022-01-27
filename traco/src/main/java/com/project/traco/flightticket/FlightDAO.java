
package com.project.traco.flightticket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import org.w3c.dom.bootstrap.DOMImplementationRegistry;

import com.project.jdbc.locarDB;
import com.project.traco.packagetour.jeju.MembersDTO;
import com.test.jdbc.DBUtil;

public class FlightDAO {
	private Connection conn;
	private Statement stat; //매개변수X
	private ResultSet rs;
	private PreparedStatement pstat; //매개변수O
	
	public FlightDAO() {
		try {
			conn = locarDB.open();
			//conn=DBUtil.open();
			stat = conn.createStatement();
		} catch (Exception e) {
			System.out.println("FlightDAO.FlightDAO()");
			e.printStackTrace();
		}
	}
	
	//목록 검색 편도
	public ArrayList<FlightDTO> list(HashMap<String,String>map){
		try {
			String sql= String.format("select * from vwairplanp");
			if(map.get("searchmode").equals("y")) {
				sql+=" WHERE sairport_name like'%"+map.get("inputAddress1")+"%'"
						+" and eairport_name like'%"+map.get("inputAddress2")+"%'"
						+" and airplanp_takeoffdate = '"+map.get("inputdateOne")+"'"
						;
			}
			sql+=" order by airplanp_seq";

			rs = stat.executeQuery(sql);
			
			ArrayList<FlightDTO> list = new ArrayList<FlightDTO>();
			
			while(rs.next()) {
				FlightDTO dto = new FlightDTO();
				
				dto.setAirplanp_seq(rs.getString("airplanp_seq"));
				dto.setAirplanl_name(rs.getString("airplanl_name"));
				dto.setAirplanl_seq(rs.getString("airplanl_seq"));
				dto.setAirplanp_takeoffdate(rs.getString("airplanp_takeoffdate"));
				dto.setAirplanp_takeofftime(rs.getString("airplanp_takeofftime"));
				dto.setAirplanp_number(rs.getString("airplanp_number"));
				dto.setAirplanp_adultprice(rs.getString("airplanp_adultprice"));
				dto.setAirplanp_kidprice(rs.getString("airplanp_kidprice"));
				dto.setAirplanp_toddlerprice(rs.getString("airplanp_toddlerprice"));
				dto.setSalek_seq(rs.getString("salek_seq"));
				dto.setSalek_kind(rs.getString("salek_kind"));
				dto.setStartl_seq(rs.getString("startl_seq"));
				dto.setSairport_name(rs.getString("sairport_name"));
				dto.setEndl_seq(rs.getString("endl_seq"));
				dto.setEairport_name(rs.getString("eairport_name"));
				
				list.add(dto);
			}
			
			return list;
		} catch (Exception e) {
			System.out.println("FlightDAO.list()");
			e.printStackTrace();
		}
		return null;
	}
	
	//왕복2
	
	
	
	  public ArrayList<FlightDTO> list2(HashMap<String, String> map) { 
		  try {
	  
		  String sql= String.format("select * from vwairplanp");
		  
		  if(map.get("searchmode").equals("y")) {
			  sql+=" WHERE sairport_name like'%"+map.get("inputAddress2")+"%'"
			  +" and eairport_name like'%"+map.get("inputAddress1")+"%'"
			  +" and airplanp_takeoffdate = '"+map.get("inputdateTwo")+"'" ; 
		  }
		  
		  sql+=" order by airplanp_seq";
	  
	  rs = stat.executeQuery(sql);
	  
	  ArrayList<FlightDTO> list2 = new ArrayList<FlightDTO>();
	  
	  while(rs.next()) { 
		  FlightDTO dto = new FlightDTO();
	  
	  dto.setAirplanp_seq(rs.getString("airplanp_seq"));
	  dto.setAirplanl_name(rs.getString("airplanl_name"));
	  dto.setAirplanl_seq(rs.getString("airplanl_seq"));
	  dto.setAirplanp_takeoffdate(rs.getString("airplanp_takeoffdate"));
	  dto.setAirplanp_takeofftime(rs.getString("airplanp_takeofftime"));
	  dto.setAirplanp_number(rs.getString("airplanp_number"));
	  dto.setAirplanp_adultprice(rs.getString("airplanp_adultprice"));
	  dto.setAirplanp_kidprice(rs.getString("airplanp_kidprice"));
	  dto.setAirplanp_toddlerprice(rs.getString("airplanp_toddlerprice"));
	  dto.setSalek_seq(rs.getString("salek_seq"));
	  dto.setSalek_kind(rs.getString("salek_kind"));
	  dto.setStartl_seq(rs.getString("startl_seq"));
	  dto.setSairport_name(rs.getString("sairport_name"));
	  dto.setEndl_seq(rs.getString("endl_seq"));
	  dto.setEairport_name(rs.getString("eairport_name"));
	  
	  list2.add(dto); 
	  }
	  
	  return list2; 
	  } catch (Exception e) { 
		  System.out.println("FlightDAO.list2()");
		  e.printStackTrace(); 
		  } 
		  
		  return null;
	  
	  }

	public ArrayList<FlightDTO> list3(HashMap<String, String> map) {
		try {
			  
			  String sql= String.format("select * from vwairplanp");
			  
				  sql+=" WHERE airplanp_seq ="+map.get("single_seq")+" or"
				  +" airplanp_seq ="+map.get("double_seq"); 
			  sql+=" order by airplanp_seq";
		  
		  rs = stat.executeQuery(sql);
		  
		  ArrayList<FlightDTO> list3 = new ArrayList<FlightDTO>();
		  
		  while(rs.next()) { 
			  FlightDTO dto = new FlightDTO();
		  
		  dto.setAirplanp_seq(rs.getString("airplanp_seq"));
		  dto.setAirplanl_name(rs.getString("airplanl_name"));
		  dto.setAirplanl_seq(rs.getString("airplanl_seq"));
		  dto.setAirplanp_takeoffdate(rs.getString("airplanp_takeoffdate"));
		  dto.setAirplanp_takeofftime(rs.getString("airplanp_takeofftime"));
		  dto.setAirplanp_number(rs.getString("airplanp_number"));
		  dto.setAirplanp_adultprice(rs.getString("airplanp_adultprice"));
		  dto.setAirplanp_kidprice(rs.getString("airplanp_kidprice"));
		  dto.setAirplanp_toddlerprice(rs.getString("airplanp_toddlerprice"));
		  dto.setSalek_seq(rs.getString("salek_seq"));
		  dto.setSalek_kind(rs.getString("salek_kind"));
		  dto.setStartl_seq(rs.getString("startl_seq"));
		  dto.setSairport_name(rs.getString("sairport_name"));
		  dto.setEndl_seq(rs.getString("endl_seq"));
		  dto.setEairport_name(rs.getString("eairport_name"));
		  
		  list3.add(dto); 
		  }
		  
		  return list3; 
		  } catch (Exception e) { 
			  System.out.println("FlightDAO.list3()");
			  e.printStackTrace(); 
			  } 
			  
			  return null;
	}

	public int check(String id) {
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public MembersDTO getMember(String memberSeq) {
		
			try {
				String sql = "select * from tblMember where member_seq=?";
						
				
				pstat = conn.prepareStatement(sql);		
				
				pstat.setString(1, memberSeq);

				
				rs = pstat.executeQuery();

				
				MembersDTO dto = new MembersDTO();
				
				
				if (rs.next()) {
					
					System.out.println("회원 찾음");
					
					dto.setSeq(rs.getString("MEMBER_SEQ"));
					dto.setName(rs.getString("MEMBER_NAME"));
					dto.setBirth(rs.getString("MEMBER_BIRTH"));
					dto.setEmail(rs.getString("MEMBER_EMAIL"));
					dto.setGender(rs.getString("MEMBER_GENDER"));
					

			}
			
			return dto;
			
			
			
		} catch (Exception e) {
			System.out.println("회원정보 로딩 DB작업 오류");
			e.printStackTrace();
		}
		
		return null;
		
		
	}

	public ArrayList<FlightDTO> list4(HashMap<String, String> map) {
		try {
			  
			  String sql= String.format("select * from vwairplanp");
			  
				  sql+=" WHERE airplanp_seq ="+map.get("single_seq"); 
			  sql+=" order by airplanp_seq";
		  
		  rs = stat.executeQuery(sql);
		  
		  ArrayList<FlightDTO> list4 = new ArrayList<FlightDTO>();
		  
		  while(rs.next()) { 
			  FlightDTO dto = new FlightDTO();
		  
		  dto.setAirplanp_seq(rs.getString("airplanp_seq"));
		  dto.setAirplanl_name(rs.getString("airplanl_name"));
		  dto.setAirplanl_seq(rs.getString("airplanl_seq"));
		  dto.setAirplanp_takeoffdate(rs.getString("airplanp_takeoffdate"));
		  dto.setAirplanp_takeofftime(rs.getString("airplanp_takeofftime"));
		  dto.setAirplanp_number(rs.getString("airplanp_number"));
		  dto.setAirplanp_adultprice(rs.getString("airplanp_adultprice"));
		  dto.setAirplanp_kidprice(rs.getString("airplanp_kidprice"));
		  dto.setAirplanp_toddlerprice(rs.getString("airplanp_toddlerprice"));
		  dto.setSalek_seq(rs.getString("salek_seq"));
		  dto.setSalek_kind(rs.getString("salek_kind"));
		  dto.setStartl_seq(rs.getString("startl_seq"));
		  dto.setSairport_name(rs.getString("sairport_name"));
		  dto.setEndl_seq(rs.getString("endl_seq"));
		  dto.setEairport_name(rs.getString("eairport_name"));
		  
		  list4.add(dto); 
		  }
		  
		  return list4; 
		  } catch (Exception e) { 
			  System.out.println("FlightDAO.list4()");
			  e.printStackTrace(); 
			  } 
			  
			  return null;
	}
	
	
}

