<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-SgOJa3DmI69IUzQ2PVdRZhwQ+dy64/BUtbMJw1MZ8t5HZApcHrRKUc4W0kG879m7" crossorigin="anonymous">
</head>
<body>
<div class="container py-5">
	<div class="row jstify-content-center">	
		<div class="col-md-6">
			<h2 class="mb-4 text-center">회원등록폼</h2>
			<form action="insert_process.jsp" method="post">
	            <div class="mb-3">
                    <label for="name" class="form-label">이름</label>
                    <input type="text" id="name" name="name" class="form-control" placeholder="이름을 입력하세요" required> 
		        </div>
		        <div class="mb-3">
                    <label for="email" class="form-label">이메일</label>
                    <input type="text" id="email" name="email" class="form-control" placeholder="이메일을 입력하세요" required>
		        </div>
		        <button type="submit" class="btn btn-primary">등록</button>
		    </form>
	    </div>
	    
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/js/bootstrap.bundle.min.js" integrity="sha384-k6d4wzSIapyDyv1kpU366/PK5hCdSbCRGRCMv+eplOQJWyd1fbcAu9OCUj5zNLiq" crossorigin="anonymous"></script>
</body>
</html>