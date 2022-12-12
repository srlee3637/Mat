package com.mat.favorite.model;

public class FavoritesVO {
	private int favoritesNum;
	private String storeNum;
	private String storeName;
	private String repMenu;
	private int price;
	private String category;
	private String id;
	
	public FavoritesVO() {
		// TODO Auto-generated constructor stub
	}

	public FavoritesVO(int favoritesNum, String storeNum, String storeName, String repMenu, int price, String category,
			String id) {
		super();
		this.favoritesNum = favoritesNum;
		this.storeNum = storeNum;
		this.storeName = storeName;
		this.repMenu = repMenu;
		this.price = price;
		this.category = category;
		this.id = id;
	}

	public int getFavoritesNum() {
		return favoritesNum;
	}

	public void setFavoritesNum(int favoritesNum) {
		this.favoritesNum = favoritesNum;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	
	
	
	
}
