package com.mat.store.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mat.category.model.CategoryDAO;
import com.mat.category.model.CategoryVO;
import com.mat.priceRange.model.PriceRangeDAO;
import com.mat.priceRange.model.PriceRangeVO;
import com.mat.store.model.StoreDAO;
import com.mat.store.model.StoreVO;

public class StoreServiceImpl implements StoreService{
	
	StoreDAO storeDAO = StoreDAO.getInstance();
	CategoryDAO categoryDAO = CategoryDAO.getInstance();
	PriceRangeDAO priceRangeDAO = PriceRangeDAO.getInstance();
	
	
	//지역(중구) 선택 메서드
	public ArrayList<StoreVO> selectJg(HttpServletRequest request, HttpServletResponse response) {
		
		ArrayList<StoreVO> list = storeDAO.selectJg();
		
		return list;
	}

	//카테고리 선택 메서드
	public ArrayList<CategoryVO> selectC(HttpServletRequest request, HttpServletResponse response) {
		
		ArrayList<CategoryVO> list = categoryDAO.selectC();
		
		return list;
	}

	//가격대 선택 메서드
	public ArrayList<PriceRangeVO> selectP(HttpServletRequest request, HttpServletResponse response) {

		ArrayList<PriceRangeVO> list = priceRangeDAO.selectP();
		
		return list;
	}
	
	
	
	
	
}
