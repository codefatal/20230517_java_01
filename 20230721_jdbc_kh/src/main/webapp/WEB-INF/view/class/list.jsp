<%@page import="kh.test.jdbckh.lclass.model.vo.ClassVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>과목 리스트</title>
</head>
<body>
	<h2>과목 리스트</h2>
	<%
	// JSP Tag - java문법
	List<ClassVo> volist = (List<ClassVo>)request.getAttribute("classList");
	%>
	<%-- <%= a %> --%>
	<%-- <%= b %> --%>
	<%-- <%= c %> --%>
	<%-- <%= volist %> --%>
	<table border="1">
		<tr>
			<td>과목 번호</td>
			<td>과목 이름</td>
			<td>과목 구분</td>
		</tr>
		<%
		for(int i=0; i<volist.size(); i++){
			ClassVo vo = volist.get(i);
		%>
		
		<tr>
			<td><a href="<%=request.getContextPath()%>/class/get?cno=<%=vo.getClassNo() %>"><%=vo.getClassNo() %></a></td>
			<td><%=vo.getClassName() %></td>
			<td><%=vo.getClassType() %></td>
		</tr>

		<%
		}
		%>
	</table>
</body>
</html>