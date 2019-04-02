<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="qna.model.vo.Qna" %>    
<%
	Qna qna = (Qna)request.getAttribute("qna");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css?family=Jua" rel="stylesheet">
<title>Insert title here</title>
<script type="text/javascript">
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
<%@ include file="../common/header.jsp" %>
<div class="page-header header-filter" data-parallax="true" style="background-image: url('/math/resources/images/math-3986758_1920.jpg')">
    <div class="container">
      <div class="row">
        <div class="col-md-8 ml-auto mr-auto">
          <div class="brand text-center">
          <h1>QnA</h1>
            <h3 class="title text-center"><%=qna.getQnaNo() %>번글 상세페이지</h3>
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
		<td><%=qna.getQnaTitle() %></td>
	</tr>
	<tr>
		<th>내용</th>
		<td><%=qna.getQnaContent() %></td>
	</tr>
	<tr>
		<th>첨부파일</th>
		<td>
		<% if(qna.getOriginalQname() != null && !qna.getOriginalQname().equals("null")){ %>
			<a href="/math/qfdown?ofile=<%=qna.getOriginalQname() %>&rfile=<%=qna.getRenameQname() %>"><%=qna.getOriginalQname() %></a>
		<% }else{ %>
			첨부파일없음
		<% } %>
		</td>
	</tr>
</table>
<% if(qna.getQnaLevel() == 0){ %>
<button onclick="updateView();" class="btn btn-default btn-sm">수정하기</button>
<button onclick="questionDelete();" class="btn btn-default btn-sm">삭제하기</button>
<% } %>
<button onclick="javascript:location.href='/math/qmuslist?userId=<%=userId%>'" class="btn btn-default btn-sm">목록으로가기</button>
<script type="text/javascript">
function updateView(){
	location.href = "/math/qqupview?no="+<%=qna.getQnaNo()%>;
}

function questionDelete(){
	if(confirm("정말 삭제하시겠습니까?") == true){
		location.href="/math/qdelete?no=<%=qna.getQnaNo()%>&userId=<%=userId%>";
	}else {
		return;
	}
}
</script>
</div>
</div>
</div>
<%@ include file="../common/ufooter.jsp" %>
</body>
</html>