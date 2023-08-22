<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학과 정보</title>
<style>
	.wrap-flex {
		display: flex;
	}
	
	.wrap-grid {
		display: grid;
		grid-template-columns: auto auto auto auto auto;
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
	<h2>학과 정보</h2>
	<%-- <button><a href="<%=request.getContextPath() %>/department/insert">학과 등록</a></button> --%>
	<div>
		<div class="wrap-grid">
			<div>학과 번호</div>
			<div>학과 이름</div>
			<div>계열</div>
			<div>개설여부</div>
			<div>정원</div>
			<c:if test="${not empty departmentList }">
				<c:forEach items="${departmentList }" var="item">
					<div><a href="${pageCotext.request.ContextPath }/department/get?departmentNo=${item.departmentNo }">${item.departmentNo }</a> </div>
					<div>${item.departmentName }</div>
					<div>${item.category }</div>
					<div>${item.openYn }</div>
					<div>${item.capacity }</div>
				</c:forEach>
			</c:if>
		</div>
	</div>
</body>
</html>