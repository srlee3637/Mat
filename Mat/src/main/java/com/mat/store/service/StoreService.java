package com.mat.store.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mat.store.model.StoreVO;

public interface StoreService {
	
	//지역(중구) 선택 메서드
	public ArrayList<StoreVO> selectJg(HttpServletRequest request, HttpServletResponse response);
	
	
	
}
