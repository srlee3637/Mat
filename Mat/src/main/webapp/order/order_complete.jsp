<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="../include/header.jsp" %>
	
	<div class="container">
		<h3>주문 가게 정보</h3>
		
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>가게이름</th>
					<th>대표메뉴</th>
					<th>가격</th>
					<th>카테고리</th>
					<th>주소</th>
					<th>연락처</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${storeVO.storeName }</td>
					<td>${storeVO.repMenu }</td>
					<td>${storeVO.price }</td>
					<td>${storeVO.category }</td>
					<td>${storeVO.storeAddress }</td>
					<td>${storeVO.contact }</td>
				</tr>
			</tbody>
		</table>
		
		<input type="button" value="즐겨찾기 추가" class="btn btn-default" onclik="location.href='store_order.store'">
		<input type="hidden" name="storeNum" value="${storeVO.storeNum }">
		
		<br>
		<h3>주문 메뉴</h3>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th align="center">메뉴</th>
					<th align="center">가격</th>
					<th align="center">수량</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="vo" items="${list }" varStatus="s">
				<tr>
					<td align="center">${vo.menuName }</td>
					<td align="center">${vo.price }</td>
					<td align="center">${vo.menuQuantity }</td>
				</tr>
				<c:set var="sum" value="${sum + vo.price * vo.menuQuantity }"/>
				</c:forEach>
			</tbody>
			<tbody>
				<tr>
					<td align="center">총 주문 금액</td>
					<td align="center">${sum }</td>
					<td align="center">
						<form action="order_history.order" class="form-inline" >
						  <div class="form-group">
						  	<input type="submit" value="주문 내역" class="btn btn-default">
						  </div>
						</form> 
					</td>
				</tr>
			</tbody>		
		</table>
	</div>
		
		
		
<%@ include file="../include/footer.jsp" %>
