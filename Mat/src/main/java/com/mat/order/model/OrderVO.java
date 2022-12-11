package com.mat.order.model;

import java.sql.Timestamp;

public class OrderVO {
	
	private String orderNum;
	private String id;
	private String storeNum;
	private String storeName;
	private String menuNum;
	private String menuName;
	private String price;
	private String menuCnt;
	private Timestamp orderDate;
	
	
	public OrderVO() {
		super();
	}

	public OrderVO(String orderNum, String id, String storeNum, String storeName, String menuNum, String menuName,
			String price, String menuCnt, Timestamp orderDate) {
		super();
		this.orderNum = orderNum;
		this.id = id;
		this.storeNum = storeNum;
		this.storeName = storeName;
		this.menuNum = menuNum;
		this.menuName = menuName;
		this.price = price;
		this.menuCnt = menuCnt;
		this.orderDate = orderDate;
	}

	
	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStoreNum() {
		return storeNum;
	}

	public void setStoreNum(String storeNum) {
		this.storeNum = storeNum;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getMenuNum() {
		return menuNum;
	}

	public void setMenuNum(String menuNum) {
		this.menuNum = menuNum;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getMenuCnt() {
		return menuCnt;
	}

	public void setMenuCnt(String menuCnt) {
		this.menuCnt = menuCnt;
	}

	public Timestamp getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}

	
	public String toString() {
		return "OrderVO : orderNum=" + orderNum + ", id=" + id + ", storeNum=" + storeNum + ", storeName=" + storeName
				+ ", menuNum=" + menuNum + ", menuName=" + menuName + ", price=" + price + ", menuCnt=" + menuCnt
				+ ", orderDate=" + orderDate;
	}

	
	
	
}
