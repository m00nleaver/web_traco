package com.project.traco.packagetour.jeju;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

import org.w3c.dom.bootstrap.DOMImplementationRegistry;

import com.test.jdbc.DBUtil;



/*dto.setPkSeq(rs.getString("PKGPM_SEQ"));
dto.setPkName(rs.getString("PKGPM_NAME"));
dto.setPkQuantity(rs.getString("PKGPM_COUNT"));
dto.setPkStartDate(rs.getString("PKGPM_START"));
dto.setPkEndDate(rs.getString("PKGPM_END"));
dto.setAdultPrice(rs.getString("PKGPM_ADULTPRICE"));
dto.setKidPrice(rs.getString("PKGPM_KIDPRICE"));
dto.setToddlerPrice(rs.getString("IMAGEM_SEQ"));
dto.setPkThumbSeq(rs.getString("THUMBNAILI_SEQ"));
dto.setPkImageSeq(rs.getString("THUMBNAILI_SEQ"));
dto.setPkAreaSeq(rs.getString("AREA_NAME"));
dto.setPkPeriod(rs.getString("PKGPM_PERIOD"));
dto.setPkStatus(rs.getString("PSTATUS"));*/

//*** DAO에서는 데이터 조작하지 않는다. 데이터 입출력만 한다.
public class PackageDAO {

	private Connection conn;
	private Statement stat; //매개변수X
	private PreparedStatement pstat; //매개변수O
	private ResultSet rs;
	
	
	public PackageDAO() { 
		
		try {
			conn = DBUtil.open();
			stat = conn.createStatement();
			
			
		} catch (Exception e) {
			System.out.println("DBUtil 에러");
			e.printStackTrace();
		}
		
		
	}


	public ArrayList<PackageDTO> list(HashMap<String, String> map) {

		
		
		try {
			
			String where = "";
			
			
			if (map.get("tagMode").equals("y")) {
				
				where = String.format("where hashtag_name = '%s' and area_name like '%%제주%%'", map.get("hashtag"));
				
			}
			
			
			
			String sql = String.format("select * from vwpktagitem %s order by pkgpm_seq", where); 
					
			
			rs = stat.executeQuery(sql);
			
			ArrayList<PackageDTO> list = new ArrayList<PackageDTO>();
			
			
			while (rs.next()) {
				
				
				
				PackageDTO dto = new PackageDTO();
				
				dto.setPkSeq(rs.getString("PKGPM_SEQ"));
				dto.setPkName(rs.getString("PKGPM_NAME"));
				dto.setAdultPrice(rs.getString("PKGPM_ADULTPRICE"));
				dto.setToddlerPrice(rs.getString("IMAGEM_SEQ"));
				dto.setPkThumbSeq(rs.getString("THUMBNAILI_SEQ"));
				dto.setPkThumbName(rs.getString("THUMBNAILI_NAME"));

				
				
				list.add(dto);
				
				
				
				
			}
			
			return list;
			
			
			
		} catch (Exception e) {
			System.out.println("패키지 상품 DB작업 오류");
			e.printStackTrace();
		}
		
		return null;
	}


	public ArrayList<PackageDTO> recomList() {


			try {
				String sql = String.format("select * from vwpkitem where PKGPM_SEQ between 1 and 4 order by PKGPM_SEQ"); 
						
				
				rs = stat.executeQuery(sql);
				
				ArrayList<PackageDTO> list = new ArrayList<PackageDTO>();
				
				
				while (rs.next()) {
					
					
					
					PackageDTO dto = new PackageDTO();
					
					dto.setPkSeq(rs.getString("PKGPM_SEQ"));
					dto.setPkName(rs.getString("PKGPM_NAME"));
					dto.setAdultPrice(rs.getString("PKGPM_ADULTPRICE"));
					dto.setToddlerPrice(rs.getString("IMAGEM_SEQ"));
					dto.setPkThumbSeq(rs.getString("THUMBNAILI_SEQ"));
					dto.setPkThumbName(rs.getString("THUMBNAILI_NAME"));

		
					
					
					list.add(dto);
					

			}
			
			return list;
			
			
			
		} catch (Exception e) {
			System.out.println("제주도 패키지 추천 상품 DB작업 오류");
			e.printStackTrace();
		}
		
		return null;
	
	
	}


	public ArrayList<TagDTO> tagList() {

		

		try {
			String sql = "select distinct * from (select HASHTAG_SEQ, HASHTAG_NAME from vwpktagitem where area_name like '%%제주%%') order by HASHTAG_SEQ";
					
			
			rs = stat.executeQuery(sql);
			
			ArrayList<TagDTO> list = new ArrayList<TagDTO>();
			
			
			while (rs.next()) {
				
				
				
				TagDTO dto = new TagDTO();
				
				dto.setTagSeq(rs.getString("HASHTAG_SEQ"));
				dto.setTagName(rs.getString("HASHTAG_NAME"));
				
				
				
				list.add(dto);
				

		}
		
		return list;
		
		
		
	} catch (Exception e) {
		System.out.println("제주도 패키지 해시태그목록 DB작업 오류");
		e.printStackTrace();
	}
	
	return null;
		
		
		
		
		
		
	
	}


	public ArrayList<PackageDTO> hashlist(HashMap<String, String> map) {

		try {
			String sql = "select * from vwpktagitem where area_name like '%%제주%%' and HASHTAG_NAME = ? order by pkgpm_seq";
					
			
			pstat = conn.prepareStatement(sql);		
			
			pstat.setString(1, map.get("hashtag"));

			
			rs = pstat.executeQuery();

			
			
			ArrayList<PackageDTO> list = new ArrayList<PackageDTO>();
			
			
			while (rs.next()) {
				
				
				
				PackageDTO dto = new PackageDTO();
				

				dto.setPkSeq(rs.getString("PKGPM_SEQ"));
				dto.setPkName(rs.getString("PKGPM_NAME"));
				dto.setAdultPrice(rs.getString("PKGPM_ADULTPRICE"));
				dto.setPkThumbSeq(rs.getString("THUMBNAILI_SEQ"));
				dto.setPkThumbName(rs.getString("THUMBNAILI_NAME"));
				
				list.add(dto);
				

		}
		
		return list;
		
		
		
	} catch (Exception e) {
		System.out.println("제주도 패키지 해시태그 해당상품목록 DB작업 오류");
		e.printStackTrace();
	}
	
	return null;
		
		
	}


	public ArrayList<PackageDTO> searchList(HashMap<String, String> map) {
		
		try {
			String sql = "select PKGPM_SEQ, PKGPM_NAME, THUMBNAILI_SEQ, THUMBNAILI_NAME, PKGPM_COUNT, PKGPM_START, PKGPM_ADULTPRICE from vwpktagitem where area_name like '%%제주%%'";

			if (!( map.get("startdate")==null)) {
			sql += String.format(" and pkgpm_adultprice between %s and %s", map.get("price").split(";")[0],map.get("price").split(";")[1]);
			}
			
			//해시태그
			
			if (!(map.get("hashtag")==null)) {
				if(!map.get("hashtag").equals("전체")) {
			
				sql += String.format(" and hashtag_name = '%s'", map.get("hashtag"));
			}}
			//시작일
			if (!( map.get("startdate")==null || map.get("startdate").trim().isEmpty())) {
				sql += String.format(" and pkgpm_start >= TO_DATE('%s', 'YYYY-MM-DD')", map.get("startdate"));
			}
			
			sql = "select distinct * from (" + sql + ")";

			//정렬
			if (!( map.get("qorder")==null)) {
				sql += " order by PKGPM_COUNT desc";
			}
			if (!( map.get("phighorder")==null)) {
				sql += " order by PKGPM_ADULTPRICE desc";			
			}
			if (!( map.get("ploworder")==null)) {
				sql += " order by PKGPM_ADULTPRICE asc";			
			}
			if (!( map.get("dateorder")==null)) {
				sql += " order by PKGPM_START";			
			}
			
			
			
			
			System.out.println(sql);
			
			
			rs = stat.executeQuery(sql);
			
			ArrayList<PackageDTO> list = new ArrayList<PackageDTO>();
			
			
			while (rs.next()) {
				
				
				
				PackageDTO dto = new PackageDTO();
				
				dto.setPkSeq(rs.getString("PKGPM_SEQ"));
				dto.setPkName(rs.getString("PKGPM_NAME"));
				dto.setAdultPrice(rs.getString("PKGPM_ADULTPRICE"));
				dto.setPkThumbSeq(rs.getString("THUMBNAILI_SEQ"));
				dto.setPkThumbName(rs.getString("THUMBNAILI_NAME"));

	
				
				
				list.add(dto);
				

		}
		
		return list;
		
		
		
	} catch (Exception e) {
		System.out.println("제주도 패키지 전체보기 DB작업 오류");
		e.printStackTrace();
	}
	
	return null;
		
		
		
		
	}


	public PackageDTO item(String pkSeq) {
		try {
			String sql = "select * from vwpkitem where pkgpm_seq = ?";
					
			
			pstat = conn.prepareStatement(sql);		
			
			pstat.setString(1, pkSeq);

			
			rs = pstat.executeQuery();

			
			
			PackageDTO dto = new PackageDTO();
			
			
			if (rs.next()) {
				
				
				
				dto.setPkSeq(rs.getString("PKGPM_SEQ")); //상품번호
				dto.setPkName(rs.getString("PKGPM_NAME")); //상품명
				dto.setPkQuantity(rs.getString("PKGPM_COUNT")); //판매개수
				dto.setPkStartDate(rs.getString("PKGPM_START")); 
				dto.setPkEndDate(rs.getString("PKGPM_END"));
				dto.setAdultPrice(rs.getString("PKGPM_ADULTPRICE"));
				dto.setKidPrice(rs.getString("PKGPM_KIDPRICE"));
				dto.setToddlerPrice(rs.getString("PKGPM_TODDLERPRICE"));
				dto.setPkThumbSeq(rs.getString("THUMBNAILI_SEQ"));
				dto.setPkThumbName(rs.getString("THUMBNAILI_NAME"));				
				dto.setPkImageSeq(rs.getString("IMAGEM_SEQ"));
				dto.setPkAreaSeq(rs.getString("AREA_SEQ"));
				dto.setPkAreaName(rs.getString("AREA_NAME"));				
				dto.setPkPeriod(rs.getString("PKGPM_PERIOD"));
				dto.setPkStatus(rs.getString("PSTATUS"));
				

		}
		
		return dto;
		
		
		
	} catch (Exception e) {
		System.out.println("제주도 패키지 해시태그 해당상품목록 DB작업 오류");
		e.printStackTrace();
	}
	
	return null;
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
	
}


