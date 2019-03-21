<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  
	String adminId = (String)session.getAttribute("admin");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <!--     Fonts and icons     -->
    <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
    <!-- Material Kit CSS -->
    <link href="/math/resources/assets/css/material-kit.css?v=2.0.5" rel="stylesheet" />
    <script src="/math/resources/assets/js/material-kit.js?v=2.0.5" type="text/javascript"></script>
    <title>adminheader</title>
</head>
<body>
<header>
<nav class="navbar navbar-transparent navbar-color-on-scroll fixed-top navbar-expand-lg" color-on-scroll="100" id="sectionsNav">
    <div class="container">
      <div class="navbar-translate">
        <a class="navbar-brand" href="/math/views/main/adminmain.jsp">
          감성수학 </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" aria-expanded="false" aria-label="Toggle navigation">
          <span class="sr-only">Toggle navigation</span>
          <span class="navbar-toggler-icon"></span>
          <span class="navbar-toggler-icon"></span>
          <span class="navbar-toggler-icon"></span>
        </button>
      </div>
      <div class="collapse navbar-collapse">
        <ul class="navbar-nav ml-auto">
          <li class="dropdown nav-item">
            <a href="#" class="dropdown-toggle nav-link" data-toggle="dropdown">
              <i class="material-icons">apps</i> 목록
            </a>
            <div class="dropdown-menu dropdown-with-icons">
              <a href="/math/nslist" class="dropdown-item">
                <i class="material-icons">apps</i> 공지사항관리
              </a>
              <a href="#" class="dropdown-item">
                <i class="material-icons">apps</i> FAQ관리
              </a>
              <a href="#" class="dropdown-item">
                <i class="material-icons">apps</i> QnA관리
              </a>
              <a href="#" class="dropdown-item">
                <i class="material-icons">apps</i> 문제관리
              </a>
              <a href="#" class="dropdown-item">
                <i class="material-icons">apps</i> 강의관리
              </a>
              <a href="/math/plist" class="dropdown-item">
                <i class="material-icons">apps</i> 팝업관리
              </a>
              <a href="#" class="dropdown-item">
                <i class="material-icons">apps</i> 회원관리
              </a>
              <a href="#" class="dropdown-item">
                <i class="material-icons">apps</i> 로그아웃
              </a>
              <a href="/math/views/main/test.jsp" class="dropdown-item">
                <i class="material-icons">apps</i> test
              </a>
            </div>
          </li>
          <li class="nav-item">
            <a class="nav-link" rel="tooltip" title="" data-placement="bottom" href="https://twitter.com/CreativeTim" target="_blank" data-original-title="Follow us on Twitter">
              <i class="fa fa-twitter"></i>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" rel="tooltip" title="" data-placement="bottom" href="https://www.facebook.com/CreativeTim" target="_blank" data-original-title="Like us on Facebook">
              <i class="fa fa-facebook-square"></i>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" rel="tooltip" title="" data-placement="bottom" href="https://www.instagram.com/CreativeTimOfficial" target="_blank" data-original-title="Follow us on Instagram">
              <i class="fa fa-instagram"></i>
            </a>
          </li>
        </ul>
      </div>
    </div>
  </nav>
<div class="page-header header-filter" data-parallax="true" style="background-image: url('/math/resources/assets/img/bg3.jpg');">
</div>
</header>
<script src="/math/resources/assets/js/core/jquery.min.js" type="text/javascript"></script>
<script src="/math/resources/assets/js/core/popper.min.js" type="text/javascript"></script>
<script src="/math/resources/assets/js/core/bootstrap-material-design.min.js" type="text/javascript"></script>
<script src="/math/resources/assets/js/plugins/moment.min.js"></script>
<!--	Plugin for the Datepicker, full documentation here: https://github.com/Eonasdan/bootstrap-datetimepicker -->
<script src="/math/resources/assets/js/plugins/bootstrap-datetimepicker.js" type="text/javascript"></script>
<!--  Plugin for the Sliders, full documentation here: http://refreshless.com/nouislider/ -->
<script src="/math/resources/assets/js/plugins/nouislider.min.js" type="text/javascript"></script>
<!-- Place this tag in your head or just before your close body tag. -->
<script async defer src="https://buttons.github.io/buttons.js"></script>
<!-- Control Center for Material Kit: parallax effects, scripts for the example pages etc -->
<script src="/math/resources/assets/js/material-kit.js?v=2.0.5" type="text/javascript"></script>
</body>
</html>