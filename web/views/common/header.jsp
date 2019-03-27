<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String userId = (String)session.getAttribute("userId"); %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>감성수학</title>
<script type="text/javascript" src="resources/js/jquery-3.3.1.min.js"></script>
<style>
</style>
</head>
<body>

<ul class="snip1485">
  <li class="current"><a href="#" data-hover="Home">감성수학</a></li>
  <li><a href="/math/nslist"  data-hover="Notice">공지사항</a></li>
  <li><a href="#" data-hover="FAQ">FAQ</a></li>
  <li><a href="#" data-hover="QnA">QnA</a></li>
  <li><a href="#" data-hover="Matter">문제</a></li>
  <li><a href="/math/myinfo" data-hover="My Page">마이페이지</a></li>
  <li><a href="/math/logout" data-hover="logout">로그아웃</a></li>
</ul>
</body>
</html>






