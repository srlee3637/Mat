<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ include file="../include/header.jsp" %>
	

	<div class="container">
		<h3>음식 카테고리 / 가격대</h3>

		<table class="table table-bordered">
			<thead>
				<tr>
					<th>음식 카테고리</th>
				</tr>
			</thead>

			<tbody>
				<tr>
				<c:forEach var="vo" items="${list }" varStatus="s">
					<td><a href="order_category.order?bno=${vo.categoryType }">${vo.categoryType }</a></td>
				</c:forEach>
				</tr>
			</tbody>
			
			
			<thead>
				<tr>
					<th>가격대</th>
				</tr>
			</thead>			
			
			<tbody>
				<tr>
				<c:forEach var="vo2" items="${list2 }" varStatus="s2">
					<td><a href="order_price.order?bno=${vo.priceRange }">${vo.priceRange }</a></td>
				</c:forEach>
				</tr>
			</tbody>
			

<%@ include file="../include/footer.jsp" %>
