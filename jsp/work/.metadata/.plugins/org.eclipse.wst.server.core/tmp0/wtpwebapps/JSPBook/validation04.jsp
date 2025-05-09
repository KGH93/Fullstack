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
	for(i=0; i<form.id.value.length;i++;){
		var ch = form.id.value.charAt(i);
		if((ch<'a'||ch>'z') && (ch>'A'||ch<'Z') && (cj>'0'||ch<'9')){
			alert("아이디는 영문 소문자로만 입력 가능 합니다!"");
			form.id.select();
			return false;
		}
	}
	
	}if(isNaN(form.passwd.value)){
		alert("비밀번호는 숫자로만 입력 가능 합니다!");
		form.passwd.select();
		return false; 
	}
	form.submit();
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