package com.project.traco.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.test.jdbc.DBUtil;

public class MemberDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	public MemberDAO() {
		
		try {

			conn = DBUtil.open();
			stat = conn.createStatement();

		} catch (Exception e) {
			System.out.println("MemberDAO.MemberDAO()");
			e.printStackTrace();
		}
		
	}

	//LoginOk 서블릿이 아이디와 암호를 줄테니 개인 정보를 돌려주세요. > 로그인 처리
	public MemberDTO login(MemberDTO dto) {
		
		try {

			//? > 오라클 매개변수 > %s 역할
			String sql = "select * from tblMember where member_id=? and member_pw=?";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, dto.getMember_id()); //첫번째 ?
			pstat.setString(2, dto.getMember_pw()); //두번째 ?
			
			rs = pstat.executeQuery();
			
			if (rs.next()) {
				
				MemberDTO result = new MemberDTO();
				
				result.setMember_seq(rs.getString("member_seq"));
				result.setMember_id(rs.getString("member_id"));
				result.setMember_name(rs.getString("member_pw"));
				
				return result;
				
			}

		} catch (Exception e) {
			System.out.println("MemberDAO.login()");
			e.printStackTrace();
		}
		
		return null;
	}
}





