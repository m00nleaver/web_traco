package com.project.traco.admin;

public class AdminPDTO {

	// 해쉬태그
	private String hseq;
	private String hashtag;

	// 패키지
	private String pseq; // 패키지번호
	private String pname; // 패키지명
	private String pcount; // 갯수
	private String pstart; // 시작날
	private String pend; // 끝나는날
	private String padultprice; // 어른가격
	private String pkidprice; // 아동가격
	private String ptoddleprice; // 유아가격
	private String pthumbname; // 썸네일명
	private String areaseq; // 지역번호
	private String pkgpriod; // 일수
	private String pstatus; // 판매상태

	private String areaname; // 지역이름

	// 미니투어
	private String minictgseq;
	private String minictgname;
	private String mstatus;

	
	
	// 렌트카
	// carfuel 테이블
	private String fuelseq;
	private String fuelname;

	// carkind 테이블
	private String kindseq;
	private String kindname;

	// carmanufacturer 테이블
	private String manufseq;
	private String manufname;

	// carprod테이블
	private String carseq; // 차번호
	private String carname; // 차이름
	private String seatnum; // 수용인원
	private String carcount; // 차량수
	private String carprice; // 가격
	// String manufname; //제조번호
	// String fuelseq;
	
	private String thumbseq; // 썸네일번호

	// 썸네일
	private String thumbname;

	// 지역
	private String areafname; // 시/도
	private String areasname; // 시/군/구
	
	//대여상태
	private String cstatus;
	
	
	//상세이미지
	private String imgseq;
	private String imgname;
	
	//공항
	private String airportseq;
	private String airportname;
	
	//항공사
	private String aircomseq;
	private String aircomname;
	
	//항공권
	private String airseq;
	private String airdate1;
	private String airdate2;
	//private String seatnum;
	private String statusseq;
	//private String aircomseq;
	private String departseq;
	private String departname;
	private String arrivalseq;
	private String arrivalname;
	
	
	//항공원 예약 승인
	private String rezseq;
	private String name;
	private String acnt;
	private String kcnt;
	private String tcnt;
	//airdate1
	//airdate2
	private String status;
	private String price;
	
	
	//회원정보
	private String memseq;
	private String memname;
	private String id;
	private String email;
	private String gender;
	
	
	
		
	
	public String getMemseq() {
		return memseq;
	}

	public void setMemseq(String memseq) {
		this.memseq = memseq;
	}

	public String getMemname() {
		return memname;
	}

	public void setMemname(String memname) {
		this.memname = memname;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRezseq() {
		return rezseq;
	}

	public void setRezseq(String rezseq) {
		this.rezseq = rezseq;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAcnt() {
		return acnt;
	}

	public void setAcnt(String acnt) {
		this.acnt = acnt;
	}

	public String getKcnt() {
		return kcnt;
	}

	public void setKcnt(String kcnt) {
		this.kcnt = kcnt;
	}

	public String getTcnt() {
		return tcnt;
	}

	public void setTcnt(String tcnt) {
		this.tcnt = tcnt;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDepartname() {
		return departname;
	}

	public void setDepartname(String departname) {
		this.departname = departname;
	}

	public String getArrivalname() {
		return arrivalname;
	}

	public void setArrivalname(String arrivalname) {
		this.arrivalname = arrivalname;
	}

	public String getAirseq() {
		return airseq;
	}

	public void setAirseq(String airseq) {
		this.airseq = airseq;
	}

	public String getAirdate1() {
		return airdate1;
	}

	public void setAirdate1(String airdate1) {
		this.airdate1 = airdate1;
	}

	public String getAirdate2() {
		return airdate2;
	}

	public void setAirdate2(String airdate2) {
		this.airdate2 = airdate2;
	}

	public String getStatusseq() {
		return statusseq;
	}

	public void setStatusseq(String statusseq) {
		this.statusseq = statusseq;
	}

	public String getDepartseq() {
		return departseq;
	}

	public void setDepartseq(String departseq) {
		this.departseq = departseq;
	}

	public String getArrivalseq() {
		return arrivalseq;
	}

	public void setArrivalseq(String arrivalseq) {
		this.arrivalseq = arrivalseq;
	}

	public String getAircomseq() {
		return aircomseq;
	}

	public void setAircomseq(String aircomseq) {
		this.aircomseq = aircomseq;
	}

	public String getAircomname() {
		return aircomname;
	}

	public void setAircomname(String aircomname) {
		this.aircomname = aircomname;
	}

	public String getAirportseq() {
		return airportseq;
	}

	public void setAirportseq(String airportseq) {
		this.airportseq = airportseq;
	}

	public String getAirportname() {
		return airportname;
	}

	public void setAirportname(String airportname) {
		this.airportname = airportname;
	}

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

	public String getCstatus() {
		return cstatus;
	}

	public void setCstatus(String cstatus) {
		this.cstatus = cstatus;
	}

	public String getFuelseq() {
		return fuelseq;
	}

	public void setFuelseq(String fuelseq) {
		this.fuelseq = fuelseq;
	}

	public String getFuelname() {
		return fuelname;
	}

	public void setFuelname(String fuelname) {
		this.fuelname = fuelname;
	}

	public String getKindseq() {
		return kindseq;
	}

	public void setKindseq(String kindseq) {
		this.kindseq = kindseq;
	}

	public String getKindname() {
		return kindname;
	}

	public void setKindname(String kindname) {
		this.kindname = kindname;
	}

	public String getManufseq() {
		return manufseq;
	}

	public void setManufseq(String manufseq) {
		this.manufseq = manufseq;
	}

	public String getManufname() {
		return manufname;
	}

	public void setManufname(String manufname) {
		this.manufname = manufname;
	}

	public String getCarseq() {
		return carseq;
	}

	public void setCarseq(String carseq) {
		this.carseq = carseq;
	}

	public String getCarname() {
		return carname;
	}

	public void setCarname(String carname) {
		this.carname = carname;
	}

	public String getSeatnum() {
		return seatnum;
	}

	public void setSeatnum(String seatnum) {
		this.seatnum = seatnum;
	}

	public String getCarcount() {
		return carcount;
	}

	public void setCarcount(String carcount) {
		this.carcount = carcount;
	}

	public String getCarprice() {
		return carprice;
	}

	public void setCarprice(String carprice) {
		this.carprice = carprice;
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

	public String getAreafname() {
		return areafname;
	}

	public void setAreafname(String areafname) {
		this.areafname = areafname;
	}

	public String getAreasname() {
		return areasname;
	}

	public void setAreasname(String areasname) {
		this.areasname = areasname;
	}



	public String getPstatus() {
		return pstatus;
	}

	public void setPstatus(String pstatus) {
		this.pstatus = pstatus;
	}

	public String getMstatus() {
		return mstatus;
	}

	public void setMstatus(String mstatus) {
		this.mstatus = mstatus;
	}

	public String getMinictgseq() {
		return minictgseq;
	}

	public void setMinictgseq(String minictgseq) {
		this.minictgseq = minictgseq;
	}

	public String getMinictgname() {
		return minictgname;
	}

	public void setMinictgname(String minictgname) {
		this.minictgname = minictgname;
	}

	public String getAreaname() {
		return areaname;
	}

	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}

	public String getPseq() {
		return pseq;
	}

	public void setPseq(String pseq) {
		this.pseq = pseq;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPcount() {
		return pcount;
	}

	public void setPcount(String pcount) {
		this.pcount = pcount;
	}

	public String getPstart() {
		return pstart;
	}

	public void setPstart(String pstart) {
		this.pstart = pstart;
	}

	public String getPend() {
		return pend;
	}

	public void setPend(String pend) {
		this.pend = pend;
	}

	public String getPadultprice() {
		return padultprice;
	}

	public void setPadultprice(String padultprice) {
		this.padultprice = padultprice;
	}

	public String getPkidprice() {
		return pkidprice;
	}

	public void setPkidprice(String pkidprice) {
		this.pkidprice = pkidprice;
	}

	public String getPtoddleprice() {
		return ptoddleprice;
	}

	public void setPtoddleprice(String ptoddleprice) {
		this.ptoddleprice = ptoddleprice;
	}

	public String getPthumbname() {
		return pthumbname;
	}

	public void setPthumbname(String pthumbname) {
		this.pthumbname = pthumbname;
	}

	public String getAreaseq() {
		return areaseq;
	}

	public void setAreaseq(String areaseq) {
		this.areaseq = areaseq;
	}

	public String getPkgpriod() {
		return pkgpriod;
	}

	public void setPkgpriod(String pkgpriod) {
		this.pkgpriod = pkgpriod;
	}

	public String getHseq() {
		return hseq;
	}

	public void setHseq(String hseq) {
		this.hseq = hseq;
	}

	public String getHashtag() {
		return hashtag;
	}

	public void setHashtag(String hashtag) {
		this.hashtag = hashtag;
	}

}
