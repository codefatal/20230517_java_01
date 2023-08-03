<%@page import="kh.lclass.test.model.trade.model.dto.TradeDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>코인 거래 내역</title>
</head>
<body>
	<%
		List<TradeDTO> tdto = (List<TradeDTO>)request.getAttribute("tradeList");
	%>
	<table>
		<tr>
			<!-- 보류 -->
		</tr>
	</table>
</body>
</html>