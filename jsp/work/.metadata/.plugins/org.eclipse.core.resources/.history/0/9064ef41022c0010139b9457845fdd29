<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="dto.Cosmetics"%>
<%@ page import="dao.CosmeticsRepository"%>
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

<div class="container-fluid p-0 text-center" style="margin-top: 80px; position: relative;">
  <img src="./resources/img/BEAUTY09.jpg" class="img-fluid mx-auto" alt="Your Image Description" style="width: 1400px; height: 600px;">

  <div class="text-overlay" style="position: absolute; top: 50%; left: 50%; transform: translate(-50%, -50%); color: white; font-size: 40px; font-weight: bold; text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.5);">
    K - BEAUTY <br>
    Experience the Secrets of Korean Skincare
  </div>
</div>

<section class="bg-image">
<div class="overlay">

<div class="container pt-5 pb-3" style="margin-bottom: 30px;">
   <div class="d-flex justify-content-between align-items-center mb-4">
    <h3 class="text-start mb-0">전체 상품</h3>
    <a href="#" class="btn btn-sm btn-outline-secondary">
      더보기(More)
    </a>
  </div>
  <div class="row row-cols-1 row-cols-md-4 gy-3 gx-3">
  <%
    CosmeticsRepository cosmeticsRepository = CosmeticsRepository.getInstance();
    List<Cosmetics> allCosmetics = cosmeticsRepository.getAllCosmetics();

    int displayCount = 0;
    for (Cosmetics cosmetic : allCosmetics) {
      if (displayCount >= 2) { // 최대 2개만 출력
        break;
      }
  %>
    <div class="col">
      <div class="card h-100 shadow-sm border-0" style="height: 280px;">
        <img src="<%= request.getContextPath() %>/resources/img/<%= cosmetic.getImage_file() %>" class="card-img-top" alt="<%= cosmetic.getName() %>" style="height: 200px; object-fit: cover;">
        <div class="card-body p-2 text-center" style="height: 80px; overflow: hidden;">
          <h5 class="card-title mb-2"><%= cosmetic.getName() %></h5>
          <p class="card-text small text-muted mb-1">주요 성분: <%= cosmetic.getMain_ingredient() %></p>
          <div class="d-flex justify-content-end gap-3 small text-muted mb-2">
            <a href="./cosmetics_detail.jsp?id=<%= cosmetic.getId() %>" class="btn btn-sm btn-outline-primary">상세보기</a>
          </div>
        </div>
        <div class="card-footer bg-white border-0 text-end"><%= cosmetic.getPrice() %>원</div>
      </div>
    </div>
  <%
      displayCount++;
    }

    // 나머지 카드 섹션들은 주석 처리하거나 제거합니다.
  %>
</div>
</div>

<%--
<div class="container p-2" style="margin-bottom: 30px;">
  <div class="d-flex justify-content-between align-items-center mb-4">
    <h3 class="text-start mb-0">Category2</h3>
    <a href="https://example.com" class="btn btn-sm btn-outline-secondary">
      더보기(More)
    </a>
  </div>
  <div class="row row-cols-1 row-cols-md-4 gy-3 gx-3">
  <div class="col">
      <div class="card h-100 shadow-sm border-0" style="height: 280px;"> <img src="./resources/img/makeup01.jpg" class="card-img-top" alt="..." style="height: 200px; object-fit: cover;">
        <div class="card-body p-2 text-center" style="height: 80px; overflow: hidden;"> <h5 class="card-title mb-2">Landscape & Cityscape</h5>
          <div class="d-flex justify-content-end gap-3 small text-muted mb-2"> <a href="#" class="btn btn-sm btn-outline-primary">상세보기</a>
          </div>
        </div>
        <div class="card-footer bg-white border-0 text-end"></div>
      </div>
    </div>
     <div class="col">
      <div class="card h-100 shadow-sm border-0" style="height: 280px;"> <img src="./resources/img/makeup02.jpg" class="card-img-top" alt="..." style="height: 200px; object-fit: cover;">
        <div class="card-body p-2 text-center" style="height: 80px; overflow: hidden;"> <h5 class="card-title mb-2">Landscape & Cityscape</h5>
          <div class="d-flex justify-content-end gap-3 small text-muted mb-2"> <a href="#" class="btn btn-sm btn-outline-primary">상세보기</a>
          </div>
        </div>
        <div class="card-footer bg-white border-0 text-end"></div>
      </div>
    </div>
     <div class="col">
      <div class="card h-100 shadow-sm border-0" style="height: 280px;"> <img src="./resources/img/makeup03.jpg" class="card-img-top" alt="..." style="height: 200px; object-fit: cover;">
        <div class="card-body p-2 text-center" style="height: 80px; overflow: hidden;"> <h5 class="card-title mb-2">Landscape & Cityscape</h5>
          <div class="d-flex justify-content-end gap-3 small text-muted mb-2"> <a href="#" class="btn btn-sm btn-outline-primary">상세보기</a>
          </div>
        </div>
        <div class="card-footer bg-white border-0 text-end"></div>
      </div>
    </div>
     <div class="col">
      <div class="card h-100 shadow-sm border-0" style="height: 280px;"> <img src="./resources/img/makeup04.jpg" class="card-img-top" alt="..." style="height: 200px; object-fit: cover;">
        <div class="card-body p-2 text-center" style="height: 80px; overflow: hidden;"> <h5 class="card-title mb-2">Landscape & Cityscape</h5>
          <div class="d-flex justify-content-end gap-3 small text-muted mb-2"> <a href="#" class="btn btn-sm btn-outline-primary">상세보기</a>
          </div>
        </div>
        <div class="card-footer bg-white border-0 text-end"></div>
      </div>
    </div>
</div>
</div>

<div class="container p-2" style="margin-bottom: 30px;">
  <div class="d-flex justify-content-between align-items-center mb-4">
    <h3 class="text-start mb-0">Category3</h3>
    <a href="https://example.com" class="btn btn-sm btn-outline-secondary">
      더보기(More)
    </a>
  </div>
  <div class="row row-cols-1 row-cols-md-4 gy-3 gx-3">
  <div class="col">
      <div class="card h-100 shadow-sm border-0" style="height: 280px;"> <img src="./resources/img/makeup01.jpg" class="card-img-top" alt="..." style="height: 200px; object-fit: cover;">
        <div class="card-body p-2 text-center" style="height: 80px; overflow: hidden;"> <h5 class="card-title mb-2">Landscape & Cityscape</h5>
          <div class="d-flex justify-content-end gap-3 small text-muted mb-2"> <a href="#" class="btn btn-sm btn-outline-primary">상세보기</a>
          </div>
        </div>
        <div class="card-footer bg-white border-0 text-end"></div>
      </div>
    </div>
     <div class="col">
      <div class="card h-100 shadow-sm border-0" style="height: 280px;"> <img src="./resources/img/makeup02.jpg" class="card-img-top" alt="..." style="height: 200px; object-fit: cover;">
        <div class="card-body p-2 text-center" style="height: 80px; overflow: hidden;"> <h5 class="card-title mb-2">Landscape & Cityscape</h5>
          <div class="d-flex justify-content-end gap-3 small text-muted mb-2"> <a href="#" class="btn btn-sm btn-outline-primary">상세보기</a>
          </div>
        </div>
        <div class="card-footer bg-white border-0 text-end"></div>
      </div>
    </div>
     <div class="col">
      <div class="card h-100 shadow-sm border-0" style="height: 280px;"> <img src="./resources/img/makeup03.jpg" class="card-img-top" alt="..." style="height: 200px; object-fit: cover;">
        <div class="card-body p-2 text-center" style="height: 80px; overflow: hidden;"> <h5 class="card-title mb-2">Landscape & Cityscape</h5>
          <div class="d-flex justify-content-end gap-3 small text-muted mb-2"> <a href="#" class="btn btn-sm btn-outline-primary">상세보기</a>
          </div>
        </div>
        <div class="card-footer bg-white border-0 text-end"></div>
      </div>
    </div>
     <div class="col">
      <div class="card h-100 shadow-sm border-0" style="height: 280px;"> <img src="./resources/img/makeup04.jpg" class="card-img-top" alt="..." style="height: 200px; object-fit: cover;">
        <div class="card-body p-2 text-center" style="height: 80px; overflow: hidden;"> <h5 class="card-title mb-2">Landscape & Cityscape</h5>
          <div class="d-flex justify-content-end gap-3 small text-muted mb-2"> <a href="#" class="btn btn-sm btn-outline-primary">상세보기</a>
          </div>
        </div>
        <div class="card-footer bg-white border-0 text-end"></div>
      </div>
    </div>
</div>
</div>


<div class="container p-2" style="margin-bottom: 30px;">
  <div class="d-flex justify-content-between align-items-center mb-4">
    <h3 class="text-start mb-0">Category4</h3>
    <a href="https://example.com" class="btn btn-sm btn-outline-secondary">
      더보기(More)
    </a>
  </div>
  <div class="row row-cols-1 row-cols-md-4 gy-3 gx-3">
  <div class="col">
      <div class="card h-100 shadow-sm border-0" style="height: 280px;"> <img src="./resources/img/makeup01.jpg" class="card-img-top" alt="..." style="height: 200px; object-fit: cover;">
        <div class="card-body p-2 text-center" style="height: 80px; overflow: hidden;"> <h5 class="card-title mb-2">Landscape & Cityscape</h5>
          <div class="d-flex justify-content-end gap-3 small text-muted mb-2"> <a href="#" class="btn btn-sm btn-outline-primary">상세보기</a>
          </div>
        </div>
        <div class="card-footer bg-white border-0 text-end"></div>
      </div>
    </div>
     <div class="col">
      <div class="card h-100 shadow-sm border-0" style="height: 280px;"> <img src="./resources/img/makeup02.jpg" class="card-img-top" alt="..." style="height: 200px; object-fit: cover;">
        <div class="card-body p-2 text-center" style="height: 80px; overflow: hidden;"> <h5 class="card-title mb-2">Landscape & Cityscape</h5>
          <div class="d-flex justify-content-end gap-3 small text-muted mb-2"> <a href="#" class="btn btn-sm btn-outline-primary">상세보기</a>
          </div>
        </div>
        <div class="card-footer bg-white border-0 text-end"></div>
      </div>
    </div>
     <div class="col">
      <div class="card h-100 shadow-sm border-0" style="height: 280px;"> <img src="./resources/img/makeup03.jpg" class="card-img-top" alt="..." style="height: 200px; object-fit: cover;">
        <div class="card-body p-2 text-center" style="height: 80px; overflow: hidden;"> <h5 class="card-title mb-2">Landscape & Cityscape</h5>
          <div class="d-flex justify-content-end gap-3 small text-muted mb-2"> <a href="#" class="btn btn-sm btn-outline-primary">상세보기</a>
          </div>
        </div>
        <div class="card-footer bg-white border-0 text-end"></div>
      </div>
    </div>
     <div class="col">
      <div class="card h-100 shadow-sm border-0" style="height: 280px;"> <img src="./resources/img/makeup04.jpg" class="card-img-top" alt="..." style="height: 200px; object-fit: cover;">
        <div class="card-body p-2 text-center" style="height: 80px; overflow: hidden;"> <h5 class="card-title mb-2">Landscape & Cityscape</h5>
          <div class="d-flex justify-content-end gap-3 small text-muted mb-2"> <a href="#" class="btn btn-sm btn-outline-primary">상세보기</a>
          </div>
        </div>
        <div class="card-footer bg-white border-0 text-end"></div>
      </div>
    </div>
</div> --%>

</section> <%@ include file="footer.jsp" %>

</body>
</html>