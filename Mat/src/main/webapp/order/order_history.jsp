<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="../include/header.jsp" %>
	<section class="banner-area text-center">
	<div class="container">
		
		<h3>주문 내역</h3>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th align="center">연번</th>
					<th align="center">가게 이름</th>
					<th align="center">주문 메뉴</th>
					<th align="center">주문 날짜</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="vo" items="${orderList }" varStatus="s">
				<tr>
					<td align="center">${s.count }</td>
					<td align="center"><a href="../store/store_detail.store?storeNum=${vo.storeNum }">${vo.storeName }</a></td>
					<td align="center"><a href="order_detail.order?orderNum=${vo.orderNum }&storeNum=${vo.storeNum }">${vo.menuName } 외 ${vo.menuCnt }개</a></td>
					<td>${vo.orderDate }</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
		</section>
<%@ include file="../include/footer.jsp" %>
