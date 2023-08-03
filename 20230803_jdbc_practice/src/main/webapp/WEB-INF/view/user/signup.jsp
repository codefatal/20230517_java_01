<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<div class=container>
		<form action="<%=request.getContextPath() %>/user/signup" method="post">
			<p><label>아이디</label>
			<input type="text" name="userid"></p>
			<p><label>패스워드</label>
			<input type="password" name="password1"></p>
			<p><label>패스워드확인</label>
			<input type="password" name="password2"></p>
			<p><label>이메일</label>
			<input type="email" name="email"></p>
			<button type="submit">회원가입</button>
		</form>
	</div>
</body>
</html>