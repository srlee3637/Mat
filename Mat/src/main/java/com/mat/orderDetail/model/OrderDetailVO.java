package com.mat.orderDetail.model;

import java.sql.Timestamp;

public class OrderDetailVO {
	
	private String orderDetailNum;
	private String orderNum;
	private String id;
	private String storeName;
	private String menuNum;
	private String menuName;
	private String price;
	private String menuQuantity;
	private Timestamp orderDate;
	
	
	public OrderDetailVO() { }

	public OrderDetailVO(String orderDetailNum, String orderNum, String id, String storeName, String menuNum,
			String menuName, String price, String menuQuantity, Timestamp orderDate) {
		super();
		this.orderDetailNum = orderDetailNum;
		this.orderNum = orderNum;
		this.id = id;
		this.storeName = storeName;
		this.menuNum = menuNum;
		this.menuName = menuName;
		this.price = price;
		this.menuQuantity = menuQuantity;
		this.orderDate = orderDate;
	}

	
	public String getOrderDetailNum() {
		return orderDetailNum;
	}

	public void setOrderDetailNum(String orderDetailNum) {
		this.orderDetailNum = orderDetailNum;
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

	public String getMenuQuantity() {
		return menuQuantity;
	}

	public void setMenuQuantity(String menuCnt) {
		this.menuQuantity = menuCnt;
	}

	public Timestamp getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}

	
	public String toString() {
		return "OrderDetailVO : orderDetailNum=" + orderDetailNum + ", orderNum=" + orderNum + ", id=" + id
				+ ", storeName=" + storeName + ", menuNum=" + menuNum + ", menuName=" + menuName + ", price=" + price
				+ ", menuQuantity=" + menuQuantity + ", orderDate=" + orderDate;
	}

}
