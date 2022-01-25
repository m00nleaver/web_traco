package com.project.traco.packagetour;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

import org.w3c.dom.bootstrap.DOMImplementationRegistry;

import com.test.jdbc.DBUtil;


//*** DAO에서는 데이터 조작하지 않는다. 데이터 입출력만 한다.
public class PackageBoardDAO {

	private Connection conn;
	private Statement stat; //매개변수X
	private PreparedStatement pstat; //매개변수O
	private ResultSet rs;
	
	
	public PackageBoardDAO() { 
		
		try {
			conn = DBUtil.open();
			stat = conn.createStatement();
			
			
		} catch (Exception e) {
			System.out.println("DBUtil 에러");
			e.printStackTrace();
		}
		
		
	}


	public ArrayList<PackageBoardDTO> list(HashMap<String, String> map) {

		try {
			
			String where = "where";
			
			//region
			if (!Objects.isNull(map.get("region"))) {
				
				where += " " + String.format("area_name like '%%%s%%'",map.get("region"));
				
			}
					

			/*추천 테이블 생성 이후에 사용
			//mode
			if (map.get("mode").equals("main") {
			
				where += " " + String .format("and rec = 'y'");
			}
			*/
			
			
			//추천 테이블 생성 전에 임시 사용
			//mode
			if (map.get("mode").equals("main") {
			
				where += " " + String .format("and pkgpm_seq between 1 and 4");
				
				}
				
			
			
			String sql = String.format("select * from vwpackageitem %s order by pkgpm_seq", where); 
					
			
			rs = stat.executeQuery(sql);
			
			ArrayList<PackageBoardDTO> list = new ArrayList<PackageBoardDTO>();
			
			
			while (rs.next()) {
				
				
				
				PackageBoardDTO dto = new PackageBoardDTO();
				
				dto.setPkSeq(rs.getString("PKGPM_SEQ"));
				dto.setPkName(rs.getString("PKGPM_NAME"));
				dto.setPkQuantity(rs.getString("PKGPM_NAME"));
				dto.setPkStartDate(rs.getString("PKGPM_NAME"));
				dto.setPkEndDate(rs.getString("PKGPM_NAME"));
				dto.setAdultPrice(rs.getString("PKGPM_NAME"));
				dto.setKidPrice(rs.getString("PKGPM_NAME"));
				dto.setToddlerPrice(rs.getString("PKGPM_NAME"));
				dto.setPkThumbSeq(rs.getString("PKGPM_NAME"));
				dto.setPkAreaSeq(rs.getString("PKGPM_NAME"));
				dto.setPkPeriod(rs.getString("PKGPM_NAME"));
				dto.setPkStatus(rs.getString("PKGPM_NAME"));
	
				
				
				list.add(dto);
				
				
				
				
			}
			
			return list;
			
			
			
		} catch (Exception e) {
			System.out.println("패키지 상품 DB작업 오류");
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	
	
	
}
