package com.project.traco.admin;

public class AdminIDTO {
	
	//상세이미지
	private String imgseq;
	private String imgname;
	
	//썸네일
	private String thumbseq;
	private String thumbname;
	
	
	public String getImgseq() {
		return imgseq;
	}
	public void setImgseq(String imgseq) {
		this.imgseq = imgseq;
	}
	public String getImgname() {
		return imgname;
	}
	public void setImgname(String imgname) {
		this.imgname = imgname;
	}
	public String getThumbseq() {
		return thumbseq;
	}
	public void setThumbseq(String thumbseq) {
		this.thumbseq = thumbseq;
	}
	public String getThumbname() {
		return thumbname;
	}
	public void setThumbname(String thumbname) {
		this.thumbname = thumbname;
	}
}
