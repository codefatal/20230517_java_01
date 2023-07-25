<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 등록</title>
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<style>
	.select {
		width: 100%;
	}
	
	.hint {
		color: blue;
		font-size: 10px;
   }
</style>
</head>
<body>
	<h1>학생 등록</h1>
	<div class="container">
		<form action="<%=request.getContextPath() %>/student/insert" method="post" id="stuform">
			<table>			
				<tr>
					<th>학생 번호</th>
					<td><input type="text" name="studentNo" required></td>					
					<td class="hint"><label>'00(년도)+5자리숫자 형식으로 입력해주세요. (00년 부터는 A0으로 시작)</label></td>
				</tr>
				<tr>
					<th>학과 번호</th>
					<td>
						<select name="departmentNo" class="select">
							<option>001</option>
							<option>002</option>
							<option>003</option>
							<option>004</option>
							<option>005</option>
							<option>006</option>
							<option>007</option>
							<option>008</option>
							<option>009</option>
							<option>010</option>
							<option>011</option>
							<option>012</option>
							<option>013</option>
							<option>014</option>
							<option>015</option>
							<option>016</option>
							<option>017</option>
							<option>018</option>
							<option>019</option>
							<option>020</option>
							<option>021</option>
							<option>022</option>
							<option>023</option>
							<option>024</option>
							<option>025</option>
							<option>026</option>
							<option>027</option>
							<option>028</option>
							<option>029</option>
							<option>030</option>
							<option>031</option>
							<option>032</option>
							<option>033</option>
							<option>034</option>
							<option>035</option>
							<option>036</option>
							<option>037</option>
							<option>038</option>
							<option>039</option>
							<option>040</option>
							<option>041</option>
							<option>042</option>
							<option>043</option>
							<option>044</option>
							<option>045</option>
							<option>046</option>
							<option>047</option>
							<option>048</option>
							<option>049</option>
							<option>050</option>
							<option>051</option>
							<option>052</option>
							<option>053</option>
							<option>054</option>
							<option>055</option>
							<option>056</option>
							<option>057</option>
							<option>058</option>
							<option>059</option>
							<option>060</option>
							<option>061</option>
							<option>062</option>
							<option>063</option>
						</select>
						
					</td>
					<td class="hint"></td>
				</tr>
				<tr>
					<th>학생 이름</th>
					<td><input type="text" name="studentName" required></td>
					<td class="hint"></td>
				</tr>
				<tr>
					<th>학생 주민번호</th>
					<td><input type="text" name="studentSsn" required></td>
					<td class="hint"><label>'-'을 포함해서 '900619-1234567' 형식으로 입력해주세요.</label></td>
				</tr>
				<tr>
					<th>학생 주소</th>
					<td><input type="text" name="studentAddress" required></td>
					<td class="hint"></td>
				</tr>
				<tr>
					<th>입학 일자</th>
					<td><input type="text" name="entranceDate" required></td>
					<td class="hint"><label>'DD-MM-YYYY' 형식으로 입력해주세요.</label></td>
				</tr>
				<tr>
					<th>휴학 여부</th>
					<td>
						<select name="absenceYn" class="select">
							<option>Y</option>
							<option>N</option>
						</select>
					</td>
					<td class="hint"></td>
				</tr>
				<tr>
					<th>지도 교수 번호</th>
					<td>
						<select name="coachProfessorNo" class="select">
							<option>P001</option>
							<option>P002</option>
							<option>P003</option>
							<option>P004</option>
							<option>P005</option>
							<option>P006</option>
							<option>P007</option>
							<option>P008</option>
							<option>P009</option>
							<option>P010</option>
							<option>P011</option>
							<option>P012</option>
							<option>P013</option>
							<option>P014</option>
							<option>P015</option>
							<option>P016</option>
							<option>P017</option>
							<option>P018</option>
							<option>P019</option>
							<option>P020</option>
							<option>P021</option>
							<option>P022</option>
							<option>P023</option>
							<option>P024</option>
							<option>P025</option>
							<option>P026</option>
							<option>P027</option>
							<option>P028</option>
							<option>P029</option>
							<option>P030</option>
							<option>P031</option>
							<option>P032</option>
							<option>P033</option>
							<option>P034</option>
							<option>P035</option>
							<option>P036</option>
							<option>P037</option>
							<option>P038</option>
							<option>P039</option>
							<option>P040</option>
							<option>P041</option>
							<option>P042</option>
							<option>P043</option>
							<option>P044</option>
							<option>P045</option>
							<option>P046</option>
							<option>P047</option>
							<option>P048</option>
							<option>P049</option>
							<option>P050</option>
							<option>P051</option>
							<option>P052</option>
							<option>P053</option>
							<option>P054</option>
							<option>P055</option>
							<option>P056</option>
							<option>P057</option>
							<option>P058</option>
							<option>P059</option>
							<option>P060</option>
							<option>P061</option>
							<option>P062</option>
							<option>P063</option>
							<option>P064</option>
							<option>P065</option>
							<option>P066</option>
							<option>P067</option>
							<option>P068</option>
							<option>P069</option>
							<option>P070</option>
							<option>P071</option>
							<option>P072</option>
							<option>P073</option>
							<option>P074</option>
							<option>P075</option>
							<option>P076</option>
							<option>P077</option>
							<option>P078</option>
							<option>P079</option>
							<option>P080</option>
							<option>P081</option>
							<option>P082</option>
							<option>P083</option>
							<option>P084</option>
							<option>P085</option>
							<option>P086</option>
							<option>P087</option>
							<option>P088</option>
							<option>P089</option>
							<option>P090</option>
							<option>P091</option>
							<option>P092</option>
							<option>P093</option>
							<option>P094</option>
							<option>P095</option>
							<option>P096</option>
							<option>P097</option>
							<option>P098</option>
							<option>P099</option>
							<option>P100</option>
							<option>P101</option>
							<option>P102</option>
							<option>P103</option>
							<option>P104</option>
							<option>P105</option>
							<option>P106</option>
							<option>P107</option>
							<option>P108</option>
							<option>P109</option>
							<option>P110</option>
							<option>P111</option>
							<option>P112</option>
							<option>P113</option>
							<option>P114</option>
						</select>
					</td>
					<td class="hint"></td>
				</tr>
				<tr>
					<td colspan="3"><input type="submit" value="등록"></td>
				</tr>
			</table>
		</form>
	</div>
	<script>
		$("#stuform [type=button]").click(submitHeadler);
		
		function submitHeadler() {
			console.log("check");
			var studentNo = $("[name=studentNo]").val();
			var regEx_studentNo = /^[A0-9][0-9]{6}$/;
			
			if(!regEx_studentNo.test(studentNo)) {
				alert("학생번호는 '00(년도)+5자리숫자 형식으로 입력해주세요. (00년 부터는 A0으로 시작)");
				$("[name=studentNo]").focus();
				return;
			}
			
			var studentSsn = $("[name=studentSsn]").val();
			var regEx_studentSsn = /^[0-9]{6}[-][1-4][0-9]{6}$/;
			
			if(!regEx_studentSsn.test(studentSsn)) {
				alert("학생 주민번호는 '-'을 포함해서 '900619-1234567' 형식으로 입력해주세요.");
				$("[name=studentSsn]").focus();
				return;
			}
			
			var entranceDate = $("[name=entranceDate]").val();
			var regEx_entranceDate = /^[0-9]{1,2}[-][0-9]{1,2}[-][0-9]{4}$/;
			
			if(!regEx_entranceDate.test(entranceDate)) {
				alert("입학일자는 '-'을 포함해서 'DD-MM-YYYY' 형식으로 입력해주세요.");
				$("[name=entranceDate]").focus();
				return;
			}
		}
	</script>
</body>
</html>