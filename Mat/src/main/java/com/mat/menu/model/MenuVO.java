package com.mat.menu.model;

public class MenuVO {
	
	private int menuNum;
	private int locationType;
	private int storeNum;
	private String menuName;
	private int price;
	
	
	public MenuVO() {
		super();
	}

	public MenuVO(String menuName, int price) {
		super();
		this.menuName = menuName;
		this.price = price;
	}
	
	public MenuVO(int menuNum, int locationType, int storeNum, String menuName, int price) {
		super();
		this.menuNum = menuNum;
		this.locationType = locationType;
		this.storeNum = storeNum;
		this.menuName = menuName;
		this.price = price;
	}


	public int getMenuNum() {
		return menuNum;
	}

	public void setMenuNum(int menuNum) {
		this.menuNum = menuNum;
	}

	public int getLocationType() {
		return locationType;
	}

	public void setLocationType(int locationType) {
		this.locationType = locationType;
	}

	public int getStoreNum() {
		return storeNum;
	}

	public void setStoreNum(int storeNum) {
		this.storeNum = storeNum;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	
	public String toString() {
		return "메뉴명 : " + menuName + ", 가격 : " + price;
	}
	
}
