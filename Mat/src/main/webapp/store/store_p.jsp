<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
	String priceRangeType = request.getParameter("priceRangeType");
%>

<%@ include file="../include/header.jsp" %>
<section class="banner-area text-center">	
	<div class="container">
		
		<h3>음식 카테고리</h3>		
		<table class="table table-bordered">
				<tr>
					<td colspan=6 align="center">음식 카테고리</td>
				</tr>

				<tr>
				<c:forEach var="vo" items="${categoryList }" varStatus="s">
					<td><a href="store_cp.store?priceRangeType=<%=priceRangeType %>&categoryType=${vo.categoryType }">${vo.categoryType }</a></td>
				</c:forEach>
				</tr>
		</table>

		<br>
		<h3>가게 정보</h3>
		
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
					<td><a href="store_detail.store?storeNum=${vo.storeNum }">${vo.storeName }</a></td>
					<td>${vo.repMenu }</td>
					<td>${vo.price }</td>
					<td>${vo.category }</td>
				</tr>
				</c:forEach>
			</tbody>
			<tbody>
				<tr>
					<td colspan="4" align="center">
						<form action="../store/store_search.store" class="form-inline" >
						  <div class="form-group">
						    <input type="text" name="word" placeholder="가게 이름" class="form-control" >
						  	<input type="submit" value="검색" class="btn btn-default">
						  </div>
						</form> 
					</td>
				</tr>
			</tbody>			
		</table>
		
	</div>
</section>		
<%@ include file="../include/footer.jsp" %>
