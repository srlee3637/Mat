package com.mat.category.model;

public class CategoryVO {
	
	private int categoryNum;
	private String categoryType;
	
	
	public CategoryVO() { }

	public CategoryVO(int categoryNum, String categoryType) {
		super();
		this.categoryNum = categoryNum;
		this.categoryType = categoryType;
	}


	public int getCategoryNum() {
		return categoryNum;
	}


	public void setCategoryNum(int categoryNum) {
		this.categoryNum = categoryNum;
	}


	public String getCategoryType() {
		return categoryType;
	}


	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}


	public String toString() {
		return "CategoryVO : categoryNum=" + categoryNum + ", categoryType=" + categoryType;
	}
	
}
