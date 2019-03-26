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
@import url(https://fonts.googleapis.com/css?family=Raleway:400,500);
.snip1241 {
  font-family: 'Raleway', Arial, sans-serif;
  text-align: center;
  text-transform: uppercase;
  font-weight: 500;
  letter-spacing: 1px;
}
.snip1241 * {
  -webkit-box-sizing: border-box;
  box-sizing: border-box;
  -webkit-transition: all 0.35s ease;
  transition: all 0.35s ease;
}
.snip1241 li {
  display: inline-block;
  list-style: outside none none;
  margin: 0.5em 1em;
  padding: 0;
}
.snip1241 a {
  padding: 0.5em 0.8em;
  color: black;
  position: relative;
  text-decoration: none;
}
.snip1241 a:before,
.snip1241 a:after {
  height: 14px;
  width: 14px;
  position: absolute;
  content: '';
  -webkit-transition: all 0.35s ease;
  transition: all 0.35s ease;
  opacity: 0;
}
.snip1241 a:before {
  right: 0;
  top: 0;
  border-right: 3px solid #9b59b6;
  border-top: 3px solid #9b59b6;
  -webkit-transform: translate(-100%, 50%);
  transform: translate(-100%, 50%);
}
.snip1241 a:after {
  left: 0;
  bottom: 0;
  border-left: 3px solid #9b59b6;
  border-bottom: 3px solid #9b59b6;
  -webkit-transform: translate(100%, -50%);
  transform: translate(100%, -50%);
}
.snip1241 a:hover,
.snip1241 .current a {
  color: black;
}
.snip1241 a:hover:before,
.snip1241 .current a:before,
.snip1241 a:hover:after,
.snip1241 .current a:after {
  -webkit-transform: translate(0%, 0%);
  transform: translate(0%, 0%);
  opacity: 1;
}
</style>
</head>
<body>

<ul class="snip1485">
  <div class="box">
  </div>
  <li class="current"><a href="#" data-hover="Home">감성수학</a></li>
  <li><a href="/math/nslist"  data-hover="Notice">공지사항</a></li>
  <li><a href="#" data-hover="FAQ">FAQ</a></li>
  <li><a href="#" data-hover="QnA">QnA</a></li>
  <li><a href="#" data-hover="Matter">문제</a></li>
  <li><a href="/math/myinfo" data-hover="My Page">마이페이지</a></li>
  <li><a href="/math/logout" data-hover="logout">로그아웃</a></li>
<ul class="snip1241">
  <li class="current"><a href="#">감성수학</a></li>
  <li><a href="#">고객센터관리</a></li>
  <li><a href="#">FAQ관리</a></li>
  <li><a href="#">QnA관리</a></li>
  <li><a href="#">문제관리</a></li>
  <li><a href="/math/myinfo">마이페이지</a></li>
  <li><a href="/math/logout">로그아웃</a></li>
</ul>
</body>
</html>






