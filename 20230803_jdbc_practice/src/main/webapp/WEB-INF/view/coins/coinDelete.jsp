<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>코인 삭제</title>
</head>
<body>
	<form action="<%=request.getContextPath() %>/coins/delete" method="post">
		<p><label>코인코드</label>
		<input type="text" name="coincode"></p>
		<button type="submit">삭제</button>
	</form>
</body>
</html>