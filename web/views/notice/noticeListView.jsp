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
<meta charset="UTF-8">
<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" />
<!-- Material Dashboard CSS -->
<link rel="stylesheet" href="/math/resources/assets/css/material-dashboard?v=2.1.1.css">
<script src="/math/resources/assets/js/core/jquery.min.js" type="text/javascript"></script>
<script src="/math/resources/assets/js/core/popper.min.js" type="text/javascript"></script>
<script src="/math/resources/assets/js/core/bootstrap-material-design.min.js" type="text/javascript"></script>
<script src="/math/resources/assets/js/plugins/perfect-scrollbar.jquery.min.js"></script>
<!-- Chartist JS -->
<script src="/math/resources/assets/js/plugins/chartist.min.js"></script>
<!--  Notifications Plugin    -->
<script src="/math/resources/assets/js/plugins/bootstrap-notify.js"></script>
<!-- Control Center for Material Dashboard: parallax effects, scripts for the example pages etc -->
<script src="/math/resources/assets/js/material-dashboard.js?v=2.1.1" type="text/javascript"></script>
<link href="/math/resources/assets/css/.min.css?v=2.1.1" rel="stylesheet" />
</head>
<body>
<%@ include file="../common/Adminheader.jsp" %>
<hr style="clear:both;">
<h1  align="center">공지사항관리목록</h1>
<h1 align="center">게시글 수 : <%=AllSearchListCount %></h1>
<table align="center" width="500" border="1" cellspacing="0" id="ts1">
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>등록일자</th>
		<th>조회수</th>
	</tr>
	<% for(int n = 0; n < nsList.size(); n++){ %>
	<tr>
		<td><%=nsList.get(n).getNoticeNo() %></td>
		<td><a href="/math/ndetail?no=<%=nsList.get(n).getNoticeNo()%>"><%=nsList.get(n).getNoticeTitle() %></a></td>
		<td><%=nsList.get(n).getWriterName() %></td>
		<td><%=nsList.get(n).getNoticeDate() %></td>
		<td><%=nsList.get(n).getNoticeCount() %></td>
	</tr>
	<% } %>
</table>
<div style="text-align:center">
	<% if(currentPage <= 1){ %>
		[맨처음]&nbsp;
	<% }else if(searchTitle != null){ %>
		<a href="/math/nslist?page=1&title=<%=searchTitle%>">[맨처음]</a>
	<% }else{ %>
		<a href="/math/nslist?page=1">[맨처음]</a>&nbsp;
	<%} if((currentPage - 5) <= startPage && (endPage - 5) >= 1){ %>
		<a href="/math/nslist?page=<%= (startPage - 5) + 4   %>&title=<%=searchTitle%>">[이전]</a>&nbsp;
	<% }else{%>
		[이전]
	<%} for(int p = startPage; p <= endPage; p++){ 
			if(p == currentPage){%>
				<font>[<%=p %>]</font>
			<%}else if(searchTitle != null){ %>
				<a href="/math/nslist?page=<%=p%>&title=<%=searchTitle%>"><%=p %></a>
				<%}else{ %>
				<a href="/math/nslist?page=<%=p%>"><%=p %></a>
	<% }} %>
	<% if((startPage + 5) <= maxPage && (currentPage + 5) >= startPage){ %>
		<a href="/math/nslist?page=<%=startPage+5%>&title=<%=searchTitle %>">&nbsp;[다음]</a>
	<%}else{ %>
		[다음]&nbsp;
	<%} %>
	<% if(currentPage >= maxPage){ %>
		&nbsp;[마지막]
	<% }else if(searchTitle != null){ %>
		<a href="/math/nslist?page=<%=maxPage%>&title=<%=searchTitle%>">&nbsp;[마지막]</a>
	<% }else{ %>
		<a href="/math/nslist?page=<%=maxPage%>">&nbsp;[마지막]</a>
	<%} %>
<div align="center">
<form action="/math/nslist?page=1" method="post" >
	<select>
		<option value="">선택하시오</option>
		<option name="title" value="title" >제목</option>
	</select>
	&nbsp;
	<input type="text" name="title" >
	<input type="submit" value="검색" >
</form>
<button onclick="javascript:location.href='views/notice/noticeWriteView.jsp'">글쓰기</button>
<%@ include file="../common/footer.jsp" %>
  <script src="/math/resources/assets/js/core/jquery.min.js" type="text/javascript"></script>
  <script src="/math/resources/assets/js/core/popper.min.js" type="text/javascript"></script>
  <script src="/math/resources/assets/js/core/bootstrap-material-design.min.js" type="text/javascript"></script>

  <!-- Plugin for the Perfect Scrollbar -->
  <script src="/math/resources/assets/js/plugins/perfect-scrollbar.jquery.min.js"></script>

  <!-- Plugin for the momentJs  -->
  <script src="/math/resources/assets/js/plugins/moment.min.js"></script>

  <!--  Plugin for Sweet Alert -->
  <script src="/math/resources/assets/js/plugins/sweetalert2.js"></script>

  <!-- Forms Validations Plugin -->
  <script src="/math/resources/assets/js/plugins/jquery.validate.min.js"></script>

  <!--  Plugin for the Wizard, full documentation here: https://github.com/VinceG/twitter-bootstrap-wizard -->
  <script src="/math/resources/assets/js/plugins/jquery.bootstrap-wizard.js"></script>

  <!--	Plugin for Select, full documentation here: http://silviomoreto.github.io/bootstrap-select -->
  <script src="/math/resources/assets/js/plugins/bootstrap-selectpicker.js" ></script>

  <!--  Plugin for the DateTimePicker, full documentation here: https://eonasdan.github.io/bootstrap-datetimepicker/ -->
  <script src="/math/resources/assets/js/plugins/bootstrap-datetimepicker.min.js"></script>

  <!--  DataTables.net Plugin, full documentation here: https://datatables.net/    -->
  <script src="/math/resources/assets/js/plugins/jquery.datatables.min.js"></script>

  <!--	Plugin for Tags, full documentation here: https://github.com/bootstrap-tagsinput/bootstrap-tagsinputs  -->
  <script src="/math/resources/assets/js/plugins/bootstrap-tagsinput.js"></script>

  <!-- Plugin for Fileupload, full documentation here: http://www.jasny.net/bootstrap/javascript/#fileinput -->
  <script src="/math/resources/assets/js/plugins/jasny-bootstrap.min.js"></script>

  <!--  Full Calendar Plugin, full documentation here: https://github.com/fullcalendar/fullcalendar    -->
  <script src="/math/resources/assets/js/plugins/fullcalendar.min.js"></script>

  <!-- Vector Map plugin, full documentation here: http://jvectormap.com/documentation/ -->
  <script src="/math/resources/assets/js/plugins/jquery-jvectormap.js"></script>

  <!--  Plugin for the Sliders, full documentation here: http://refreshless.com/nouislider/ -->
  <script src="/math/resources/assets/js/plugins/nouislider.min.js" ></script>

  <!-- Include a polyfill for ES6 Promises (optional) for IE11, UC Browser and Android browser support SweetAlert -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/core-js/2.4.1/core.js"></script>

  <!-- Library for adding dinamically elements -->
  <script src="/math/resources/assets/js/plugins/arrive.min.js"></script>

  <!-- Chartist JS -->
  <script src="/math/resources/assets/js/plugins/chartist.min.js"></script>

  <!--  Notifications Plugin    -->
  <script src="/math/resources/assets/js/plugins/bootstrap-notify.js"></script>

  <!-- Control Center for Material Dashboard: parallax effects, scripts for the example pages etc -->
  <script src="/math/resources/assets/js/material-dashboard.min.js?v=2.1.1" type="text/javascript"></script>
</body>
</html>