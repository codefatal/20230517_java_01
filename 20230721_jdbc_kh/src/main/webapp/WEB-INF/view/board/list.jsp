<%@page import="kh.test.jdbckh.board.model.dto.BoardDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록</title>
</head>
<body>
	<h2>게시글</h2>
	<%
	// JSP Tag - java문법
	List<BoardDto> dtoList = (List<BoardDto>)request.getAttribute("BoardList");
	
	%>
	<table border="1">
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>작성시간</td>
		</tr>
		<%
		for(int i=0; i<dtoList.size(); i++){
			BoardDto dto = dtoList.get(i);
		%>
		
		<tr>
			<td><a href="<%=request.getContextPath()%>/board/get?bno=<%=dto.getBno() %>"><%=dto.getBno() %></a></td>
			<td><%=dto.getBtitle() %></td>
			<td><%=dto.getBwriteDate() %></td>
		</tr>

		<%
		}
		%>
	</table>
	<div>
	<%
		for(int i=1; i<=10; i++) {
	%>
			<a href="<%=request.getContextPath() %>/student/list?pageNo=<%=i%>"><span><%=i%></span></a>
	<%
		}
	%>
	<div>
		<form action="<%=request.getContextPath() %>/board/list" method="post">
			<input type="submit" value="글쓰기">
		</form>
	</div>
	</div>
</body>
</html>