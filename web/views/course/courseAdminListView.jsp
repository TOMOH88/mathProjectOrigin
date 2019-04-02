<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, course.model.vo.Course, course.model.vo.Semester, course.model.vo.Book" %>    
<%
    	ArrayList<Course> cList = (ArrayList<Course>)request.getAttribute("cList");
		ArrayList<Semester> semList = (ArrayList<Semester>)request.getAttribute("semList");
		ArrayList<Book> bList = (ArrayList<Book>)request.getAttribute("bList");
    	int allListCount = ((Integer) request.getAttribute("allListCount")).intValue();
    	int currentPage = ((Integer) request.getAttribute("currentPage")).intValue();
    	int startPage = ((Integer) request.getAttribute("startPage")).intValue();
    	int endPage = ((Integer) request.getAttribute("endPage")).intValue();
    	int maxPage = ((Integer) request.getAttribute("maxPage")).intValue();
    	String sOption = (String)request.getAttribute("sOption");
    	String bOption = (String)request.getAttribute("bOption");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  <!--     Fonts and icons     -->
  <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
  <!-- Material Kit CSS -->
  <link href="/math/resources/assets/css/material-dashboard.css?v=2.1.1" rel="stylesheet" />
  <link href="https://fonts.googleapis.com/css?family=Black+Han+Sans" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Do+Hyeon" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Jua" rel="stylesheet">
<title>강의목록관리페이지</title>
<script type="text/javascript">
	function courseWrite(){
		location.href="/math/cwview";
	}
</script>
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
                  <h4 class="card-title ">강의</h4>
                  <p class="card-category"> 목록보기 </p>
                </div>
                <div class="card-body">
                  <div class="table-responsive">
                    <table class="table table-striped table-hover">
                      <thead class="text-primary">
	<tr class="table-primary">
		<th>글번호</th>
		<th>제목</th>
		<th>등록일자</th>
	</tr>
	</thead>
	<% for(Course course : cList){ %>
	<tr>
		<td><%=course.getCourseNo() %></td>
		<td><a href="/math/cdetail?no=<%=course.getCourseNo()%>&page=<%=currentPage%>"><%=course.getCourseTitle() %></a></td>
		<td><%=course.getCourseDate() %></td>
	</tr>
	<% } %>
</table>
<ul class="pagination pagination-primary" style="justify-content: center;">
	<% if(currentPage <= 1){ %>
	<li class="page-item">
		<a class="page-link"> [맨처음] </a>
		</li>
	<% }else{ %>
	<li class="page-item">
		<a href="/math/clist?page=1&sOption=<%=sOption%>&bOption=<%=bOption%>" class="page-link">[맨처음]</a>
		</li>
	<%} if((currentPage - 5) <= startPage && (endPage - 5) >= 1){ %>
	<li class="page-item">
		<a href="/math/clist?page=<%= (startPage - 5) + 4   %>&sOption=<%=sOption%>&bOption=<%=bOption%>" class="page-link">[이전]</a>
		</li>
	<% }else{%>
	<li class="page-item">
		<a class="page-link"> [이전] </a>
		</li>
	<%} for(int p = startPage; p <= endPage; p++){ 
			if(p == currentPage){%>
			<li class="page-item">
				<a class="page-link"> <font>[<%=p %>]</font></a>
				</li>
				<%}else{ %>
				<li class="page-item">
				<a href="/math/clist?page=<%=p%>&sOption=<%=sOption%>&bOption=<%=bOption%>" class="page-link"><%=p %></a>
				</li>
	<% }} %>
	<% if((startPage + 5) <= maxPage && (currentPage + 5) >= startPage){ %>
	<li class="page-item">
		<a href="/math/clist?page=<%=startPage+5%>&sOption=<%=sOption%>&bOption=<%=bOption%>" class="page-link">[다음]</a>
		</li>
	<%}else{ %>
	<li class="page-item">
		<a class="page-link"> [다음] </a>
		</li>
	<%} %>
	<% if(currentPage >= maxPage){ %>
	<li class="page-item">
		<a class="page-link"> [마지막] </a>
		</li>
	<% }else{ %>
	<li class="page-item">
		<a href="/math/clist?page=<%=maxPage%>&sOption=<%=sOption%>&bOption=<%=bOption%>" class="page-link">[마지막]</a>
		</li>
	<%} %>
</ul>
<div align="center">
<form action="/math/clist" method="post" class="form-inline ml-auto">
<div class="container">
<select name="sOption" class="form-control">
	<option value="">선택하세요</option>
<% for(int i = 0; i < semList.size(); i++){ %>
	<option value="<%=semList.get(i).getSemesterName() %>"><%=semList.get(i).getSemesterName() %></option>
<% } %>
</select>
<select name="bOption" class="form-control">
	<option value="">선택하세요</option>
	<% for(int i = 0; i < bList.size(); i ++){ %>
	<option value="<%=bList.get(i).getBookName() %>"><%=bList.get(i).getBookName() %></option>
	<% } %>
</select>
<button type="submit" class="btn btn-white btn-raised btn-fab btn-round">
                    <i class="material-icons">search</i>
                  </button>
</div>
</form>
</div>
<div align="center" id="d1">
<button onclick="courseWrite();" class="btn btn-primary btn-sm">글쓰기</button>
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