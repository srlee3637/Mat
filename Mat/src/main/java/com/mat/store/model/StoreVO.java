package com.mat.store.model;

public class StoreVO {

	private int storeNum;
	private int locationType;
	private String storeName;
	private String storeAddress;
	private String repMenu;
	private int price;
	private String contact;
	private String category;
	
	
	public StoreVO() {
		super();
	}
	
	public StoreVO(String storeName, String repMenu, int price, String category) {
		super();
		this.storeName = storeName;
		this.repMenu = repMenu;
		this.price = price;
		this.category = category;
	}
	
	

	public StoreVO(String storeName, String repMenu, int price, String category, String storeAddress, String contact) {
		super();
		this.storeName = storeName;
		this.repMenu = repMenu;
		this.price = price;
		this.category = category;
		this.storeAddress = storeAddress;
		this.contact = contact;
	}

	public StoreVO(int storeNum, int locationType, String storeName, String storeAddress, String repMenu, int price,
			String contact, String category) {
		super();
		this.storeNum = storeNum;
		this.locationType = locationType;
		this.storeName = storeName;
		this.storeAddress = storeAddress;
		this.repMenu = repMenu;
		this.price = price;
		this.contact = contact;
		this.category = category;
	}

	
	public int getStoreNum() {
		return storeNum;
	}

	public void setStoreNum(int storeNum) {
		this.storeNum = storeNum;
	}

	public int getLocationType() {
		return locationType;
	}

	public void setLocationType(int locationType) {
		this.locationType = locationType;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getStoreAddress() {
		return storeAddress;
	}

	public void setStoreAddress(String address) {
		this.storeAddress = address;
	}

	public String getRepMenu() {
		return repMenu;
	}

	public void setRepMenu(String repMenu) {
		this.repMenu = repMenu;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	
	public String toString() {
		return "가게명 :" + storeName + ", 대표메뉴 : " + repMenu +
				", 가격 : " + price + ", 카테고리 : " + category;
	}
	
	public String toStringDetail() {
		return "가게명 :" + storeName + ", 대표메뉴 : " + repMenu +
				", 가격 : " + price + ", 카테고리 : " + category +
				", 주소 : " + storeAddress + ", 연락처 : " + contact;
	}
	
}
