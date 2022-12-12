package com.mat.store.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mat.category.model.CategoryDAO;
import com.mat.category.model.CategoryVO;
import com.mat.menu.model.MenuDAO;
import com.mat.menu.model.MenuVO;
import com.mat.priceRange.model.PriceRangeDAO;
import com.mat.priceRange.model.PriceRangeVO;
import com.mat.store.model.StoreDAO;
import com.mat.store.model.StoreVO;

public class StoreServiceImpl implements StoreService{
	
	StoreDAO storeDAO = StoreDAO.getInstance();
	CategoryDAO categoryDAO = CategoryDAO.getInstance();
	PriceRangeDAO priceRangeDAO = PriceRangeDAO.getInstance();
	MenuDAO menuDAO = MenuDAO.getInstance();
	
	
	//지역(중구) 선택 메서드
	public ArrayList<StoreVO> selectJg(HttpServletRequest request, HttpServletResponse response) {
		
		ArrayList<StoreVO> list = storeDAO.selectJg();
		
		return list;
	}

	//카테고리 종류 선택 메서드
	public ArrayList<CategoryVO> selectC(HttpServletRequest request, HttpServletResponse response) {
		
		ArrayList<CategoryVO> list = categoryDAO.selectC();
		
		return list;
	}

	//가격대 종류 선택 메서드
	public ArrayList<PriceRangeVO> selectP(HttpServletRequest request, HttpServletResponse response) {

		ArrayList<PriceRangeVO> list = priceRangeDAO.selectP();
		
		return list;
	}
	
	//지역(중구)-카테고리 선택 메서드
	public ArrayList<StoreVO> selectJgC(HttpServletRequest request, HttpServletResponse response) {
		
		String categoryType = request.getParameter("categoryType");
		request.setAttribute("categoryType", categoryType);
		ArrayList<StoreVO> list = storeDAO.selectJgC(categoryType);
		
		return list;
	}
	
	//지역(중구)-가격대 선택 메서드
	public ArrayList<StoreVO> selectJgP(HttpServletRequest request, HttpServletResponse response) {
		
		String priceRangeType = request.getParameter("priceRangeType");
		request.setAttribute("priceRangeType", priceRangeType);
		ArrayList<StoreVO> list = storeDAO.selectJgP(priceRangeType);
		
		return list;
	}

	//지역(중구)-카테고리&가격대 선택 메서드
	public ArrayList<StoreVO> selectJgCP(HttpServletRequest request, HttpServletResponse response) {

		String categoryType = request.getParameter("categoryType");
		String priceRangeType = request.getParameter("priceRangeType");
		ArrayList<StoreVO> list = storeDAO.selectJgCP(categoryType, priceRangeType);
		
		return list;
	}

	//가게 상세정보 불러오기 메서드
	public StoreVO selectStore(HttpServletRequest request, HttpServletResponse response) {
		
		String storeNum = request.getParameter("storeNum");
		StoreVO vo = storeDAO.selectStore(storeNum);
		
		return vo;
	}

	//가게 모든 메뉴 불러오는 메서드
	public ArrayList<MenuVO> getMenu(HttpServletRequest request, HttpServletResponse response) {
		
		String storeNum = request.getParameter("storeNum");
		ArrayList<MenuVO> list = menuDAO.getMenu(storeNum);
		
		return list;
	}
	
	
	
}
