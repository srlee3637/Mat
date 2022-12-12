package com.mat.order.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mat.order.model.OrderVO;
import com.mat.orderDetail.model.OrderDetailVO;


public interface OrderService {

	//주문 내역 저장하는 메서드
	public ArrayList<OrderDetailVO> insertOrder(HttpServletRequest request, HttpServletResponse response);

	//특정 OrderNum 주문 정보 list 저장 메서드
	public ArrayList<OrderDetailVO> getOrderDetail(HttpServletRequest request, HttpServletResponse response);

	//주문 내역 전체 불러오는 메서드
	public ArrayList<OrderVO> getOrderList(HttpServletRequest request, HttpServletResponse response);


}
