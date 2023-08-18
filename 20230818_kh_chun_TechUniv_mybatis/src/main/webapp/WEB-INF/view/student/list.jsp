<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 정보</title>
<style>
	.wrap-flex {
		display: flex;
	}
	
	.wrap-grid {
		display: grid;
		grid-template-columns: auto auto auto;
	}
	
	div div > div {
		border: 1px solid #000;
		padding: 5px;
	}
	button {
		margin: 5px;
	}
	button a {
		color: #000;
		text-decoration: none;
	}
</style>
</head>
<body>
	<h2>학생 정보</h2>
	<button><a href="<%=request.getContextPath() %>/student/insert">학생 등록</a></button>
	<div>
		<div class="wrap-grid">
			<div>학생번호</div>
			<div>학생이름</div>
			<div>학생주소</div>
			<c:if test="${not empty StudentList }">
				<c:forEach items="${StudentList }" var="item">
					<div><a href="${pageCotext.request.contextPath }/student/get?studentNo=${item.studentNo}">${item.studentNo }</a></div>
					<div>${item.studentName }</div>
					<div>${item.studentAddress }</div>
				</c:forEach>
			</c:if>
		</div>
	</div>
</body>
</html>