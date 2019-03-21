<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, notice.model.vo.Notice" %>    
<%
	ArrayList<Notice> nsList = (ArrayList<Notice>)request.getAttribute("nslist");
	int AllSearchListCount = ((Integer)request.getAttribute("AllSearchListCount")).intValue();
	int currentPage = ((Integer)request.getAttribute("currentPage")).intValue();
	int startPage = ((Integer)request.getAttribute("startPage")).intValue();
	int endPage = ((Integer)request.getAttribute("endPage")).intValue();
	int maxPage = ((Integer)request.getAttribute("maxPage")).intValue();
	String searchTitle = (String)request.getAttribute("searchTitle");
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
</head>
<body>
<%@ include file="../common/Adminheader.jsp" %>
<div class="main main-raised">
  <div class="container">
    <div class="section text-center">
      <h2 class="title">Your main section here</h2>
    </div>
  </div>
</div>
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
<%@ include file="../common/footer.jsp" %>
</body>
</html>