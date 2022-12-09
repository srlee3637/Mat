package com.mat.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("*.user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);


	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);


	}

	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//한글 처리
		request.setCharacterEncoding("utf-8");

		//요청분기
		String uri = request.getRequestURI();
		String path = request.getContextPath();

		String command = uri.substring(path.length());

		System.out.println("요청경로:" + command);

		HttpSession session = request.getSession();//자바에서 현재 세션 얻는 방법

		if(command.equals("/user/user_join.user")) {//회원 가입 페이지
			request.getRequestDispatcher("user_join.jsp").forward(request, response);//파일의 경로 
		}else if(command.equals("/user/joinForm.user")) {//회원 가입 기능

		}else if(command.equals("/user/user_login.user")) {//로그인 페이지
			request.getRequestDispatcher("user_login.jsp").forward(request, response);//파일의 경로 
		}else if(command.equals("/user/loginForm.user")) {//로그인 요청
			request.getRequestDispatcher("user_mypage.jsp").forward(request, response);//파일의 경로 
		}else if(command.equals("/user/user_search.user")) {//검색 페이지
			request.getRequestDispatcher("user_search.jsp").forward(request, response);//파일의 경로 
		}else if(command.equals("/user/user_mypage.user")) {//마이 페이지

		}else if(command.equals("/board/user_favorite.user")) {//즐겨찾기

		}else if(command.equals("/user/user_modify.user")) {//즐겨찾기

		}else if(command.equals("/user/deleteForm.user")) {//회원 탈퇴 기능

		}else if(command.equals("/user/user_delete.user")) {//회원 탈퇴 페이지 

		}

	}

}
