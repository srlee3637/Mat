package com.mat.order.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mat.menu.model.MenuDAO;
import com.mat.menu.model.MenuVO;
import com.mat.order.model.OrderDAO;
import com.mat.order.model.OrderVO;
import com.mat.orderDetail.model.OrderDetailDAO;
import com.mat.orderDetail.model.OrderDetailVO;
import com.mat.store.model.StoreDAO;
import com.mat.store.model.StoreVO;

public class OrderServiceImpl implements OrderService{

	OrderDAO orderDAO = OrderDAO.getInstance();
	OrderDetailDAO orderDetailDAO = OrderDetailDAO.getInstance();
	StoreDAO storeDAO = StoreDAO.getInstance();
	MenuDAO menuDAO = MenuDAO.getInstance();


	//주문 내역 저장하고 마지막 주문 상세정보 반환 메서드
	public ArrayList<OrderDetailVO> insertOrder(HttpServletRequest request, HttpServletResponse response) {

		//		HttpSession session = request.getSession();
		//		String id = (String)session.getAttribute("user_id");
		String id = "aaa1";

		String storeNum = request.getParameter("storeNum");
		StoreVO storeVO = storeDAO.selectStore(storeNum);
		String storeName = storeVO.getStoreName();

		ArrayList<MenuVO> menuList = menuDAO.getMenu(storeNum);
		
		//총 주문 메뉴 개수(cnt'n' 합)
		int menuCount = 0;
		for(int i=1; i<=menuList.size(); i++) {
			
			menuCount += Integer.parseInt(request.getParameter("cnt"+i));
		}
		String menuCnt = Integer.toString(menuCount);
		
		//Order Table insert
		for(int i=1; i<=menuList.size(); i++) {

			String cnt = request.getParameter("cnt"+i);
			
			if(!cnt.equals("0")) {

				String menuNum = Integer.toString(menuList.get(i-1).getMenuNum());
				String menuName = menuList.get(i-1).getMenuName();
				String price = Integer.toString(menuList.get(i-1).getPrice());

				int result = orderDAO.insertOrder(id, storeName, menuNum, menuName, price, menuCnt);

				break;
			}
		}

		String lastOrderNum = orderDAO.lastOrderNum();

		//OrderDetail Table insert
		for(int i=1; i<=menuList.size(); i++) {

			String menuQuantity = request.getParameter("cnt"+i);
			if(menuQuantity.equals("0")) continue;

			String menuNum = Integer.toString(menuList.get(i-1).getMenuNum());
			String menuName = menuList.get(i-1).getMenuName();
			String price = Integer.toString(menuList.get(i-1).getPrice());

			int result = orderDetailDAO.insertOrderDetail(lastOrderNum, id, storeName, menuNum, menuName, price, menuQuantity);
		}
		
		ArrayList<OrderDetailVO> list = orderDetailDAO.getList(lastOrderNum);

		return list;
	}
	
	
	//특정 OrderNum 주문 정보 list 저장 메서드
	public ArrayList<OrderDetailVO> getOrderDetail(HttpServletRequest request, HttpServletResponse response) {
		
		String orderNum = request.getParameter("orderNum");
		
		ArrayList<OrderDetailVO> list = orderDetailDAO.getList(orderNum); 
		
		return list;
	}
	

	//주문 내역 전체 불러오는 메서드
	public ArrayList<OrderVO> getOrderList(HttpServletRequest request, HttpServletResponse response) {

		ArrayList<OrderVO> list = orderDAO.getList();

		return list;
	}



}
