<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="bbs.BbsDAO"%>
<%@page import="bbs.Bbs"%>
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
         }
         if(userID == null){
             PrintWriter script = response.getWriter();
             script.println("<script>");
             script.println("alert('로그인 후 글쓰기를 하세요.')");
             script.println("location.href='login.jsp'");
             script.println("</script>");
         }
         
         int bbsID = 0; // 현재 페이지 번호 초기값
         if(request.getParameter("bbsID") != null) {  //request.getParameter는 get방식으로 넘어온 데이터를 가져오는 메소드
            bbsID = Integer.parseInt(request.getParameter("bbsID"));  //getparameter로 넘어온 bbsID를 int형으로 변환
         }
         if(bbsID == 0){ // 만약 넘어온 데이터가 없다면
             PrintWriter script = response.getWriter();
             script.println("<script>");
             script.println("alert('유효하지 않은 글입니다.')");
             script.println("location.href='bbs.jsp'");
             script.println("</script>");
         }
        
         BbsDAO bbsDAOForUpdate = new BbsDAO(); // 업데이트를 위한 DAO 객체
         Bbs existingBbs = bbsDAOForUpdate.getBbs(bbsID); // 데이터베이스에서 게시글 정보 가져오기
         
         if(!userID.equals(existingBbs.getUserID())){
             PrintWriter script = response.getWriter();
             script.println("<script>");
             script.println("alert('권한이 없습니다.')");
             script.println("location.href='bbs.jsp'");
             script.println("</script>");
         }else{
	
	       	  //정상적으로 입력이 되었다면 글 삭제 로직 수행
	       	  BbsDAO bbsDAO = new BbsDAO();//DAO 객체 생성
	       	  int result = bbsDAO.delete(bbsID); //delete 메소드 호출
	       	  //데이터베이스 오류인 경우
	       	  if(result == -1){
	       		  PrintWriter script = response.getWriter();
	       		  script.println("<script>");
	       		  script.println("alert('글 삭제에 필패했습니다.')");
	       		  script.println("history.back()");
	       		  script.println("</script>");
	       	  }else{
	          		  PrintWriter script = response.getWriter();
	          		  script.println("<script>");
	          		  script.println("alert('글 삭제 성공했습니다.')");
	          		  script.println("location.href='bbs.jsp'");
	          		  script.println("</script>");
              }
          }
         
      
      
   %>
</body>
</html>










