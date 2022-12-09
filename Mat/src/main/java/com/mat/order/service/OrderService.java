package com.mat.order.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mat.store.model.StoreVO;

public interface OrderService {
	
	public ArrayList<StoreVO> getList(HttpServletRequest request, HttpServletResponse response);

	
}
