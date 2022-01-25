package com.project.traco.packagetour.jeju;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.test.jdbc.DBUtil;

public class qnaDAO {

	private Connection conn;
	private Statement stat; //매개변수X
	private PreparedStatement pstat; //매개변수O
	private ResultSet rs;
	
	
	public qnaDAO() { 
		
		try {
			conn = DBUtil.open();
			stat = conn.createStatement();
			
			
		} catch (Exception e) {
			System.out.println("DBUtil 에러");
			e.printStackTrace();
		}
		
		
	}

	
	
	
	
	public ArrayList<qnaDTO> list(String pkSeq) {
		
		
		try {
			String sql = String.format("select * from tblPackageqna inner join tblQna using(qna_seq) where pkgpm_seq = ?"); 
					
			
			pstat = conn.prepareStatement(sql);		
			
			pstat.setString(1, pkSeq);

			
			rs = pstat.executeQuery();
			
			
			ArrayList<qnaDTO> list = new ArrayList<qnaDTO>();

			
			while (rs.next()) {
				
				
				
				qnaDTO dto = new qnaDTO();
				
				dto.setPkSeq(rs.getString("PKGPM_SEQ"));
				dto.setQnaSeq(rs.getString("QNA_SEQ"));
				dto.setQnaContent(rs.getString("QNA_CONTENT"));
				dto.setQnaComment(rs.getString("QNA_COMMENT"));

	
				
				
				list.add(dto);
				

		}
		
		return list;
		
		
		
	} catch (Exception e) {
		System.out.println("문의사항 리스트 출력 DB작업 오류");
		e.printStackTrace();
	}
	
	return null;


}





	public int addQna(String addContent) {

		try {
			
			String sqlQna = "insert into tblQna (QNA_SEQ, QNA_CONTENT, QNA_COMMENT) values (qna_seq.nextval, ?, '답변 준비중')";
			
			
			
			pstat = conn.prepareStatement(sqlQna);
			pstat.setString(1, addContent);
			int res = pstat.executeUpdate();


		return res;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return 0;
		
	}





	public int addPkQna(String pkSeq) {
		try {
			
			
			
			
			String sqlPkQna = "insert into tblpackageqna (PKGPM_SEQ, QNA_SEQ) values (?, (select max(qna_seq) from tblQna))";
			
			
			
			pstat = conn.prepareStatement(sqlPkQna);
			pstat.setString(1, pkSeq);
			int res = pstat.executeUpdate();

		return res;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return 0;
	}



}
