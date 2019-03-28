<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, qna.model.vo.Qna" %>    
<%
	ArrayList<Qna> qList = (ArrayList<Qna>)request.getAttribute("qList");
	int myUserListCount = ((Integer)request.getAttribute("myUserListCount")).intValue();
	int currentPage = ((Integer)request.getAttribute("currentPage")).intValue();
	int startPage = ((Integer)request.getAttribute("startPage")).intValue();
	int endPage = ((Integer)request.getAttribute("endPage")).intValue();
	int maxPage = ((Integer)request.getAttribute("maxPage")).intValue();	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QnA 내글보기페이지</title>
</head>
<body>
<%@ include file="../common/header.jsp" %>
<hr style="clear:both;">
<h1 align="QnA 목록 관리자페이지"></h1>
<table align="center" cellspacing="0" width="800px">
	<tr>
		<th></th>
		<th>질문내용</th>
		<th>작성자</th>
		<th>등록일자</th>
	</tr>
	<% for(Qna qna : qList){ %>
	<tr>
		<td><%=qna.getQnaNo() %></td>
		<%if(qna.getQnaLevel() == 0){ %>
			<td><a href="/math/qudetail?no=<%=qna.getQnaNo()%>"><%=qna.getQnaTitle() %></a></td>
		<%} else { %>
			<td><a href="/math/qudetail?no=<%=qna.getQnaNo()%>">[re]<%=qna.getQnaTitle() %></a></td>
		<%} %>
		<td><%=qna.getQnaWriter() %></td>
		<td><%=qna.getQnaDate() %></td>
	</tr>
	<% } %>
</table>
<div style="text-align:center">
	<% if(currentPage <= 1){ %>
		[맨처음]
	<% }else{ %>
		<a href="/math/qmuslist?page=1&userId=<%=userId%>">[맨처음]</a>
	<%} if((currentPage - 5) <= startPage && (endPage - 5) >= 1){ %>
		<a href="/math/qmuslist?page=<%= (startPage - 5) + 4   %>&userId=<%=userId%>">[이전]</a>
	<% }else{%>
		[이전]
	<%} for(int p = startPage; p <= endPage; p++){ 
			if(p == currentPage){%>
				<font>[<%=p %>]</font>
				<%}else{ %>
				<a href="/math/qmuslist?page=<%=p%>&userId=<%=userId%>"><%=p %></a>
	<% }} %>
	<% if((startPage + 5) <= maxPage && (currentPage + 5) >= startPage){ %>
		<a href="/math/qmuslist?page=<%=startPage+5%>&userId=<%=userId%>">[다음]</a>
	<%}else{ %>
		[다음]
	<%} %>
	<% if(currentPage >= maxPage){ %>
		[마지막]
	<% }else{ %>
		<a href="/math/qmuslist?page=<%=maxPage%>&userId=<%=userId%>">[마지막]</a>
	<%} %>
</div>
<button onclick="questionWrite();">질문하기</button>
<script type="text/javascript">
function questionWrite(){
	location.href="/math/views/qna/questionWriteView.jsp";
}
</script>
</body>
</html>