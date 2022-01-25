package com.project.traco.community;

//오라클 테이블 1개당 > DTO 클래스 1개 생성
public class CommentDTO {
	
	private String commentm_seq; 		//댓글관리번호
	private String commentm_name; 		//작정사
	private String commentm_content; 	//내용
	private String commentm_date; 		//작성일
	private String commentm_up;			//댓글추천
	private String postm_seq;			//게시글관리번호
	private String memberm_seq;			//회원번호
	private String member_id;			//아이디
	
	public String getCommentm_seq() {
		return commentm_seq;
	}
	public void setCommentm_seq(String commentm_seq) {
		this.commentm_seq = commentm_seq;
	}
	public String getCommentm_name() {
		return commentm_name;
	}
	public void setCommentm_name(String commentm_name) {
		this.commentm_name = commentm_name;
	}
	public String getCommentm_content() {
		return commentm_content;
	}
	public void setCommentm_content(String commentm_content) {
		this.commentm_content = commentm_content;
	}
	public String getCommentm_date() {
		return commentm_date;
	}
	public void setCommentm_date(String commentm_date) {
		this.commentm_date = commentm_date;
	}
	public String getCommentm_up() {
		return commentm_up;
	}
	public void setCommentm_up(String commentm_up) {
		this.commentm_up = commentm_up;
	}
	public String getPostm_seq() {
		return postm_seq;
	}
	public void setPostm_seq(String postm_seq) {
		this.postm_seq = postm_seq;
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
	
	
	
	
	

}	
