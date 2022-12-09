package com.mat.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mat.category.model.CategoryVO;
import com.mat.order.model.OrderDAO;
import com.mat.order.model.OrderVO;
import com.mat.order.service.OrderService;
import com.mat.order.service.OrderServiceImpl;

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
		
		CategoryVO categoryVO = new CategoryVO();
		OrderService orderService = new OrderServiceImpl();
		OrderVO orderVO = new OrderVO();
		OrderDAO orderDAO = OrderDAO.getInstance();
		
		
		if(command.equals("/order/order_main.order")) {
			
			request.getRequestDispatcher("order_main.jsp").forward(request, response);//파일의 경로 

			
		} else if(command.equals("/order/order_c.order")) {
			
			
			
		} else if(command.equals("/order/order_p.order")) {
			
			
			
		} else if(command.equals("/order/order_cp.order")) {
			
			
			
		} else if(command.equals("/order/order_pc.order")) {
			
			
			
		} else if(command.equals("/order/order_store.order")) {
			
			
			
		} else if(command.equals("/order/order_complete.order")) {
			
			
			
		} else if(command.equals("/order/order_history.order")) {
			
			
			
		}


	}



}
