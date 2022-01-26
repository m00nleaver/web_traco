package com.project.traco.community;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.my.jdbc.DBUtil;

//import com.test.jdbc.DBUtil;


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
				where = String.format("where %s like '%%%s%%'"
							, map.get("column")
							, map.get("word").replace("'", "''"));
			}
			String sql = String.format("select * from (select rownum as rnum, a.* from (select * from vtblBoardM %s order by boardm_seq desc) a) where rnum between %s and %s order by boardm_seq desc",where, map.get("begin"), map.get("end"));

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

				dto.setCommentcount(rs.getInt("commentcount"));

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

	// View 서블릿이 글번호를 줄테니 좋아요+1 해주세요~
	public int addUpCount(String boardm_seq) {

		try {

			String sql = "update tblBoardm set boardm_up = boardm_up + 1 where boardm_seq = ?";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, boardm_seq);

			return pstat.executeUpdate();

		} catch (Exception e) {
			System.out.println("BoardDAO.addUpCount()");
			e.printStackTrace();
		}
		return 0;
	}
	
	public int delUpCount(String boardm_seq) {

		try {

			String sql = "update tblBoardm set boardm_up = boardm_up - 1 where boardm_seq = ?";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, boardm_seq);

			return pstat.executeUpdate();

		} catch (Exception e) {
			System.out.println("BoardDAO.delUpCount()");
			e.printStackTrace();
		}
		return 0;
	}

	//게시물 수정
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

	// AddCommentOk 서블릿이 CommentDTO를 줄테니 insert해주세요~
	public int addComment(CommentDTO cdto) {

		try {

			String sql = "insert into tblCommentM (commentm_seq, commentm_name, commentm_content, commentm_date, commentm_up, postm_seq, memberm_seq) values (seqCommentM.nextVal, ?, ?, default, default, ?, ?)";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, cdto.getMember_id());
			pstat.setString(2, cdto.getCommentm_content());
			pstat.setString(3, cdto.getPostm_seq());
			pstat.setString(4, cdto.getMemberm_seq());
			return pstat.executeUpdate();

		} catch (Exception e) {
			System.out.println("BoardDAO.addComment()");
			e.printStackTrace();
		}

		return 0;
	}
	
	//댓글 수정
	public int editComment(CommentDTO cdto) {
		try {

			String sql = "update tblCommentM set commentm_content = ? where commentm_name = ? and postm_seq = ? and commentm_seq = ?";
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, cdto.getCommentm_content());
			pstat.setString(2, cdto.getMember_id());
			pstat.setString(3, cdto.getPostm_seq());
			pstat.setString(4, cdto.getCommentm_seq());
			return pstat.executeUpdate();

		} catch (Exception e) {
			System.out.println("BoardDAO.editComment()");
			e.printStackTrace();
		}

		return 0;
	}

	public ArrayList<CommentDTO> listComment(String boardm_seq) {
		try {

			String sql = "select * from vtblCommentM where postm_seq = ? order by commentm_seq desc";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, boardm_seq);

			rs = pstat.executeQuery();

			ArrayList<CommentDTO> clist = new ArrayList<CommentDTO>();

			while (rs.next()) {
				// 레코드 1줄 > DTO 1개
				CommentDTO dto = new CommentDTO();

				dto.setCommentm_seq(rs.getString("commentm_seq"));
				dto.setCommentm_name(rs.getString("commentm_name"));
				dto.setCommentm_content(rs.getString("commentm_content"));
				dto.setCommentm_date(rs.getString("commentm_date"));
				dto.setCommentm_up(rs.getString("commentm_up"));
				dto.setPostm_seq(rs.getString("postm_seq"));
				dto.setMemberm_seq(rs.getString("memberm_seq"));
				dto.setMember_id(rs.getString("member_id"));

				clist.add(dto);
			}

			return clist;

		} catch (Exception e) {
			System.out.println("BoardDAO.listComment()");
			e.printStackTrace();
		}

		return null;
	}

	// CommentDelOk 서블릿이 댓글 번호를 줄테니 삭제해주세요~
	public int Commentdel(String commentm_seq) {
		try {

			String sql = "delete from tblCommentM where commentm_seq = ?";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, commentm_seq);

			return pstat.executeUpdate();

		} catch (Exception e) {
			System.out.println("BoardDAO.Commentdel()");
			e.printStackTrace();
		}
		return 0;
	}

	// DelOk 서블릿이 부모 글번호를 줄테니 달린 댓글을 모두 삭제해주세요~
	public void CommentdelAll(String boardm_seq) {

		try {

			String sql = "delete from tblCommentM where postm_seq = ?";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, boardm_seq);

			pstat.executeUpdate();

		} catch (Exception e) {
			System.out.println("BoardDAO.CommentdelAll()");
			e.printStackTrace();
		}

	}

	public int getTotalCount(HashMap<String, String> map) {
		try {
	
			String sql = "select count(*) as cnt from vtblBoardM";
			
			rs = stat.executeQuery(sql);
			
			if (rs.next()) {
				return rs.getInt("cnt");
			}
			
		} catch (Exception e) {
			System.out.println("BoardDAO.getTotalCount()");
			e.printStackTrace();
		}
		return 0;
	}

	//추천테이블찾기
	public int upstatussearch(String boardm_seq, String member_id) {
		try {
		
			String sql = "select count(*) as cnt from tblUpstatus where boardm_seq= ? and memberm_name= ?";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, boardm_seq);
			pstat.setString(2, member_id);

			rs = pstat.executeQuery();
			
			if (rs.next()) {
				return rs.getInt("cnt");
			}

		} catch (Exception e) {
			System.out.println("CommunityDAO.upstatussearch()");
			e.printStackTrace();
		}
		return 0;
	}
	
	//추천상태확인
	public int upstatusadd(String boardm_seq, String member_id) {
		try {

			String sql = "insert into tblUpstatus (Upstatus_seq, boardm_seq, memberm_name, upstatus) values (seqUpstatus.nextval, ?, ?, default)";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, boardm_seq);
			pstat.setString(2, member_id);

			return pstat.executeUpdate();

		} catch (Exception e) {
			System.out.println("CommunityDAO.upstatusadd()");
			e.printStackTrace();
		}

		return 0;
	}

	public int upstatusdel(String boardm_seq, String member_id) {
		try {

			String sql = "delete from tblUpstatus where boardm_seq = ? and memberm_name = ?";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, boardm_seq);
			pstat.setString(2, member_id);
			
			return pstat.executeUpdate();

		} catch (Exception e) {
			System.out.println("BoardDAO.Communitydel");
			e.printStackTrace();
		}

		return 0;
	}



	



}
