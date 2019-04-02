<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="qna.model.vo.Qna" %>
<%
	Qna qna = (Qna)request.getAttribute("qna");
	int currentPage = (Integer)request.getAttribute("currentPage");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QnA 상세보기창</title>
<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  <!--     Fonts and icons     -->
  <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
  <!-- Material Kit CSS -->
  <link href="/math/resources/assets/css/material-dashboard.css?v=2.1.1" rel="stylesheet" />
  <link href="https://fonts.googleapis.com/css?family=Jua" rel="stylesheet">
<script type="text/javascript">
		function answerWrite(){
			location.href="/math/qaview?no="+<%=qna.getQnaNo()%>;
		}
		function updateView(){
			location.href = "/math/qaupview?no=<%=qna.getQnaNo()%>&page=<%=currentPage%>";
		}
		function qnaAllDelete(){
			if(confirm("정말 삭제하시겠습니까?") == true){
				location.href="/math/qaadelete?no="+<%=qna.getQnaNo()%>;
			}else {
				return;
			}
		}
		function answerDelete(){
			if(confirm("정말 삭제하시겠습니까?") == true){
				location.href="/math/qadelete?no="+<%=qna.getQnaNo()%>;
			}else {
				return;
			}
		}
		function qnaList(){
			location.href="/math/qslist?page="+<%=currentPage%>;
		
		}
</script>
</head>
<style>

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
                  <h4 class="card-title ">QnA 상세보기</h4>
                  <p class="card-category"> <%=qna.getQnaNo() %>번글 상세페이지</p>
                </div>
                <div class="card-body">
                  <div class="table-responsive">
                    <table class="table table-striped table-hover">
                    <tr>
                    </tr>
	<tr>
		<th style="font-family: 'Jua', sans-serif;">제목</th>
		<td style="font-family: 'Jua', sans-serif;"><%=qna.getQnaTitle() %></td>
	</tr>
	<tr>
		<th style="font-family: 'Jua', sans-serif;">내용</th>
		<td><%=qna.getQnaContent() %></td>
	</tr>
	<tr>
		<th style="font-family: 'Jua', sans-serif;">첨부파일</th>
		<td style="font-family: 'Jua', sans-serif;">
		<% if(qna.getOriginalQname() != null && !qna.getOriginalQname().equals("null")){ %>
			<a href="/math/qfdown?ofile=<%=qna.getOriginalQname() %>&rfile=<%=qna.getRenameQname() %>"><%=qna.getOriginalQname() %></a>
		<% }else{ %>
			첨부파일없음
		<% } %>
		</td>
	</tr>
</table>
<div align="center" id="d1">
<% if(qna.getQnaStatus().equals("N")){ %>
	<button onclick="answerWrite();" class="btn btn-default btn-sm">답변하기</button>	
<% } %>
<% if(qna.getQnaLevel() == 0){ %>
<button onclick="qnaAllDelete();" class="btn btn-default btn-sm">삭제하기</button>
<% } if(qna.getQnaLevel() == 1){  %>
<button onclick="updateView();" class="btn btn-default btn-sm">수정하기</button>
<button onclick="answerDelete();" class="btn btn-default btn-sm">삭제하기</button>
<% } %>
<button onclick="qnaList();" class="btn btn-default btn-sm">목록으로가기</button>
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