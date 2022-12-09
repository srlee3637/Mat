package com.mat.order.model;

import java.sql.Timestamp;

public class OrderVO {
	
	private int orderNum;
	private String storeName;
	private String repMenu;
	private int menuCnt;
	private Timestamp orderDate;
	
	
	public OrderVO() {
		super();
	}

	public OrderVO(int orderNum, String storeName, String repMenu, int menuCnt, Timestamp orderDate) {
		super();
		this.orderNum = orderNum;
		this.storeName = storeName;
		this.repMenu = repMenu;
		this.menuCnt = menuCnt;
		this.orderDate = orderDate;
	}

	
	public int getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getRepMenu() {
		return repMenu;
	}

	public void setRepMenu(String repMenu) {
		this.repMenu = repMenu;
	}

	public int getMenuCnt() {
		return menuCnt;
	}

	public void setMenuCnt(int menuCnt) {
		this.menuCnt = menuCnt;
	}

	public Timestamp getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}


	public String toString() {
		return "OrderDAO : orderNum=" + orderNum + ", storeName=" + storeName + ", repMenu=" + repMenu + ", menuCnt="
				+ menuCnt + ", orderDate=" + orderDate;
	}
	
}
