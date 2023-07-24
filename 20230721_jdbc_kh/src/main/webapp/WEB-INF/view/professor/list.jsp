<%@page import="kh.test.jdbckh.professor.model.vo.ProfessorVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>교수 리스트</title>
</head>
<body>
	<h2>교수 리스트</h2>
	<%
	// JSP Tag - java문법
	List<ProfessorVo> volist = (List<ProfessorVo>)request.getAttribute("professorList");
	%>
	<%-- <%= a %> --%>
	<%-- <%= b %> --%>
	<%-- <%= c %> --%>
	<%-- <%= volist %> --%>
	<table border="1">
		<tr>
			<td>교수 번호</td>
			<td>교수 이름</td>
			<td>학과 번호</td>
		</tr>
		<%
		for(int i=0; i<volist.size(); i++){
			ProfessorVo vo = volist.get(i);
		%>
		
		<tr>
			<td><a href="<%=request.getContextPath()%>/professor/get?pno=<%=vo.getProfessorNo() %>"><%=vo.getProfessorNo() %></a></td>
			<td><%=vo.getProfessorName() %></td>
			<td><%=vo.getDepartmentNo() %></td>
		</tr>

		<%
		}
		%>
	</table>
</body>
</html>