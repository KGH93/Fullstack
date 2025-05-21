<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="dto.Cosmetics" %>
<%@ page import="dao.CosmeticsRepository" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/beautyCategorystyle.css">
<script src="<%= request.getContextPath() %>/resources/js/dday.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">
<title>BeautyCategory</title>
</head>
<body>

<%@ include file="header.jsp" %>


<!-- 메인 이미지 -->
<div class="container-fluid p-0 text-center" style="margin-top: 80px; position: relative;">
  <img src="./resources/img/BEAUTY09.jpg" class="img-fluid mx-auto" alt="Your Image Description" style="width: 1400px; height: 600px;">
  
  <!-- 텍스트 오버레이 -->
  <div class="text-overlay" style="position: absolute; top: 50%; left: 50%; transform: translate(-50%, -50%); color: white; font-size: 40px; font-weight: bold; text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.5);">
    K - BEAUTY <br>
    Experience the Secrets of Korean Skincare
  </div>
</div>

<!-- 배경 이미지 섹션 -->
<section class="bg-image">	
<div class="overlay">
<!-- 상품 카테고리1 섹션 -->
<div class="container pt-5 pb-3" style="margin-bottom: 30px;">
   <div class="d-flex justify-content-between align-items-center mb-4">
    <h3 class="text-start mb-0">Category1</h3>
    <a href="https://example.com" class="btn btn-sm btn-outline-secondary">
      더보기(More)
    </a>
  </div>
  <div class="row row-cols-1 row-cols-md-4 gy-3 gx-3">
  <!-- 카드1 -->
    <div class="col">
      <div class="card h-100 shadow-sm border-0" style="height: 280px;"> <!-- style 위치 수정 -->
        <img src="./resources/img/makeup01.jpg" class="card-img-top" alt="..." style="height: 200px; object-fit: cover;">
        <div class="card-body p-2 text-center" style="height: 80px; overflow: hidden;"> <!-- 가운데 정렬 -->
          <h5 class="card-title mb-2">Landscape & Cityscape</h5>
          <div class="d-flex justify-content-end gap-3 small text-muted mb-2"> <!-- 가운데 정렬 -->
            <a href="#" class="btn btn-sm btn-outline-primary">상세보기</a>
          </div>
        </div>
        <div class="card-footer bg-white border-0 text-end"></div>
      </div>
    </div>
     <!-- 카드2 -->
    <div class="col">
      <div class="card h-100 shadow-sm border-0" style="height: 280px;"> <!-- style 위치 수정 -->
        <img src="./resources/img/makeup02.jpg" class="card-img-top" alt="..." style="height: 200px; object-fit: cover;">
        <div class="card-body p-2 text-center" style="height: 80px; overflow: hidden;"> <!-- 가운데 정렬 -->
          <h5 class="card-title mb-2">Landscape & Cityscape</h5>
          <div class="d-flex justify-content-end gap-3 small text-muted mb-2"> <!-- 가운데 정렬 -->
            <a href="#" class="btn btn-sm btn-outline-primary">상세보기</a>
          </div>
        </div>
        <div class="card-footer bg-white border-0 text-end"></div>
      </div>
    </div>
     <!-- 카드3 -->
    <div class="col">
      <div class="card h-100 shadow-sm border-0" style="height: 280px;"> <!-- style 위치 수정 -->
        <img src="./resources/img/makeup03.jpg" class="card-img-top" alt="..." style="height: 200px; object-fit: cover;">
        <div class="card-body p-2 text-center" style="height: 80px; overflow: hidden;"> <!-- 가운데 정렬 -->
          <h5 class="card-title mb-2">Landscape & Cityscape</h5>
          <div class="d-flex justify-content-end gap-3 small text-muted mb-2"> <!-- 가운데 정렬 -->
            <a href="#" class="btn btn-sm btn-outline-primary">상세보기</a>
          </div>
        </div>
        <div class="card-footer bg-white border-0 text-end"></div>
      </div>
    </div>
     <!-- 카드4 -->
    <div class="col">
      <div class="card h-100 shadow-sm border-0" style="height: 280px;"> <!-- style 위치 수정 -->
        <img src="./resources/img/makeup04.jpg" class="card-img-top" alt="..." style="height: 200px; object-fit: cover;">
        <div class="card-body p-2 text-center" style="height: 80px; overflow: hidden;"> <!-- 가운데 정렬 -->
          <h5 class="card-title mb-2">Landscape & Cityscape</h5>
          <div class="d-flex justify-content-end gap-3 small text-muted mb-2"> <!-- 가운데 정렬 -->
            <a href="#" class="btn btn-sm btn-outline-primary">상세보기</a>
          </div>
        </div>
        <div class="card-footer bg-white border-0 text-end"></div>
      </div>
    </div>
</div>
</div>

<!-- 상품 카테고리2 섹션 -->
<div class="container p-2" style="margin-bottom: 30px;">
  <div class="d-flex justify-content-between align-items-center mb-4">
    <h3 class="text-start mb-0">Category2</h3>
    <a href="https://example.com" class="btn btn-sm btn-outline-secondary">
      더보기(More)
    </a>
  </div>
  <div class="row row-cols-1 row-cols-md-4 gy-3 gx-3">
  <!-- 카드1 -->
    <div class="col">
      <div class="card h-100 shadow-sm border-0" style="height: 280px;"> <!-- style 위치 수정 -->
        <img src="./resources/img/makeup01.jpg" class="card-img-top" alt="..." style="height: 200px; object-fit: cover;">
        <div class="card-body p-2 text-center" style="height: 80px; overflow: hidden;"> <!-- 가운데 정렬 -->
          <h5 class="card-title mb-2">Landscape & Cityscape</h5>
          <div class="d-flex justify-content-end gap-3 small text-muted mb-2"> <!-- 가운데 정렬 -->
            <a href="#" class="btn btn-sm btn-outline-primary">상세보기</a>
          </div>
        </div>
        <div class="card-footer bg-white border-0 text-end"></div>
      </div>
    </div>
     <!-- 카드2 -->
    <div class="col">
      <div class="card h-100 shadow-sm border-0" style="height: 280px;"> <!-- style 위치 수정 -->
        <img src="./resources/img/makeup02.jpg" class="card-img-top" alt="..." style="height: 200px; object-fit: cover;">
        <div class="card-body p-2 text-center" style="height: 80px; overflow: hidden;"> <!-- 가운데 정렬 -->
          <h5 class="card-title mb-2">Landscape & Cityscape</h5>
          <div class="d-flex justify-content-end gap-3 small text-muted mb-2"> <!-- 가운데 정렬 -->
            <a href="#" class="btn btn-sm btn-outline-primary">상세보기</a>
          </div>
        </div>
        <div class="card-footer bg-white border-0 text-end"></div>
      </div>
    </div>
     <!-- 카드3 -->
    <div class="col">
      <div class="card h-100 shadow-sm border-0" style="height: 280px;"> <!-- style 위치 수정 -->
        <img src="./resources/img/makeup03.jpg" class="card-img-top" alt="..." style="height: 200px; object-fit: cover;">
        <div class="card-body p-2 text-center" style="height: 80px; overflow: hidden;"> <!-- 가운데 정렬 -->
          <h5 class="card-title mb-2">Landscape & Cityscape</h5>
          <div class="d-flex justify-content-end gap-3 small text-muted mb-2"> <!-- 가운데 정렬 -->
            <a href="#" class="btn btn-sm btn-outline-primary">상세보기</a>
          </div>
        </div>
        <div class="card-footer bg-white border-0 text-end"></div>
      </div>
    </div>
     <!-- 카드4 -->
    <div class="col">
      <div class="card h-100 shadow-sm border-0" style="height: 280px;"> <!-- style 위치 수정 -->
        <img src="./resources/img/makeup04.jpg" class="card-img-top" alt="..." style="height: 200px; object-fit: cover;">
        <div class="card-body p-2 text-center" style="height: 80px; overflow: hidden;"> <!-- 가운데 정렬 -->
          <h5 class="card-title mb-2">Landscape & Cityscape</h5>
          <div class="d-flex justify-content-end gap-3 small text-muted mb-2"> <!-- 가운데 정렬 -->
            <a href="#" class="btn btn-sm btn-outline-primary">상세보기</a>
          </div>
        </div>
        <div class="card-footer bg-white border-0 text-end"></div>
      </div>
    </div>
</div>
</div>

<!-- 상품 카테고리3 섹션 -->
<div class="container p-2" style="margin-bottom: 30px;">
  <div class="d-flex justify-content-between align-items-center mb-4">
    <h3 class="text-start mb-0">Category3</h3>
    <a href="https://example.com" class="btn btn-sm btn-outline-secondary">
      더보기(More)
    </a>
  </div>
  <div class="row row-cols-1 row-cols-md-4 gy-3 gx-3">
  <!-- 카드1 -->
    <div class="col">
      <div class="card h-100 shadow-sm border-0" style="height: 280px;"> <!-- style 위치 수정 -->
        <img src="./resources/img/makeup01.jpg" class="card-img-top" alt="..." style="height: 200px; object-fit: cover;">
        <div class="card-body p-2 text-center" style="height: 80px; overflow: hidden;"> <!-- 가운데 정렬 -->
          <h5 class="card-title mb-2">Landscape & Cityscape</h5>
          <div class="d-flex justify-content-end gap-3 small text-muted mb-2"> <!-- 가운데 정렬 -->
            <a href="#" class="btn btn-sm btn-outline-primary">상세보기</a>
          </div>
        </div>
        <div class="card-footer bg-white border-0 text-end"></div>
      </div>
    </div>
     <!-- 카드2 -->
    <div class="col">
      <div class="card h-100 shadow-sm border-0" style="height: 280px;"> <!-- style 위치 수정 -->
        <img src="./resources/img/makeup02.jpg" class="card-img-top" alt="..." style="height: 200px; object-fit: cover;">
        <div class="card-body p-2 text-center" style="height: 80px; overflow: hidden;"> <!-- 가운데 정렬 -->
          <h5 class="card-title mb-2">Landscape & Cityscape</h5>
          <div class="d-flex justify-content-end gap-3 small text-muted mb-2"> <!-- 가운데 정렬 -->
            <a href="#" class="btn btn-sm btn-outline-primary">상세보기</a>
          </div>
        </div>
        <div class="card-footer bg-white border-0 text-end"></div>
      </div>
    </div>
     <!-- 카드3 -->
    <div class="col">
      <div class="card h-100 shadow-sm border-0" style="height: 280px;"> <!-- style 위치 수정 -->
        <img src="./resources/img/makeup03.jpg" class="card-img-top" alt="..." style="height: 200px; object-fit: cover;">
        <div class="card-body p-2 text-center" style="height: 80px; overflow: hidden;"> <!-- 가운데 정렬 -->
          <h5 class="card-title mb-2">Landscape & Cityscape</h5>
          <div class="d-flex justify-content-end gap-3 small text-muted mb-2"> <!-- 가운데 정렬 -->
            <a href="#" class="btn btn-sm btn-outline-primary">상세보기</a>
          </div>
        </div>
        <div class="card-footer bg-white border-0 text-end"></div>
      </div>
    </div>
     <!-- 카드4 -->
    <div class="col">
      <div class="card h-100 shadow-sm border-0" style="height: 280px;"> <!-- style 위치 수정 -->
        <img src="./resources/img/makeup04.jpg" class="card-img-top" alt="..." style="height: 200px; object-fit: cover;">
        <div class="card-body p-2 text-center" style="height: 80px; overflow: hidden;"> <!-- 가운데 정렬 -->
          <h5 class="card-title mb-2">Landscape & Cityscape</h5>
          <div class="d-flex justify-content-end gap-3 small text-muted mb-2"> <!-- 가운데 정렬 -->
            <a href="#" class="btn btn-sm btn-outline-primary">상세보기</a>
          </div>
        </div>
        <div class="card-footer bg-white border-0 text-end"></div>
      </div>
    </div>
</div>
</div>


<!-- 상품 카테고리4 섹션 -->
<div class="container p-2" style="margin-bottom: 30px;">
  <div class="d-flex justify-content-between align-items-center mb-4">
    <h3 class="text-start mb-0">Category4</h3>
    <a href="https://example.com" class="btn btn-sm btn-outline-secondary">
      더보기(More)
    </a>
  </div>
  <div class="row row-cols-1 row-cols-md-4 gy-3 gx-3">
  <!-- 카드1 -->
    <div class="col">
      <div class="card h-100 shadow-sm border-0" style="height: 280px;"> <!-- style 위치 수정 -->
        <img src="./resources/img/makeup01.jpg" class="card-img-top" alt="..." style="height: 200px; object-fit: cover;">
        <div class="card-body p-2 text-center" style="height: 80px; overflow: hidden;"> <!-- 가운데 정렬 -->
          <h5 class="card-title mb-2">Landscape & Cityscape</h5>
          <div class="d-flex justify-content-end gap-3 small text-muted mb-2"> <!-- 가운데 정렬 -->
            <a href="#" class="btn btn-sm btn-outline-primary">상세보기</a>
          </div>
        </div>
        <div class="card-footer bg-white border-0 text-end"></div>
      </div>
    </div>
     <!-- 카드2 -->
    <div class="col">
      <div class="card h-100 shadow-sm border-0" style="height: 280px;"> <!-- style 위치 수정 -->
        <img src="./resources/img/makeup02.jpg" class="card-img-top" alt="..." style="height: 200px; object-fit: cover;">
        <div class="card-body p-2 text-center" style="height: 80px; overflow: hidden;"> <!-- 가운데 정렬 -->
          <h5 class="card-title mb-2">Landscape & Cityscape</h5>
          <div class="d-flex justify-content-end gap-3 small text-muted mb-2"> <!-- 가운데 정렬 -->
            <a href="#" class="btn btn-sm btn-outline-primary">상세보기</a>
          </div>
        </div>
        <div class="card-footer bg-white border-0 text-end"></div>
      </div>
    </div>
     <!-- 카드3 -->
    <div class="col">
      <div class="card h-100 shadow-sm border-0" style="height: 280px;"> <!-- style 위치 수정 -->
        <img src="./resources/img/makeup03.jpg" class="card-img-top" alt="..." style="height: 200px; object-fit: cover;">
        <div class="card-body p-2 text-center" style="height: 80px; overflow: hidden;"> <!-- 가운데 정렬 -->
          <h5 class="card-title mb-2">Landscape & Cityscape</h5>
          <div class="d-flex justify-content-end gap-3 small text-muted mb-2"> <!-- 가운데 정렬 -->
            <a href="#" class="btn btn-sm btn-outline-primary">상세보기</a>
          </div>
        </div>
        <div class="card-footer bg-white border-0 text-end"></div>
      </div>
    </div>
     <!-- 카드4 -->
    <div class="col">
      <div class="card h-100 shadow-sm border-0" style="height: 280px;"> <!-- style 위치 수정 -->
        <img src="./resources/img/makeup04.jpg" class="card-img-top" alt="..." style="height: 200px; object-fit: cover;">
        <div class="card-body p-2 text-center" style="height: 80px; overflow: hidden;"> <!-- 가운데 정렬 -->
          <h5 class="card-title mb-2">Landscape & Cityscape</h5>
          <div class="d-flex justify-content-end gap-3 small text-muted mb-2"> <!-- 가운데 정렬 -->
            <a href="#" class="btn btn-sm btn-outline-primary">상세보기</a>
          </div>
        </div>
        <div class="card-footer bg-white border-0 text-end"></div>
      </div>
    </div>
</div> <!-- .row 끝 -->

</section> <!-- .section 끝 -->



<%@ include file="footer.jsp" %> 

</body>
</html>
