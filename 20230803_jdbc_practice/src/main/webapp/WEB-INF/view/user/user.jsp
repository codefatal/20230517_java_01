<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="kh.lclass.test.user.model.dto.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>유저 리스트</title>
</head>
<body>
	<%
		List<UserDTO> udto = (List<UserDTO>)request.getAttribute("userList");
	%>
	<button><a href="<%=request.getContextPath() %>/user/signup">회원가입</a></button>
	<table border=1>
		<tr>
			<td>유저네임</td>
			<td>이메일</td>
		</tr>
	<%
		for(int i=0; i<udto.size(); i++) {
			UserDTO dto = udto.get(i);
	%>
		<tr>
			<td><a href="<%=request.getContextPath() %>/mypage?searchNum=<%=dto.getId() %>"><%=dto.getUsername() %></a></td>
			<td><%=dto.getEmail() %></td>
		</tr>	
	<%
		}
	%>
	
	</table>
</body>
</html>