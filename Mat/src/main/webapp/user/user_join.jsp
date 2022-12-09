<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>



<section>
	<div align="center">
		<h3>회원가입</h3>

		<form action="joinForm.user" method="post">

			<span style="color: red">${msg }</span>

			<table border="1" >
				<tr>
					<td>아이디</td>
					<td><input type="text" name="id" placeholder="4~8글자 영문숫자" size="20"
						pattern="\w{4,8}" required="required"></td>
				</tr>


				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="pw" placeholder="4~8글자 영문숫자" size="20"
						pattern="\w{4,8}" required="required"></td>
				</tr>

				<tr>


					<td>주소</td>
					<td><input type="text" name="userAddress" placeholder="주소" size="20"> 
						
						

				</tr>

				<tr>
					<td>연락처</td>
					<td><input type="text" name="contact" size="20"></td>
				</tr>


				<tr>
					<td>이메일</td>
					<td><input type="email" name="email" required="required" size="20"></td>
				</tr>




			</table>

			<input type="submit" value="가입">
			<!-- js로 기능을 붙임 -->
			


		</form>
	</div>

</section>

<!-- 화면에서 사용할 js -->
<script>
   var msg ='${msg}';
   if(msg !=''){
      alert(msg);
   }

</script>

<%@include file="../include/footer.jsp"%>

