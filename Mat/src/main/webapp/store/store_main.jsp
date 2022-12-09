<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ include file="../include/header.jsp" %>
	

	<div class="container">
		<h3>음식 카테고리 / 가격대</h3>
		
		<table class="table table-bordered">
		<tr>
			<c:forEach var="list" items="${list }" varStatus="s">
				<td><a href="order_category.order?bno=${list.storeName }">${list.storeName }</a></td>
			</c:forEach>
		</tr>
		</table>
		
		<table class="table table-bordered">
				<tr>
					<th>음식 카테고리</th>
				</tr>

				<tr>
				<c:forEach var="list" items="${list }" varStatus="s">
					<td><a href="order_category.order?bno=${list.storeName }">${list.storeName }</a></td>
				</c:forEach>
				</tr>
			
			
				<tr>
					<th>가격대</th>
				</tr>
			
				<tr>
				<c:forEach var="list" items="${list }" varStatus="s">
					<td><a href="order_category.order?bno=${list.storeName }">${list.storeName }</a></td>
				</c:forEach>
				</tr>
		</table>
	</div>
			

<%@ include file="../include/footer.jsp" %>
