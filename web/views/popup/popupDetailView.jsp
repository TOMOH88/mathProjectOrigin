<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="popup.model.vo.Popup" %>    
<%
	Popup popup = (Popup)request.getAttribute("popup");
	String psearchTitle = (String)request.getAttribute("psearchTitle");
	String pOption = (String)request.getAttribute("poption");
	int popupBack = (Integer)request.getAttribute("popupBack");
	int popupNext = (Integer)request.getAttribute("popupNext");
	int popupMin = (Integer)request.getAttribute("popupMin");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>팝업상세보기</title>
<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  <!--     Fonts and icons     -->
  <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
  <!-- Material Kit CSS -->
  <link href="/math/resources/assets/css/material-dashboard.css?v=2.1.1" rel="stylesheet" />
  <link href="https://fonts.googleapis.com/css?family=Jua" rel="stylesheet">
</head>
<style>
table{
	font-family: 'Jua', sans-serif;
}

div > h4{
	font-family: 'Jua', sans-serif;
}

div > p{
	font-family: 'Jua', sans-serif;
}

ul {
	font-family: 'Jua', sans-serif;
}

#d1{
	font-family: 'Jua', sans-serif;
}
</style>
<body>
<%@ include file="../common/Adminheader.jsp" %>
 <div class="content">
        <div class="container-fluid">
          <div class="card">
            <div class="card-header card-header-primary">
              <h4 class="card-title">팝업상세보기</h4>
              <p class="card-category"><%=popup.getPopupNo() %>번글 상세보기페이지</p>
            </div>
            <div class="card-body">
              <div id="typography">
                <div class="card-title">
	<table class="table table-striped table-hover">
	<tr>
	</tr>
		<tr>
			<th>제목</th>
			<td><%=popup.getPopupName() %></td>
		</tr>
		<tr>
			<th>팝업메모</th>
			<td><%=popup.getPopupExplan()%></td>
		</tr>
		<tr>
			<th>팝업설정여부</th>
			<td><button onclick="location.href=window.open('views/main/main.jsp')">팝	업뛰우기</button></td>
		</tr>
	</table>
	<div style="text-align:center;" id="d1">
	<a href="/math/pupview?no=<%=popup.getPopupNo() %>" class="btn btn-default btn-sm">글수정</a>
				<a href="/math/pdelete?no=<%=popup.getPopupNo()%>" class="btn btn-default btn-sm">글삭제</a>
				<a href="/math/plist" class="btn btn-default btn-sm">목록가기</a>
				<%if(popup.getPopupNo() > popupMin){ %>
					<button name="btn" onclick="javascript:location.href='/math/pback?no=<%=popup.getPopupNo()%>'" class="btn btn-primary btn-link">이전글</button>
				<%} if(popup.getPopupNo() < popupNext){ %>
					<button name="btn" onclick="javascript:location.href='/math/pnext?no=<%=popup.getPopupNo()%>'" class="btn btn-primary btn-link">다음글</button>
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