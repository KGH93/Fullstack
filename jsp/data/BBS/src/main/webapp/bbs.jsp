<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bbs.Bbs"%>
<%@page import="bbs.BbsDAO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/custom.css">
<title>Insert title here</title>
</head>
<body>
	<%
		//메인페이지로 이동했을때 세션값이 담겨있는지 체크
		String userID = null;
		if(session.getAttribute("userID")!=null){
			userID = (String)session.getAttribute("userID");
		}
		int pageNumber = 1; // 현재 페이지 번호//초기값
		if(request.getParameter("pageNumber") != null) {
            pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
        }
	%>


<nav class="navbar navbar-default"> <!-- 네비게이션 -->
		<div class="navbar-header"> 	<!-- 네비게이션 상단 부분 -->
			<!-- 네비게이션 상단 박스 영역 -->
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<!-- 이 삼줄 버튼은 화면이 좁아지면 우측에 나타난다 -->
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<!-- 상단 바에 제목이 나타나고 클릭하면 main 페이지로 이동한다 -->
			<a class="navbar-brand" href="main.jsp">JSP 게시판 웹 사이트</a>
		</div>
		<!-- 게시판 제목 이름 옆에 나타나는 메뉴 영역 -->
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="main.jsp">메인</a></li>
				<li class="active"><a href="bbs.jsp">게시판</a></li>
			</ul>
			<%
				//로그인 안되있을때
				if(userID==null){
			%>
			<!-- 헤더 우측에 나타나는 드랍다운 영역 -->
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
					<a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">접속하기<span class="caret"></span></a>
					<!-- 드랍다운 아이템 영역 -->	
					<ul class="dropdown-menu">
						<li><a href="login.jsp">로그인</a></li>
						<li><a href="join.jsp">회원가입</a></li>
					</ul>
				</li>
			</ul>
			<%
				}else{
			%>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
					<a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">접속하기<span class="caret"></span></a>
					<!-- 드랍다운 아이템 영역 -->	
					<ul class="dropdown-menu">
						<li><a href="logoutAction.jsp">로그아웃</a></li>
						<li><a href="deleteAction.jsp" onclick="return confirm('정말로 탈퇴하시겠습니까?')">회원탈퇴</a></li>
					</ul>
				</li>
			</ul>
			<%
				}
			%>
		</div>
	</nav>

	<!-- 게시판 메인 페이지 영역 시작 -->
	<div class="container">
		<div class="row">
			<table class="table table-scriped" style="text-align:center;border:1px solid #ddd;">
				<thead>
					<tr>
						<th style="background:#eee;text-align:center;">번호</th>
						<th style="background:#eee;text-align:center;">제목</th>
						<th style="background:#eee;text-align:center;">작성자</th>
						<th style="background:#eee;text-align:center;">작성일</th>
					</tr>
				</thead>
				<tbody>
				    <%
				    BbsDAO bbsDAO = new BbsDAO(); //인스턴스 생성
				    ArrayList<Bbs> list = bbsDAO.getList(pageNumber); //게시판 리스트를 가져온다
				    for(int i=0; i<list.size(); i++){
				    %>
				    
				    
					<tr>
						<td><%= list.get(i).getBbsID() %></td>
						<td><a href="view.jsp?bbsID=<%= list.get(i).getBbsID() %>">
						<%= list.get(i).getBbsTitle() %></a>
						</td>
						<td><%= list.get(i).getUserID() %></td>
						<td><%= list.get(i).getBbsDate().substring(0,11) +  //날짜, substring(0,11)로 잘라서 년-월-일 형태로 출력
								list.get(i).getBbsDate().substring(11,13) + "시" +
								list.get(i).getBbsDate().substring(14,16) + "분" %></td>
					</tr>
					<%
				    }
					%>
				</tbody>
			</table>
			<!-- 페이징 처리 영역 -->
			<%
				if(pageNumber != 1){
			%>
			<a href="bbs.jsp?pageNumber=<%= pageNumber-1 %>" 
			class="btn btn-success">이전</a>
			<%
			}
				if(bbsDAO.nextPage(pageNumber+1)){
			%>
			<a href="bbs.jsp?pageNumber=<%= pageNumber+1 %>" 
			class="btn btn-success">다음</a>
			<%
			}
			%>
			
			<!-- 글쓰기 버튼 생성 -->
			<a href="write.jsp" class="btn btn-primary pull-right">글쓰기</a>
		</div>
	</div>
	
	
	
	
	
<!-- 부트스트랩 참조 영역 -->	
<script src="http://code.jquery.com/jquery-3.1.1.js"></script>
<script src="js/bootstrap.js"></script>
</body>
</html>