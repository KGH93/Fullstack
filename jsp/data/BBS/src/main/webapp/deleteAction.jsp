<%@page import="java.io.PrintWriter"%>
<%@page import="user.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="user" class="user.User" scope="page" />
<jsp:setProperty name="user" property="userID" />    
     
       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%	
		//현재 세션 상태를 체크한다.
		String userID = null;
		if(session.getAttribute("userID") != null){
			userID = (String)session.getAttribute("userID");
		}
		//로그인을 안했으면 탈퇴안됨
		if(userID ==null){
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('로그인후 이용해주세요.')");
			script.println("location.href = 'login.jsp'");
			script.println("</script>");
		}else{
	
		UserDAO userDAO = new UserDAO();
		int result = userDAO.deleteUser(userID);
		if(result == 1){ //탈퇴 성공
			session.invalidate(); //세션 종료
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('회원탈퇴가 완료되었습니다.')");
			script.println("location.href='main.jsp'");
			script.println("</script>");
		}else {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('회원탈퇴에 실패했습니다.')");
			script.println("history.back()");
			script.println("</script>");
		}
		}
	%>
</body>
</html>










