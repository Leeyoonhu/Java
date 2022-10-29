package com.ai.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Data
@Document(collection = "field")
public class FieldDTO {
	@Id
	private String id;
	private String fAddress, fName, fPhoneNo, fPic1, fPic2, fPic3, fPic4, fSize, capacity, fInfo;
	private Integer fPrice1, fPrice2;
	private String shoesRent, uniformRent, ballRent, shower, parking, coldHot;
	private String fRule, fRefundRule, fChangeRule, fWeatherRefundRule, fRefund, fChange;
	private String review, latitude, longitude, reserve;
	
	public FieldDTO() {}
	
	public FieldDTO(String id, String fAddress, String fName, String fPhoneNo, String fPic1, String fPic2, String fPic3,
			String fPic4, String fSize, String capacity, String fInfo, Integer fPrice1, Integer fPrice2,
			String shoesRent, String uniformRent, String ballRent, String shower, String parking, String coldHot,
			String fRule, String fRefundRule, String fChangeRule, String fWeatherRefundRule, String fRefund,
			String fChange, String review, String latitude, String longitude, String reserve) {
		this.id = id;
		this.fAddress = fAddress;
		this.fName = fName;
		this.fPhoneNo = fPhoneNo;
		this.fPic1 = fPic1;
		this.fPic2 = fPic2;
		this.fPic3 = fPic3;
		this.fPic4 = fPic4;
		this.fSize = fSize;
		this.capacity = capacity;
		this.fInfo = fInfo;
		this.fPrice1 = fPrice1;
		this.fPrice2 = fPrice2;
		this.shoesRent = shoesRent;
		this.uniformRent = uniformRent;
		this.ballRent = ballRent;
		this.shower = shower;
		this.parking = parking;
		this.coldHot = coldHot;
		this.fRule = fRule;
		this.fRefundRule = fRefundRule;
		this.fChangeRule = fChangeRule;
		this.fWeatherRefundRule = fWeatherRefundRule;
		this.fRefund = fRefund;
		this.fChange = fChange;
		this.review = review;
		this.latitude = latitude;
		this.longitude = longitude;
		this.reserve = reserve;
	}
	
	@Builder
	public FieldDTO(String fAddress, String fName, String fPhoneNo, String fPic1, String fPic2, String fPic3,
			String fPic4, String fSize, String capacity, String fInfo, Integer fPrice1, Integer fPrice2,
			String shoesRent, String uniformRent, String ballRent, String shower, String parking, String coldHot,
			String fRule, String fRefundRule, String fChangeRule, String fWeatherRefundRule, String fRefund,
			String fChange, String review, String latitude, String longitude, String reserve) {
		super();
		this.fAddress = fAddress;
		this.fName = fName;
		this.fPhoneNo = fPhoneNo;
		this.fPic1 = fPic1;
		this.fPic2 = fPic2;
		this.fPic3 = fPic3;
		this.fPic4 = fPic4;
		this.fSize = fSize;
		this.capacity = capacity;
		this.fInfo = fInfo;
		this.fPrice1 = fPrice1;
		this.fPrice2 = fPrice2;
		this.shoesRent = shoesRent;
		this.uniformRent = uniformRent;
		this.ballRent = ballRent;
		this.shower = shower;
		this.parking = parking;
		this.coldHot = coldHot;
		this.fRule = fRule;
		this.fRefundRule = fRefundRule;
		this.fChangeRule = fChangeRule;
		this.fWeatherRefundRule = fWeatherRefundRule;
		this.fRefund = fRefund;
		this.fChange = fChange;
		this.review = review;
		this.latitude = latitude;
		this.longitude = longitude;
		this.reserve = reserve;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public String getfAddress() {
		return fAddress;
	}
	public void setfAddress(String fAddress) {
		this.fAddress = fAddress;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getfPhoneNo() {
		return fPhoneNo;
	}
	public void setfPhoneNo(String fPhoneNo) {
		this.fPhoneNo = fPhoneNo;
	}
	public String getfPic1() {
		return fPic1;
	}
	public void setfPic1(String fPic1) {
		this.fPic1 = fPic1;
	}
	public String getfPic2() {
		return fPic2;
	}
	public void setfPic2(String fPic2) {
		this.fPic2 = fPic2;
	}
	public String getfPic3() {
		return fPic3;
	}
	public void setfPic3(String fPic3) {
		this.fPic3 = fPic3;
	}
	public String getfPic4() {
		return fPic4;
	}
	public void setfPic4(String fPic4) {
		this.fPic4 = fPic4;
	}
	public String getfSize() {
		return fSize;
	}
	public void setfSize(String fSize) {
		this.fSize = fSize;
	}
	public String getCapacity() {
		return capacity;
	}
	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}
	public String getfInfo() {
		return fInfo;
	}
	public void setfInfo(String fInfo) {
		this.fInfo = fInfo;
	}
	public Integer getfPrice1() {
		return fPrice1;
	}
	public void setfPrice1(Integer fPrice1) {
		this.fPrice1 = fPrice1;
	}
	public Integer getfPrice2() {
		return fPrice2;
	}
	public void setfPrice2(Integer fPrice2) {
		this.fPrice2 = fPrice2;
	}
	public String getShoesRent() {
		return shoesRent;
	}
	public void setShoesRent(String shoesRent) {
		this.shoesRent = shoesRent;
	}
	public String getUniformRent() {
		return uniformRent;
	}
	public void setUniformRent(String uniformRent) {
		this.uniformRent = uniformRent;
	}
	public String getBallRent() {
		return ballRent;
	}
	public void setBallRent(String ballRent) {
		this.ballRent = ballRent;
	}
	public String getShower() {
		return shower;
	}
	public void setShower(String shower) {
		this.shower = shower;
	}
	public String getParking() {
		return parking;
	}
	public void setParking(String parking) {
		this.parking = parking;
	}
	public String getColdHot() {
		return coldHot;
	}
	public void setColdHot(String coldHot) {
		this.coldHot = coldHot;
	}
	public String getfRule() {
		return fRule;
	}
	public void setfRule(String fRule) {
		this.fRule = fRule;
	}
	public String getfRefundRule() {
		return fRefundRule;
	}
	public void setfRefundRule(String fRefundRule) {
		this.fRefundRule = fRefundRule;
	}
	public String getfChangeRule() {
		return fChangeRule;
	}
	public void setfChangeRule(String fChangeRule) {
		this.fChangeRule = fChangeRule;
	}
	public String getfWeatherRefundRule() {
		return fWeatherRefundRule;
	}
	public void setfWeatherRefundRule(String fWeatherRefundRule) {
		this.fWeatherRefundRule = fWeatherRefundRule;
	}
	public String getfRefund() {
		return fRefund;
	}
	public void setfRefund(String fRefund) {
		this.fRefund = fRefund;
	}
	public String getfChange() {
		return fChange;
	}
	public void setfChange(String fChange) {
		this.fChange = fChange;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getReserve() {
		return reserve;
	}
	public void setReserve(String reserve) {
		this.reserve = reserve;
	}
	
}
