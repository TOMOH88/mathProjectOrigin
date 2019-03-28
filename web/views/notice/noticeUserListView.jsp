<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, notice.model.vo.Notice" %>    
<%
	ArrayList<Notice> nsList = (ArrayList<Notice>)request.getAttribute("nslist");
	int allSearchListCount = ((Integer)request.getAttribute("allSearchListCount")).intValue();
	int currentPage = ((Integer)request.getAttribute("currentPage")).intValue();
	int startPage = ((Integer)request.getAttribute("startPage")).intValue();
	int endPage = ((Integer)request.getAttribute("endPage")).intValue();
	int maxPage = ((Integer)request.getAttribute("maxPage")).intValue();
	String searchTitle = (String)request.getAttribute("searchTitle");
	String nOption = (String)request.getAttribute("noption");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항목록페이지</title>
<script type="text/javascript" src="/math/resources/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
</script>
</head>
<body>
<%@ include file="../common/header.jsp" %>
<hr style="clear:both;">
<h1  align="center">공지사항관리목록</h1>
<h1 align="center">게시글 수 : <%=allSearchListCount %></h1>
<table align="center" width="500" border="1" cellspacing="0" id="ts1">
	<tr>
		<th></th>
		<th>제목</th>
		<th>작성자</th>
		<th>등록일자</th>
		<th>조회수</th>
	</tr>
	<% for(int n = 0; n < nsList.size(); n++){ %>
	<tr>
		<td><%=nsList.get(n).getNoticeNo() %></td>
		<td><a href="/math/nudetail?no=<%=nsList.get(n).getNoticeNo()%>&page=<%=currentPage%>"><%=nsList.get(n).getNoticeTitle() %></a></td>
		<td><%=nsList.get(n).getWriterName() %></td>
		<td><%=nsList.get(n).getNoticeDate() %></td>
		<td><%=nsList.get(n).getNoticeCount() %></td>
	</tr>
	<% } %>
</table>
<div style="text-align:center">
	<% if(currentPage <= 1){ %>
		[맨처음]
	<% }else if(searchTitle != null){ %>
		<a href="/math/nuslist?page=1&title=<%=searchTitle%>&noption=<%=nOption%>">[맨처음]</a>
	<% }else{ %>
		<a href="/math/nuslist?page=1">[맨처음]</a>
	<%} if((currentPage - 5) <= startPage && (endPage - 5) >= 1){ %>
		<a href="/math/nuslist?page=<%= (startPage - 5) + 4   %>&title=<%=searchTitle%>&noption=<%=nOption%>">[이전]</a>
	<% }else{%>
		[이전]
	<%} for(int p = startPage; p <= endPage; p++){ 
			if(p == currentPage){%>
				<font>[<%=p %>]</font>
			<%}else if(searchTitle != null && nOption != null){ %>
				<a href="/math/nuslist?page=<%=p%>&title=<%=searchTitle%>&noption=<%=nOption%>"><%=p %></a>
				<%}else{ %>
				<a href="/math/nuslist?page=<%=p%>"><%=p %></a>
	<% }} %>
	<% if((startPage + 5) <= maxPage && (currentPage + 5) >= startPage){ %>
		<a href="/math/nuslist?page=<%=startPage+5%>&title=<%=searchTitle %>&noption=<%=nOption%>">[다음]</a>
	<%}else{ %>
		[다음]
	<%} %>
	<% if(currentPage >= maxPage){ %>
		[마지막]
	<% }else if(searchTitle != null){ %>
		<a href="/math/nuslist?page=<%=maxPage%>&title=<%=searchTitle%>&noption=<%=nOption%>">[마지막]</a>
	<% }else{ %>
		<a href="/math/nuslist?page=<%=maxPage%>">[마지막]</a>
	<%} %>
</div>
<div align="center">
<form action="/math/nuslist?page=1" method="post" >
	<select name="noption">
		<option value="">선택하세요</option>
		<option name="ntitle" value="ntitle" >제목</option>
		<option name="ntContent" value="ntContent">제목+내용</option>
	</select>
	&nbsp;
	<input type="text" name="title" >
	<input type="submit" value="검색" >
</form>
</div>
<%@ include file="../common/footer.jsp" %>
</body>
</html>