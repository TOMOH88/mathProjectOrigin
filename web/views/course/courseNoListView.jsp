<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  <!--     Fonts and icons     -->
  <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
  <!-- Material Kit CSS -->
  <link href="/math/resources/assets/css/material-dashboard.css?v=2.1.1" rel="stylesheet" />
  <link href="https://fonts.googleapis.com/css?family=Black+Han+Sans" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Do+Hyeon" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Jua" rel="stylesheet">
<title>감성수학</title>
<script type="text/javascript">
	function courseWrite(){
		location.href="/math/cwview";
	}
</script>
</head>
<body>
<%@ include file="../common/Adminheader.jsp" %>
<div class="content">
        <div class="container-fluid">
          <div class="row">
            <div class="col-md-12">
              <div class="card">
                <div class="card-header card-header-primary">
                <%if(admin != null){ %>
                  <h4 class="card-title ">강의</h4>
                </div>
                <div class="card-body">
                  <div class="table-responsive">
                  <h2>강의 목록이 없습니다.</h2>
<button onclick="courseWrite();" class="btn btn-primary btn-sm">글쓰기</button>
<%}else{ %>
<h1>로그인 해주세요.</h1>
<%} %>
</div>
</div>
</div>
</div>
</div>
</div>
</div>
<%@ include file="../common/footer.jsp" %>
<script src="/math/resources/assets/js/core/jquery.min.js"></script>
  <script src="/math/resources/assets/js/core/popper.min.js"></script>
  <script src="/math/resources/assets/js/core/bootstrap-material-design.min.js"></script>
  <script src="/math/resources/assets/js/plugins/perfect-scrollbar.jquery.min.js"></script>
  <!-- Include a polyfill for ES6 Promises (optional) for IE11, UC Browser and Android browser support SweetAlert -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/core-js/2.4.1/core.js"></script>
  <!-- Library for adding dinamically elements -->
  <script src="/math/resources/assets/js/plugins/arrive.min.js"></script>
  <!-- Chartist JS -->
  <script src="/math/resources/assets/js/plugins/chartist.min.js"></script>
  <!--  Notifications Plugin    -->
  <script src="/math/resources/assets/js/plugins/bootstrap-notify.js"></script>
  <!-- Control Center for Material Dashboard: parallax effects, scripts for the example pages etc -->
  <script src="/math/resources/assets/js/material-dashboard.js?v=2.1.1" type="text/javascript"></script>
  <!-- Material Dashboard DEMO methods, don't include it in your project! -->
  <script src="/math/resources/assets/demo/demo.js"></script>
</body>
</html>