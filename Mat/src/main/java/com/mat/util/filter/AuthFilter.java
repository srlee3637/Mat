package com.mat.util.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter({"/user/user_mypage.user",
	"/user/user_favorite.user",
	"/order/order_complete.order",
	"/order/order_detail.order",
	"/order/order_history.order"})
public class AuthFilter extends HttpFilter implements Filter {
       
    public AuthFilter() {
        super();
    }

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		request.setCharacterEncoding("UTF-8");
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse	res = (HttpServletResponse)response;

		HttpSession session = req.getSession();
		String user_id = (String)session.getAttribute("user_id");

		if(session.getAttribute("user_id") == null) {
			
			String path = req.getContextPath();
			
			res.setContentType("text/html; charset=utf-8");
			PrintWriter out = res.getWriter();
			out.println("<script>");
			out.println("alert('권한이 필요한 기능입니다.');");
			out.println("location.href='" + path + "/user/user_login.user" + "';");
			out.println("</script>");
			
			return;
		}
		
		chain.doFilter(request, response);
	}

}
