<%@page import="kh.chun.techuniv.mybatis.classes.model.dto.ClassesDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 상세정보</title>
</head>
<body>
	<%
		ClassesDTO dto = (ClassesDTO)request.getAttribute("classNo");
	%>
	<h2>과목번호 <%=dto.getClassNo() %> 상세 정보</h2>
	<table border=1>
		<tr>
			<td>과목이름</td>
			<td><%=dto.getClassName() %></td>
		</tr>
		<tr>
			<td>선수과목번호</td>
			<td><%=dto.getPreattendingClassNo() %></td>
		</tr>
		<tr>
			<td>과목구분</td>
			<td><%=dto.getClassType() %></td>
		</tr>
	</table>
</body>
</html>