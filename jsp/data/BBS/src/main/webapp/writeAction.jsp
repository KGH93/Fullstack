<%@page import="java.io.PrintWriter"%>
<%@page import="bbs.BbsDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="bbs" class="bbs.Bbs" scope="page" />
<jsp:setProperty name="bbs" property="bbsTitle" />    
 <jsp:setProperty name="bbs" property="bbsContent" />   
         
       
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
         //이미 로그인했으면 다시 로그인 할 수 없게 한다.
         if(userID ==null){
            PrintWriter script = response.getWriter();
            script.println("<script>");
            script.println("alert('로그인하세요')");
            script.println("location.href = 'login.jsp'");
            script.println("</script>");
         }else{
            //입력이 안 된 부분이 있는지 체크한다.
            if(bbs.getBbsTitle() == null || bbs.getBbsContent()==null){
               PrintWriter script = response.getWriter();
               script.println("<script>");
               script.println("alert('입력이 안된사항이 있습니다.')");
               script.println("history.back()");
               script.println("</script>");
            }else{
               //정상적으로 입력이 되었다면 로직을 수행한다.
               BbsDAO bbsDAO = new BbsDAO();
               int result = bbsDAO.write(bbs.getBbsTitle(),userID,bbs.getBbsContent());
               //데이터베이스오류
               if(result == -1){
                  PrintWriter script = response.getWriter();
                  script.println("<script>");
                  script.println("alert('글쓰기 실패했습니다.')");
                  script.println("history.back()");
                  script.println("</script>");
               }else{//글쓰기가 정상 실행되면 성공알림창 후 게시판 메인으로 이동
                  PrintWriter script = response.getWriter();
                  script.println("<script>");
                  script.println("alert('글쓰기 성공')");
                  script.println("location.href='bbs.jsp'");
                  script.println("</script>");
               }
               
            }
            
         }
   
      
      
   %>
</body>
</html>










