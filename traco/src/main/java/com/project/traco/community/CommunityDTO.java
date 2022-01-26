package com.project.traco.community;

//오라클 테이블 1개당 > DTO 클래스 1개 생성
public class CommunityDTO {
	
	private String boardm_seq; 		//게시글관리번호
	private String postm_title; 	//제목
	private String boardm_content; 	//내용
	private String boardm_date; 	//작성일
	private String boardm_view;		//조회수
	private String boardm_up;		//추천
	private String communityc_seq;	//커뮤니티카테고리번호
	private String memberm_seq;		//회원번호
	private String member_id;		//회원아이디
	private String member_name; 	//회원이름
	private String communityc_name; //카테고리명
	
	private double isnew; //새글 유무
	
	private int commentcount; //댓글 갯수
	
	private String Upstatus_seq;		//게시글추천번호
	private String upstatus;		//추천상태 Y N
	
	public String getUpstatus_seq() {
		return Upstatus_seq;
	}
	public void setUpstatus_seq(String upstatus_seq) {
		Upstatus_seq = upstatus_seq;
	}
	public String getUpstatus() {
		return upstatus;
	}
	public void setUpstatus(String upstatus) {
		this.upstatus = upstatus;
	}
	public int getCommentcount() {
		return commentcount;
	}
	public void setCommentcount(int commentcount) {
		this.commentcount = commentcount;
	}
	public String getBoardm_seq() {
		return boardm_seq;
	}
	public void setBoardm_seq(String boardm_seq) {
		this.boardm_seq = boardm_seq;
	}
	public String getPostm_title() {
		return postm_title;
	}
	public void setPostm_title(String postm_title) {
		this.postm_title = postm_title;
	}
	public String getBoardm_content() {
		return boardm_content;
	}
	public void setBoardm_content(String boardm_content) {
		this.boardm_content = boardm_content;
	}
	public String getBoardm_date() {
		return boardm_date;
	}
	public void setBoardm_date(String boardm_date) {
		this.boardm_date = boardm_date;
	}
	public String getBoardm_view() {
		return boardm_view;
	}
	public void setBoardm_view(String boardm_view) {
		this.boardm_view = boardm_view;
	}
	public String getBoardm_up() {
		return boardm_up;
	}
	public void setBoardm_up(String boardm_up) {
		this.boardm_up = boardm_up;
	}
	public String getCommunityc_seq() {
		return communityc_seq;
	}
	public void setCommunityc_seq(String communityc_seq) {
		this.communityc_seq = communityc_seq;
	}
	public String getMemberm_seq() {
		return memberm_seq;
	}
	public void setMemberm_seq(String memberm_seq) {
		this.memberm_seq = memberm_seq;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public String getCommunityc_name() {
		return communityc_name;
	}
	public void setCommunityc_name(String communityc_name) {
		this.communityc_name = communityc_name;
	}
	public double getIsnew() {
		return isnew;
	}
	public void setIsnew(double isnew) {
		this.isnew = isnew;
	}
	
	
	

}	
