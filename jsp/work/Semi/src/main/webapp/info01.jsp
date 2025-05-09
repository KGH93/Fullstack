<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>K-Culture Info Site</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/infostyle.css">
</head>

<body>
  <!--  네비게이션 바 -->
  <nav class="navbar navbar-expand-lg" style="background-color: #005BAC;">
    <div class="container">
      <a class="navbar-brand text-white fw-bold" href="#">K-Culture INFO</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav ms-auto">
          <li class="nav-item dropdown me-4">
            <a class="nav-link dropdown-toggle text-white" href="#" role="button" data-bs-toggle="dropdown">K-FOOD</a>
            <ul class="dropdown-menu">
              <li><a class="dropdown-item" href="#">Traditional Food</a></li>
              <li><a class="dropdown-item" href="#">Street Food</a></li>
              <li><a class="dropdown-item" href="#">Experience Program</a></li>
            </ul>
          </li>
          <li class="nav-item dropdown me-4">
            <a class="nav-link dropdown-toggle text-white" href="#" role="button" data-bs-toggle="dropdown">K-BEAUTY</a>
            <ul class="dropdown-menu">
              <li><a class="dropdown-item" href="#">Skincare</a></li>
              <li><a class="dropdown-item" href="#">Makeup Trends</a></li>
              <li><a class="dropdown-item" href="#">Where to Buy</a></li>
            </ul>
          </li>
          <li class="nav-item dropdown me-4">
            <a class="nav-link dropdown-toggle text-white" href="#" role="button" data-bs-toggle="dropdown">LOCATION</a>
            <ul class="dropdown-menu">
              <li><a class="dropdown-item" href="#">Seoul</a></li>
              <li><a class="dropdown-item" href="#">Busan</a></li>
              <li><a class="dropdown-item" href="#">Jeju</a></li>
            </ul>
          </li>
        </ul>
      </div>
    </div>
  </nav>


  <!--  단일 배너 이미지 + 중앙 텍스트 -->
<div class="position-relative text-white" style="height: 400px; background: url('<%= request.getContextPath() %>/resources/img/slideimg02.jpg') center/cover no-repeat;">
  <div class="position-absolute top-50 start-50 translate-middle text-center">
    <h1 class="fw-bold">K-CULTURE 제품 소개</h1>
    <p class="fs-5">한국 문화를 담은 특별한 제품들을 만나보세요</p>
  </div>
</div>


  <!--  메인 콘텐츠: 왼쪽 이미지 + 오른쪽 설명 -->
  <div class="container mt-5 mb-5">
    <div class="row align-items-center">
      <div class="col-md-6 d-flex justify-content-center">
  			<img src="<%= request.getContextPath() %>/resources/img/ev02.jpg" class="img-fluid rounded shadow" style="width: 70%;" alt="Product Main">
	  </div>
      <div class="col-md-6">
        <h3>전통 한과 세트</h3>
        <p class="lead">정성껏 만든 한국의 전통 과자, 선물용으로도 좋고 가족과 나눠먹기에도 좋은 제품입니다.</p>
        <ul>
          <li>100% 국산 재료 사용</li>
          <li>전통 방식 수작업 제조</li>
          <li>선물용 포장 가능</li>
        </ul>
      </div>
    </div>
  </div>

  <!-- 관련 이미지 -->
<div class="container mb-5">
  <h4 class="mb-3"></h4>
  <div class="d-flex flex-wrap film-strip">
    <img src="<%= request.getContextPath() %>/resources/img/rg01.jpg" class="img-thumbnail hover-zoom" alt="related1">
    <img src="<%= request.getContextPath() %>/resources/img/rg02.jpg" class="img-thumbnail hover-zoom" alt="related2">
    <img src="<%= request.getContextPath() %>/resources/img/rg03.png" class="img-thumbnail hover-zoom" alt="related3">
    <img src="<%= request.getContextPath() %>/resources/img/rg04.jpg" class="img-thumbnail hover-zoom" alt="related4">
    <img src="<%= request.getContextPath() %>/resources/img/rg05.jpg" class="img-thumbnail hover-zoom" alt="related5">
    <img src="<%= request.getContextPath() %>/resources/img/rg06.jpg" class="img-thumbnail hover-zoom" alt="related6">
  </div>
</div>



  <!-- 하단 네비바 -->
<div class="w-100 border-top small-nav" style="height: 50px; background-color: #005BAC;">
    <div class="d-flex justify-content-center align-items-center h-100">
     <a class="mx-3 text-decoration-none fw-bold" style="color: #fff;">Posts</a>
     <a class="mx-3 text-decoration-none fw-bold" style="color: #fff;">View reserved </a>
     <a class="mx-3 text-decoration-none fw-bold" style="color: #fff;">View activity history</a>
     <a class="mx-3 text-decoration-none fw-bold" style="color: #fff;">Apply for experience</a>
     <a class="mx-3 text-decoration-none fw-bold" style="color: #fff;">View details</a>
    </div>
   </div>
   
   
   
  <!--  푸터 -->
  <footer class="text-center py-4 bg-light border-top">
    <p>&copy; 2025 K-Culture Info. All rights reserved.</p>
  </footer>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
