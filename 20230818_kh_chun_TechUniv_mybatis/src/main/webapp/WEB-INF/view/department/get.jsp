<%@page import="kh.chun.techuniv.mybatis.department.model.dto.DepartmentDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학과 상세 정보</title>
</head>
<body>
	<%
		DepartmentDTO dto = (DepartmentDTO)request.getAttribute("departmentNo");
	%>
	<h2>학과번호 <%=dto.getDepartmentNo() %>의 상세정보</h2>
	<table border=1>
		<tr>
			<td>학과이름</td>
			<td><%=dto.getDepartmentName() %></td>
		</tr>
		<tr>
			<td>계열</td>
			<td><%=dto.getCategory() %></td>
		</tr>
		<tr>
			<td>개설 여부</td>
			<td><%=dto.getOpenYn() %></td>
		</tr>
		<tr>
			<td>정원</td>
			<td><%=dto.getCapacity() %></td>
		</tr>
	</table>
</body>
</html>