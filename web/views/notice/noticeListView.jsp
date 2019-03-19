<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, notice.model.vo.Notice" %>    
<%
	ArrayList<Notice> nList = (ArrayList<Notice>)request.getAttribute("nList");
	int listCount = ((Integer)request.getAttribute("listCount")).intValue();
	int currentPage = ((Integer)request.getAttribute("currentPage")).intValue();
	int startPage = ((Integer)request.getAttribute("startPage")).intValue();
	int endPage = ((Integer)request.getAttribute("endPage")).intValue();
	int maxPage = ((Integer)request.getAttribute("maxPage")).intValue();
	String searchTitle = (String)request.getAttribute("searchTitle");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항목록관리</title>
<style type="text/css">
	/* /* table {
		background-image: url("/math/resources/images/보노보노.png");
		background-size: 100% 100%;
	} */ */
</style>
</head>
<body>
<%@ include file="../common/Adminheader.jsp" %>
<hr style="clear:both;">
<h1 align="center">공지사항목록관리페이지</h1>
<h1 align="center">게시글 수 : <%=listCount %></h1>
<table align="center" border="1" width="600" cellspacing="0" cellpadding="0" >
	<tr>
		<th></th>
		<th>제목</th>
		<th>작성자</th>
		<th>등록일자</th>
		<th>조회수</th>
	</tr>
	<% for(int i = 0; i < nList.size(); i++){ %>
	<tr>
		<td><%= nList.get(i).getNoticeNo() %></td>
		<td><a href="/math/ndetail?no=<%=nList.get(i).getNoticeNo()%>"><%= nList.get(i).getNoticeTitle() %></a></td>
		<td><%= nList.get(i).getWriterName() %></td>
		<td><%= nList.get(i).getNoticeDate() %></td>
		<td><%= nList.get(i).getNoticeCount() %></td>
	</tr>
	<% } %>
	<tr>
		<th colspan="5"><a href="/math/views/notice/noticeWriteView.jsp">글쓰기</a></th>
	</tr>
</table>
<br>
<div style="text-align:center">
	<% if(currentPage <= 1){ %>
		▼맨처음▲&nbsp;
	<% }else if(searchTitle != null){ %>
		<a href="/math/nsearcht?page=1&title=<%=searchTitle%>">▼맨처음▲</a>
	<% }else{ %>
		<a href="/math/nlist?page=1">▼맨처음▲</a>&nbsp;
	<%} if((currentPage - 5) <= startPage && (endPage - 5) >= 1){ %>
		<a href="/math/nlist?page=<%= (startPage - 5) + 4   %>">▼이전▲</a>&nbsp;
	<% }else{%>
		▼이전▲
	<%} for(int p = startPage; p <= endPage; p++){ 
			if(p == currentPage){%>
				<font>[<%=p %>]</font>
			<%}else if(searchTitle != null){ %>
				<a href="/math/nsearcht?page=<%=p%>&title=<%=searchTitle%>"><%=p %></a>
				<%}else{ %>
				<a href="/math/nlist?page=<%=p%>"><%=p %></a>
	<% }} %>
	<% if((startPage + 5) <= maxPage && (currentPage + 5) >= startPage){ %>
		<a href="/math/nlist?page=<%=startPage + 5%>">&nbsp;▼다음▲</a>
	<% }else{ %>
		▼다음▲&nbsp;
	<%} if(currentPage >= maxPage){ %>
		&nbsp;▼마지막▲
	<% }else if(searchTitle != null){ %>
		<a href="/math/nsearcht?page=<%=maxPage%>&title=<%=searchTitle%>">&nbsp;▼마지막▲</a>
	<% }else{ %>
		<a href="/math/nlist?page=<%=maxPage%>">&nbsp;▼마지막▲</a>
	<%} %>
</div>
<div align="center">
<form action="/math/nsearcht?page=1" method="post">
	<select>
		<option value="">선택하시오</option>
		<option name="title" value="title">제목</option>
	</select>
	&nbsp;
	<input type="text" name="title">
	<input type="submit" value="검색">
</form>
</div>
<%@ include file="../common/footer.jsp" %>
</body>
</html>