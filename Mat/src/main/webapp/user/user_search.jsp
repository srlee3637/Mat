<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp" %>
<section class="banner-area text-center">
	<div align="center">
			<h3>지역 선택 </h3>

			<input type="button" value="도봉구" class="btn btn-default" onclick="location.href='../store/store_main.store'">
			<input type="button" value="노원구" class="btn btn-default" onclick="location.href='../store/store_main.store'">
			<input type="button" value="강북구" class="btn btn-default" onclick="location.href='../store/store_main.store'">
			<input type="button" value="성북구" class="btn btn-default" onclick="location.href='../store/store_main.store'">
			<input type="button" value="중랑구" class="btn btn-default" onclick="location.href='../store/store_main.store'">
			<br>
			<input type="button" value="은평구" class="btn btn-default" onclick="location.href='../store/store_main.store'">
			<input type="button" value="종로구" class="btn btn-default" onclick="location.href='../store/store_main.store'">
			<input type="button" value="동대문구" class="btn btn-default" onclick="location.href='../store/store_main.store'">
			<input type="button" value="성동구" class="btn btn-default" onclick="location.href='../store/store_main.store'">
			<input type="button" value="광진구" class="btn btn-default" onclick="location.href='../store/store_main.store'">
			<br>
			<input type="button" value="용산구" class="btn btn-default" onclick="location.href='../store/store_main.store'">
			<input type="button" value="송파구" class="btn btn-default" onclick="location.href='../store/store_main.store'">
			<input type="button" value="중구" class="btn btn-default" onclick="location.href='../store/store_main.store'">
			<input type="button" value="서대문구" class="btn btn-default" onclick="location.href='../store/store_main.store'">
			<input type="button" value="마포구" class="btn btn-default" onclick="location.href='../store/store_main.store'">
			<br>
			<input type="button" value="강서구" class="btn btn-default" onclick="location.href='../store/store_main.store'">
			<input type="button" value="양천구" class="btn btn-default" onclick="location.href='../store/store_main.store'">
			<input type="button" value="송파구" class="btn btn-default" onclick="location.href='../store/store_main.store'">
			<input type="button" value="영등포구" class="btn btn-default" onclick="location.href='../store/store_main.store'">
			<input type="button" value="구로구" class="btn btn-default" onclick="location.href='../store/store_main.store'">
			<br>
			<input type="button" value="금천구" class="btn btn-default" onclick="location.href='../store/store_main.store'">
			<input type="button" value="동작구" class="btn btn-default" onclick="location.href='../store/store_main.store'">
			<input type="button" value="강남구" class="btn btn-default" onclick="location.href='../store/store_main.store'">
			<input type="button" value="서초구" class="btn btn-default" onclick="location.href='../store/store_main.store'">
			<input type="button" value="관악구" class="btn btn-default" onclick="location.href='../store/store_main.store'">
			<br>
			
			<br><br>
			
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