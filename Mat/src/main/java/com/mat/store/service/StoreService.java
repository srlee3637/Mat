package com.mat.store.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mat.category.model.CategoryVO;
import com.mat.menu.model.MenuVO;
import com.mat.priceRange.model.PriceRangeVO;
import com.mat.store.model.StoreVO;

public interface StoreService {

	//지역(중구) 선택 메서드
	public ArrayList<StoreVO> selectJg(HttpServletRequest request, HttpServletResponse response);

	//카테고리 선택 메서드
	public ArrayList<CategoryVO> selectC(HttpServletRequest request, HttpServletResponse response);

	//가격대 선택 메서드
	public ArrayList<PriceRangeVO> selectP(HttpServletRequest request, HttpServletResponse response);

	//지역(중구)-카테고리 선택 메서드
	public ArrayList<StoreVO> selectJgC(HttpServletRequest request, HttpServletResponse response);

	//지역(중구)-가격대 선택 메서드
	public ArrayList<StoreVO> selectJgP(HttpServletRequest request, HttpServletResponse response);

	//지역(중구)-카테고리&가격대 선택 메서드
	public ArrayList<StoreVO> selectJgCP(HttpServletRequest request, HttpServletResponse response);

	//가게 상세정보 불러오기 메서드
	public StoreVO selectStore(HttpServletRequest request, HttpServletResponse response);
	
	//가게 모든 메뉴 불러오는 메서드
	public ArrayList<MenuVO> getMenu(HttpServletRequest request, HttpServletResponse response);
	
	//게시글 제목 검색 메서드
	public ArrayList<StoreVO> search(HttpServletRequest request, HttpServletResponse response);
	
}
