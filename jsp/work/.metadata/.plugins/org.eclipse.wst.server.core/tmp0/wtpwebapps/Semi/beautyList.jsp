<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/beautyListstyle.css">
<script src="<%= request.getContextPath() %>/resources/js/dday.js"></script>
<title>Beautylist</title>
</head>
<body>
<%@ include file="header.jsp" %>

<!-- 배경 이미지 섹션 -->
<section class="bg-image">	
  <div class="overlay">

    <!-- 상품 이미지 섹션 -->
    <div class="container pt-5 pb-3">
      <h3 class="mb-4 text-start">Category</h3>
      <div class="row row-cols-1 row-cols-md-4 gy-5 gx-4">

        <!-- 카드1 -->
        <div class="col">
          <div class="card h-100 shadow-sm border-0" style="height: 280px;">
            <img src="<%= request.getContextPath() %>/resources/img/makeup01.jpg" class="card-img-top" alt="..." style="height: 200px; object-fit: cover;">
            <div class="card-body p-2 text-center" style="height: 80px; overflow: hidden;">
              <h5 class="card-title mb-2">Landscape & Cityscape</h5>
              <div class="d-flex justify-content-end gap-3 small text-muted mb-2">
                <a href="#" class="btn btn-sm btn-outline-primary">상세보기</a>
              </div>
            </div>
          </div>
        </div>

        <!-- 카드2 -->
        <div class="col">
          <div class="card h-100 shadow-sm border-0" style="height: 280px;">
            <img src="<%= request.getContextPath() %>/resources/img/makeup02.jpg" class="card-img-top" alt="..." style="height: 200px; object-fit: cover;">
            <div class="card-body p-2 text-center" style="height: 80px; overflow: hidden;">
              <h5 class="card-title mb-2">Landscape & Cityscape</h5>
              <div class="d-flex justify-content-end gap-3 small text-muted mb-2">
                <a href="#" class="btn btn-sm btn-outline-primary">상세보기</a>
              </div>
            </div>
          </div>
        </div>

        <!-- 카드3 -->
        <div class="col">
          <div class="card h-100 shadow-sm border-0" style="height: 280px;">
            <img src="<%= request.getContextPath() %>/resources/img/makeup03.jpg" class="card-img-top" alt="..." style="height: 200px; object-fit: cover;">
            <div class="card-body p-2 text-center" style="height: 80px; overflow: hidden;">
              <h5 class="card-title mb-2">Landscape & Cityscape</h5>
              <div class="d-flex justify-content-end gap-3 small text-muted mb-2">
                <a href="#" class="btn btn-sm btn-outline-primary">상세보기</a>
              </div>
            </div>
          </div>
        </div>

        <!-- 카드4 -->
        <div class="col">
          <div class="card h-100 shadow-sm border-0" style="height: 280px;">
            <img src="<%= request.getContextPath() %>/resources/img/makeup04.jpg" class="card-img-top" alt="..." style="height: 200px; object-fit: cover;">
            <div class="card-body p-2 text-center" style="height: 80px; overflow: hidden;">
              <h5 class="card-title mb-2">Landscape & Cityscape</h5>
              <div class="d-flex justify-content-end gap-3 small text-muted mb-2">
                <a href="#" class="btn btn-sm btn-outline-primary">상세보기</a>
              </div>
            </div>
          </div>
        </div>
        
		    <!-- 카드5 -->
		<div class="col">
		  <div class="card h-100 shadow-sm border-0" style="height: 280px;">
		    <img src="<%= request.getContextPath() %>/resources/img/makeup05.jpg" class="card-img-top" alt="..." style="height: 200px; object-fit: cover;">
		    <div class="card-body p-2 text-center" style="height: 80px; overflow: hidden;">
		      <h5 class="card-title mb-2">Landscape & Cityscape</h5>
		      <div class="d-flex justify-content-end gap-3 small text-muted mb-2">
		        <a href="#" class="btn btn-sm btn-outline-primary">상세보기</a>
		      </div>
		    </div>
		  </div>
		</div>
		
		<!-- 카드6 -->
		<div class="col">
		  <div class="card h-100 shadow-sm border-0" style="height: 280px;">
		    <img src="<%= request.getContextPath() %>/resources/img/makeup06.jpg" class="card-img-top" alt="..." style="height: 200px; object-fit: cover;">
		    <div class="card-body p-2 text-center" style="height: 80px; overflow: hidden;">
		      <h5 class="card-title mb-2">Landscape & Cityscape</h5>
		      <div class="d-flex justify-content-end gap-3 small text-muted mb-2">
		        <a href="#" class="btn btn-sm btn-outline-primary">상세보기</a>
		      </div>
		    </div>
		  </div>
		</div>
		
		<!-- 카드7 -->
		<div class="col">
		  <div class="card h-100 shadow-sm border-0" style="height: 280px;">
		    <img src="<%= request.getContextPath() %>/resources/img/makeup07.jpg" class="card-img-top" alt="..." style="height: 200px; object-fit: cover;">
		    <div class="card-body p-2 text-center" style="height: 80px; overflow: hidden;">
		      <h5 class="card-title mb-2">Landscape & Cityscape</h5>
		      <div class="d-flex justify-content-end gap-3 small text-muted mb-2">
		        <a href="#" class="btn btn-sm btn-outline-primary">상세보기</a>
		      </div>
		    </div>
		  </div>
		</div>
		
		<!-- 카드8 -->
		<div class="col">
		  <div class="card h-100 shadow-sm border-0" style="height: 280px;">
		    <img src="<%= request.getContextPath() %>/resources/img/makeup08.jpg" class="card-img-top" alt="..." style="height: 200px; object-fit: cover;">
		    <div class="card-body p-2 text-center" style="height: 80px; overflow: hidden;">
		      <h5 class="card-title mb-2">Landscape & Cityscape</h5>
		      <div class="d-flex justify-content-end gap-3 small text-muted mb-2">
		        <a href="#" class="btn btn-sm btn-outline-primary">상세보기</a>
		      </div>
		    </div>
		  </div>
		</div>
		    <!-- 카드9 -->
		<div class="col">
		  <div class="card h-100 shadow-sm border-0" style="height: 280px;">
		    <img src="<%= request.getContextPath() %>/resources/img/makeup09.jpg" class="card-img-top" alt="..." style="height: 200px; object-fit: cover;">
		    <div class="card-body p-2 text-center" style="height: 80px; overflow: hidden;">
		      <h5 class="card-title mb-2">Landscape & Cityscape</h5>
		      <div class="d-flex justify-content-end gap-3 small text-muted mb-2">
		        <a href="#" class="btn btn-sm btn-outline-primary">상세보기</a>
		      </div>
		    </div>
		  </div>
		</div>
		
		<!-- 카드10 -->
		<div class="col">
		  <div class="card h-100 shadow-sm border-0" style="height: 280px;">
		    <img src="<%= request.getContextPath() %>/resources/img/makeup10.jpg" class="card-img-top" alt="..." style="height: 200px; object-fit: cover;">
		    <div class="card-body p-2 text-center" style="height: 80px; overflow: hidden;">
		      <h5 class="card-title mb-2">Landscape & Cityscape</h5>
		      <div class="d-flex justify-content-end gap-3 small text-muted mb-2">
		        <a href="#" class="btn btn-sm btn-outline-primary">상세보기</a>
		      </div>
		    </div>
		  </div>
		</div>
		
		<!-- 카드11 -->
		<div class="col">
		  <div class="card h-100 shadow-sm border-0" style="height: 280px;">
		    <img src="<%= request.getContextPath() %>/resources/img/makeup11.jpg" class="card-img-top" alt="..." style="height: 200px; object-fit: cover;">
		    <div class="card-body p-2 text-center" style="height: 80px; overflow: hidden;">
		      <h5 class="card-title mb-2">Landscape & Cityscape</h5>
		      <div class="d-flex justify-content-end gap-3 small text-muted mb-2">
		        <a href="#" class="btn btn-sm btn-outline-primary">상세보기</a>
		      </div>
		    </div>
		  </div>
		</div>
		
		<!-- 카드12 -->
		<div class="col">
		  <div class="card h-100 shadow-sm border-0" style="height: 280px;">
		    <img src="<%= request.getContextPath() %>/resources/img/makeup12.jpg" class="card-img-top" alt="..." style="height: 200px; object-fit: cover;">
		    <div class="card-body p-2 text-center" style="height: 80px; overflow: hidden;">
		      <h5 class="card-title mb-2">Landscape & Cityscape</h5>
		      <div class="d-flex justify-content-end gap-3 small text-muted mb-2">
		        <a href="#" class="btn btn-sm btn-outline-primary">상세보기</a>
		      </div>
		    </div>
		  </div>
		</div>
		    <!-- 카드13 -->
		<div class="col">
		  <div class="card h-100 shadow-sm border-0" style="height: 280px;">
		    <img src="<%= request.getContextPath() %>/resources/img/makeup13.jpg" class="card-img-top" alt="..." style="height: 200px; object-fit: cover;">
		    <div class="card-body p-2 text-center" style="height: 80px; overflow: hidden;">
		      <h5 class="card-title mb-2">Landscape & Cityscape</h5>
		      <div class="d-flex justify-content-end gap-3 small text-muted mb-2">
		        <a href="#" class="btn btn-sm btn-outline-primary">상세보기</a>
		      </div>
		    </div>
		  </div>
		</div>
		
		<!-- 카드14 -->
		<div class="col">
		  <div class="card h-100 shadow-sm border-0" style="height: 280px;">
		    <img src="<%= request.getContextPath() %>/resources/img/makeup14.jpg" class="card-img-top" alt="..." style="height: 200px; object-fit: cover;">
		    <div class="card-body p-2 text-center" style="height: 80px; overflow: hidden;">
		      <h5 class="card-title mb-2">Landscape & Cityscape</h5>
		      <div class="d-flex justify-content-end gap-3 small text-muted mb-2">
		        <a href="#" class="btn btn-sm btn-outline-primary">상세보기</a>
		      </div>
		    </div>
		  </div>
		</div>
		
		<!-- 카드15 -->
		<div class="col">
		  <div class="card h-100 shadow-sm border-0" style="height: 280px;">
		    <img src="<%= request.getContextPath() %>/resources/img/makeup15.jpg" class="card-img-top" alt="..." style="height: 200px; object-fit: cover;">
		    <div class="card-body p-2 text-center" style="height: 80px; overflow: hidden;">
		      <h5 class="card-title mb-2">Landscape & Cityscape</h5>
		      <div class="d-flex justify-content-end gap-3 small text-muted mb-2">
		        <a href="#" class="btn btn-sm btn-outline-primary">상세보기</a>
		      </div>
		    </div>
		  </div>
		</div>


		<!-- 카드16 -->
		<div class="col">
		  <div class="card h-100 shadow-sm border-0" style="height: 280px;">
		    <img src="<%= request.getContextPath() %>/resources/img/makeup16.jpg" class="card-img-top" alt="..." style="height: 200px; object-fit: cover;">
		    <div class="card-body p-2 text-center" style="height: 80px; overflow: hidden;">
		      <h5 class="card-title mb-2">Landscape & Cityscape</h5>
		      <div class="d-flex justify-content-end gap-3 small text-muted mb-2">
		        <a href="#" class="btn btn-sm btn-outline-primary">상세보기</a>
		      </div>
		    </div>
		  </div>
		</div>
		
	 </div>
   </div>



<!-- 페이지 네비게이션 -->
<nav aria-label="Page navigation example" class="mt-4">
  <ul class="pagination justify-content-center">
    <li class="page-item disabled">
      <a class="page-link" href="#" tabindex="-1">이전</a>
    </li>
    <li class="page-item active"><a class="page-link" href="#">1</a></li>
    <li class="page-item"><a class="page-link" href="#">2</a></li>
    <li class="page-item"><a class="page-link" href="#">3</a></li>
    <li class="page-item"><a class="page-link" href="#">4</a></li>
    <li class="page-item"><a class="page-link" href="#">5</a></li>
    <li class="page-item">
      <a class="page-link" href="#">다음</a>
    </li>
  </ul>
</nav>

</div> <!-- overlay 끝 -->
</section> <!-- .section 끝 -->



<%@ include file="footer.jsp" %> 

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
