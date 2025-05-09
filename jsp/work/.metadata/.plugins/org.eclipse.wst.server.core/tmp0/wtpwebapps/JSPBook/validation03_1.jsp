<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
function checkLogin(){
	var form = document.loginForm;
	if(form.id.value.length < 4 || form.id.value.length > 12){
		alert("아이디는 4~12자 이내로 입력 가능합니다!");
		form.id.select();
		return false;  //폼제출 중단
	}else if(form.passwd.value.length < 4){
		alert("비밀번호는 4자 이상으로 입력해야 합니다!");
		form.passwd.focus();
		return false;  //폼제출 중단
	}
	return true; //유효성 검사 통과 -> 폼제출 진행
}
</script>
</head>
<body>
	<form action ="validation03_process.jsp" method="post" name="loginForm" onsubmit="return checkLogin()">
		<p>아 이 디 : <input type="text" name="id">
		<p>비밀번호 : <input type="text" name="passwd">
		<p><input type="submit" value="전송"/>
		<!-- return checkLogin() -> checkLogin 함수 결과에 따라 결정 -->
	</form>
</body>
</html>