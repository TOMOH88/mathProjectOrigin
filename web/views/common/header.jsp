<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String userId = (String)session.getAttribute("userId"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>감성수학</title>
<script type="text/javascript" src="resources/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
$(".hover").mouseleave(
        function () {
          $(this).removeClass("hover");
        }
      );
	function logout() {
		location.href="math/logout";
		return false;
	}
</script>
<!-- <style>
@import url(https://fonts.googleapis.com/css?family=Work+Sans);
.snip1485 {
  font-family: 'Work Sans', Arial, sans-serif;
  text-align: center;
  text-transform: uppercase;
  font-weight: 400;
}
.snip1485 *,
.snip1485 *:after {
  box-sizing: border-box;
  -webkit-transition: all 0.2s linear;
  transition: all 0.2s linear;
}
.snip1485 li {
  display: inline-block;
  list-style: outside none none;
  margin: 0.5em 0.6em;
  -webkit-perspective: 50em;
  perspective: 50em;
}
.snip1485 a {
  backface-visibility: hidden;
  color: #ffffff;
  display: inline-block;
  line-height: 2.2em;
  padding: 0 1.4em;
  position: relative;
  text-decoration: none;
  -webkit-transform-style: preserve-3d;
  transform-style: preserve-3d;
  background-color: #667273;
  -webkit-transform-origin: 50% 50%;
  -ms-transform-origin: 50% 50%;
  transform-origin: 50% 50%;
}
.snip1485 a:after {
  background-color: #5c122e;
  color: transparent;
  content: attr(data-hover);
  bottom: 100%;
  line-height: 2.2em;
  position: absolute;
  left: 0;
  width: 100%;
  -webkit-transform: translateY(0%) rotateX(90deg);
  transform: translateY(0%) rotateX(90deg);
  -webkit-transform-origin: 50% 100%;
  -ms-transform-origin: 50% 100%;
  transform-origin: 50% 100%;
}
.snip1485 li:hover a,
.snip1485 li.current a {
  -webkit-transform: translateY(50%) rotateX(-90deg);
  transform: translateY(50%) rotateX(-90deg);
  background-color: #363c3d;
  color: transparent;
}
.snip1485 li:hover a:after,
.snip1485 li.current a:after {
  background-color: #b12358;
  color: #ffffff;
  cursor: pointer;
}
.box{
   width:5px;
   height:5px;
   float:left;
   z-index: 1;
}
</style> -->
</head>
<body>

<ul class="snip1485">
  <div class="box">
  </div>
  <li class="current"><a href="#" data-hover="Home">감성수학</a></li>
  <li><a href="/math/nlist"  data-hover="Notice">공지사항</a></li>
  <li><a href="#" data-hover="FAQ">FAQ</a></li>
  <li><a href="#" data-hover="QnA">QnA</a></li>
  <li><a href="/math/views/question/questionPrint.jsp" data-hover="Matter">문제</a></li>
  <li><a href="/math/myinfo" data-hover="My Page">마이페이지</a></li>
  <li><a href="/math/logout" data-hover="logout">로그아웃</a></li>
</ul>
</body>
</html>