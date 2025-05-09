<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
function checkForm(){
	var form = document.loginForm;
	if(form.id.value == ""){
		alert("아이디를 입력해 주세요.");
		form.id.focus();
		return false;
	}else if(form.passwd.value == ""){
		alert("비밀번호를 입력해주세요");
		form.passwd.focus();
		return false;
	}
	form.submit();   //validation02_process.jsp로 이동
}
</script>
</head>
<body>
	<form action ="validation02_process.jsp" method="post" name="loginForm">
		<p>아 이 디 : <input type="text" name="id">
		<p>비밀번호 : <input type="text" name="passwd">
		<p><input type="submit" value="전송" onclick="checkLogin()"/>
	</form>
</body>
</html>