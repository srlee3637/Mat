<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<section>
	<div align="center">
		<form action="loginForm.user" method="post">
			<span style="color: red;">${msg }</span>
			<h3>로그인</h3>

			<table border="1" >
				<tr>
					<td>아이디</td>
					<td><input type="text" name="id">
					<td>
				</tr>

				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="pw"></td>
				</tr>
			</table>

			<input type="submit" value="로그인" class="btn btn-default"> 
			<input type="button" value="회원가입" class="btn btn-default" onclick="location.href='user_join.user'">

		</form>
	</div>

</section>


<script>
	var msg = '${msg}';
	if(msg!=''){
		alert(msg);
	}
</script>



<%@include file="../include/footer.jsp"%>
