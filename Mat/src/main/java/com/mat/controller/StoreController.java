package com.mat.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mat.category.model.CategoryVO;
import com.mat.menu.model.MenuVO;
import com.mat.order.model.OrderDAO;
import com.mat.order.service.OrderService;
import com.mat.order.service.OrderServiceImpl;
import com.mat.priceRange.model.PriceRangeVO;
import com.mat.store.model.StoreVO;
import com.mat.store.service.StoreService;
import com.mat.store.service.StoreServiceImpl;

@WebServlet("*.store")
public class StoreController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public StoreController() { }

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

		StoreService storeService = new StoreServiceImpl();
		OrderDAO orderDAO = OrderDAO.getInstance();
		
		if(command.equals("/store/store_main.store")) {
			
			ArrayList<StoreVO> storeList = storeService.selectJg(request, response);
			request.setAttribute("storeList", storeList);
			ArrayList<CategoryVO> categoryList = storeService.selectC(request, response);
			request.setAttribute("categoryList", categoryList);
			ArrayList<PriceRangeVO> priceRangeList = storeService.selectP(request, response);
			request.setAttribute("priceRangeList", priceRangeList);
			
			request.getRequestDispatcher("store_main.jsp").forward(request, response);
			
			
		} else if(command.equals("/store/store_c.store")) {
			
			String categoryType = request.getParameter("categoryType");
			request.setAttribute("categoryType", categoryType);
			
			ArrayList<StoreVO> storeList = storeService.selectJgC(request, response);
			request.setAttribute("storeList", storeList);
			ArrayList<PriceRangeVO> priceRangeList = storeService.selectP(request, response);
			request.setAttribute("priceRangeList", priceRangeList);
			
			request.getRequestDispatcher("store_c.jsp").forward(request, response);
			
			
		} else if(command.equals("/store/store_p.store")) {
			
			String priceRangeType = request.getParameter("priceRangeType");
			request.setAttribute("priceRangeType", priceRangeType);
			
			ArrayList<StoreVO> storeList = storeService.selectJgP(request, response);
			request.setAttribute("storeList", storeList);
			ArrayList<CategoryVO> categoryList = storeService.selectC(request, response);
			request.setAttribute("categoryList", categoryList);
			
			request.getRequestDispatcher("store_p.jsp").forward(request, response);
			
			
		} else if(command.equals("/store/store_cp.store")) {
			
			ArrayList<StoreVO> storeList = storeService.selectJgCP(request, response);
			request.setAttribute("storeList", storeList);
			
			request.getRequestDispatcher("store_cp.jsp").forward(request, response);
			
			
		} else if(command.equals("/store/store_detail.store")) {
			
			StoreVO storeVO = storeService.selectStore(request, response);
			request.setAttribute("storeVO", storeVO);
			ArrayList<MenuVO> menuList = storeService.getMenu(request, response);
			request.setAttribute("menuList", menuList);
			
			request.getRequestDispatcher("store_detail.jsp").forward(request, response);
		} 

	}

}
