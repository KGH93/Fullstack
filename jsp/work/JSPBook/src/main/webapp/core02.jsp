<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
browser 변수 값 설정
   <form action="core02_process.jsp" method="post">
      <p>숫자: <input type="text" name="number">
      <p><input type="submit" value="전송">
   </form>
</body>
</html>