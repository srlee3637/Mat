package com.mat.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("*.main")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request,response);
	}
	
	//get , post 하나로 묶음
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//한글 처리
		request.setCharacterEncoding("utf-8");
		
		//요청분기
		String uri = request.getRequestURI();
		String path = request.getContextPath();
		
		String command = uri.substring(path.length());
		
		System.out.println("요청경로:" + command);
		
		switch(command) {
		
			case "/MainPage.main":
				
				request.getRequestDispatcher("MainPage.jsp").forward(request, response);//파일의 경로 
				
				break;
				
			default:
				break;
		}
	}
	

}
