<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>K-Culture Info Site</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/mainstyle.css">
</head>

<body>
	<nav class="navbar navbar-expand-lg" style="background-color: #005BAC;">
    <div class="container">
      <a class="navbar-brand text-white fw-bold" href="#">K-Culture INFO</a>

      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav ms-auto" style="margin-left: 100px;"> <li class="nav-item dropdown me-4">
            <a class="nav-link dropdown-toggle text-white" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
              K-FOOD
            </a>
            <ul class="dropdown-menu">
              <li><a class="dropdown-item" href="#">Traditional Food</a></li>
              <li><a class="dropdown-item" href="#">Street Food</a></li>
              <li><a class="dropdown-item" href="#">Experience Program</a></li>
            </ul>
          </li>

          <li class="nav-item dropdown me-4">
            <a class="nav-link dropdown-toggle text-white" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
              K-BEAUTY
            </a>
            <ul class="dropdown-menu">
              <li><a class="dropdown-item" href="#">Korean Skincare</a></li>
              <li><a class="dropdown-item" href="#">Makeup Trends</a></li>
              <li><a class="dropdown-item" href="#">Recommended Purchase Place</a></li>
            </ul>
          </li>

          <li class="nav-item dropdown me-4">
            <a class="nav-link dropdown-toggle text-white" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
              LOCATION
            </a>
            <ul class="dropdown-menu">
              <li><a class="dropdown-item" href="#">Seoul</a></li>
              <li><a class="dropdown-item" href="#">Busan</a></li>
              <li><a class="dropdown-item" href="#">Jeju</a></li>
            </ul>
          </li>

          <li class="nav-item dropdown me-4">
            <a class="nav-link dropdown-toggle text-white" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
              LOGIN
            </a>
            <ul class="dropdown-menu">
              <li><a class="dropdown-item" href="#">Login</a></li>
              <li><a class="dropdown-item" href="#">Sign Up</a></li>
              <li><a class="dropdown-item" href="#">Sign Out</a></li>
            </ul>
          </li>
        </ul>
      </div>
    </div>
  </nav>


  <div id="mainCarousel" class="carousel slide" data-bs-ride="carousel">
    <div class="carousel-inner">
      <div class="carousel-item active">
        <img src="<%= request.getContextPath() %>/resources/img/slideimg01.jpg" class="d-block w-100" alt="...">
        <div class="fixed-caption">
          <h3>Welcome to K-Culture</h3>
          <p>Explore the rich and vibrant world of Korean culture!</p>
        </div>
      </div>
      <div class="carousel-item">
        <img src="<%= request.getContextPath() %>/resources/img/slideimg02.jpg" class="d-block w-100" alt="...">
        <div class="fixed-caption">
          <h3>Experience Korea</h3>
          <p>From food to fashion, discover everything Korean!</p>
        </div>
      </div>
    </div>
    <button class="carousel-control-prev" type="button" data-bs-target="#mainCarousel" data-bs-slide="prev">
      <span class="carousel-control-prev-icon"></span>
    </button>
    <button class="carousel-control-next" type="button" data-bs-target="#mainCarousel" data-bs-slide="next">
      <span class="carousel-control-next-icon"></span>
    </button>
  </div>


  <div class="container mt-4 category-container">
    <h4>CATEGORY</h4>
    <div class="row">
      <div class="col-md-4 mb-4 category-item">
        <a href="https://www.example.com/kfood" target="_blank" class="category-link">
          <img src="<%= request.getContextPath() %>/resources/img/KFOOD.JPG" class="img-fluid rounded" alt="K-푸드">
          <div class="fw-bold">K-푸드</div>
        </a>
      </div>
      <div class="col-md-4 mb-4 category-item">
        <a href="https://www.example.com/kbeauty" target="_blank" class="category-link">
          <img src="<%= request.getContextPath() %>/resources/img/BEAUTY01.jpg" class="img-fluid rounded" alt="K-뷰티">
          <div class="fw-bold">K-뷰티</div>
        </a>
      </div>
      <div class="col-md-4 mb-4 category-item">
        <a href="https://www.example.com/location" target="_blank" class="category-link">
          <img src="<%= request.getContextPath() %>/resources/img/img (1).jpg" class="img-fluid rounded" alt="LOCATION">
          <div class="fw-bold">LOCATION</div>
        </a>
      </div>
    </div>
  </div>

  <div class="container mt-5">
    <div class="row">
      <div class="col-md-6">
        <h4>Notice Board</h4>
        <ul class="list-group">
          <li class="list-group-item">[공지] K-팝 체험 신청 시작!</li>
          <li class="list-group-item">[신청] k-푸드 체험 김장 프로그램 신청</li>
          <li class="list-group-item">[질문] 종로에서 음식점 추천 해주세요</li>
        </ul>
      </div>

      <div class="col-md-6 d-flex flex-column" style="height: 100%;">
        <h4>Attraction Experience Program</h4>
        <div id="adCarousel" class="carousel slide ad-slide" data-bs-ride="carousel" style="flex-grow: 1;">
          <div class="carousel-inner">
            <div class="carousel-item active">
              <img src="<%= request.getContextPath() %>/resources/img/체험0.jpg" class="d-block w-100" style="max-height: 150px; object-fit: cover;">
            </div>
            <div class="carousel-item">
              <img src="<%= request.getContextPath() %>/resources/img/체험1.png" class="d-block w-100" style="max-height: 150px; object-fit: cover;">
            </div>
            <div class="carousel-item">
              <img src="<%= request.getContextPath() %>/resources/img/체험2.jpg" class="d-block w-100" style="max-height: 150px; object-fit: cover;">
            </div>
            <div class="carousel-item">
              <img src="<%= request.getContextPath() %>/resources/img/체험3.jpg" class="d-block w-100" style="max-height: 150px; object-fit: cover;">
            </div>
          </div>
          <button class="carousel-control-prev" type="button" data-bs-target="#adCarousel" data-bs-slide="prev">
            <span class="carousel-control-prev-icon"></span>
          </button>
          <button class="carousel-control-next" type="button" data-bs-target="#adCarousel" data-bs-slide="next">
            <span class="carousel-control-next-icon"></span>
          </button>
        </div>
      </div>
    </div>
  </div>

  <div class="w-100 border-top small-nav" style="height: 50px; margin-top: 40px; background-color: #005BAC;">
    <div class="d-flex justify-content-center align-items-center h-100">
     <a class="mx-3 text-decoration-none fw-bold" style="color: #fff;">Posts</a>
     <a class="mx-3 text-decoration-none fw-bold" style="color: #fff;">View reserved </a>
     <a class="mx-3 text-decoration-none fw-bold" style="color: #fff;">View activity history</a>
     <a class="mx-3 text-decoration-none fw-bold" style="color: #fff;">Apply for experience</a>
     <a class="mx-3 text-decoration-none fw-bold" style="color: #fff;">View details</a>
    </div>
   </div>

  <footer>
    <p>&copy; 2025 K-Culture Info. All rights reserved.</p>
  </footer>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>