package com.mat.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mat.category.model.CategoryVO;
import com.mat.menu.model.MenuVO;
import com.mat.order.model.OrderVO;
import com.mat.order.service.OrderService;
import com.mat.order.service.OrderServiceImpl;
import com.mat.orderDetail.model.OrderDetailVO;
import com.mat.store.model.StoreDAO;
import com.mat.store.model.StoreVO;
import com.mat.store.service.StoreService;
import com.mat.store.service.StoreServiceImpl;

@WebServlet("*.order")
public class OrderController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public OrderController() { }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//한글 처리
		request.setCharacterEncoding("UTF-8");

		//요청 분기
		String path = request.getContextPath();
		String uri = request.getRequestURI();
		String command = uri.substring(path.length());

		System.out.println("요청 경로 : " + command);

		OrderService orderService = new OrderServiceImpl();
		StoreService storeService = new StoreServiceImpl();


		if(command.equals("/order/order_complete.order")) {
			
//			StoreVO storeVO = storeService.selectStore(request, response);
//			request.setAttribute("storeVO", storeVO);
//			ArrayList<MenuVO> menuList = storeService.getMenu(request, response);
//			request.setAttribute("menuList", menuList);
			
			StoreVO storeVO = storeService.selectStore(request, response);
			request.setAttribute("storeVO", storeVO);
			ArrayList<OrderDetailVO> list = orderService.insertOrder(request, response);
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("order_complete.jsp").forward(request, response);;
			
			
		} else if(command.equals("/order/order_history.order")) {
			
			ArrayList<OrderVO> orderList = orderService.getOrderList(request, response);
			request.setAttribute("orderList", orderList);
			
			request.getRequestDispatcher("order_history.jsp").forward(request, response);
		}

	}

}