<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script type="text/javascript"></script>
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<style>
	.hint {
		font-size: 8px;
		color: blue;
		visibility: hidden;
	}
</style>
<script>
	window.onload = loadedHandler;
	function loadedHandler() {
		$("[type=text]").click(inputClickHandler);
		$("[type=password]").click(inputClickHandler);
	}
	
	function inputClickHandler() {
		$(".hint").css("visibility", "hidden");
		
		var $hintElement = $(this).parent().next(".hint");
		
		$hintElement.css("visibility", "visible");
	}
</script>
</head>
<body>
	<h1>회원가입</h1>
	<div>
		<form action="<%=request.getContextPath() %>/join" method="post" id="frmJoin">
			<table>
				<tr>
					<th>아이디</th>
					<td><input type="text" name="mid" required></td>
					<td class="hint">아이디는 5-9자 영문자로 시작하고 영문자와 숫자만 입력 가능합니다.</td>
				</tr>
				<tr>
					<th>패스워드</th>
					<td><input type="password" name="mpwd" required></td>
					<td class="hint">패스워드를 5-9자 대문자, 소문자, 숫자, 특수문자(!_#)를 1개이상 입력해주세요.</td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text" name="mname" required></td>
					<td class="hint">이름은 2-10자 한글만 입력 가능합니다.</td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td><input type="text" name="mtel" required></td>
					<td class="hint">전화번호는 하이픈(-)을 포함하여 전화번호 양식에 맞게 작성해주세요.</td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="text" name="memail" required></td>
					<td class="hint">이메일을 @을 포함하여 이메일 양식에 맞게 작성해주세요.</td>
				</tr>
				<tr>
					<th>주민번호</th>
					<td><input type="text" name="msno" required></td>
					<td class="hint">주민번호를 하이픈(-)을 포함하여 주민번호 양식에 맞게 작성해주세요.</td>
				</tr>
				<tr>
					<td colspan="2"><input type="button" value="회원가입"></td>
				</tr>
			</table>
		</form>
	</div>
	<script>
		$("#frmJoin [type=button]").click(sumbitHandler);
		
		function sumbitHandler() {
			console.log("여기들어온?");
			// 유효성 검사
			var id = $("[name=mid]").val();
			var regEx_id = /^[a-zA-Z][0-9a-zA-Z]{4,8}$/;
			if(!regEx_id.test(id)) {
				alert("아이디는 5-9자 영문자로 시작하고 영문자와 숫자만 입력 가능합니다.");
				$("[name=mid]").focus();
				return;
			}
			var pwd = $("[name=mpwd]").val();
			var regEx_pwd = /^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!_#])[A-Za-z0-9!_#]{5,9}$/;
			if(!regEx_pwd.test(pwd)) {
				alert("패스워드를 5-9자 대문자, 소문자, 숫자, 특수문자(!_#)를 1개이상 입력해주세요.");
				$("[name=mpwd]").focus();
				return;
			}

			var name = $("[name=mname]").val();
			var regEx_name = /^[가-힣]{2,10}$/;
			if(!regEx_name.test(name)) {
				alert("이름은 2-10자 한글만 입력 가능합니다.");
				$("[name=mname]").focus();
				return;
			}
			var tel = $("[name=mtel]").val();
			var regEx_tel = /^01[0126789][-][0-9]{3,4}[-][0-9]{4}$/;
			if(!regEx_tel.test(tel)) {
				alert("전화번호는 하이픈(-)을 포함하여 전화번호 양식에 맞게 작성해주세요.");
				$("[name=mtel]").focus();
				return;
			}
			var email = $("[name=memail]").val();
			var regEx_email = /^[A-Za-z0-9]{5,20}[@][A-Za-z0-9]{2,20}[.][A-Za-z0-9.]{2,20}$/;
			if(!regEx_email.test(email)) {
				alert("이메일을 @을 포함하여 이메일 양식에 맞게 작성해주세요.");
				$("[name=memail]").focus();
				return;
			}
			var sno = $("[name=msno]").val();
			var regEx_sno = /^[0-9]{6}[-][1234][0-9]{6}$/;
			if(!regEx_sno.test(sno)) {
				alert("주민번호를 하이픈(-)을 포함하여 주민번호 양식에 맞게 작성해주세요.");
				$("[name=msno]").focus();
				return;
			}
			
			$("#frmJoin").submit();
		}
		
	</script>
</body>
</html>