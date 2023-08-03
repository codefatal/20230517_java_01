<%@page import="java.text.*" %>
<%@page import="java.util.List"%>
<%@page import="kh.lclass.test.model.prices.model.dto.PricesDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1분간 코인 변동 수치</title>
</head>
<body>
	<%
		List<PricesDTO> pdto = (List<PricesDTO>)request.getAttribute("pricesList");
	%>
	<table border=1>
		<tr>
			<td>코인코드</td>
			<td>가격</td>
			<td>거래량</td>
			<td>시간</td>
		</tr>
	<%
		DecimalFormat df = new DecimalFormat("###,###.#");
		DecimalFormat dd = new DecimalFormat("###,###.#####");
		for(int i=0; i<pdto.size(); i++) {
			PricesDTO dto = pdto.get(i);
			String dfPrice = df.format(dto.getPrice());
			String ddVolume = dd.format(dto.getVolumes());
	%>
		<tr>
			<td><%=dto.getCoincode() %></td>
			<td><%=dfPrice %></td>
			<td><%=ddVolume %></td>
			<td><%=dto.getDates() %></td>
		</tr>
	<%
		}
	%>
	</table>
</body>
</html>