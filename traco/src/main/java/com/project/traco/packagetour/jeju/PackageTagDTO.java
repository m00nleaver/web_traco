package com.project.traco.packagetour.jeju;

public class PackageTagDTO {

	private String pkSeq;  //상품번호
	private String pkName; // 상품명
	private String pkQuantity; //판매개수
	private String pkStartDate; //출발일
	private String pkEndDate; //복귀일
	private String adultPrice; //성인가격
	private String kidPrice; //아동가격
	private String toddlerPrice; //유아가격
	private String pkThumbSeq; //썸네일번호
	private String pkImageSeq; //이미지번호	
	private String pkAreaSeq; //지역번호
	private String pkPeriod; //일자
	private String pkStatus; //상품상태 
	private String pkTagSeq; //해쉬태그 번호
	
	

	public String getPkTagSeq() {
		return pkTagSeq;
	}

	public void setPkTagSeq(String pkTagSeq) {
		this.pkTagSeq = pkTagSeq;
	}

	public String getPkImageSeq() {
		return pkImageSeq;
	}

	public void setPkImageSeq(String pkImageSeq) {
		this.pkImageSeq = pkImageSeq;
	}

	public String getPkThumbSeq() {
		return pkThumbSeq;
	}

	public void setPkThumbSeq(String pkThumbSeq) {
		this.pkThumbSeq = pkThumbSeq;
	}



	public String getPkSeq() {
		return pkSeq;
	}

	public void setPkSeq(String pkSeq) {
		this.pkSeq = pkSeq;
	}

	public String getPkName() {
		return pkName;
	}

	public void setPkName(String pkName) {
		this.pkName = pkName;
	}

	public String getPkQuantity() {
		return pkQuantity;
	}

	public void setPkQuantity(String pkQuantity) {
		this.pkQuantity = pkQuantity;
	}

	public String getPkStartDate() {
		return pkStartDate;
	}

	public void setPkStartDate(String pkStartDate) {
		this.pkStartDate = pkStartDate;
	}

	public String getPkEndDate() {
		return pkEndDate;
	}

	public void setPkEndDate(String pkEndDate) {
		this.pkEndDate = pkEndDate;
	}

	public String getAdultPrice() {
		return adultPrice;
	}

	public void setAdultPrice(String adultPrice) {
		this.adultPrice = adultPrice;
	}

	public String getKidPrice() {
		return kidPrice;
	}

	public void setKidPrice(String kidPrice) {
		this.kidPrice = kidPrice;
	}

	public String getToddlerPrice() {
		return toddlerPrice;
	}

	public void setToddlerPrice(String toddlerPrice) {
		this.toddlerPrice = toddlerPrice;
	}



	public String getPkAreaSeq() {
		return pkAreaSeq;
	}

	public void setPkAreaSeq(String pkAreaSeq) {
		this.pkAreaSeq = pkAreaSeq;
	}

	public String getPkPeriod() {
		return pkPeriod;
	}

	public void setPkPeriod(String pkPeriod) {
		this.pkPeriod = pkPeriod;
	}

	public String getPkStatus() {
		return pkStatus;
	}

	public void setPkStatus(String pkStatus) {
		this.pkStatus = pkStatus;
	}
}