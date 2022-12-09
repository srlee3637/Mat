package com.mat.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mat.user.model.UserVO;
import com.mat.user.service.UserServiceImpl;




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
		UserServiceImpl service = new UserServiceImpl();
		HttpSession session = request.getSession();//자바에서 현재 세션 얻는 방법

		if(command.equals("/user/user_join.user")) {//회원 가입 페이지
			
			request.getRequestDispatcher("user_join.jsp").forward(request, response);//파일의 경로 
		
		}else if(command.equals("/user/joinForm.user")) {//회원 가입 기능
			
			int result = service.join(request, response);
			if(result>=1) {//아이디 중복
				//메시지
				request.setAttribute("msg", "중복된 아이디 or email입니다");
				request.getRequestDispatcher("user_join.jsp").forward(request, response);//파일의 경로 

			}else {//가입성공
				//request.getRequestDispatcher("user_login.jsp").forward(request, response);//파일의 경로 
				//MVC2에서 리다이렉트는 다시 컨트롤러를 태우는 요청 
				response.sendRedirect("user_login.user");
			}
			
		}else if(command.equals("/user/user_login.user")) {//로그인 페이지
			
			request.getRequestDispatcher("user_login.jsp").forward(request, response);//파일의 경로 
		
		}else if(command.equals("/user/loginForm.user")) {//로그인 요청
			
			UserVO vo =  service.login(request, response);
			System.out.println(vo);
			if(vo==null) {//로그인 실패
				request.setAttribute("msg", "아이디와 비밀번호를 확인하세요");
				request.getRequestDispatcher("user_login.jsp").forward(request, response);
				
			}else {//로그인 성공 
				//세션에 아이디, 이름 저장
				System.out.println("로그인 성공");
				session = request.getSession();
				session.setAttribute("user_id", vo.getId());
				
				//마이페이지
				response.sendRedirect("user_mypage.user");

			}		
		}else if(command.equals("/user/user_search.user")) {//검색 페이지
			
			request.getRequestDispatcher("user_search.jsp").forward(request, response);//파일의 경로 
		
		}else if(command.equals("/user/user_mypage.user")) {//마이 페이지
			
			request.getRequestDispatcher("user_mypage.jsp").forward(request, response);//파일의 경로 

		}else if(command.equals("/board/user_favorite.user")) {//즐겨찾기

			request.getRequestDispatcher("user_favorite.jsp").forward(request, response);//파일의 경로 

			
		}else if(command.equals("/user/updateForm.user")) {//즐겨찾기

			int result = service.update(request, response);
			if(result==1) {//업데이트 성공
				
				//response.sendRedirect("user_mypage.user");
				response.setContentType("text/html; charset=utf-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('정보가 수정되었습니다');");
				out.println("location.href='user_mypage.user';");
				out.println("</script>");
				
			}else {// 업데이트 실패
				request.setAttribute("msg", "양식에 맞춰 작성해주세요");
				response.sendRedirect("user_modify.user");
				
				//out객체를 이용해서 화면에 스크립트를 작성해서 보냄
				
			}
			
		}else if(command.equals("/user/user_modify.user")) {//즐겨찾기

			UserVO vo =  service.getInfo(request, response);
			request.setAttribute("vo", vo);
		
			request.getRequestDispatcher("user_modify.jsp").forward(request, response);
			
			
		}else if(command.equals("/user/deleteForm.user")) {//회원 탈퇴 기능

			int result = service.delete(request, response);
			if(result == 1) {
				response.sendRedirect(path + "/MainPage.main");
			}else {
				response.sendRedirect("user_delete.user");
			}
			
		}else if(command.equals("/user/user_delete.user")) {//회원 탈퇴 페이지 

			request.getRequestDispatcher("user_delete.jsp").forward(request, response);

			
		}

	}

}
