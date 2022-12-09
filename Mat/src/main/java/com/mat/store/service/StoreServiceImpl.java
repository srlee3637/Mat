package com.mat.store.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mat.store.model.StoreDAO;
import com.mat.store.model.StoreVO;

public class StoreServiceImpl implements StoreService{
	
	StoreDAO storeDAO = StoreDAO.getInstance();
	
	//지역(중구) 선택 메서드
	public ArrayList<StoreVO> selectJg(HttpServletRequest request, HttpServletResponse response) {

		ArrayList<StoreVO> list = storeDAO.selectJg();
		
		return list;
	}
	
	//지역(중구)-카테고리 선택 메서드
	
	
	
}
