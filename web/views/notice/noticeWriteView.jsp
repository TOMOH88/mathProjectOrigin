<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="notice.model.vo.Notice"  %>    
<%
	Notice notice = (Notice)request.getAttribute("notice");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no" name="viewport" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <!--     Fonts and icons     -->
    <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
    <!-- Material Kit CSS -->
    <link href="/math/resources/assets/css/material-kit.css?v=2.0.5" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
  <!-- CSS Files -->
  <link href="/math/resources/assets/css/material-dashboard.css?v=2.1.1" rel="stylesheet" />
  <!-- CSS Just for demo purpose, don't include it in your project -->
  <link href="/math/resources/assets/demo/demo.css" rel="stylesheet" />
<script src="/math/resources/assets/js/material-kit.js?v=2.0.5" type="text/javascript"></script>
<title>공지사항 글쓰기</title>
</head>
<body>
<%@ include file="../common/Adminheader.jsp" %>
<div class="main main-raised">
  <div class="container">
    <div class="section text-center">
<h1 align="center">공지사항 글쓰기</h1>
<form action="/math/nwrite" method="post" enctype="multipart/form-data">
<table align="center" width="800" cellspacing="0">
<input type="hidden" name="writer" value="">
	<tr>
		<th>제목</th>
		<td><input type="text" name="title" ></td>
	</tr>
	<tr>
		<th>내용</th>
		<td><textarea rows="10" cols="100" name="content"></textarea></td>
	</tr>
	<tr>
		<th>첨부파일</th>
		<td><input type="file" name="upfile"></td>
	</tr>
	<tr>
		<th colspan="2">
			<input type="submit" value="글 등록">
			<input type="reset" value="작성취소">
			<button onclick="javascript:location.href='/math/nslist'; return false;">목록가기</button>
		</th>
	</tr>
</table>
</form>
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