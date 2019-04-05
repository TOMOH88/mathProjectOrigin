<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, popup.model.vo.Popup" %>
<% 
	ArrayList<Popup> plist = (ArrayList<Popup>)request.getAttribute("plist");
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
<meta charset="UTF-8">
<title>Popup</title>
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
          <div class="row">
            <div class="col-md-12">
              <div class="card">
                <div class="card-header card-header-primary">
                  <h4 class="card-title ">팝업관리</h4>
                  <%if(admin != null){ %>
                  <p class="card-category"> 현재 게시글 수 : <%=AllSearchListCount %></p>
                  <%}%>
                </div>
                <div class="card-body">
                  <div class="table-responsive">
                  <%if(admin != null){ %>
                    <table class="table table-striped table-hover">
                      <thead class=" text-primary">
	<tr class="table-primary">
		<th>글번호</th>
		<th>제목</th>
		<th>이미지</th>
		<th>등록날짜</th>
		<th>종료날짜</th>
	</tr>
	</thead>
	<% for(int n = 0; n < plist.size(); n++){ %>
	<tr>
		<td><%=plist.get(n).getPopupNo() %></td>
		<td><a href="/math/pdetail?no=<%=plist.get(n).getPopupNo()%>&page=<%=currentPage%>"><%=plist.get(n).getPopupName() %></a></td>
		<td><%=plist.get(n).getPopupImagePath() %></td>
		<td><%=plist.get(n).getPopupDate() %></td>
		<td><%=plist.get(n).getPopupEndDate() %></td>
	</tr>
	<% } %>
</table>
<ul class="pagination pagination-primary" style="justify-content: center;">
	<% if(currentPage <= 1){ %>
	<li class="page-item">
		<a class="page-link">[맨처음]&nbsp; </a>
		</li>
	<% }else if(searchTitle != null){ %>
	<li class="page-item">
		<a href="/math/plist?page=1&title=<%=searchTitle%>" class="page-link">[맨처음]</a>
		</li>
	<% }else{ %>
	<li class="page-item">
		<a href="/math/plist?page=1">[맨처음]</a>&nbsp;
		</li>
	<%} if((currentPage - 5) <= startPage && (endPage - 5) >= 1){ %>
	<li class="page-item">
		<a href="/math/plist?page=<%= (startPage - 5) + 4   %>&title=<%=searchTitle%>" class="page-link">[이전]</a>&nbsp;
		</li>
	<% }else{%>
	<li class="page-item">
		<a class="page-link"> [이전] </a>
		</li>
	<%} for(int p = startPage; p <= endPage; p++){ 
			if(p == currentPage){%>
			<li class="page-item">
				<a class="page-link"> <font>[<%=p %>]</font> </a>
				</li>
			<%}else if(searchTitle != null){ %>
			<li class="page-item">
				<a href="/math/plist?page=<%=p%>&title=<%=searchTitle%>" v><%=p %></a>
				</li>
				<%}else{ %>
				<li class="page-item">
				<a href="/math/plist?page=<%=p%>" class="page-link"><%=p %></a>
				</li>
	<% }} %>
	<% if((startPage + 5) <= maxPage && (currentPage + 5) >= startPage){ %>
	<li>
		<a href="/math/plist?page=<%=startPage+5%>&title=<%=searchTitle %>">&nbsp;[다음]</a>
		</li>
	<%}else{ %>
	<li class="page-item">
		<a class="page-link"> [다음]&nbsp; </a>
		</li>
	<%} %>
	<% if(currentPage >= maxPage){ %>
	<li class="page-item">
		<a class="page-link"> &nbsp;[마지막] </a>
		</li>
	<% }else if(searchTitle != null){ %>
	<li class="page-item">
		<a href="/math/plist?page=<%=maxPage%>&title=<%=searchTitle%>" class="page-link">&nbsp;[마지막]</a>
		</li>
	<% }else{ %>
	<li class="page-item">
		<a href="/math/plist?page=<%=maxPage%>" class="page-link">&nbsp;[마지막]</a>
		</li>
	<%} %>
	</ul>
<div align="center" id="d1">
<form action="/math/plist?page=1" method="post" class="form-inline ml-auto">
<div class="container">
	<select class="form-control">
		<option value="">선택하시오</option>
		<option name="title" value="title" >제목</option>
	</select>
	&nbsp;
	<input type="text" name="title" class="form-control" placeholder="Search">
	<button type="submit" class="btn btn-white btn-raised btn-fab btn-round">
                    <i class="material-icons">search</i>
                  </button>
                  </div>
</form>
<button onclick="javascript:location.href='views/popup/popupWriteView.jsp'" type="button" class="btn btn-primary btn-sm">팝업등록</button>
<%}else { %>
<h1>로그인 해주세요.</h1>
<%} %>
</div>
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