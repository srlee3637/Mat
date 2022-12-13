<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ include file="../include/header.jsp" %>
	
<section class="banner-area text-center">
	<div class="container">
		<h3>즐겨찾기 목록 </h3>

		<table class="table table-bordered">
			<thead>
				<tr>
					<th align="center">연번</th>
					<th align="center">가게 이름</th>
					<th align="center">대표 메뉴</th>
					<th align="center">가격</th>
					<th align="center">카테고리</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach var="vo" items="${list }" varStatus="s">
					<input type="hidden" name="favoritesNum" value="${vo.favoritesNum }">
				<tr>
					<td>${s.count }</td>
					<td><a href="../store/store_detail.store?storeNum=${vo.storeNum }">${vo.storeName }</a></td>
					<td>${vo.repMenu }</td>
					<td>${vo.price }</td>
					<td>${vo.category }</td>
				</tr>
				</c:forEach>
			</tbody>
			
			
		
		</table>
	</div>
	</section>



<%@include file="../include/footer.jsp" %>