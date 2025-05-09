<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/reservationListstyle.css">
<script src="<%= request.getContextPath() %>/resources/js/dday.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">
<title>reservation</title>
</head>
<body>

<%@ include file="header.jsp" %>

 
<section class="hero">
        <div class="hero-content">
            <h1>한국 전통 음식을 통해 새로운 경험을 느껴보세요</h1>
            <p>한국 전통 방식을 체험하고, 즐겨보세요. GongGan과 함께 전통적인 한식의 세계로 초대합니다.</p>
            <a href="#" class="hero_btn">한식 체험 예약 하기</a>
        </div>
</section>



<div class="container py-5">
  <h4 class="mb-4 text-start">Cultural Experiences</h4>
  <div class="row row-cols-1 row-cols-md-2 g-4">
    <!-- 카드 1 -->
    <div class="col">
      <div class="card h-100 shadow-sm border-0">
        <img src="./resources/img/exs01.jpg" class="card-img-top" alt="...">
        <div class="card-body">
          <div class="d-flex align-items-center mb-2">
           <h5 class="card-title">Landscape & Cityscape</h5>
           <span class="badge d-day-badge ms-3" data-dday="2025-06-05"></span>
          </div>
          <div class="d-flex align-items-center gap-3 small text-muted mb-2">
            <div><i class="bi bi-eye"></i> 120</div>
            <div><i class="bi bi-chat-left"></i> 3</div>
            <div><i class="bi bi-heart"></i> 15</div>
          </div>
          <p class="card-text">Describe your forum category. Engage your audience and entice them to continue reading.</p>
        </div>
        <div class="card-footer bg-white border-0 text-end">
          <a href="#" class="btn btn-sm btn-outline-primary">예약하기</a>
        </div>
      </div>
    </div>

    <!-- 카드 2 -->
    <div class="col">
      <div class="card h-100 shadow-sm border-0">
        <img src="./resources/img/exs02.jpg" class="card-img-top" alt="...">
        <div class="card-body">
         <div class="d-flex align-items-center mb-2">
          <h5 class="card-title">Nature & Wildlife</h5>
          <span class="badge d-day-badge ms-3" data-dday="2025-05-15"></span>
         </div>
          <div class="d-flex align-items-center gap-3 small text-muted mb-2">
            <div><i class="bi bi-eye"></i> 98</div>
            <div><i class="bi bi-chat-left"></i> 3</div>
            <div><i class="bi bi-heart"></i> 15</div>
          </div>
          <p class="card-text">Add your category description here. Be sure to write in an informative way that entices further reading.</p>
        </div>
        <div class="card-footer bg-white border-0 text-end">
          <a href="#" class="btn btn-sm btn-outline-primary">예약하기</a>
        </div>
      </div>
    </div>

    <!-- 카드 3 -->
    <div class="col">
      <div class="card h-100 shadow-sm border-0">
        <img src="./resources/img/체험2.jpg" class="card-img-top" alt="...">
        <div class="card-body">
         <div class="d-flex align-items-center mb-2">
          <h5 class="card-title">Black & White</h5>
          <span class="badge d-day-badge ms-3" data-dday="2025-05-09"></span>
         </div>
           <div class="d-flex align-items-center gap-3 small text-muted mb-2">
            <div><i class="bi bi-eye"></i> 56</div>
            <div><i class="bi bi-chat-left"></i> 3</div>
            <div><i class="bi bi-heart"></i> 15</div>
          </div>
          <p class="card-text">Describe your forum category. Engage your audience and entice them to continue reading.</p>
        </div>
        <div class="card-footer bg-white border-0 text-end">
          <a href="#" class="btn btn-sm btn-outline-primary">예약하기</a>
        </div>
      </div>
    </div>

    <!-- 카드 4 -->
    <div class="col">
      <div class="card h-100 shadow-sm border-0">
        <img src="./resources/img/체험3.jpg" class="card-img-top" alt="...">
        <div class="card-body">
         <div class="d-flex align-items-center mb-2">
          <h5 class="card-title">Macro Photography</h5>
          <span class="badge d-day-badge ms-3" data-dday="2025-08-05"></span>
         </div>	
            <div class="d-flex align-items-center gap-3 small text-muted mb-2">
            <div><i class="bi bi-eye"></i> 42</div>
            <div><i class="bi bi-chat-left"></i> 3</div>
            <div><i class="bi bi-heart"></i> 15</div>
          </div>
          <p class="card-text">Add your category description here. Be sure to write in an informative way that entices further reading.</p>
        </div>
        <div class="card-footer bg-white border-0 text-end">
          <a href="#" class="btn btn-sm btn-outline-primary">예약하기</a>
        </div>
      </div>
    </div>
  </div>
</div>


<!-- 3카드 섹션  -->
<div class="container py-3">
  <div class="row row-cols-1 row-cols-md-3 g-4"> <!-- 여기 변경됨 -->
    
    <!-- 카드 1 -->
    <div class="col">
      <div class="card h-100 shadow-sm border-0">
        <img src="./resources/img/체험0.jpg" class="card-img-top2" alt="...">
        <div class="card-body">
         <div class="d-flex align-items-center mb-2">
          <h5 class="card-title">Landscape & Cityscape</h5>
          <span class="badge d-day-badge ms-3" data-dday="2025-08-05"></span>
         </div>
          <div class="d-flex align-items-center gap-3 small text-muted mb-2">
            <div><i class="bi bi-eye"></i> 120</div>
            <div><i class="bi bi-chat-left"></i> 3</div>
            <div><i class="bi bi-heart"></i> 15</div>
          </div>
          <p class="card-text">Describe your forum category. Engage your audience and entice them to continue reading.</p>
        </div>
        <div class="card-footer bg-white border-0 text-end">
          <a href="#" class="btn btn-sm btn-outline-primary">예약하기</a>
        </div>
      </div>
    </div>
    
     <!-- 카드 2 -->
    <div class="col">
      <div class="card h-100 shadow-sm border-0">
        <img src="./resources/img/체험1.png" class="card-img-top2" alt="...">
        <div class="card-body">
         <div class="d-flex align-items-center mb-2">
          <h5 class="card-title">Landscape & Cityscape</h5>
          <span class="badge d-day-badge ms-3" data-dday="2025-08-05"></span>
         </div>
          <div class="d-flex align-items-center gap-3 small text-muted mb-2">
            <div><i class="bi bi-eye"></i> 120</div>
            <div><i class="bi bi-chat-left"></i> 3</div>
            <div><i class="bi bi-heart"></i> 15</div>
          </div>
          <p class="card-text">Describe your forum category. Engage your audience and entice them to continue reading.</p>
        </div>
        <div class="card-footer bg-white border-0 text-end">
          <a href="#" class="btn btn-sm btn-outline-primary">예약하기</a>
        </div>
      </div>
    </div>
    
     <!-- 카드 3 -->
    <div class="col">
      <div class="card h-100 shadow-sm border-0">
        <img src="./resources/img/체험2.jpg" class="card-img-top2" alt="...">
        <div class="card-body">
         <div class="d-flex align-items-center mb-2">
          <h5 class="card-title">Landscape & Cityscape</h5>
          <span class="badge d-day-badge ms-3" data-dday="2025-08-05"></span>
         </div>
          <div class="d-flex align-items-center gap-3 small text-muted mb-2">
            <div><i class="bi bi-eye"></i> 120</div>
            <div><i class="bi bi-chat-left"></i> 3</div>
            <div><i class="bi bi-heart"></i> 15</div>
          </div>
          <p class="card-text">Describe your forum category. Engage your audience and entice them to continue reading.</p>
        </div>
        <div class="card-footer bg-white border-0 text-end">
          <a href="#" class="btn btn-sm btn-outline-primary">예약하기</a>
        </div>
      </div>
     </div>
    </div>
   </div>


<%@ include file="footer.jsp" %> 

</body>
</html>
