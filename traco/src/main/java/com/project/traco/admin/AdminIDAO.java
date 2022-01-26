package com.project.traco.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

//import com.project.jdbc.locarDB;
import com.test.jdbc.DBUtil;

public class AdminIDAO {

	
	private Connection conn;
	private Statement stat; //매개변수X
	private PreparedStatement pstat; //매개변수O
	private ResultSet rs;
	
	public AdminIDAO() {
		try {
			conn = DBUtil.open();
			//conn = locarDB.open();
			stat = conn.createStatement();

		} catch (Exception e) {
			System.out.println("AdminIDAO.AdminIDAO()");
			e.printStackTrace();
		}
		
	}
	
	
	public int tadd(AdminIDTO idto) {
		try {
			String sql = "insert into tblThumbnaili (thumbnaili_seq,thumbnaili_name) values (seqthumb.nextval,?)";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1,idto.getThumbname());
			
			return pstat.executeUpdate();

		} catch (Exception e) {
			System.out.println(idto.getThumbname());
			e.printStackTrace();
			
		}
		return 0;
	}

	public int iadd(AdminIDTO idto) {
		try {
			String sql = "insert into tblImagem (imagem_seq,imagem_name) values (seqimage.nextval,?)";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1,idto.getImgname());
			
			return pstat.executeUpdate();
		} catch (Exception e) {
			System.out.println(idto.getImgname());
			e.printStackTrace();
		}
		return 0;
	}


	public AdminIDTO iget(String seq) {
		try {
			String sql ="select ti.IMAGEM_SEQ as imagem_Seq, ti.IMAGEM_NAME as imagem_name, tbi.THUMBNAILI_SEQ as thumbnaili_seq,tbi.THUMBNAILI_NAME as thumbnaili_name from TBLPACKAGEPM tp inner join TBLPACKAGEI tpi on tp.PKGPM_SEQ = tpi.PKGPM_SEQ inner join TBLIMAGEM ti on ti.IMAGEM_SEQ = tpi.IMGM_SEQ inner join TBLTHUMBNAILI tbi on tbi.THUMBNAILI_SEQ=tp.THUMBNAILI_SEQ where tp.PKGPM_SEQ =?";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1,seq);
			
			rs = pstat.executeQuery();
			
			if(rs.next()) {
				AdminIDTO idto = new AdminIDTO();
				idto.setImgseq(rs.getString("imagem_seq"));
				idto.setImgname(rs.getString("imagem_name"));
				idto.setThumbseq(rs.getString("thumbnaili_seq"));
				idto.setThumbname(rs.getString("thumbnaili_name"));
				
				return idto;
				
			}
			
		} catch (Exception e) {
			System.out.println("이미지 번호 이름 가져오기 실패");
			e.printStackTrace();
		}
		return null;
	}


	public AdminIDTO gettname(String seq) {
		try {
			String sql="select tbi.thumbnaili_name as thumbnaili_name,tbi.thumbnaili_seq as thumbnaili_seq from TBLPACKAGEPM tp inner join TBLTHUMBNAILI tbi on tp.THUMBNAILI_SEQ=tbi.THUMBNAILI_SEQ where tp.PKGPM_SEQ=?";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, seq);
			
			rs =pstat.executeQuery();
			
			if(rs.next()) {
				AdminIDTO idto = new AdminIDTO();
				
				idto.setThumbname(rs.getString("thumbnaili_name"));
				idto.setThumbseq(rs.getString("thumbnaili_seq"));
				
				return idto;
				
			}
			
			
		} catch (Exception e) {
			System.out.println("썸네일이름 가져오기");
			e.printStackTrace();
		}
		return null;
	}


	public AdminIDTO getiname(String seq) {
		try {
			String sql ="select ti.imagem_name as imagem_name from TBLPACKAGEPM tp inner join TBLPACKAGEI tpi on tp.PKGPM_SEQ=tpi.PKGPM_SEQ inner join TBLIMAGEM ti on ti.IMAGEM_SEQ = tpi.IMGM_SEQ where tp.PKGPM_SEQ=?";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, seq);
			
			rs =pstat.executeQuery();
			
			if(rs.next()) {
				AdminIDTO idto = new AdminIDTO();
				
				idto.setImgname(rs.getString("imagem_name"));
				
				return idto;
				
			}
		} catch (Exception e) {
			System.out.println("상세이미지 이름");
			e.printStackTrace();
		}
		return null;
	}


	public int tupdate(String seq) {
		try {
			String sql = "update TBLPACKAGEPM set THUMBNAILI_SEQ = (select max(THUMBNAILI_SEQ) from TBLTHUMBNAILI) where PKGPM_SEQ = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
			
			rs = pstat.executeQuery();
			
			return 1;
			
		} catch (Exception e) {
			System.out.println("썸네일 수정");
			e.printStackTrace();
		}
		return 0;
	}


	public AdminIDTO imget(String seq) {
		try {
			String sql="select ti.imagem_seq as imageseq, ti.imagem_name as imagename, tbi.thumbnaili_seq as thumbseq, tbi.thumbnaili_name as thumbname from tblminipm tm inner join tblminiimg tmi on tm.minipm_Seq = tmi.minipm_seq ;inner join tblImagem ti on ti.imagem_seq = tmi.imagem_seq inner join tblthumbnaili tbi on tbi.thumbnaili_seq = tm.thumbnaili_seq where tm.minipm_seq=?";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, seq);
			
			rs = pstat.executeQuery();
			
			if(rs.next()) {
				AdminIDTO idto = new AdminIDTO();
				idto.setImgseq(rs.getString("imagemseq"));
				idto.setImgname(rs.getString("imagemname"));
				idto.setThumbseq(rs.getString("thumbseq"));
				idto.setThumbname(rs.getString("thumbname"));
				
				return idto;
				
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}


	public AdminIDTO getmtname(String seq) {
		try {
			String sql="select tbi.thumbnaili_name as thumbnaili_name from TBLminiPM tm inner join TBLTHUMBNAILI tbi on tm.THUMBNAILI_SEQ=tbi.THUMBNAILI_SEQ where tm.miniPM_SEQ=?";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, seq);
			
			rs =pstat.executeQuery();
			
			if(rs.next()) {
				AdminIDTO idto = new AdminIDTO();
				
				idto.setThumbname(rs.getString("thumbnaili_name"));
				
				return idto;
				
			}
			
			
		} catch (Exception e) {
			System.out.println("썸네일이름 가져오기");
			e.printStackTrace();
		}
		return null;
	}


	public AdminIDTO getminame(String seq) {
		try {
			String sql ="select ti.imagem_name as imagem_name from TBLminiPM tp inner join TBLminiimg tpi on tp.miniPM_SEQ=tpi.miniPM_SEQ inner join TBLIMAGEM ti on ti.IMAGEM_SEQ = tpi.Imagem_SEQ where tp.miniPM_SEQ=?";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, seq);
			
			rs =pstat.executeQuery();
			
			if(rs.next()) {
				AdminIDTO idto = new AdminIDTO();
				
				idto.setImgname(rs.getString("imagem_name"));
				
				return idto;
				
			}
		} catch (Exception e) {
			System.out.println("상세이미지 이름");
			e.printStackTrace();
		}
		return null;
	}


	public void rtupdate(String seq) {
		try {
			String sql = "update tblcarprod set thumbnaili_seq = (select max(THUMBNAILI_SEQ) from TBLTHUMBNAILI) where carprod_seq=?";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1,seq);
			
			rs = pstat.executeQuery();
			
		
			
		} catch (Exception e) {
			System.out.println("자동차썸네일 등록");
			e.printStackTrace();
		}
		
	}

}
