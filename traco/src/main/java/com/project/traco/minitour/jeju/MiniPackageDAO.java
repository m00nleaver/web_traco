package com.project.traco.minitour.jeju;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

import org.w3c.dom.bootstrap.DOMImplementationRegistry;

import com.project.jdbc.locarDB;

import mylibrary.DBUtil;



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
public class MiniPackageDAO {

	private Connection conn;
	private Statement stat; //매개변수X
	private PreparedStatement pstat; //매개변수O
	private ResultSet rs;
	
	
	public MiniPackageDAO() { 
		
		try {
			conn = locarDB.open();
			//conn = DBUtil.open();
			stat = conn.createStatement();
			
			
		} catch (Exception e) {
			System.out.println("DBUtil 에러");
			e.printStackTrace();
		}
		
		
	}



	public ArrayList<TagDTO> tagList() {

		

		try {
			String sql = "select distinct * from (select HASHTAG_SEQ, HASHTAG_NAME from vwminitagitem where area_name like '%%서울%%') order by HASHTAG_SEQ";
					
			
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




	public MiniPackageDTO item(String miniSeq) {
		try {
			
			
			String sql = "select * from vwminitagitem where MINIPM_SEQ = ?";
					
			
			pstat = conn.prepareStatement(sql);		
			
			pstat.setString(1, miniSeq);

			
			rs = pstat.executeQuery();

			
			
			MiniPackageDTO dto = new MiniPackageDTO();
			
			
			if (rs.next()) {
				
				System.out.println("minidto있어?");
				
				dto.setMINIPM_SEQ(rs.getString("MINIPM_SEQ")); //상품번호
				dto.setMINIPM_NAME(rs.getString("MINIPM_NAME")); //상품명
				dto.setMINIPM_COUNT(rs.getString("MINIPM_COUNT")); //판매개수
				dto.setMINIPM_START(rs.getString("MINIPM_START")); 
				dto.setMINIPM_END(rs.getString("MINIPM_END"));
				dto.setMINIPM_PRICE1(rs.getString("MINIPM_PRICE1"));
				dto.setMINIPM_PRICE2(rs.getString("MINIPM_PRICE2"));
				dto.setMINIPM_PRICE3(rs.getString("MINIPM_PRICE3"));
				dto.setTHUMBNAILI_SEQ(rs.getString("THUMBNAILI_SEQ"));
				dto.setIMAGEM_SEQ(rs.getString("IMAGEM_SEQ"));
				dto.setMSTATUS(rs.getString("MSTATUS"));
				dto.setHASHTAG_NAME(rs.getString("HASHTAG_NAME"));
				

		}
		
		return dto;
		
		
		
	} catch (Exception e) {
		System.out.println("미니투어 개별상품 DB작업 오류");
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


	public int insertPackageR(ReserveDTO dto) {

		try {
			
			String sql = "insert into tblminitourr (REZ_SEQ, MINIPM_SEQ) values ( (select max(rez_seq)+1 from tblminitourr), ?)";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getPkgpm_seq());

			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("미니투어-예약 테이블 insert 오류");
		}
		
		return 0;
	}


	public int insertRez(ReserveDTO dto) {
		try {
			
			String sql = "insert into tblrez values( (select max(rez_seq)+1 from tblrez),?, ?, ?, ?, (select bankm_seq from tblbankm where bankm_name = ?), 1, ?, 0)";
			
					
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getRez_date());
			pstat.setString(2, dto.getRez_adultcnt());
			pstat.setString(3, dto.getRez_toddlercnt());
			pstat.setString(4, dto.getRez_kidcnt());
			pstat.setString(5, dto.getBankm_name());
			pstat.setString(6, dto.getMember_seq());

			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("주문예약관리 테이블 insert 오류");
		}
		
		return 0;
	}


	public ArrayList<AreaDTO> arealist(String big) {
		
		try {
			
			String where = String.format("where area_name like '%%%s %%'", big);
			
			String sql = "select * from tblArea "+where;
			
			

			rs = stat.executeQuery(sql);

			
			
			ArrayList<AreaDTO> list = new ArrayList<AreaDTO>();
			
			
			while (rs.next()) {
				
				System.out.println("DTO있어?");
				
				AreaDTO dto = new AreaDTO();
				

				dto.setAREA_SEQ(rs.getString("AREA_SEQ"));
				dto.setAREA_SMALL(rs.getString("AREA_NAME"));
				
				
				list.add(dto);
				

		}
		
		return list;
		
		
		
	} catch (Exception e) {
		System.out.println("지역 중분류 가져오기 DB작업 오류");
		e.printStackTrace();
	}
	
	return null;
		
	}


	public ArrayList<MiniPackageDTO> arlist(String area) {
		try {
			
			String where = String.format("where area_name like '%%%s%%'", area);
			
			String sql = "select * from vwminitagitem "+where;
			
			

			rs = stat.executeQuery(sql);

			
			
			ArrayList<MiniPackageDTO> list = new ArrayList<MiniPackageDTO>();
			
			
			while (rs.next()) {
				
				System.out.println("DTO있어?");
				
				MiniPackageDTO dto = new MiniPackageDTO();

				
				dto.setMINIPM_SEQ(rs.getString("MINIPM_SEQ")); //상품번호
				dto.setMINIPM_NAME(rs.getString("MINIPM_NAME")); //상품명
				dto.setMINIPM_COUNT(rs.getString("MINIPM_COUNT")); //판매개수
				dto.setMINIPM_START(rs.getString("MINIPM_START")); 
				dto.setMINIPM_END(rs.getString("MINIPM_END"));
				dto.setMINIPM_PRICE1(rs.getString("MINIPM_PRICE1"));
				dto.setMINIPM_PRICE2(rs.getString("MINIPM_PRICE2"));
				dto.setMINIPM_PRICE3(rs.getString("MINIPM_PRICE3"));
				dto.setTHUMBNAILI_SEQ(rs.getString("THUMBNAILI_SEQ"));
				dto.setIMAGEM_SEQ(rs.getString("IMAGEM_SEQ"));
				dto.setMSTATUS(rs.getString("MSTATUS"));
				dto.setHASHTAG_NAME(rs.getString("HASHTAG_NAME"));

				
				
				list.add(dto);
				

		}
		
		return list;
		
		
		
	} catch (Exception e) {
		System.out.println("특정지역 해당상품 조회 DB작업 오류");
		e.printStackTrace();
	}
	
	return null;
		
	}


	public ArrayList<MiniPackageDTO> alist() {
		try {
			
			
			String sql = "select * from vwminitagitem";
			
			

			rs = stat.executeQuery(sql);

			
			
			ArrayList<MiniPackageDTO> list = new ArrayList<MiniPackageDTO>();
			
			
			while (rs.next()) {
				
				System.out.println("미니DTO있어?");
				
				MiniPackageDTO dto = new MiniPackageDTO();

				
				dto.setMINIPM_SEQ(rs.getString("MINIPM_SEQ")); //상품번호
				dto.setMINIPM_NAME(rs.getString("MINIPM_NAME")); //상품명
				dto.setMINIPM_COUNT(rs.getString("MINIPM_COUNT")); //판매개수
				dto.setMINIPM_START(rs.getString("MINIPM_START")); 
				dto.setMINIPM_END(rs.getString("MINIPM_END"));
				dto.setMINIPM_PRICE1(rs.getString("MINIPM_PRICE1"));
				dto.setMINIPM_PRICE2(rs.getString("MINIPM_PRICE2"));
				dto.setMINIPM_PRICE3(rs.getString("MINIPM_PRICE3"));
				dto.setTHUMBNAILI_SEQ(rs.getString("THUMBNAILI_SEQ"));
				dto.setIMAGEM_SEQ(rs.getString("IMAGEM_SEQ"));
				dto.setMSTATUS(rs.getString("MSTATUS"));
				dto.setHASHTAG_NAME(rs.getString("HASHTAG_NAME"));

				
				
				list.add(dto);
				

		}
		
		return list;
		
		
		
	} catch (Exception e) {
		System.out.println("전체상품 조회 DB작업 오류");
		e.printStackTrace();
	}
	
	return null;
	}
	
}


