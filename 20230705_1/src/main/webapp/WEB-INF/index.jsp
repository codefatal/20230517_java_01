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
	<!-- <a href="/join"><p>회원가입 - 절대위치 - context path 누락됨. 사용불가</p></a>
	<a href="./join"><p>회원가입 - 상대위치 - 고민..불편함.</p></a> -->
	<a href="<%=request.getContextPath()  %>/join"><p>회원가입 - 권장방법</p></a>
	<h1><%=request.getContextPath() %></h1>
</body>
</html>