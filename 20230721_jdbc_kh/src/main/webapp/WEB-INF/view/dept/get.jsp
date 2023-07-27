<%@page import="kh.test.jdbckh.department.model.dto.DepartmentDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학과 상세 정보</title>
</head>
<body>
	<h1>학과 상세 정보</h1>
	<%-- <%= request.getAttribute("dto") %> --%>
	<%
	DepartmentDto dto = null;
	if(request.getAttribute("dto") instanceof DepartmentDto){
		dto = (DepartmentDto)request.getAttribute("dto");
	}
	%>
	<table border="1">
		<tr>
			<td>학과 번호</td>
			<td><%=dto.getDepartmentNo() %></td>
		</tr>
		<tr>
			<td>학과 이름</td>
			<td><%=dto.getDepartmentName() %></td>
		</tr>
		<tr>
			<td>계열</td>
			<td><%=dto.getCategory() %></td>
		</tr>
		<tr>
			<td>개설여부</td>
			<td><%=dto.getOpenYn() %></td>
		</tr>
		<tr>
			<td>정원</td>
			<td><%=dto.getCapacity() %></td>
		</tr>
	</table>
	
</body>
</html>