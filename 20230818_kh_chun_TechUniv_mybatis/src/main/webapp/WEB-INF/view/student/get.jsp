<%@page import="kh.chun.techuniv.mybatis.student.model.dto.StudentDTO"%>
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
		StudentDTO dto = (StudentDTO)request.getAttribute("studentNo");
	%>
	<h2><%=dto.getStudentName() %>님의 상세 정보</h2>
	<table border=1>
		<tr>
			<td>학생번호</td>
			<td><%=dto.getStudentNo() %></td>
		</tr>
		<tr>
			<td>학생주소</td>
			<td><%=dto.getStudentAddress() %></td>
		</tr>
		<tr>
			<td>입학일자</td>
			<td><%=dto.getEntranceDate() %></td>
		</tr>
		<tr>
			<td>휴학유무</td>
			<td><%=dto.getAbsenceYn() %></td>
		</tr>
		<tr>
			<td>지도교수번호</td>
			<td><%=dto.getCoachProfessorNo() %></td>
		</tr>
	</table>
</body>
</html>