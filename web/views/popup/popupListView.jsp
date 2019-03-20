<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, popup.model.vo.Popup" %>
<% 
	ArrayList<Popup> plist = (ArrayList<Popup>)request.getAttribute("plist");
	int AllSearchListCount = ((Integer)request.getAttribute("AllSearchListCount")).intValue();
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
<title>Popup</title>
</head>
<body>
<%@ include file="../common/Adminheader.jsp" %>
<h1  align="center">팝업관리 목록</h1>
<table align="center" width="500" border="1" cellspacing="0" id="ts1">
	<tr>
		<th></th>
		<th>제목</th>
		<th>이미지</th>
		<th>등록날짜</th>
		<th>종료날짜</th>
	</tr>
	<% for(int n = 0; n < plist.size(); n++){ %>
	<tr>
		<td><%=plist.get(n).getPopupNo() %></td>
		<td><a href="/math/ndetail?no=<%=plist.get(n).getPopupName()%>"><%=plist.get(n).getPopupName() %></a></td>
		<td><%=plist.get(n).getPopupImagePath() %></td>
		<td><%=plist.get(n).getPopupDate() %></td>
		<td><%=plist.get(n).getPopupEndDate() %></td>
	</tr>
	<% } %>
</table>
<div style="text-align:center">
	<% if(currentPage <= 1){ %>
		[맨처음]&nbsp;
	<% }else if(searchTitle != null){ %>
		<a href="/math/plist?page=1&title=<%=searchTitle%>">[맨처음]</a>
	<% }else{ %>
		<a href="/math/plist?page=1">[맨처음]</a>&nbsp;
	<%} if((currentPage - 5) <= startPage && (endPage - 5) >= 1){ %>
		<a href="/math/plist?page=<%= (startPage - 5) + 4   %>&title=<%=searchTitle%>">[이전]</a>&nbsp;
	<% }else{%>
		[이전]
	<%} for(int p = startPage; p <= endPage; p++){ 
			if(p == currentPage){%>
				<font>[<%=p %>]</font>
			<%}else if(searchTitle != null){ %>
				<a href="/math/plist?page=<%=p%>&title=<%=searchTitle%>"><%=p %></a>
				<%}else{ %>
				<a href="/math/plist?page=<%=p%>"><%=p %></a>
	<% }} %>
	<% if((startPage + 5) <= maxPage && (currentPage + 5) >= startPage){ %>
		<a href="/math/plist?page=<%=startPage+5%>&title=<%=searchTitle %>">&nbsp;[다음]</a>
	<%}else{ %>
		[다음]&nbsp;
	<%} %>
	<% if(currentPage >= maxPage){ %>
		&nbsp;[마지막]
	<% }else if(searchTitle != null){ %>
		<a href="/math/plist?page=<%=maxPage%>&title=<%=searchTitle%>">&nbsp;[마지막]</a>
	<% }else{ %>
		<a href="/math/plist?page=<%=maxPage%>">&nbsp;[마지막]</a>
	<%} %>
<div align="center">
<form action="/math/plist?page=1" method="post" >
	<select>
		<option value="">선택하시오</option>
		<option name="title" value="title" >제목</option>
	</select>
	&nbsp;
	<input type="text" name="title" >
	<input type="submit" value="검색" >
</form>
<%@ include file="../common/footer.jsp" %>
</body>
</html>