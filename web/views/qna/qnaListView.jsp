<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, qna.model.vo.Qna" %>    
<%
	ArrayList<Qna> qList = (ArrayList<Qna>)request.getAttribute("qList");
	int allSearchListCount = ((Integer)request.getAttribute("allSearchListCount")).intValue();
	int currentPage = ((Integer)request.getAttribute("currentPage")).intValue();
	int startPage = ((Integer)request.getAttribute("startPage")).intValue();
	int endPage = ((Integer)request.getAttribute("endPage")).intValue();
	int maxPage = ((Integer)request.getAttribute("maxPage")).intValue();	
	String searchTitle = (String)request.getAttribute("searchTitle");
	String qOption = (String)request.getAttribute("qOption");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>qna목록 관리자페이지</title>
</head>
<body>
<%@ include file="../common/Adminheader.jsp" %>
<hr style="clear:both;">
<h1 align="QnA 목록 관리자페이지"></h1>
<table align="center" cellspacing="0" width="800px">
	<tr>
		<th></th>
		<th>내용</th>
		<th>작성자</th>
		<th>등록일자</th>
	</tr>
	<% for(Qna qna : qList){ %>
	<tr>
		<td><%=qna.getQnaNo() %></td>
		<%if(qna.getQnaLevel() == 0){ %>
			<td><a href="/math/qdetail?no=<%=qna.getQnaNo()%>"><%=qna.getQnaTitle() %></a></td>
		<%} else { %>
			<td><a href="/math/qdetail?no=<%=qna.getQnaNo()%>">[re]<%=qna.getQnaTitle() %></a></td>
		<%} %>
		<td><%=qna.getQnaWriter() %></td>
		<td><%=qna.getQnaDate() %></td>
	</tr>
	<% } %>
</table>
<div style="text-align:center">
	<% if(currentPage <= 1){ %>
		[맨처음]
	<% }else if(searchTitle != null){ %>
		<a href="/math/qslist?page=1&title=<%=searchTitle%>&qOption=<%=qOption%>">[맨처음]</a>
	<% }else{ %>
		<a href="/math/qslist?page=1">[맨처음]</a>
	<%} if((currentPage - 5) <= startPage && (endPage - 5) >= 1){ %>
		<a href="/math/qslist?page=<%= (startPage - 5) + 4   %>&title=<%=searchTitle%>&qOption=<%=qOption%>">[이전]</a>
	<% }else{%>
		[이전]
	<%} for(int p = startPage; p <= endPage; p++){ 
			if(p == currentPage){%>
				<font>[<%=p %>]</font>
			<%}else if(searchTitle != null && qOption != null){ %>
				<a href="/math/qslist?page=<%=p%>&title=<%=searchTitle%>&qOption=<%=qOption%>"><%=p %></a>
				<%}else{ %>
				<a href="/math/qslist?page=<%=p%>"><%=p %></a>
	<% }} %>
	<% if((startPage + 5) <= maxPage && (currentPage + 5) >= startPage){ %>
		<a href="/math/qslist?page=<%=startPage+5%>&title=<%=searchTitle %>&qOption=<%=qOption%>">[다음]</a>
	<%}else{ %>
		[다음]
	<%} %>
	<% if(currentPage >= maxPage){ %>
		[마지막]
	<% }else if(searchTitle != null){ %>
		<a href="/math/qslist?page=<%=maxPage%>&title=<%=searchTitle%>&qOption=<%=qOption%>">[마지막]</a>
	<% }else{ %>
		<a href="/math/qslist?page=<%=maxPage%>">[마지막]</a>
	<%} %>
</div>	
<div align="center">
<form action="/math/qslist" method="post">
<select name="qOption">
	<option value="">선택하세요</option>
	<option name="qTitle" value="qTitle">제목</option>
	<option name="qTContent" value="qTContent">제목+내용</option>
	<option name="qnaUser" value="qUserId">작성자</option>
</select>
<input type="text" name="title">
<input type="submit" value="검색">
</form>
</div>
</body>
</html>