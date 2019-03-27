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
<title>QnA 상세보기창</title>
<script type="text/javascript">
		function answerWrite(){
			location.href="/math/qaview?no="+<%=qna.getQnaNo()%>;
		}
		function updateView(){
			location.href = "/math/qaupview?no="+<%=qna.getQnaNo()%>;
		}
</script>
</head>
<body>
<%@ include file="../common/Adminheader.jsp" %>
         <div class="content">
        <div class="container-fluid">
          <div class="card">
            <div class="card-header card-header-primary">
              <h4 class="card-title">공지사항</h4>
               <p class="card-category"><%=qna.getQnaNo() %>번글 상세페이지</p>
            </div>
            <div class="card-body">
              <div id="typography">
                <div class="card-title">
                <table class="table">
                <tr>
                </tr>
	<tr>
		<th>질문내용</th>
		<td><%=qna.getQnaTitle() %></td>
	</tr>
	<% if(qna.getQnaLevel() == 1){ %>
	<tr>
		<th>질문답변</th>
		<td><%=qna.getQnaContent() %></td>
	</tr>
	<% } %>
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
<div align="center">
<% if(qna.getQnaStatus().equals("N")){ %>
	<button onclick="answerWrite();" class="btn btn-default btn-sm">답변하기</button>	
<% } %>
<button onclick="updateView();" class="btn btn-default btn-sm">수정하기</button>
</div>
</div>
</div>
</div>
</div>
</div>
</div>
<%@ include file="../common/footer.jsp" %>
</body>
</html>