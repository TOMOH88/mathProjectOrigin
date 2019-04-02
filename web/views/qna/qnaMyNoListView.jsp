<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String message = (String)request.getAttribute("message");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css?family=Jua" rel="stylesheet">
<title>qna페이지</title>
<script type="text/javascript">
function questionWrite() {
	location.href="/math/views/qna/questionWriteView.jsp";
}
</script>
</head>
<style>
div >	h3{
	font-family: 'Jua', sans-serif;
}

#d1{
	font-family: 'Jua', sans-serif;
}
</style>
<body>
<%@ include file="../common/header.jsp" %>
<div class="page-header header-filter" data-parallax="true" style="background-image: url('/math/resources/images/math-3986758_1920.jpg')">
    <div class="container">
      <div class="row">
        <div class="col-md-8 ml-auto mr-auto">
          <div class="brand text-center">
          <h1>QnA</h1>
            <h3 class="title text-center">목록보기</h3>
          </div>
        </div>
      </div>
    </div>
  </div>
   <div class="main main-raised">
    <div class="container">
      <div class="section text-center">
<h3 align="center">QnA 목록이없습니다. 새로운글을 작성해주세요.</h3>
<div id="d1">
<button onclick="questionWrite();" class="btn btn-default btn-sm">질문하기</button>
</div>
</div>
</div>
</div>
<%@ include file="../common/ufooter.jsp" %>
</body>
</html>