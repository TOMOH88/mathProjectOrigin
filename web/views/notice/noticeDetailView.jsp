<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="notice.model.vo.Notice" %>    
<%
	Notice notice = (Notice)request.getAttribute("notice");
	String searchTitle = (String)request.getAttribute("searchTitle");
	String nOption = (String)request.getAttribute("noption");
	int noticeBack = (Integer)request.getAttribute("noticeBack");
	int noticeNext = (Integer)request.getAttribute("noticeNext");
	int noticeMin = (Integer)request.getAttribute("noticeMin");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no" name="viewport" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <!--     Fonts and icons     -->
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
<script type="text/javascript">
</script>
<title>공지사항 상세보기</title>
</head>
<body>
<%@ include file="../common/Adminheader.jsp" %>
<div class="main main-raised">
  <div class="container">
    <div class="section text-center">
<h1 align="center"><%=notice.getNoticeNo() %>번 상세보기페이지</h1>
	<table border="1" cellspacing="0" width="600"  height="200" align="center">
		<tr>
			<th>제목</th>
			<td><%=notice.getNoticeTitle() %></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><%=notice.getWriterName()%></td>
		</tr>
		<tr>
			<th>글내용</th>
			<td><%=notice.getNoticeContent().replaceAll("\r\n", "<br>") %></td>
		</tr>
		<tr>
			<th>첨부파일</th>
			<td>
				<% if(notice.getOriginalFileName() != null && !notice.getOriginalFileName().equals("null")){ %>
					<a href="/math/nfdown?ofile=<%=notice.getOriginalFileName() %>&rfile=<%=notice.getRenameFileName()%>"><%=notice.getOriginalFileName() %></a>
				<% }else{ %>
					첨부파일없음
				<% } %>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<a href="/math/nupview?no=<%=notice.getNoticeNo() %>">글수정</a>
				<a href="/math/ndelete?no=<%=notice.getNoticeNo()%>">글삭제</a>
				<a href="/math/nslist">목록가기</a>
				<%if(notice.getNoticeNo() > noticeMin){ %>
					<button name="btn" onclick="javascript:location.href='/math/nback?no=<%=notice.getNoticeNo()%>'">이전글</button>
				<%} if(notice.getNoticeNo() < noticeNext){ %>
					<button name="btn" onclick="javascript:location.href='/math/nnext?no=<%=notice.getNoticeNo()%>'">다음글</button>
				<%} %>
			</td>
		</tr>
	</table>
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