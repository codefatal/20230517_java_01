<%@page import="kh.lclass.test.model.mypage.model.dto.MypageDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
</head>
<body>
	<%
		MypageDTO mdto = (MypageDTO)request.getAttribute("mypage");
	%>
	<table border=1>
		<tr>
			<td>아이디</td>
			<td>소지금액</td>
			<td>보유BTC</td>
			<td>보유ETH</td>
		</tr>
		<tr>
			<td><%=mdto.getUsername() %></td>
			<td><%=mdto.getMoney() %></td>
			<td><%=mdto.getUserBtc() %></td>
			<td><%=mdto.getUserEth() %></td>
		</tr>
	</table>
</body>
</html>