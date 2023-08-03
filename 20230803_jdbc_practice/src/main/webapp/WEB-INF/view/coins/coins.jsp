<%@page import="java.util.ArrayList"%>
<%@page import="kh.lclass.test.model.coins.model.dto.CoinsDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>코인 리스트</title>
</head>
<body>
	<button><a href="<%=request.getContextPath() %>/coins/insert">코인 추가</a></button>
	<button><a href="<%=request.getContextPath() %>/coins/delete">코인 삭제</a></button>
	<%
		List<CoinsDTO> cdto = (List<CoinsDTO>)request.getAttribute("coinsList");
	%>
	<table border=1>
		<tr>
			<td>코인코드</td>
			<td>코인이름</td>			
		</tr>
		
	<%
		for(int i=0; i<cdto.size(); i++) {
			CoinsDTO dto = cdto.get(i);
	%>
		<tr>
			<td><%=dto.getCoincode() %></td>
			<td><%=dto.getCoinname() %></td>
		</tr>		
	<%
		}
	%>	
	</table>
</body>
</html>