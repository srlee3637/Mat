package com.mat.store.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mat.category.model.CategoryVO;
import com.mat.priceRange.model.PriceRangeVO;
import com.mat.store.model.StoreVO;

public interface StoreService {
	
	//지역(중구) 선택 메서드
	public ArrayList<StoreVO> selectJg(HttpServletRequest request, HttpServletResponse response);
	
	//카테고리 선택 메서드
	public ArrayList<CategoryVO> selectC(HttpServletRequest request, HttpServletResponse response);
	
	//가격대 선택 메서드
	public ArrayList<PriceRangeVO> selectP(HttpServletRequest request, HttpServletResponse response);
	
}
