<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>

<section class="banner-area text-center">
	<div align="center">
			${sessionScope.user_id }	
			<a href="../order/order_history.order">[나의주문내역]</a>
			
			
			<div>
			
			<a href="user_logout.user">[로그아웃]</a>
			<a href="user_modify.user">[정보수정]</a>
			<a href="user_delete.user">[회원탈퇴]</a>
			
			</div>

	</div>
</section>

<%@include file="../include/footer.jsp"%>