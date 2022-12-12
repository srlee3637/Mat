<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ include file="../include/header.jsp" %>
	<section class="banner-area text-center">        
	<div class="container">
		<h3><span>가게 정보</span></h3>
		
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
					<td><a href="store_detail.store?storeNum=${vo.storeNum }"><span>${vo.storeName }</span></a></td>
					<td>${vo.repMenu }</td>
					<td>${vo.price }</td>
					<td>${vo.category }</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		
	</div>
	</section>
		
<%@ include file="../include/footer.jsp" %>
