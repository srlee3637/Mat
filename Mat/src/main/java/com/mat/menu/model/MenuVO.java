package com.mat.menu.model;

public class MenuVO {
	
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
