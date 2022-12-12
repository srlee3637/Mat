<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp" %>
<section class="banner-area text-center">
	<div align="center">
			<h3>지역 선택 </h3>

			<input type="button" value="중구" class="btn btn-default" onclick="location.href='../store/store_main.store'">
			
			<br>
			<table>
				<tbody>
				<tr>
					<td align="center">
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
<%@include file="../include/footer.jsp" %>