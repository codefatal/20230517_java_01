<%@page import="kh.test.mybatis.student.model.vo.StudentVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>myBatis 메인페이지</title>
</head>
<body>
	<h2>myBatis 메인페이지</h2>
	<c:choose>
	<c:when test="${empty studentList }">
		<h2>결과 없습니다.</h2>
	</c:when>
	<c:otherwise>
		<table border=1>
			<tr>
				<td>학생번호</td>
				<td>학생이름</td>
				<td>학생주소</td>
			</tr>
		<c:forEach items="${studentList }" var="item">
			<tr>
				<td><a href="<%=request.getContextPath() %>/student?studentNo=${item.studentNo } %>">${item.studentNo }</a></td>
				<td>${item.studentName }</td>
				<td>${item.studentAddress }</td>
			</tr>	
		</c:forEach>
		</table>
	</c:otherwise>
	</c:choose>
	
</body>
</html>