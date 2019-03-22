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

<script type="text/javascript">
</script>
<title>공지사항 상세보기</title>
</head>
<body>
<%@ include file="../common/Adminheader.jsp" %>
 <div class="content">
        <div class="container-fluid">
          <div class="card">
            <div class="card-header card-header-primary">
              <h4 class="card-title">공지사항</h4>
              <p class="card-category"><%=notice.getNoticeNo() %>번글 상세보기페이지</p>
            </div>
            <div class="card-body">
              <div id="typography">
                <div class="card-title">
	<table class="table">
	<tr>
	</tr>
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
	</table>
	<div style="text-align:center;">
	<a href="/math/nupview?no=<%=notice.getNoticeNo() %>" class="btn btn-default">글수정</a>
				<a href="/math/ndelete?no=<%=notice.getNoticeNo()%>" class="btn btn-default">글삭제</a>
				<a href="/math/nslist" class="btn btn-default">목록가기</a>
				<%if(notice.getNoticeNo() > noticeMin){ %>
					<button name="btn" onclick="javascript:location.href='/math/nback?no=<%=notice.getNoticeNo()%>'" class="btn btn-primary btn-link">이전글</button>
				<%} if(notice.getNoticeNo() < noticeNext){ %>
					<button name="btn" onclick="javascript:location.href='/math/nnext?no=<%=notice.getNoticeNo()%>'" class="btn btn-primary btn-link">다음글</button>
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