<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ include file="../include/header.jsp" %>
	

	<div class="container">
		

		<table class="table table-bordered">
			
			<tbody>
				<c:forEach var="vo" items="${list }" varStatus="s">
					<input type="hidden" name="favoritesNum" value="${vo.favoritesNum }">
				<tr>
					<td>${s.count }</td>
					<td><a href="../store/store_detail.store?storeNum=${vo.storeNum }">${vo.storeName }</a></td>
					<td>${vo.repMenu }</td>
					<td>${vo.price }</td>
					<td>${vo.category }</td>
					<td>${vo.id }</td>
				</tr>
				</c:forEach>
			</tbody>
			
			
		
		</table>
	</div>



<%@include file="../include/footer.jsp" %>