package com.mat.user.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mat.favorite.model.FavoritesDAO;
import com.mat.favorite.model.FavoritesVO;
import com.mat.user.model.UserDAO;
import com.mat.user.model.UserVO;



public class UserServiceImpl implements UserService{
	//컨트롤러의 역할을 분담
	//가입처리

	UserDAO userDAO = UserDAO.getInstance();
	FavoritesDAO favoritesDAO = FavoritesDAO.getInstance();

	public int join(HttpServletRequest request, HttpServletResponse response) {
		String id =request.getParameter("id");
		String pw = request.getParameter("pw");
		String userAddress = request.getParameter("userAddress");
		String contact = request.getParameter("contact");
		String email = request.getParameter("email");

		//아이디 or email 중복 검사 -> 가입 
		int result = userDAO.idCheck(id, email);
		System.out.println(result);
		if(result>=1) {//중복
			return 1; //중복 의미 반환

		}else {
			//중복x ->가입
			UserVO vo = new UserVO(id,pw,userAddress,contact,email);
			userDAO.join(vo);
		}
		return 0;
	}

	@Override
	public UserVO login(HttpServletRequest request, HttpServletResponse response) {

		String id =request.getParameter("id");
		String pw = request.getParameter("pw");

		UserVO vo = userDAO.login(id, pw);


		return vo;
	}

	@Override
	public UserVO getInfoUser(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();//자바에서 현재 세션 얻는 방법

		String id = (String)session.getAttribute("user_id");


		UserVO vo = userDAO.getInfo(id);



		return vo;
	}

	@Override
	public int updateUser(HttpServletRequest request, HttpServletResponse response) {

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");

		UserDAO dao = UserDAO.getInstance();
		int result = dao.update(id, pw, name, gender);

		

		return result;
	}

	@Override
	public int deleteUser(HttpServletRequest request, HttpServletResponse response) {
		//id가 필요
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("user_id");
		String pw = request.getParameter("pw");


		int result = 0;
		UserVO vo = userDAO.login(id,pw);
		if(vo != null) {
			result = userDAO.delete(id);

		}
		if(result==1) {//삭제성공
			session.invalidate();
		}
		return result;
	}

	@Override
	public int insertFavor(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("user_id");
		String storeNum = request.getParameter("storeNum");
		int result = favoritesDAO.storeCheck(storeNum, id);
		if(result>=1) {//중복
			return 1; //중복 의미 반환

		}else {
			favoritesDAO.insertFavorMain(storeNum,id);
		}
		return 0;
		
		
	}

	@Override
	public ArrayList<FavoritesVO> getFavorites(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		String id = (String)session.getAttribute("user_id");
		
		ArrayList<FavoritesVO> list = favoritesDAO.getFavorites(id);
		
		return list;
	}

	@Override
	public int deleteFavor(HttpServletRequest request, HttpServletResponse response) {
		
		String storeNum = request.getParameter("storeNum");
		int result = favoritesDAO.deleteFavor(storeNum);
		
		
		return result;
	}
	
	
	
	
	


}