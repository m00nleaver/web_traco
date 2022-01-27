package com.project.traco.rentcar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.test.jdbc.DBUtil;


public class RentCarDAO {
	
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	public RentCarDAO() {
		
		try {

			conn = DBUtil.open();
			stat = conn.createStatement();

		} catch (Exception e) {
			System.out.println("RentCarDAO.RentCarDAO()");
			e.printStackTrace();
		}
		
		
	}
	
	public ArrayList<RentCarDTO> Kategorie() {

        try {

            String sql = "select * from tblcarprod";

            rs = stat.executeQuery(sql);

            ArrayList<RentCarDTO> list = new ArrayList<RentCarDTO>();

            while (rs.next()) {
                // 레코드 1줄 -> BoardDTO 1개
            	RentCarDTO dto = new RentCarDTO();

            	dto.setCarprod_seq(rs.getString("carprod_seq"));
            	dto.setCarprod_name(rs.getString("carprod_name"));
				dto.setCarprod_people(rs.getString("carprod_people"));
				dto.setCarprod_number(rs.getString("carprod_number"));
				dto.setCarprod_price(rs.getString("carprod_price"));
				dto.setCarmanufacturer_seq(rs.getString("carmanufacturer_seq"));
				dto.setCarfuel_seq(rs.getString("carfuel_seq"));
				dto.setCarkind_seq(rs.getString("carkind_seq"));
				dto.setArea_seq(rs.getString("area_seq"));
				dto.setThumbnaili_seq(rs.getString("thumbnaili_seq"));
				dto.setStatus(rs.getString("status"));

                list.add(dto);
            }

            return list;

        } catch (Exception e) {
            System.out.println("RentCarDAO.list()");
            e.printStackTrace();
        }
        return null;
    }

	

}
