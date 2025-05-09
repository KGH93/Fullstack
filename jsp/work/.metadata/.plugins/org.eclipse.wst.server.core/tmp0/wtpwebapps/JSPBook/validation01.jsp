<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
function checkForm(){
	alert("아이디 : " + document.loginForm.id.value + "\n" + "비밀번호 : " + document.loginForm.passwd.value);
}
</script>
</head>
<body>
	<form action ="#" method="post" name="loginForm">
		<p>아 이 디 : <input type="text" name="id">
		<p>비밀번호 : <input type="text" name="passwd">
		<p><input type="submit" value="전송" onclick="checkForm()"/>
	</form>
</body>
</html>