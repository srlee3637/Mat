package com.mat.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mat.category.model.CategoryVO;
import com.mat.priceRange.model.PriceRangeVO;
import com.mat.store.model.StoreDAO;
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

		CategoryVO categoryVO = new CategoryVO();
		StoreDAO storeDAO = StoreDAO.getInstance();
		StoreService storeService = new StoreServiceImpl();
		
		
		if(command.equals("/store/store_main.store")) {
			
			ArrayList<StoreVO> storeList = storeService.selectJg(request, response);
			request.setAttribute("storeList", storeList);
			ArrayList<CategoryVO> categoryList = storeService.selectC(request, response);
			request.setAttribute("categoryList", categoryList);
			ArrayList<PriceRangeVO> priceRangeList = storeService.selectP(request, response);
			request.setAttribute("priceRangeList", priceRangeList);
			
			request.getRequestDispatcher("store_main.jsp").forward(request, response);//파일의 경로 
			
		} else if(command.equals("/store/store_c.store")) {
			
			
			
		} else if(command.equals("/store/store_p.store")) {
			
			
			
		} else if(command.equals("/store/store_cp.store")) {
			
			
			
		} else if(command.equals("/store/store_pc.store")) {
			
			
			
		} else if(command.equals("/store/store_detail.store")) {
			
			
			
		} else if(command.equals("/store/store_complete.store")) {
			
			
			
		} else if(command.equals("/store/store_history.store")) {
			
			
			
		}


	}



}
