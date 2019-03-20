<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  
	String adminId = (String)session.getAttribute("admin");
%>    
<!DOCTYPE html>
<html>
<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
		<meta name="description" content="">
		<meta name="author" content="">
		<link rel="icon" href="favicon.ico">
		<title>Adminheader</title>
		<!-- Bootstrap core CSS -->
		<link href="/math/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
		<!-- Custom styles for this template -->
		<link href="/math/resources/bootstrap/css/style.css" rel="stylesheet">
	</head>
	<body id="page-top">
	<header>
		<!-- Navigation -->
		<nav class="navbar navbar-default">
			<div class="container">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header page-scroll">
					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand page-scroll" href="#page-top"><img src="/math/resources/bootstrap/images/logo.png" alt="감성수학"></a>
				</div>
				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav navbar-right">
						<li class="hidden">
							<a href="#page-top"></a>
						</li>
						<li>
							<a class="page-scroll" href="/math/nslist" data-toggle="modal">공지사항관리</a>
						</li>
						<li>
							<a class="page-scroll" href="/math/flist" data-toggle="modal">FAQ관리</a>
						</li>
						<li>
							<a class="page-scroll" href="#team" data-toggle="modal">QnA관리</a>
						</li>
						<li>
							<a class="page-scroll" href="#contact" data-toggle="modal">문제관리</a>
						</li>
						<li>
							<a class="page-scroll" href="#contact" data-toggle="modal">강의관리</a>
						</li>
						<li>
							<a class="page-scroll" href="/math/plist" data-toggle="modal">팝업관리</a>
						</li>
						<li>
							<a class="page-scroll" href="/math/mmanager" data-toggle="modal">회원관리</a>
						</li>
						<li>
							<a class="page-scroll" href="/math/alogout" data-toggle="modal">로그아웃</a>
						</li>
					</ul>
				</div>
				<!-- /.navbar-collapse -->
			</div>
			<!-- /.container-fluid -->
		</nav>
		</header>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
		<script src="/math/resources/bootstrap/js/bootstrap.min.js"></script>
		<script src="/math/resources/bootstrap/js/SmoothScroll.js"></script>
		<script src="/math/resources/bootstrap/js/theme-scripts.js"></script>
</body>
</html>