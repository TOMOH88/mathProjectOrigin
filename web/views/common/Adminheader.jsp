<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  
	String adminId = (String)session.getAttribute("admin");
%>    
<!DOCTYPE html>
<html>
<head>
<<<<<<< HEAD
<meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  <!--     Fonts and icons     -->
  <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
  <!-- Material Kit CSS -->
  <link href="/math/resources/assets/css/material-dashboard.css?v=2.1.1" rel="stylesheet" />
    <title>adminheader</title>
=======
<meta charset="UTF-8">
<title>감성수학</title>
<script type="text/javascript" src="/math/resources/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
/* $(".hover").mouseleave(
        function () {
          $(this).removeClass("hover");
        }
      ); */
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
>>>>>>> b68da3285039aad70a53f42e6a653fdb7a1cb7e9
</head>
<body>
<div class="wrapper ">
    <div class="sidebar" data-color="purple" data-background-color="white">
      <!--
      Tip 1: You can change the color of the sidebar using: data-color="purple | azure | green | orange | danger"

      Tip 2: you can also add an image using data-image tag
  -->
      <div class="logo">
        <a href="#" class="simple-text logo-normal">
          감성수학
        </a>
      </div>
      <div class="sidebar-wrapper">
        <ul class="nav">
          <li class="nav-item active  ">
            <a class="nav-link" href="#">
              <i class="material-icons">dashboard</i>
              <p>감성수학</p>
            </a>
          </li>
          <li class="nav-item ">
            <a class="nav-link" href="/math/nslist">
              <i class="material-icons">dashboard</i>
              <p>공지사항관리</p>
            </a>
          </li>
          <li class="nav-item ">
            <a class="nav-link" href="#">
              <i class="material-icons">dashboard</i>
              <p>FAQ관리</p>
            </a>
          </li>
          <li class="nav-item ">
            <a class="nav-link" href="#">
              <i class="material-icons">dashboard</i>
              <p>QnA관리</p>
            </a>
          </li>
          <li class="nav-item ">
            <a class="nav-link" href="#">
              <i class="material-icons">dashboard</i>
              <p>문제관리</p>
            </a>
          </li>
          <li class="nav-item ">
            <a class="nav-link" href="#">
              <i class="material-icons">dashboard</i>
              <p>강의관리</p>
            </a>
          </li>
          <li class="nav-item ">
            <a class="nav-link" href="/math/plist">
              <i class="material-icons">dashboard</i>
              <p>팝업관리</p>
            </a>
          </li>
          <li class="nav-item ">
            <a class="nav-link" href="/math/mmanager">
              <i class="material-icons">dashboard</i>
              <p>회원관리</p>
            </a>
          </li>
          <li class="nav-item ">
            <a class="nav-link" href="/math/views/main/test.jsp">
              <i class="material-icons">dashboard</i>
              <p>테스트</p>
            </a>
          </li>
          <!-- your sidebar here -->
        </ul>
      </div>
    </div>
    <div class="main-panel">
      <!-- Navbar -->
      <nav class="navbar navbar-expand-lg navbar-transparent navbar-absolute fixed-top ">
        <div class="container-fluid">
          <div class="navbar-wrapper">
            <a class="navbar-brand" href="#">Dashboard</a>
          </div>
          <button class="navbar-toggler" type="button" data-toggle="collapse" aria-controls="navigation-index" aria-expanded="false" aria-label="Toggle navigation">
            <span class="sr-only">Toggle navigation</span>
            <span class="navbar-toggler-icon icon-bar"></span>
            <span class="navbar-toggler-icon icon-bar"></span>
            <span class="navbar-toggler-icon icon-bar"></span>
          </button>
          <div class="collapse navbar-collapse justify-content-end">
            <ul class="navbar-nav">
              <li class="nav-item">
                <a class="nav-link" href="#">
                  <i class="material-icons">notifications</i> logout
                </a>
              </li>
              <!-- your navbar here -->
            </ul>
          </div>
        </div>
      </nav>
</body>
</html>