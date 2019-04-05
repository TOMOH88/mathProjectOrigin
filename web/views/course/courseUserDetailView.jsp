<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="course.model.vo.Course" %>
<%
	Course course = (Course)request.getAttribute("course");
	int currentPage = ((Integer)request.getAttribute("currentPage")).intValue();
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css?family=Jua" rel="stylesheet">
<title>감성수학</title>
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
</head>
<body>
<%@ include file="../common/header.jsp" %>
<div class="page-header header-filter" data-parallax="true" style="background-image: url('/math/resources/images/math-3986758_1920.jpg')">
    <div class="container">
      <div class="row">
        <div class="col-md-8 ml-auto mr-auto">
          <div class="brand text-center">
          <h1>강의</h1>
            <h3 class="title text-center"><%=course.getCourseNo() %>번글 상세페이지</h3>
          </div>
        </div>
      </div>
    </div>
  </div>
   <div class="main main-raised">
    <div class="container">
      <div class="section text-center">
<table class="table table-striped table-hover">
	<tr>
		<th>제목</th>
		<td><%=course.getCourseTitle() %></td>
	</tr>
	<tr>
		<th>내용</th>
		<td><%=course.getCourseContent() %></td>
	</tr>
</table>
<div id="d1">
<button onclick="courseList();" class="btn btn-default btn-sm">목록으로가기</button>
</div>
<script type="text/javascript">
function courseList(){
	console.log("1");
	location.href="/math/culist?page=<%=currentPage%>&userId=<%=userId%>";
}
</script>
</div>
</div>
</div>
<%@ include file="../common/ufooter.jsp" %>
</body>
</html>