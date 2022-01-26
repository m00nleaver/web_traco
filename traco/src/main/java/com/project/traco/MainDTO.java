package com.project.traco;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MainDTO{
	
	String banneri_seq; 		//배너이미지번호
	String banneri_name; 		//이미지명
	String banneri_imageurl; 	//이미지URL
	String banneri_linkurl;		//링크URL
	String status; 				//사용여부
	String bannerctg_seq; 		//배너그룹번호
	
	String pkgpm_seq;			//패키지상품관리번호
	String pkgpm_name;			//상품명
	String pkgpm_count;			//판매개수
	String pkgpm_start;			//출발일
	String pkgpm_end;			//복귀일
	String pkgpm_adultprice;	//성인가격	
	String pkgpm_kidprice;		//아동가격
	String pkgpm_toddlerprice;	//유아가격
	String pkgperiod;			//일자
	String pstatus;				//상품상태
	String thumbnaili_seq;		//섬네일이미지번호
	String area_seq;			//지역번호
	String area_name;			//지역이름
	
	String minipm_name;			//미니투어이름
	String minipm_price1;		//성인가격
	String minictg_name;		//미니투어카테고리
	String thumbnaili_name;		//미니투어썸네일
	String rec;					//메인등록여부
	
	public String getBanneri_seq() {
		return banneri_seq;
	}
	public void setBanneri_seq(String banneri_seq) {
		this.banneri_seq = banneri_seq;
	}
	public String getBanneri_name() {
		return banneri_name;
	}
	public void setBanneri_name(String banneri_name) {
		this.banneri_name = banneri_name;
	}
	public String getBanneri_imageurl() {
		return banneri_imageurl;
	}
	public void setBanneri_imageurl(String banneri_imageurl) {
		this.banneri_imageurl = banneri_imageurl;
	}
	public String getBanneri_linkurl() {
		return banneri_linkurl;
	}
	public void setBanneri_linkurl(String banneri_linkurl) {
		this.banneri_linkurl = banneri_linkurl;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getBannerctg_seq() {
		return bannerctg_seq;
	}
	public void setBannerctg_seq(String bannerctg_seq) {
		this.bannerctg_seq = bannerctg_seq;
	}
	public String getPkgpm_seq() {
		return pkgpm_seq;
	}
	public void setPkgpm_seq(String pkgpm_seq) {
		this.pkgpm_seq = pkgpm_seq;
	}
	public String getPkgpm_name() {
		return pkgpm_name;
	}
	public void setPkgpm_name(String pkgpm_name) {
		this.pkgpm_name = pkgpm_name;
	}
	public String getPkgpm_count() {
		return pkgpm_count;
	}
	public void setPkgpm_count(String pkgpm_count) {
		this.pkgpm_count = pkgpm_count;
	}
	public String getPkgpm_start() {
		return pkgpm_start;
	}
	public void setPkgpm_start(String pkgpm_start) {
		this.pkgpm_start = pkgpm_start;
	}
	public String getPkgpm_end() {
		return pkgpm_end;
	}
	public void setPkgpm_end(String pkgpm_end) {
		this.pkgpm_end = pkgpm_end;
	}
	public String getPkgpm_adultprice() {
		return pkgpm_adultprice;
	}
	public void setPkgpm_adultprice(String pkgpm_adultprice) {
		this.pkgpm_adultprice = pkgpm_adultprice;
	}
	public String getPkgpm_kidprice() {
		return pkgpm_kidprice;
	}
	public void setPkgpm_kidprice(String pkgpm_kidprice) {
		this.pkgpm_kidprice = pkgpm_kidprice;
	}
	public String getPkgpm_toddlerprice() {
		return pkgpm_toddlerprice;
	}
	public void setPkgpm_toddlerprice(String pkgpm_toddlerprice) {
		this.pkgpm_toddlerprice = pkgpm_toddlerprice;
	}
	public String getPkgperiod() {
		return pkgperiod;
	}
	public void setPkgperiod(String pkgperiod) {
		this.pkgperiod = pkgperiod;
	}
	public String getPstatus() {
		return pstatus;
	}
	public void setPstatus(String pstatus) {
		this.pstatus = pstatus;
	}
	public String getThumbnaili_seq() {
		return thumbnaili_seq;
	}
	public void setThumbnaili_seq(String thumbnaili_seq) {
		this.thumbnaili_seq = thumbnaili_seq;
	}
	public String getArea_seq() {
		return area_seq;
	}
	public void setArea_seq(String area_seq) {
		this.area_seq = area_seq;
	}
	public String getArea_name() {
		return area_name;
	}
	public void setArea_name(String area_name) {
		this.area_name = area_name;
	}
	public String getMinipm_name() {
		return minipm_name;
	}
	public void setMinipm_name(String minipm_name) {
		this.minipm_name = minipm_name;
	}
	public String getMinipm_price1() {
		return minipm_price1;
	}
	public void setMinipm_price1(String minipm_price1) {
		this.minipm_price1 = minipm_price1;
	}
	public String getMinictg_name() {
		return minictg_name;
	}
	public void setMinictg_name(String minictg_name) {
		this.minictg_name = minictg_name;
	}
	public String getThumbnaili_name() {
		return thumbnaili_name;
	}
	public void setThumbnaili_name(String thumbnaili_name) {
		this.thumbnaili_name = thumbnaili_name;
	}
	public String getRec() {
		return rec;
	}
	public void setRec(String rec) {
		this.rec = rec;
	}
	
}