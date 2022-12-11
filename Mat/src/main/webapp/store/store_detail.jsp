<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="../include/header.jsp" %>
	
	<div class="container">
		
		<form action="${pageContext.request.contextPath}/order/order_complete.order" class="form-inline" >
		
		<h3>가게 상세 정보</h3>
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

		<br>
		<h3>가게 메뉴</h3>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th align="center">메뉴</th>
					<th align="center">가격</th>
					<th align="center">수량</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="vo" items="${menuList }" varStatus="s">
				<tr>
					<td align="center">${vo.menuName }</td>
					<td align="center">${vo.price }</td>
					<td align="center"><input type="text" name="cnt${s.count }" placeholder="수량 입력" class="form-control"></td>
				</tr>
				</c:forEach>
			</tbody>
			<tbody>
				<tr>
					<td colspan="3" align="center">
						  <div class="form-group">
						  	<input type="submit" value="주문하기" class="btn btn-default">
						  	<input type="hidden" name="storeNum" value="${storeVO.storeNum }">
						  </div>
					</td>
				</tr>
			</tbody>		
		</table>
		</form>
	</div>
		
		
		
<%@ include file="../include/footer.jsp" %>
