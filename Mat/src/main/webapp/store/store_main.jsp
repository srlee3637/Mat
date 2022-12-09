<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ include file="../include/header.jsp" %>
	

	<div class="container">
		<h3>중구 소재 가게</h3>
		
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>가게이름</th>
					<th>대표메뉴</th>
					<th>가격</th>
					<th>카테고리</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="vo" items="${storeList }" varStatus="s">
				<tr>
					<td><a href="store_detail.store?storeName=${vo.storeName }">${vo.storeName }</a></td>
					<td><a href="store_detail.store?repMenu=${vo.repMenu }">${vo.repMenu }</a></td>
					<td><a href="store_detail.store?price=${vo.price }">${vo.price }</a></td>
					<td><a href="store_detail.store?category=${vo.category }">${vo.category }</a></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<table class="table table-bordered">
				<tr>
					<th>음식 카테고리</th>
				</tr>

				<tr>
				<c:forEach var="vo1" items="${categoryList }" varStatus="s">
					<td><a href="store_c.store?storeName=${vo1.categoryType }">${vo1.categoryType }</a></td>
				</c:forEach>
				</tr>
		</table>
		
		<table class="table table-bordered">
				<tr>
					<th>가격대</th>
				</tr>
			
				<tr>
				<c:forEach var="vo2" items="${priceRangeList }" varStatus="s">
					<td><a href="store_p.store?storeName=${vo2.priceRange }">${vo2.priceRange }</a></td>
				</c:forEach>
				</tr>
		</table>
	</div>
			

<%@ include file="../include/footer.jsp" %>
