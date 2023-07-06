<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello</title>
</head>
<body>
	<h1>메인페이지!</h1>
	<a href="<%=request.getContextPath()  %>/join"><p>회원가입</p></a>
	<a href="<%=request.getContextPath()  %>/login"><p>로그인</p></a>
	<h1><%=request.getContextPath() %></h1>
</body>
</html>