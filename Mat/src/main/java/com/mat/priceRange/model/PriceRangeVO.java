package com.mat.priceRange.model;

public class PriceRangeVO {
	
	private int priceRangeType;
	private String priceRange;
	
	
	public PriceRangeVO() {	}


	public PriceRangeVO(int priceRangeType, String priceRange) {
		super();
		this.priceRangeType = priceRangeType;
		this.priceRange = priceRange;
	}


	public int getPriceRangeType() {
		return priceRangeType;
	}


	public void setPriceRangeType(int priceRangeType) {
		this.priceRangeType = priceRangeType;
	}


	public String getPriceRange() {
		return priceRange;
	}


	public void setPriceRange(String priceRange) {
		this.priceRange = priceRange;
	}


	public String toString() {
		return "priceRangeVO : priceRangeType=" + priceRangeType + ", priceRange=" + priceRange;
	}
	
}
