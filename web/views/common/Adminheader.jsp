<%@page import="admin.model.vo.Admin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%  String admin = (String)session.getAttribute("admin");%>
<!DOCTYPE html>
<html>
<head>
<title>adminheader</title>
 <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  <!--     Fonts and icons     -->
  <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
  <!-- Material Kit CSS -->
  <link href="/math/resources/assets/css/material-dashboard.css?v=2.1.1" rel="stylesheet" />
  <link href="https://fonts.googleapis.com/css?family=Black+Han+Sans" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Do+Hyeon" rel="stylesheet">
  <script type="text/javascript" src="/math/resources/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
function logout() {
	
	if(confirm("로그아웃 하시겠습니다.")){
		admin=null;	
		location.href="/math/alogout";
		
	}else{
		return false;
	}
}
</script>
</head>
<body>
<div class="wrapper ">
    <div class="sidebar" data-color="purple" data-background-color="white">
      <!--
      Tip 1: You can change the color of the sidebar using: data-color="purple | azure | green | orange | danger"

      Tip 2: you can also add an image using data-image tag
  -->
      <div class="logo">
        <a href="#" class="simple-text logo-normal" style="font-family: Black Han Sans;">
          감성수학
        </a>
      </div>
      <div class="sidebar-wrapper">
        <ul class="nav">
          <li class="nav-item">
            <a class="nav-link" href="/math/nslist" style="font-family: Black Han Sans;">
              <i class="material-icons">dashboard</i>
              <p>공지사항</p>
            </a>
          </li>
           <li class="nav-item">
            <a class="nav-link" href="/math/fslist" style="font-family: Black Han Sans;">
              <i class="material-icons">description</i>
              <p>FAQ</p>
            </a>
          </li>
           <li class="nav-item">
            <a class="nav-link" href="/math/qslist" style="font-family: Black Han Sans;">
              <i class="material-icons">toc</i>
              <p>QnA</p>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/math/plist" style="font-family: Black Han Sans;">
              <i class="material-icons">style</i>
              <p>팝업관리</p>
            </a>
          </li>
           <li class="nav-item">
            <a class="nav-link" href="/math/views/question/adminQuestionPrint.jsp" style="font-family: Black Han Sans;">
              <i class="material-icons">import_contacts</i>
              <p>문제관리</p>
            </a>
          </li>
           <li class="nav-item">
            <a class="nav-link" href="/math/clist" style="font-family: Black Han Sans;">
              <i class="material-icons">ondemand_video</i>
              <p>강의관리</p>
            </a>
          </li>
           <li class="nav-item">
            <a class="nav-link" href="/math/mmanager" style="font-family: Black Han Sans;">
              <i class="material-icons">people</i>
              <p>회원관리</p>
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
            <a class="navbar-brand" href="#" style="font-family: Black Han Sans;">Admin</a>
          </div>
          <button class="navbar-toggler" type="button" data-toggle="collapse" aria-controls="navigation-index" aria-expanded="false" aria-label="Toggle navigation">
            <span class="sr-only">Toggle navigation</span>
            <span class="navbar-toggler-icon icon-bar"></span>
            <span class="navbar-toggler-icon icon-bar"></span>
            <span class="navbar-toggler-icon icon-bar"></span>
          </button>
          <%if(admin!=null){ %>
          <div class="collapse navbar-collapse justify-content-end">
            <ul class="navbar-nav">
              <li class="nav-item">
                <a class="nav-link" onclick="logout();" style="font-family: Black Han Sans; cursor:pointer;">
                  <i class="material-icons">power_settings_new</i> logout
                </a>
              </li>
              <!-- your navbar here -->
            </ul>
            </div>
            <%}else{ %>
                      <div class="collapse navbar-collapse justify-content-end">
            <ul class="navbar-nav">
              <li class="nav-item">
                <a class="nav-link" href="/math/admin.jsp" style="font-family: Black Han Sans; cursor:pointer;">
                  <i class="material-icons">power_settings_new</i> login
                </a>
              </li>
              <!-- your navbar here -->
            </ul>
            </div>
            <%} %>
        </div>
      </nav>
</body>
</html>