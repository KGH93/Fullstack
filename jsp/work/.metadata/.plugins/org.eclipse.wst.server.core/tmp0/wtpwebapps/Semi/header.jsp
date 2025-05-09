<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <header>
        <div class="container">
            <div class="header-content">
                <div class="logo">K-<span>FOOD</span> GUIDE</div>
                <nav>
                    <ul>
                        <li><a href="#">홈</a></li>
                        <li><a href="#">한식(K-FOOD)</a></li>
                        <li><a href="#">뷰티(K-BEAUTY)</a></li>
                        <li><a href="#">관광지(TOURIST ATTRACTION)</a></li>
                        <% if (session.getAttribute("user") != null) { %>
                            <li><a href="logout.jsp">로그아웃</a></li>
                            <li><a href="mypage.jsp">마이페이지</a></li>
                        <% } else { %>
                            <li><a href="login.jsp">로그인</a></li>
                            <li><a href="signin.jsp">회원가입</a></li>
                        <% } %>
                    </ul>
                </nav>
            </div>
        </div>
    </header>
