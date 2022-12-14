<%@page import="com.mat.store.model.StoreVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="../include/header.jsp" %>
	<section class="banner-area text-center">        
	<div class="container">
		<h3>음식 카테고리 및 가격대</h3>
		
		<table class="table table-bordered">
				<tr>
					<th colspan=6 align="center"><h4>음식 카테고리</h4></th>
				</tr>

				<tr>
				<c:forEach var="vo" items="${categoryList }" varStatus="s">
					<td><h4><a href="store_c.store?categoryType=${vo.categoryType }">${vo.categoryType }</a></h4></td>
				</c:forEach>
				</tr>
		</table>
		
		<table class="table table-bordered">
				<tr>
					<td colspan=3 align="center">가격대</td>
				</tr>
			
				<tr>
				<c:forEach var="vo" items="${priceRangeList }" varStatus="s">
					<td><h4><a href="store_p.store?priceRangeType=${vo.priceRangeType }">${vo.priceRange }</a></h4></td>
				</c:forEach>
				</tr>
		</table>

		<br>
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
