package com.project.traco;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.jdbc.DBUtil;
import com.project.traco.community.CommunityDTO;


public class MainDAO extends HttpServlet {
	
	private Connection conn;
	private Statement stat; // 매개변수X
	private PreparedStatement pstat; // 매개변수O
	private ResultSet rs;

	public MainDAO() {

		try {

			conn = DBUtil.open();
			stat = conn.createStatement();

		} catch (Exception e) {
			System.out.println("CommunityDAO.CommunityDAO()");
			e.printStackTrace();
		}

	}


	//배너 가져오기
	public ArrayList<MainDTO> banner(String banner_status) {
		try {

			String sql = "select * from tblBannerImg where status = ?";

			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, banner_status);
			
			rs = pstat.executeQuery();
			
			ArrayList<MainDTO> banerlist = new ArrayList<MainDTO>();
			
			while (rs.next()) {
				
				MainDTO dto = new MainDTO();

				dto.setBanneri_seq(rs.getString("banneri_seq"));
				dto.setBanneri_name(rs.getString("banneri_name"));
				dto.setBanneri_imageurl(rs.getString("banneri_imageurl"));
				dto.setBanneri_linkurl(rs.getString("banneri_linkurl"));
				dto.setStatus(rs.getString("status"));
				dto.setBannerctg_seq(rs.getString("bannerctg_seq"));
				
				banerlist.add(dto);
			}
			
			return banerlist; 

		} catch (Exception e) {
			System.out.println("MainDAO.banner()");
			e.printStackTrace();
		}
		return null;
	}


	public ArrayList<MainDTO> toppackage(String package_status) {
		try {

			String sql = "select pkgpm_name, area_name, pstatus, pkgpm_adultprice,thumbnaili_name from vtblPackagePM where rec = ?";

			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, package_status);
			
			rs = pstat.executeQuery();
			
			ArrayList<MainDTO> packagelist = new ArrayList<MainDTO>();
			
			while (rs.next()) {
				
				MainDTO dto = new MainDTO();

				dto.setPkgpm_name(rs.getString("pkgpm_name"));
				dto.setArea_name(rs.getString("area_name"));
				dto.setPstatus(rs.getString("pstatus"));
				dto.setPkgpm_adultprice(rs.getString("pkgpm_adultprice"));
				dto.setThumbnaili_name(rs.getString("thumbnaili_name"));
				
				packagelist.add(dto);
			}
			
			return packagelist; 

		} catch (Exception e) {
			System.out.println("MainDAO.banner()");
			e.printStackTrace();
		}
		return null;
	}


	public ArrayList<MainDTO> topmini(String mini_status) {
		try {

			String sql = "select minipm_name,area_name,minipm_price1,minictg_name,thumbnaili_name,rec from vtblMiniPM where rec = ?";

			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, mini_status);
			
			rs = pstat.executeQuery();
			
			ArrayList<MainDTO> packagelist = new ArrayList<MainDTO>();
			
			while (rs.next()) {
				
				MainDTO dto = new MainDTO();

				dto.setMinipm_name(rs.getString("minipm_name"));
				dto.setMinipm_price1(rs.getString("minipm_price1"));
				dto.setMinictg_name(rs.getString("minictg_name"));
				dto.setThumbnaili_name(rs.getString("thumbnaili_name"));
				dto.setArea_name(rs.getString("area_name"));
				
				packagelist.add(dto);
			}
			
			return packagelist; 

		} catch (Exception e) {
			System.out.println("MainDAO.banner()");
			e.printStackTrace();
		}
		return null;
	}
}