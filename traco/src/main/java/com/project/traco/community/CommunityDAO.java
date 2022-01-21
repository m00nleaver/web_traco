package com.project.traco.community;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.test.jdbc.DBUtil;

//오라클 테이블 1개당 > DTO 클래스 1개 생성
public class CommunityDAO {

	private Connection conn;
	private Statement stat; // 매개변수X
	private PreparedStatement pstat; // 매개변수O
	private ResultSet rs;

	public CommunityDAO() {

		try {

			conn = DBUtil.open();
			stat = conn.createStatement();

		} catch (Exception e) {
			System.out.println("CommunityDAO.CommunityDAO()");
			e.printStackTrace();
		}

	}

	public int add(CommunityDTO dto) {

		try {

			String sql = "insert into tblBoardM (boardm_seq, postm_title, boardm_content, boardm_date, boardm_view, boardm_up, communityc_seq,memberm_seq) values (SEQBOARDM.nextval, ?, ?, default, default, default, ?, ?)";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, dto.getPostm_title());
			pstat.setString(2, dto.getBoardm_content());
			pstat.setString(3, dto.getCommunityc_seq());
			pstat.setString(4, dto.getMemberm_seq());

			return pstat.executeUpdate();

		} catch (Exception e) {
			System.out.println("CommunityDAO.add()");
			e.printStackTrace();
		}

		return 0;
	}

	// List 서블릿이 목록주세요~ 라고 요청
	public ArrayList<CommunityDTO> list(HashMap<String, String> map) {

		try {
			String where = "";

			if (map.get("searchmode").equals("y")) {
				where = String.format("where %s like '%%%s%%'", map.get("column"), map.get("word").replace("'", "''"));
			}
			String sql = String.format("select * from vtblBoardM %s order by boardm_seq desc", where);

			rs = stat.executeQuery(sql);

			ArrayList<CommunityDTO> list = new ArrayList<CommunityDTO>();

			while (rs.next()) {
				// 레코드 1줄 -> BoardDTO 1개
				CommunityDTO dto = new CommunityDTO();

				dto.setBoardm_seq(rs.getString("boardm_seq"));
				dto.setPostm_title(rs.getString("postm_title"));
				dto.setBoardm_content(rs.getString("boardm_content"));
				dto.setBoardm_date(rs.getString("boardm_date"));
				dto.setBoardm_view(rs.getString("boardm_view"));
				dto.setBoardm_up(rs.getString("boardm_up"));
				dto.setMember_name(rs.getString("member_name"));
				dto.setMember_id(rs.getString("member_id"));
				dto.setCommunityc_name(rs.getString("communityc_name"));

				dto.setIsnew(rs.getDouble("isnew"));
				
				list.add(dto);
			}

			return list;

		} catch (Exception e) {
			System.out.println("CommunityDAO.Communitylist()");
			e.printStackTrace();
		}

		return null;
	}

	// 커뮤니티게시판등록-카테고리불러오기
	public ArrayList<CommunityDTO> Kategorie() {

		try {

			String sql = "select * from tblCommunityC order by communityc_seq asc";

			rs = stat.executeQuery(sql);

			ArrayList<CommunityDTO> Kategorie = new ArrayList<CommunityDTO>();

			while (rs.next()) {
				// 레코드 1줄 -> BoardDTO 1개
				CommunityDTO dto = new CommunityDTO();

				dto.setCommunityc_seq(rs.getString("communityc_seq"));
				dto.setCommunityc_name(rs.getString("Communityc_name"));

				Kategorie.add(dto);
			}

			return Kategorie;

		} catch (Exception e) {
			System.out.println("CommunityDAO.list()");
			e.printStackTrace();
		}
		return null;
	}

	public CommunityDTO get(String boardm_seq) {
		try {

			String sql = "select * from vtblBoardM where boardm_seq = ?";
//					"select tblBoardM.*, (select member_id from tblMember where tblMember.member_seq = tblBoardM.memberm_seq) as id from tblBoardM where boardm_seq = ?";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, boardm_seq);

			rs = pstat.executeQuery();

			if (rs.next()) {
				CommunityDTO dto = new CommunityDTO();

				dto.setBoardm_seq(rs.getString("boardm_seq"));
				dto.setPostm_title(rs.getString("postm_title"));
				dto.setBoardm_content(rs.getString("boardm_content"));
				dto.setBoardm_date(rs.getString("boardm_date"));
				dto.setBoardm_view(rs.getString("boardm_view"));
				dto.setBoardm_up(rs.getString("boardm_up"));
				dto.setMember_name(rs.getString("member_name"));
				dto.setMember_id(rs.getString("member_id"));
				dto.setCommunityc_name(rs.getString("communityc_name"));

				return dto;
			}

		} catch (Exception e) {
			System.out.println("CommunityDAO.get()");
			e.printStackTrace();
		}

		return null;
	}

	// View 서블릿이 글번호를 줄테니 조회수 +1 해주세요~
	public void addReadCount(String boardm_seq) {

		try {

			String sql = "update tblBoardm set boardm_view = boardm_view + 1 where boardm_seq = ?";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, boardm_seq);

			pstat.executeUpdate();

		} catch (Exception e) {
			System.out.println("BoardDAO.addReadCount()");
			e.printStackTrace();
		}

	}

	public int Communityedit(CommunityDTO dto) {
		try {

			String sql = "update tblBoardM set postm_title = ?, boardm_content = ? where boardm_seq = ?";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getPostm_title());
			pstat.setString(2, dto.getBoardm_content());
			pstat.setString(3, dto.getBoardm_seq());

			return pstat.executeUpdate();

		} catch (Exception e) {
			System.out.println("BoardDAO.Communityedit()");
			e.printStackTrace();
		}

		return 0;
	}

	public int Communitydel(String boardm_seq) {
		try {

			String sql = "delete from tblBoardM where boardm_seq = ?";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, boardm_seq);

			return pstat.executeUpdate();

		} catch (Exception e) {
			System.out.println("BoardDAO.Communitydel");
			e.printStackTrace();
		}

		return 0;
	}

}
