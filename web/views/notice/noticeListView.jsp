<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, notice.model.vo.Notice" %>    
<%
	ArrayList<Notice> nsList = (ArrayList<Notice>)request.getAttribute("nslist");
	int AllSearchListCount = ((Integer)request.getAttribute("AllSearchListCount")).intValue();
	int currentPage = ((Integer)request.getAttribute("currentPage")).intValue();
	int startPage = ((Integer)request.getAttribute("startPage")).intValue();
	int endPage = ((Integer)request.getAttribute("endPage")).intValue();
	int maxPage = ((Integer)request.getAttribute("maxPage")).intValue();
	String searchTitle = (String)request.getAttribute("searchTitle");
	String nOption = (String)request.getAttribute("noption");
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
</head>
<body>
<%@ include file="../common/Adminheader.jsp" %>
<hr style="clear:both;">
<div class="main main-raised">
  <div class="container">
    <div class="section text-center">
<h1  align="center">공지사항관리목록</h1>
<h1 align="center">게시글 수 : <%=AllSearchListCount %></h1>
<div class="row">
            <div class="col-md-12">
              <div class="card">
                <div class="card-header card-header-primary">
                  <h4 class="card-title ">공지사항 </h4>
                  <p class="card-category"> Here is a subtitle for this table</p>
                </div>
                <div class="card-body">
                  <div class="table-responsive">
                    <table class="table">
                      <thead class=" text-primary">
                        <th>
                          글번호
                        </th>
                        <th>
                          제목
                        </th>
                        <th>
                          작성자
                        </th>
                        <th>
                          등록일자
                        </th>
                        <th>
                          조회수
                        </th>
                      </thead>
                      <tbody>
                      <% for(int n = 0; n < nsList.size(); n++){ %>
                        <tr>
                          <td>
                            <%=nsList.get(n).getNoticeNo() %>
                          </td>
                          <td>
                            <a href="/math/ndetail?no=<%=nsList.get(n).getNoticeNo()%>"><%=nsList.get(n).getNoticeTitle() %></a>
                          </td>
                          <td>
                            <%=nsList.get(n).getWriterName() %>
                          </td>
                          <td>
                            <%=nsList.get(n).getNoticeDate() %>
                          </td>
                          <td class="text-primary">
                            <%=nsList.get(n).getNoticeCount() %>
                          </td>
                        </tr>
                        <% } %>
                      </tbody>
                    </table>
                  </div>
                </div>
<div style="text-align:center">
	<% if(currentPage <= 1){ %>
		[맨처음]&nbsp;
	<% }else if(searchTitle != null){ %>
		<a href="/math/nslist?page=1&title=<%=searchTitle%>&noption=<%=nOption%>">[맨처음]</a>
	<% }else{ %>
		<a href="/math/nslist?page=1">[맨처음]</a>&nbsp;
	<%} if((currentPage - 5) <= startPage && (endPage - 5) >= 1){ %>
		<a href="/math/nslist?page=<%= (startPage - 5) + 4   %>&title=<%=searchTitle%>&noption=<%=nOption%>">[이전]</a>&nbsp;
	<% }else{%>
		[이전]
	<%} for(int p = startPage; p <= endPage; p++){ 
			if(p == currentPage){%>
				<font>[<%=p %>]</font>
			<%}else if(searchTitle != null && nOption != null){ %>
				<a href="/math/nslist?page=<%=p%>&title=<%=searchTitle%>&noption=<%=nOption%>"><%=p %></a>
				<%}else{ %>
				<a href="/math/nslist?page=<%=p%>"><%=p %></a>
	<% }} %>
	<% if((startPage + 5) <= maxPage && (currentPage + 5) >= startPage){ %>
		<a href="/math/nslist?page=<%=startPage+5%>&title=<%=searchTitle %>&noption=<%=nOption%>">&nbsp;[다음]</a>
	<%}else{ %>
		[다음]&nbsp;
	<%} %>
	<% if(currentPage >= maxPage){ %>
		&nbsp;[마지막]
	<% }else if(searchTitle != null){ %>
		<a href="/math/nslist?page=<%=maxPage%>&title=<%=searchTitle%>&noption=<%=nOption%>">&nbsp;[마지막]</a>
	<% }else{ %>
		<a href="/math/nslist?page=<%=maxPage%>">&nbsp;[마지막]</a>
	<%} %>
<div align="center">
<form action="/math/nslist?page=1" method="post" >
	<select name="noption">
		<option value="">선택하시오</option>
		<option name="ntitle" value="ntitle" >제목</option>
		<option name="ntContent" value="ntContent">제목+내용</option>
	</select>
	&nbsp;
	<input type="text" name="title" >
	<input type="submit" value="검색" >
</form>
<button onclick="javascript:location.href='views/notice/noticeWriteView.jsp'">글쓰기</button>
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