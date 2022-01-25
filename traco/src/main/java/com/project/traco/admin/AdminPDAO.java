package com.project.traco.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.test.jdbc.DBUtil;

public class AdminPDAO {

	private Connection conn;
	private Statement stat; // 매개변수X
	private PreparedStatement pstat; // 매개변수O
	private ResultSet rs;

	public AdminPDAO() {
		try {

			conn = DBUtil.open();
			stat = conn.createStatement();

		} catch (Exception e) {
			System.out.println("AdminPDAO.AdminPDAO()");
			e.printStackTrace();
		}

	}

	public ArrayList<AdminPDTO> hlist() {
		try {
			String sql = "select * from tblHashtag";
			rs = stat.executeQuery(sql);

			ArrayList<AdminPDTO> list = new ArrayList<AdminPDTO>();

			while (rs.next()) {
				AdminPDTO pdto = new AdminPDTO();
				pdto.setHseq(rs.getString("hashtag_seq"));
				pdto.setHashtag(rs.getString("hashtag_name"));

				list.add(pdto);
			}

			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// addpackageok 에서 패키지 등록
	public int padd(AdminPDTO pdto) {
		try {
			String sql = "insert into TBLPACKAGEPM (PKGPM_SEQ, PKGPM_NAME, PKGPM_COUNT, PKGPM_START, PKGPM_END,PKGPM_ADULTPRICE, PKGPM_KIDPRICE, PKGPM_TODDLERPRICE,THUMBNAILI_SEQ, AREA_SEQ, PKGPM_PERIOD, pstatus) values (seqPackage.nextval,?,?,?,?,?,?,?,(select max(thumbnaili_seq) from tblThumbnaili),?,?,?)";
			pstat = conn.prepareStatement(sql);

			pstat.setString(1, pdto.getPname());
			pstat.setString(2, pdto.getPcount());
			pstat.setString(3, pdto.getPstart());
			pstat.setString(4, pdto.getPend());
			pstat.setInt(5, Integer.parseInt(pdto.getPadultprice()));
			pstat.setInt(6, Integer.parseInt(pdto.getPkidprice()));
			pstat.setInt(7, Integer.parseInt(pdto.getPtoddleprice()));
			pstat.setInt(8, Integer.parseInt(pdto.getAreaseq()));
			pstat.setInt(9, Integer.parseInt(pdto.getPkgpriod()));
			pstat.setString(10, pdto.getPstatus());

			return pstat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	// addpackageok 에서 미니투어 등록
	public int madd(AdminPDTO pdto) {
		try {
			String sql = "insert into TBLMINIPM (MINIPM_SEQ, MINIPM_NAME, MINIPM_COUNT, MINIPM_START,MINIPM_PRICE1, MINIPM_PRICE2, MINIPM_PRICE3,MINICTG_SEQ, THUMBNAILI_SEQ, AREA_SEQ,MINIPM_END,mstatus) VALUES (seqmini.nextval,?,?,?,?,?,?,?,(select max(thumbnaili_seq) from tblThumbnaili),?,?,?)";
			pstat = conn.prepareStatement(sql);

			pstat.setString(1, pdto.getPname());
			pstat.setString(2, pdto.getPcount());
			pstat.setString(3, pdto.getPstart());

			pstat.setInt(4, Integer.parseInt(pdto.getPadultprice()));
			pstat.setInt(5, Integer.parseInt(pdto.getPkidprice()));
			pstat.setInt(6, Integer.parseInt(pdto.getPtoddleprice()));
			pstat.setInt(7, Integer.parseInt(pdto.getMinictgseq())); // 카테고리
			pstat.setInt(8, Integer.parseInt(pdto.getAreaseq()));
			pstat.setString(9, pdto.getPend());
			pstat.setString(10, pdto.getMstatus());

			return pstat.executeUpdate();
		} catch (Exception e) {
			System.out.println("미니투어 정보 가져오기 실패");
			e.printStackTrace();
		}
		return 0;
	}

	public ArrayList<AdminPDTO> alist() {
		try {
			String sql = "select * from TBLAREA where area_seq between 230 and 246";
			rs = stat.executeQuery(sql);

			ArrayList<AdminPDTO> list = new ArrayList<AdminPDTO>();

			while (rs.next()) {
				AdminPDTO pdto = new AdminPDTO();
				pdto.setAreaseq(rs.getString("area_seq"));
				pdto.setAreaname(rs.getString("area_name"));

				list.add(pdto);
			}

			return list;
		} catch (Exception e) {
			System.out.println("지역번호 가져오기 실패");
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<AdminPDTO> catlist() {
		try {
			String sql = "select * from tblminictg";
			rs = stat.executeQuery(sql);

			ArrayList<AdminPDTO> list = new ArrayList<AdminPDTO>();

			while (rs.next()) {
				AdminPDTO pdto = new AdminPDTO();
				pdto.setMinictgseq(rs.getString("minictg_seq"));
				pdto.setMinictgname(rs.getString("minictg_name"));

				list.add(pdto);
			}

			return list;
		} catch (Exception e) {
			System.out.println("미니투어카테고리 가져오기실패");
			e.printStackTrace();
		}
		return null;
	}

	public int ipadd() {
		try {
			String sql = "insert into tblpackagei (pkgpm_seq,imgm_seq) values ((select max(pkgpm_seq) from tblPackagePM),(select max(imagem_seq) from tblImagem))";

			rs = stat.executeQuery(sql);

			return 1;
		} catch (Exception e) {
			System.out.println("이미지패키지연결 실패");
			e.printStackTrace();
		}
		return 0;
	}

	public int imadd() {
		try {
			String sql = "insert into tblminiimg (minipm_seq,imagem_seq) values ((select max(minipm_seq) from tblminipm),(select max(imagem_seq) from tblImagem))";

			rs = stat.executeQuery(sql);

			return 1;
		} catch (Exception e) {
			System.out.println("이미지미니투어연결 실패");
			e.printStackTrace();
		}
		return 0;
	}

	public ArrayList<AdminPDTO> plist() {

		try {
			String sql = "select * from tblPackagePM order by pkgpm_seq desc";
			rs = stat.executeQuery(sql);

			ArrayList<AdminPDTO> list = new ArrayList<AdminPDTO>();

			while (rs.next()) {
				AdminPDTO pdto = new AdminPDTO();

				pdto.setPseq(rs.getString("pkgpm_seq")); // 패키지번호
				pdto.setPname(rs.getString("pkgpm_name")); // 패키지명
				pdto.setPcount(rs.getString("pkgpm_count")); // 패키지개수
				pdto.setPstart(rs.getString("pkgpm_start")); // 패키지시작일
				pdto.setPend(rs.getString("pkgpm_end")); // 패키지종료일
				pdto.setPadultprice(rs.getString("pkgpm_adultprice")); // 어른가격
				pdto.setPkidprice(rs.getString("pkgpm_kidprice")); // 아이가격
				pdto.setPtoddleprice(rs.getString("pkgpm_toddlerprice")); // 유아가격
				pdto.setPthumbname(rs.getString("thumbnaili_seq")); // 썸네일번호
				pdto.setAreaseq(rs.getString("area_seq")); // 지역번호
				pdto.setPkgpriod(rs.getString("pkgpm_period")); // 기간
				pdto.setPstatus(rs.getString("pstatus")); // 판매상태

				list.add(pdto);
			}

			return list;

		} catch (Exception e) {
			System.out.println("패키지리스트 가져오기 실패");
			e.printStackTrace();
		}
		return null;
	}

	public AdminPDTO pget(String seq) {
		try {
			String sql = "select tp.*,ta.AREA_NAME as area_name from TBLPACKAGEPM tp inner join TBLAREA ta on tp.AREA_SEQ = ta.AREA_seq where pkgpm_seq=?";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);

			rs = pstat.executeQuery();

			if (rs.next()) {
				AdminPDTO pdto = new AdminPDTO();

				pdto.setPseq(rs.getString("pkgpm_seq")); // 패키지번호
				pdto.setPname(rs.getString("pkgpm_name")); // 패키지명
				pdto.setPcount(rs.getString("pkgpm_count")); // 패키지개수
				pdto.setPstart(rs.getString("pkgpm_start")); // 패키지시작일
				pdto.setPend(rs.getString("pkgpm_end")); // 패키지종료일
				pdto.setPadultprice(rs.getString("pkgpm_adultprice")); // 어른가격
				pdto.setPkidprice(rs.getString("pkgpm_kidprice")); // 아이가격
				pdto.setPtoddleprice(rs.getString("pkgpm_toddlerprice")); // 유아가격
				pdto.setPthumbname(rs.getString("thumbnaili_seq")); // 썸네일번호
				pdto.setAreaseq(rs.getString("area_seq")); // 지역번호
				pdto.setPkgpriod(rs.getString("pkgpm_period")); // 기간
				pdto.setPstatus(rs.getString("pstatus")); // 판매상태
				pdto.setAreaname(rs.getString("area_name")); // 지역이름

				return pdto;
			}

		} catch (Exception e) {
			System.out.println("개별로 불러오기 실패");
			e.printStackTrace();
		}
		return null;
	}

	public int pedit(AdminPDTO pdto) {
		try {
			String sql = "update TBLPACKAGEPM set PKGPM_NAME=?, PKGPM_COUNT=?,PKGPM_START=?,PKGPM_END=?,PKGPM_ADULTPRICE=?,PKGPM_KIDPRICE=?,PKGPM_TODDLERPRICE=?,THUMBNAILI_SEQ=(select max(THUMBNAILI_SEQ) from TBLTHUMBNAILI),area_seq=?,PKGPM_PERIOD=?,PSTATUS=? where PKGPM_SEQ=?";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, pdto.getPname());
			pstat.setInt(2, Integer.parseInt(pdto.getPcount()));
			pstat.setString(3, pdto.getPstart());
			pstat.setString(4, pdto.getPend());
			pstat.setInt(5, Integer.parseInt(pdto.getPadultprice()));
			pstat.setInt(6, Integer.parseInt(pdto.getPkidprice()));
			pstat.setInt(7, Integer.parseInt(pdto.getPtoddleprice()));
			pstat.setInt(8, Integer.parseInt(pdto.getAreaseq()));
			pstat.setInt(9, Integer.parseInt(pdto.getPkgpriod()));
			pstat.setString(10, pdto.getPstatus());
			pstat.setString(11, pdto.getPseq());

			return pstat.executeUpdate();

		} catch (Exception e) {
			System.out.println("수정하기 실패");
			e.printStackTrace();
		}

		return 0;
	}

	// 패키지-이미지 연결 삭제하기
	public void ipdel(String seq) {
		try {
			String sql = "delete from TBLPACKAGEI where PKGPM_SEQ=?";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, seq);

			rs = pstat.executeQuery();

		} catch (Exception e) {
			System.out.println("패키지-이미지연결 삭제실패");
			e.printStackTrace();
		}

	}

	public int delPackage(String seq) {
		try {
			String sql = "delete from tblpackagepm where pkgpm_seq=?";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, seq);

			return pstat.executeUpdate();

		} catch (Exception e) {
			System.out.println("패키지 삭제 실패");
			e.printStackTrace();
		}

		return 0;
	}

	public ArrayList<AdminPDTO> mlist() {
		try {
			String sql = "select * from tblMiniPM order by minipm_seq desc";
			rs = stat.executeQuery(sql);

			ArrayList<AdminPDTO> list = new ArrayList<AdminPDTO>();

			while (rs.next()) {
				AdminPDTO pdto = new AdminPDTO();

				pdto.setPseq(rs.getString("minipm_seq")); // 미니투어번호
				pdto.setPname(rs.getString("minipm_name")); // 미니투어명
				pdto.setPcount(rs.getString("minipm_count")); // 미니투어개수
				pdto.setPstart(rs.getString("minipm_start")); // 미니투어시작일
				pdto.setPadultprice(rs.getString("minipm_price1")); // 어른가격
				pdto.setPkidprice(rs.getString("minipm_price2")); // 아이가격
				pdto.setPtoddleprice(rs.getString("minipm_price3")); // 유아가격
				pdto.setMinictgseq(rs.getString("minictg_seq")); // 미니투어카테고리
				pdto.setPthumbname(rs.getString("thumbnaili_seq")); // 썸네일번호
				pdto.setAreaseq(rs.getString("area_seq")); // 지역번호
				pdto.setPend(rs.getString("minipm_end")); // 기간
				pdto.setMstatus(rs.getString("mstatus")); // 판매상태

				list.add(pdto);
			}

			return list;
		} catch (Exception e) {
			System.out.println("미니투어 리스트");
			e.printStackTrace();
		}
		return null;
	}

	public AdminPDTO mget(String seq) {
		try {
			String sql = "select tm.*,ta.area_name as area_name,tmc.minictg_name as ctgname from tblMinipm tm inner join tblArea ta on tm.area_seq = ta.area_seq inner join tblminictg tmc on tmc.minictg_seq = tm.minictg_seq  where minipm_seq = ?";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);

			rs = pstat.executeQuery();

			if (rs.next()) {
				AdminPDTO pdto = new AdminPDTO();

				pdto.setPseq(rs.getString("minipm_seq")); // 미니투어번호
				pdto.setPname(rs.getString("minipm_name")); // 미니투어명
				pdto.setPcount(rs.getString("minipm_count")); // 미니투어개수
				pdto.setPstart(rs.getString("minipm_start")); // 미니투어시작일
				pdto.setPadultprice(rs.getString("minipm_price1")); // 어른가격
				pdto.setPkidprice(rs.getString("minipm_price2")); // 아이가격
				pdto.setPtoddleprice(rs.getString("minipm_price3")); // 유아가격
				pdto.setMinictgseq(rs.getString("minictg_seq")); // 미니투어카테고리
				pdto.setPthumbname(rs.getString("thumbnaili_seq")); // 썸네일번호
				pdto.setAreaseq(rs.getString("area_seq")); // 지역번호
				pdto.setPend(rs.getString("minipm_end")); // 기간
				pdto.setMstatus(rs.getString("mstatus")); // 판매상태
				pdto.setAreaname(rs.getString("area_name")); // 지역이름
				pdto.setMinictgname(rs.getString("ctgname")); // 카테고리명

				return pdto;
			}

		} catch (Exception e) {
			System.out.println("미니투어개별로 불러오기 실패");
			e.printStackTrace();
		}
		return null;

	}

	public int medit(AdminPDTO pdto) {
		try {
			String sql = "update tblminipm set minipm_name=?,minipm_count=?,minipm_start=?,minipm_price1=?,minipm_price2=?,minipm_price3=?,minictg_seq=?,area_seq=?,minipm_end=?,mstatus=? where minipm_seq=?";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, pdto.getPname());
			pstat.setInt(2, Integer.parseInt(pdto.getPcount()));
			pstat.setString(3, pdto.getPstart());

			pstat.setInt(4, Integer.parseInt(pdto.getPadultprice()));
			pstat.setInt(5, Integer.parseInt(pdto.getPkidprice()));
			pstat.setInt(6, Integer.parseInt(pdto.getPtoddleprice()));
			pstat.setInt(7, Integer.parseInt(pdto.getMinictgseq()));
			pstat.setInt(8, Integer.parseInt(pdto.getAreaseq()));
			pstat.setString(9, pdto.getPend());

			pstat.setString(10, pdto.getMstatus());
			pstat.setString(11, pdto.getPseq());

			return pstat.executeUpdate();

		} catch (Exception e) {
			System.out.println("미니투어 수정 실패");
			e.printStackTrace();
		}
		return 0;
	}

	public void imdel(String seq) {
		try {
			String sql = "delete from TBLminiimg where minipm_seq=?";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, seq);

			rs = pstat.executeQuery();

		} catch (Exception e) {
			System.out.println("미니투어-이미지연결 삭제실패");
			e.printStackTrace();
		}

	}

	public int delMini(String seq) {
		try {
			String sql = "delete from tblminipm where minipm_seq=?";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, seq);

			return pstat.executeUpdate();

		} catch (Exception e) {
			System.out.println("미니투어 삭제 실패");
			e.printStackTrace();
		}

		return 0;

	}

	// Addcar.java에서 제조사리스트 불러오기
	public ArrayList<AdminPDTO> manulist() {
		try {
			String sql = "select * from tblcarmanufacturer";
			rs = stat.executeQuery(sql);

			ArrayList<AdminPDTO> list = new ArrayList<AdminPDTO>();

			while (rs.next()) {

				AdminPDTO pdto = new AdminPDTO();

				pdto.setManufseq(rs.getString("carmanufacturer_seq"));
				pdto.setManufname(rs.getString("carmanufacturer_name"));

				list.add(pdto);
			}

			return list;

		} catch (Exception e) {
			System.out.println("제조사리스트 실패");
			e.printStackTrace();
		}
		return null;
	}

	// Addcar.java에서 연료리스트 불러오기
	public ArrayList<AdminPDTO> fuellist() {
		try {
			String sql = "select * from tblcarfuel";
			rs = stat.executeQuery(sql);

			ArrayList<AdminPDTO> list = new ArrayList<AdminPDTO>();

			while (rs.next()) {

				AdminPDTO pdto = new AdminPDTO();
				pdto.setFuelseq(rs.getString("carfuel_seq"));
				pdto.setFuelname(rs.getString("carfuel_name"));

				list.add(pdto);
			}

			return list;

		} catch (Exception e) {
			System.out.println("연료리스트 실패");
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<AdminPDTO> kindlist() {
		try {
			String sql = "select * from tblcarkind";
			rs = stat.executeQuery(sql);

			ArrayList<AdminPDTO> list = new ArrayList<AdminPDTO>();

			while (rs.next()) {

				AdminPDTO pdto = new AdminPDTO();
				pdto.setKindseq(rs.getString("carkind_seq"));
				pdto.setKindname(rs.getString("carkind_name"));

				list.add(pdto);
			}

			return list;

		} catch (Exception e) {
			System.out.println("크기리스트 실패");
			e.printStackTrace();
		}
		return null;
	}

	public int radd(AdminPDTO pdto) {
		try {
			String sql = "insert into tblCarprod (carprod_seq,carprod_name,carprod_people,carprod_number,carprod_price,carManufacturer_seq,carfuel_seq,carkind_seq,area_seq,thumbnaili_seq,status) values (seqCarp.nextval,?,?,?,?,?,?,?,?,(select max(thumbnaili_seq) from tblThumbnaili),?)";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, pdto.getCarname());
			pstat.setInt(2, Integer.parseInt(pdto.getSeatnum()));
			pstat.setInt(3, Integer.parseInt(pdto.getCarcount()));
			pstat.setInt(4, Integer.parseInt(pdto.getCarprice()));
			pstat.setInt(5, Integer.parseInt(pdto.getManufseq()));
			pstat.setInt(6, Integer.parseInt(pdto.getFuelseq()));
			pstat.setInt(7, Integer.parseInt(pdto.getKindseq()));
			pstat.setInt(8, Integer.parseInt(pdto.getAreaseq()));
			pstat.setString(9, pdto.getCstatus());

			return pstat.executeUpdate();

		} catch (Exception e) {
			System.out.println("렌트카등록 실패");
			e.printStackTrace();
		}
		return 0;
	}
	
	//렌트카 리스트
	public ArrayList<AdminPDTO> rlist() {
		try {
			String sql = "select * from vwcarlist order by carprod_seq desc";
			
			rs = stat.executeQuery(sql);
			
			ArrayList<AdminPDTO> list = new ArrayList<AdminPDTO>();
			
			while(rs.next()) {
				AdminPDTO pdto = new AdminPDTO();
				
				pdto.setCarseq(rs.getString("carprod_Seq"));
				pdto.setCarname(rs.getString("carprod_name"));
				pdto.setSeatnum(rs.getString("carprod_people"));
				pdto.setCarcount(rs.getString("carprod_number"));
				pdto.setCarprice(rs.getString("carprod_price"));
				pdto.setCstatus(rs.getString("status"));
				pdto.setManufname(rs.getString("manufname"));
				pdto.setFuelname(rs.getString("fuelname"));
				pdto.setKindname(rs.getString("kindname"));
				pdto.setAreaname(rs.getString("areaname"));
						
				list.add(pdto);
			}
			
			return list;
			
			
		} catch (Exception e) {
			System.out.println("렌트카 리스트");
			e.printStackTrace();
		}
		return null;
	}

	public AdminPDTO rget(String seq) {
		try {
			String sql = "select * from vwcarlist where carprod_seq=?";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, seq);
			
			rs = pstat.executeQuery();
			
			if (rs.next()) {
				AdminPDTO pdto = new AdminPDTO();
				pdto.setCarseq(rs.getString("carprod_seq"));
				pdto.setCarname(rs.getString("carprod_name"));
				pdto.setCarcount(rs.getString("carprod_number"));
				pdto.setSeatnum(rs.getString("carprod_people"));
				pdto.setCarprice(rs.getString("carprod_price"));
				pdto.setManufname(rs.getString("manufname"));
				pdto.setFuelname(rs.getString("fuelname"));
				pdto.setAreaname(rs.getString("areaname"));
				pdto.setThumbname(rs.getString("thumbname"));
				pdto.setKindname(rs.getString("kindname"));
				pdto.setThumbseq(rs.getString("thumbnaili_seq"));
				
				
				
				return pdto;
			}
			
		} catch (Exception e) {
			System.out.println("렌트카 정보 가져오기");
			e.printStackTrace();
		}
		return null;
	}
	
	
	//렌트카 수정
	public int rupdate(AdminPDTO pdto) {
		try {
			String sql ="update tblcarprod set carprod_name = ?, carprod_people=?,carprod_number=?,carprod_price=?,carmanufacturer_Seq=?,carfuel_seq=?,carkind_seq=?,area_seq=?,status=? where carprod_seq=?";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, pdto.getCarname());
			pstat.setInt(2, Integer.parseInt(pdto.getSeatnum()));
			pstat.setInt(3, Integer.parseInt(pdto.getCarcount()));
			pstat.setInt(4, Integer.parseInt(pdto.getCarprice()));
			pstat.setInt(5, Integer.parseInt(pdto.getManufseq()));
			pstat.setInt(6, Integer.parseInt(pdto.getFuelseq()));
			pstat.setInt(7, Integer.parseInt(pdto.getKindseq()));
			pstat.setInt(8, Integer.parseInt(pdto.getAreaseq()));
			pstat.setString(9, pdto.getCstatus());
			pstat.setInt(10,Integer.parseInt(pdto.getCarseq()));
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("렌트카 수정하기");
			e.printStackTrace();
		}
		return 0;
	}

	public int tadd(AdminPDTO pdto) {
		try {
			String sql = "insert into tblThumbnaili (thumbnaili_seq,thumbnaili_name) values (seqthumb.nextval,?)";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1,pdto.getThumbname());
			
			return pstat.executeUpdate();

		} catch (Exception e) {
			System.out.println("렌트카썸네일등록");
			e.printStackTrace();
			
		}
		return 0;
	}

	public int rentdel(String seq) {
		try {
			String sql = "delete from tblcarprod where carprod_seq=?";
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, seq);
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("렌트카지우기");
			e.printStackTrace();
		}
		return 0;
	}

	//Addflight에서 출발도착리스트 불러오기
	public ArrayList<AdminPDTO> arealist() {
		try {
			String sql= "select * from tblairport";
			rs = stat.executeQuery(sql);

			ArrayList<AdminPDTO> list = new ArrayList<AdminPDTO>();

			while (rs.next()) {
				AdminPDTO pdto = new AdminPDTO();
				pdto.setAirportseq(rs.getString("airport_seq"));
				pdto.setAirportname(rs.getString("airport_name"));

				list.add(pdto);
			}

			return list;
			
		} catch (Exception e) {
			System.out.println("항공 출발도착리스트");
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<AdminPDTO> comlist() {
		try {
			String sql = "select * from tblairplanl";
			rs = stat.executeQuery(sql);

			ArrayList<AdminPDTO> list = new ArrayList<AdminPDTO>();

			while (rs.next()) {
				AdminPDTO pdto = new AdminPDTO();
				pdto.setAircomseq(rs.getString("airplanl_seq"));
				pdto.setAircomname(rs.getString("airplanl_name"));

				list.add(pdto);
			}

			return list;
			
		} catch (Exception e) {
			System.out.println("항공사리스트");
			e.printStackTrace();
		}
		return null;
	}
	
	//AddflightOk에서 항공권 넣기
	public int fadd(AdminPDTO pdto) {
		try {
			String sql = "insert into tblAirplanp (airplanp_Seq,airplanp_takeoffdate,airplanp_takeofftime,airplanp_number,airplanp_adultprice,airplanp_kidprice,airplanp_toddlerprice,salek_seq,airplanl_seq,startl_seq,endl_seq) values (seqair.nextval,?,TO_DATE(?,'YYYY-MM-DD hh24:mi:ss'),?,?,?,?,?,?,?,?)";
			
			pstat = conn.prepareStatement(sql);
			System.out.println(pdto.getAirdate2());
			
			pstat.setString(1, pdto.getAirdate1());
			pstat.setString(2, pdto.getAirdate2());
			pstat.setInt(3, Integer.parseInt(pdto.getSeatnum()));
			pstat.setInt(4, Integer.parseInt(pdto.getPadultprice()));
			pstat.setInt(5, Integer.parseInt(pdto.getPkidprice()));
			pstat.setInt(6, Integer.parseInt(pdto.getPtoddleprice()));
			pstat.setInt(7, Integer.parseInt(pdto.getStatusseq()));
			pstat.setInt(8, Integer.parseInt(pdto.getAircomseq()));
			pstat.setInt(9, Integer.parseInt(pdto.getDepartseq()));
			pstat.setInt(10, Integer.parseInt(pdto.getArrivalseq()));
			
			return pstat.executeUpdate();
			
			
			
		} catch (Exception e) {
			System.out.println("항공권 등록 실패");
			e.printStackTrace();
		}
		return 0;
	}

	public ArrayList<AdminPDTO> flist() {
		try {
			String sql = "select * from vwFlightlist";
			rs = stat.executeQuery(sql);

			ArrayList<AdminPDTO> list = new ArrayList<AdminPDTO>();

			while (rs.next()) {
				AdminPDTO pdto = new AdminPDTO();
				pdto.setPstatus(rs.getString("salek_kind"));
				pdto.setDepartname(rs.getString("startport"));
				pdto.setArrivalname(rs.getString("endport"));
				pdto.setAircomname(rs.getString("airplanl_name"));
				pdto.setAirdate1(rs.getString("airplanp_takeoffdate").substring(2,10));
				pdto.setAirdate2(rs.getString("airplanp_takeofftime").substring(11,16));
				pdto.setPadultprice(rs.getString("airplanp_adultprice"));
				pdto.setPkidprice(rs.getString("airplanp_kidprice"));
				pdto.setPtoddleprice(rs.getString("airplanp_toddlerprice"));
				pdto.setAirseq(rs.getString("airplanp_seq"));

				list.add(pdto);
			}

			return list;
			
			
		} catch (Exception e) {
			System.out.println("항공권리스트");
			e.printStackTrace();
		}
		return null;
	}

	public AdminPDTO fget(String seq) {
		try {
			String sql = "select * from vwflightlist where airplanp_seq=?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);

			rs = pstat.executeQuery();

			if (rs.next()) {
				AdminPDTO pdto = new AdminPDTO();
				pdto.setPstatus(rs.getString("salek_kind"));
				pdto.setAirdate1(rs.getString("airplanp_takeoffdate"));
				pdto.setAirdate2(rs.getString("airplanp_takeofftime"));
				pdto.setDepartseq(rs.getString("startl_seq"));
				pdto.setDepartname(rs.getString("startport"));
				pdto.setArrivalseq(rs.getString("endl_seq"));
				pdto.setArrivalname(rs.getString("endport"));
				pdto.setAircomseq(rs.getString("airplanl_seq"));
				pdto.setAircomname(rs.getString("airplanl_name"));
				pdto.setPadultprice(rs.getString("airplanp_adultprice"));
				pdto.setPkidprice(rs.getString("airplanp_kidprice"));
				pdto.setPtoddleprice(rs.getString("airplanp_toddlerprice"));
				pdto.setSeatnum(rs.getString("airplanp_number"));
				pdto.setAirseq(rs.getString("airplanp_seq"));
				
				return pdto;
			}
			
			
		} catch (Exception e) {
			System.out.println("항공권 개별정보 가져오기");
			e.printStackTrace();
		}
		return null;
	}

	public int fupdate(AdminPDTO pdto) {
		try {
			String sql = "update tblairplanp set airplanp_takeoffdate = ?, airplanp_takeofftime=TO_DATE(?,'YYYY-MM-DD hh24:mi:ss'), airplanp_number=?,airplanp_adultprice=?,airplanp_kidprice=?,airplanp_toddlerprice=?,salek_seq=?,airplanl_seq=?,startl_seq=?,endl_seq=? where airplanp_seq=?";
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1,pdto.getAirdate1());
			pstat.setString(2, pdto.getAirdate2());
			pstat.setInt(3, Integer.parseInt(pdto.getSeatnum()));
			pstat.setInt(4, Integer.parseInt(pdto.getPadultprice()));
			pstat.setInt(5, Integer.parseInt(pdto.getPkidprice()));
			pstat.setInt(6, Integer.parseInt(pdto.getPtoddleprice()));
			pstat.setInt(7, Integer.parseInt(pdto.getStatusseq()));
			pstat.setInt(8, Integer.parseInt(pdto.getAircomseq()));
			pstat.setInt(9, Integer.parseInt(pdto.getDepartseq()));
			pstat.setInt(10, Integer.parseInt(pdto.getArrivalseq()));
			pstat.setString(11, pdto.getAirseq());
			
			
			return pstat.executeUpdate();
			
			
			
		} catch (Exception e) {
			System.out.println("항공권 수정하기");
			e.printStackTrace();
		}
		return 0;
	}

	public int fdel(String seq) {
		try {
			String sql = "delete from tblairplanp where airplanp_seq=?";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, seq);
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("항공권 지우기");
			e.printStackTrace();
		}
		return 0;
	}
	
	//Fconfirm에서 항공권예약 승인 리스트
	public ArrayList<AdminPDTO> fmlist() {
		try {
			String sql = "select * from vwConfirm order by seq desc";
			rs = stat.executeQuery(sql);

			ArrayList<AdminPDTO> list = new ArrayList<AdminPDTO>();

			while (rs.next()) {
				AdminPDTO pdto = new AdminPDTO();
				pdto.setRezseq(rs.getString("seq"));
				pdto.setAcnt(rs.getString("adult"));
				pdto.setKcnt(rs.getString("kid"));
				pdto.setTcnt(rs.getString("tod"));
				pdto.setAirdate1(rs.getString("day").substring(2,10));
				pdto.setAirdate2(rs.getString("time").substring(11,16));
				pdto.setName(rs.getString("name"));
				pdto.setStatus(rs.getString("status"));
				pdto.setPrice(rs.getString("price"));

				list.add(pdto);
			}

			return list;
			
			
		} catch (Exception e) {
			System.out.println("항공권예약승인리스트");
			e.printStackTrace();
		}
		return null;
	}
	
	
	//Memlist에서 멤버리스트 불러오기
	public ArrayList<AdminPDTO> memlist(HashMap<String, String> map) {

		try {
			String sql = String.format("select * from (select rownum as rnum, a.* from (select * from tblmember order by member_seq desc) a) where rnum between %s and %s order by member_seq desc", map.get("begin"),map.get("end"));
			rs = stat.executeQuery(sql);

			ArrayList<AdminPDTO> list = new ArrayList<AdminPDTO>();

			while (rs.next()) {
				AdminPDTO pdto = new AdminPDTO();
				
				pdto.setMemseq(rs.getString("member_seq"));
				pdto.setMemname(rs.getString("member_name"));
				pdto.setId(rs.getString("member_id"));
				pdto.setEmail(rs.getString("member_email"));
				pdto.setGender(rs.getString("member_gender"));

				list.add(pdto);
			}

			return list;
			
			
		} catch (Exception e) {
			System.out.println("멤버관리 리스트");
			e.printStackTrace();
		}

		return null;
	}
	
	
	//MemdelOK에서 회원 삭제하기
	public int memdel(String seq) {
		try {
			String sql = "delete from tblmember where member_seq=?";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, seq);
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("회원삭제 실패");
			e.printStackTrace();
		}
		return 0;
	}

	public int getTotalCount(HashMap<String, String> map) {
		try {
			
			String sql = "select count(*) as cnt from tblmember";
			
			rs = stat.executeQuery(sql);
			
			if (rs.next()) {
				return rs.getInt("cnt");
			}
			
		} catch (Exception e) {
			System.out.println("멤버인원수");
			e.printStackTrace();
		}
		
		return 0;
		
	}
	
	
}
