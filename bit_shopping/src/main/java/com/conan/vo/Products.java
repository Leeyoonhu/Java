package com.conan.vo;

public class Products {
	private String proId, proName;
	private Integer unitPrice;
	private String description, manufacturer, category;
	private Integer noOfStock;
//	private String fileName;
	public Products() {
		
	}
	public Products(String proName, Integer unitPrice, String description) {
	this.proName = proName;
	this.unitPrice = unitPrice;
	this.description = description;
}

	public Products(String proId, String proName, Integer unitPrice, String description, String manufacturer,
			String category, Integer noOfStock) {
		this.proId = proId;
		this.proName = proName;
		this.unitPrice = unitPrice;
		this.description = description;
		this.manufacturer = manufacturer;
		this.category = category;
		this.noOfStock = noOfStock;
	}
	
	public String getProId() {
		return proId;
	}
	public String getProName() {
		return proName;
	}
	public Integer getUnitPrice() {
		return unitPrice;
	}
	public String getDescription() {
		return description;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public String getCategory() {
		return category;
	}
	public Integer getNoOfStock() {
		return noOfStock;
	}
	public void setProId(String proId) {
		this.proId = proId;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public void setUnitPrice(Integer unitPrice) {
		this.unitPrice = unitPrice;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setNoOfStock(Integer noOfStock) {
		this.noOfStock = noOfStock;
	}
	
	
}
