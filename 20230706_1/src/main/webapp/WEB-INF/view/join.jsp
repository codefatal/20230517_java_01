<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
</head>
<body>
	<h1>회원가입</h1>
	<div>
		<form action="<%=request.getContextPath() %>/join" method="post" id="frmJoin">
			<table>
				<tr>
					<th>아이디</th>
					<td><input type="text" name="mid" required></td>
				</tr>
				<tr>
					<th>패스워드</th>
					<td><input type="password" name="mpwd" required></td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text" name="mname" required></td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td><input type="text" name="mtel" required></td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="text" name="memail" required></td>
				</tr>
				<tr>
					<th>주민번호</th>
					<td><input type="text" name="msno" required></td>
				</tr>
				<tr>
					<td colspan="2"><input type="button" value="회원가입"></td>
				</tr>
			</table>
		</form>
	</div>
	<script>
		$("#frmJoin [type=button]").click(submitHeadler);
		
		function submitHeadler() {
			console.log("check");
			var id = $("[name=mid]").val();
			var regEx_id = /^[a-zA-Z][a-zA-Z0-9!_#]{4,8}$/;
			
			if(!regEx_id.test(id)) {
				alert("아이디는 5-9자 이내로 첫글자는 영문자만 입력 가능합니다.");
				$("[name=mid]").focus();
				return;
			}
			
			var pwd = $("[name=mpwd]").val();
			var regEx_pwd = /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!_#])[a-zA-Z0-9!_#]{5,9}$/;
			
			if(!regEx_pwd.test(pwd)) {
				alert("패스워드는 5-9자 이내로 대문자 소문자 숫자 특수문자(!_#)가 1개 이상 들어가야 합니다.");
				$("[name=mpwd]").focus();
				return;
			}
		}
		
	</script>
</body>
</html>