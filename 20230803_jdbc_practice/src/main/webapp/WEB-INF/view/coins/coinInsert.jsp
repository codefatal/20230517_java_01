<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>코인 추가</title>
</head>
<body>
	<form action="<%=request.getContextPath() %>/coins/insert" method="post">
		<p><label>코인코드</label>
		<input type="text" name="coincode"></p>
		<p><label>코인이름</label>
		<input type="text" name="coinname"></p>
		<button type="submit">등록</button>
	</form>
	
</body>
</html>