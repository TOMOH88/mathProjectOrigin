<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="notice.model.vo.Notice" %>    
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
    <link rel="icon" type="image/png" href="http://example.com/myicon.png">
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
<title>수정페이지</title>
<script type="text/javascript" src="/math/resources/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
function listView(){
	location.href = '/math/nslist';
}

</script>
</head>
<body>
<%@ include file="../common/Adminheader.jsp" %>
<div class="main main-raised">
  <div class="container">
    <div class="section text-center">
<h1 align="center"><%=notice.getNoticeNo() %>번 글 수정페이지</h1>
<form action="/math/nupdate" method="post" enctype="multipart/form-data">
<input type="hidden" name="no" value="<%=notice.getNoticeNo() %>">
<input type="hidden" name="ofile" value="<%=notice.getOriginalFileName() %>">
<input type="hidden" name="rfile" value="<%=notice.getRenameFileName() %>">
	<table	align="center" border="1" width="500" cellspacing="0">
		<tr>
			<th>제목</th>
			<td><input type="text" name="title" value="<%=notice.getNoticeTitle() %>"></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><input type="text" name="writer" value="<%=notice.getWriterName() %>" readonly ></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea rows="10" cols="100" name="content" class="etext"><%=notice.getNoticeContent().replaceAll("<br>","\r\n")%></textarea></td>
		</tr>
		<tr height="50">
			<th>첨부파일</th>
			<td id="filetd">
				<% if(notice.getOriginalFileName() != null && !notice.getOriginalFileName().equals("null")){ %>
					<%=notice.getOriginalFileName() %>
				<% }else{ %>
					첨부파일없음
				<% } %>&nbsp;
				<input type="file" value="첨부파일 변경"  name="upfile">
			</td>
		</tr>
		<tr>
			<th colspan="2">
				<input type="submit" value="수정하기">
				<button onclick="listView(); return false;">목록으로 돌아가기</button>
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