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
		function qnaAllDelete(){
			if(confirm("정말 삭제하시겠습니까?") == true){
				location.href="/math/qdelete?no="+<%=qna.getQnaNo()%>;
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
</script>
</head>
<body>
<%@ include file="../common/Adminheader.jsp" %>
<hr style="clear:both;">
<H1 align="center"><%=qna.getQnaNo() %>번 상세페이지</H1>
<table align="center" width="800px">
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
<% if(qna.getQnaStatus().equals("N")){ %>
	<button onclick="answerWrite();">답변하기</button>	
<% } %>
<% if(qna.getQnaLevel() == 0){ %>
<button onclick="qnaAllDelete();">삭제하기</button>
<% } if(qna.getQnaLevel() == 1){  %>
<button onclick="updateView();">수정하기</button>
<button onclick="answerDelete();">삭제하기</button>
<% } %>
</body>
</html>