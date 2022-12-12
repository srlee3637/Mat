package com.mat.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mat.category.model.CategoryVO;
import com.mat.favorite.model.FavoritesDAO;
import com.mat.menu.model.MenuVO;
import com.mat.order.model.OrderDAO;
import com.mat.order.service.OrderService;
import com.mat.order.service.OrderServiceImpl;
import com.mat.priceRange.model.PriceRangeVO;
import com.mat.store.model.StoreVO;
import com.mat.store.service.StoreService;
import com.mat.store.service.StoreServiceImpl;
import com.mat.user.service.UserService;
import com.mat.user.service.UserServiceImpl;

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
		UserService userService = new UserServiceImpl();
		OrderDAO orderDAO = OrderDAO.getInstance();
		FavoritesDAO fdao = FavoritesDAO.getInstance();
		
		if(command.equals("/store/store_main.store")) {//가게 메인페이지
			
			ArrayList<StoreVO> storeList = storeService.selectJg(request, response);
			request.setAttribute("storeList", storeList);
			ArrayList<CategoryVO> categoryList = storeService.selectC(request, response);
			request.setAttribute("categoryList", categoryList);
			ArrayList<PriceRangeVO> priceRangeList = storeService.selectP(request, response);
			request.setAttribute("priceRangeList", priceRangeList);
			
			request.getRequestDispatcher("store_main.jsp").forward(request, response);
			
			
		} else if(command.equals("/store/store_c.store")) {//카테고리 한번에
			
			String categoryType = request.getParameter("categoryType");
			request.setAttribute("categoryType", categoryType);
			
			ArrayList<StoreVO> storeList = storeService.selectJgC(request, response);
			request.setAttribute("storeList", storeList);
			ArrayList<PriceRangeVO> priceRangeList = storeService.selectP(request, response);
			request.setAttribute("priceRangeList", priceRangeList);
			
			request.getRequestDispatcher("store_c.jsp").forward(request, response);
			
			
		} else if(command.equals("/store/store_p.store")) {//가격대 한번에
			
			String priceRangeType = request.getParameter("priceRangeType");
			request.setAttribute("priceRangeType", priceRangeType);
			
			ArrayList<StoreVO> storeList = storeService.selectJgP(request, response);
			request.setAttribute("storeList", storeList);
			ArrayList<CategoryVO> categoryList = storeService.selectC(request, response);
			request.setAttribute("categoryList", categoryList);
			
			request.getRequestDispatcher("store_p.jsp").forward(request, response);
			
			
		} else if(command.equals("/store/store_cp.store")) {//카테고리 가격대 한번에
			
			ArrayList<StoreVO> storeList = storeService.selectJgCP(request, response);
			request.setAttribute("storeList", storeList);
			
			request.getRequestDispatcher("store_cp.jsp").forward(request, response);
			
			
		} else if(command.equals("/store/store_detail.store")) {//가게 상세정보 페이지
			
			StoreVO storeVO = storeService.selectStore(request, response);
			request.setAttribute("storeVO", storeVO);
			
			ArrayList<MenuVO> menuList = storeService.getMenu(request, response);
			request.setAttribute("menuList", menuList);
			
			
			HttpSession session = request.getSession();
			String id = (String)session.getAttribute("user_id");
			String storeNum = request.getParameter("storeNum");
			//
			int result = fdao.storeCheck(storeNum,id);
			request.setAttribute("result", result);
			System.out.println(result);
			
			
			request.getRequestDispatcher("store_detail.jsp").forward(request, response);
		
		
		} else if(command.equals("/store/store_search.store")) {//가게 검색
			
			ArrayList<StoreVO> storeList = storeService.search(request, response);
			request.setAttribute("storeList", storeList);
			
			request.getRequestDispatcher("store_search.jsp").forward(request, response);
		}else if(command.equals("/store/favoriteInsertForm.store")) {//즐겨찾기 추가
			
			
			String storeNum = request.getParameter("storeNum");
			HttpSession session = request.getSession();
			String id = (String)session.getAttribute("user_id");
			int result = userService.insertFavor(request, response);
			
			response.sendRedirect("store_detail.store?storeNum=" + storeNum + "&orderNum=" + request.getParameter("orderNum") );
			
		}else if(command.equals("/store/favoriteDeleteForm.store")) {//즐겨찾기 삭제
			
			
			String storeNum = request.getParameter("storeNum");
			HttpSession session = request.getSession();
			String id = (String)session.getAttribute("user_id");
			int result = userService.deleteFavor(request, response);
			
			response.sendRedirect("store_detail.store?storeNum=" + storeNum + "&orderNum=" + request.getParameter("orderNum") );
			

		}
		

	}

}