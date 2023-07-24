<%@page import="kh.test.jdbckh.lclass.model.vo.ClassVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>과목 상세 정보</title>
</head>
<body>
	<h1>과목 상세 정보</h1>
	<%-- <%= request.getAttribute("cvo") %> --%>
	<%
	ClassVo vo = null;
	if(request.getAttribute("cvo") instanceof ClassVo){
		vo = (ClassVo)request.getAttribute("cvo");
	}
	%>
	<table border="1">
		<tr>
			<td>과목 번호</td>
			<td><%=vo.getClassNo() %></td>
		</tr>
		<tr>
			<td>학과 번호</td>
			<td><%=vo.getDepartmentNo() %></td>
		</tr>
 		<tr>
			<td>선수 과목 번호</td>
			<td><%=vo.getPreattendingClassNo() %></td>
		</tr>
		<tr>
			<td>과목 이름</td>
			<td><%=vo.getClassName() %></td>
		</tr>
		<tr>
			<td>과목 구분</td>
			<td><%=vo.getClassType() %></td>
		</tr>
	</table>
	
</body>
</html>