<%@page import="java.io.PrintWriter"%>
<%@page import="user.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="user" class="user.User" scope="page" />
<jsp:setProperty name="user" property="userID" />    
<jsp:setProperty name="user" property="userPassword" />    
       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%	//현재 세션 상태를 체크한다.
		String userID = null;
		if(session.getAttribute("userID") != null){
			userID = (String)session.getAttribute("userID");
		}
		//이미 로그인했으면 다시 로그인 할 수 없게 한다.
		if(userID !=null){
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('이미 로그인 상태입니다.')");
			script.println("location.href = 'main.jsp'");
			script.println("</script>");
		}
		UserDAO userDAO = new UserDAO();
		int result = userDAO.login(user.getUserID(), user.getUserPassword());
		if(result == 1){
			session.setAttribute("userID", user.getUserID());
			//로그인이 성공 했을때 입력한 아이디를 세션 id에 넣는다. (세션을 부여) 
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('로그인성공')");
			script.println("location.href = 'main.jsp'");
			script.println("</script>");
		}else if(result == 0){
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('비밀번호가 틀립니다.')");
			script.println("history.back()"); //자바스크립트 뒤로가기
			script.println("</script>");
		}else if(result == -1){
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('존재하지않는 아이디입니다.')");
			script.println("history.back()"); //자바스크립트 뒤로가기
			script.println("</script>");
		}else if(result == -2){
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('데이터베이스오류입니다.')");
			script.println("history.back()"); //자바스크립트 뒤로가기
			script.println("</script>");
		}
		
	%>
</body>
</html>










