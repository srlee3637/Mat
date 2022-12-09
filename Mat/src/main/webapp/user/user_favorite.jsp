<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ include file="../include/header.jsp" %>
	

	<div class="container">
		

		<table class="table table-bordered">
			
			<tbody>
				<c:forEach var="vo" items="${list }" varStatus="s">
				<tr>
					<td>${s.count }</td>
					<td>${vo.favoritesNum }</td>
					<td>${vo.storeName }</td>
					<!-- a태그를 통하여 하이퍼링크를 생성하고 다음 페이지에서 필요한 값도 실어보낸다. -->
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