<%@page import="kh.test.jdbckh.professor.model.vo.ProfessorVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>교수 상세 정보</title>
</head>
<body>
	<h1>교수 상세 정보</h1>
	<%
	ProfessorVo vo = null;
	if(request.getAttribute("pvo") instanceof ProfessorVo){
		vo = (ProfessorVo)request.getAttribute("pvo");
	}
	%>
	<table border="1">
		<tr>
			<td>교수 번호</td>
			<td><%=vo.getProfessorNo() %></td>
		</tr>
		<tr>
			<td>교수 이름</td>
			<td><%=vo.getProfessorName() %></td>
		</tr>
<%-- 		<tr>
			<td>교수 주민번호</td>
			<td><%=vo.getProfessorSsn() %></td>
		</tr> --%>
		<tr>
			<td>교수 주소</td>
			<td><%=vo.getProfessorAddress() %></td>
		</tr>
		<tr>
			<td>학과 번호</td>
			<td><%=vo.getDepartmentNo() %></td>
		</tr>
	</table>
	
</body>
</html>