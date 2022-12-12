<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<%@taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c"%>   

<section class="banner-area text-center">
<div align="center">
	<form action="updateForm.user" method="post">
		<span style="color: red;">${msg }</span>
		<table border="1">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id" placeholder="4~8글자 영문자 숫자" size="20"
					pattern="\w{4,8}" required="required" value="${requestScope.vo.id}" readonly></td>
			</tr>

			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pw" pattern="\w{4,8}" size="20"
					required="required" value="${requestScope.vo.pw}"></td>
			</tr>

			<tr>
				<td>주소</td>
				<td><input type="text" name="userAddress" placeholder="주소" size="20" value="${requestScope.vo.userAddress}">
				</td>
			</tr>

			<tr>
				<td>연락처</td>
				
				<td><input type="text" name="contact" size="20" value="${requestScope.vo.contact}" readonly></td>
			</tr>
			
			<tr>
				<td>이메일</td>
				
				<td><input type="email" name="email" size="20" value="${requestScope.vo.email}" readonly></td>
			</tr>

			

		</table>
		<input type="submit" value="정보수정"> 
		<input type="button" value="마이페이지" onclick="location.href='user_mypage.user'">

	</form>
</div>
</section>


<%@include file="../include/footer.jsp"%>
