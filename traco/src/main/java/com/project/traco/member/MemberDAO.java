package com.project.traco.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.my.jdbc.DBUtil;

//import com.test.jdbc.DBUtil;


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

	// LoginOk 서블릿이 아이디와 암호를 줄테니 개인 정보를 돌려주세요. > 로그인 처리
	public MemberDTO login(MemberDTO dto) {

		try {

			// ? > 오라클 매개변수 > %s 역할
			String sql = "select * from tblMember where member_id=? and member_pw=?";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, dto.getMember_id()); // 첫번째 ?
			pstat.setString(2, dto.getMember_pw()); // 두번째 ?

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

	public int Memberadd(MemberDTO dto) {
		try {

			String sql = "insert into tblMember (member_seq, member_name, member_id, member_pw, member_birth, member_email, member_gender) values (seqMember.nextval, ?, ?, ?, ?, ?, ?)";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, dto.getMember_name());
			pstat.setString(2, dto.getMember_id());
			pstat.setString(3, dto.getMember_pw());
			pstat.setString(4, dto.getMember_birth());
			pstat.setString(5, dto.getMember_email());
			pstat.setString(6, dto.getMember_gender());

			return pstat.executeUpdate();

		} catch (Exception e) {
			System.out.println("MemberDAO.Memberadd()");
			e.printStackTrace();
		}

		return 0;
	}

	// 아이디찾기
	public String findId(MemberDTO dto) {
		try {

			String sql = "select member_id from tblMember where member_name=? and member_email=?";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, dto.getMember_name());
			pstat.setString(2, dto.getMember_email());

			rs = pstat.executeQuery();

			String member_id;

			if (rs.next()) {

				member_id = rs.getString("member_id");

				return member_id;
			} else {
				member_id = null;
			}

			return member_id;
		} catch (Exception e) {
			System.out.println("MemberDAO.findId()");
			e.printStackTrace();
		}

		return null;
	}

	// 아이디찾기
	public String findPw(MemberDTO dto) {
		try {

			String sql = "select member_pw from tblMember where member_id=? and member_email=?";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, dto.getMember_id());
			pstat.setString(2, dto.getMember_email());

			rs = pstat.executeQuery();

			String member_pw;

			if (rs.next()) {

				member_pw = rs.getString("member_pw");

				return member_pw;
			} else {
				member_pw = null;
			}

			return member_pw;

		} catch (Exception e) {
			System.out.println("MemberDAO.findPw()");
			e.printStackTrace();
		}

		return null;
	}

	// 아이디 중복확인
	public int idcheck(String member_id) {
		try {

			String sql = "select count(*) as cnt from tblMember where member_id = ?";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, member_id);

			rs = pstat.executeQuery();

			if (rs.next()) {
				return rs.getInt("cnt");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}
}
