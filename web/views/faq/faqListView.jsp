<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, faq.model.vo.Faq" %>    
<%
	ArrayList<Faq> fList = (ArrayList<Faq>)request.getAttribute("fList"); 
	int currentPage = ((Integer)request.getAttribute("currentPage")).intValue();
	int startPage = ((Integer)request.getAttribute("startPage")).intValue();
	int endPage = ((Integer)request.getAttribute("endPage")).intValue();
	int maxPage = ((Integer)request.getAttribute("maxPage")).intValue();
	int limit = ((Integer)request.getAttribute("limit")).intValue();
	int allSearchListCount = ((Integer)request.getAttribute("allSearchListCount")).intValue();
	String searchTitle = (String)request.getAttribute("searchTitle");
	String fOption = (String)request.getAttribute("fOption");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>faq목록페이지</title>
<script type="text/javascript">
function faqWrite(){
	location.href = "/math/views/faq/faqWriteView.jsp";
}
</script>
</head>
<body>
<%@ include file="../common/Adminheader.jsp" %>
<hr style="clear:both;">
<h1>총 게시물 수 : <%=allSearchListCount %></h1>
<<<<<<< HEAD
<table align="center" border="1"  width="600"  cellspacing="0" id="faqTable">
=======
<table align="center" border="1"  width="600"  cellspacing="0" >
>>>>>>> ysy2
	<tr>
		<th></th>
		<th>글제목</th>
		<th>등록일자</th>
	</tr>
	<% for(int i =0; i < fList.size(); i++){ %>
	<tr>
		<td><%=fList.get(i).getFaqNo() %></td>
<<<<<<< HEAD
		<td><a href="/math/fdetail?no=<%=fList.get(i).getFaqNo()%>"><%=fList.get(i).getQuestionContent() %></a></td>
=======
		<td><a href="/math/fdetail?no=<%=fList.get(i).getFaqNo()%>&page=<%=currentPage%>"><%=fList.get(i).getQuestionContent() %></a></td>
>>>>>>> ysy2
		<td><%=fList.get(i).getFaqDate() %></td>
	</tr>
	<% } %>
</table>
<div style="text-align:center">
	<% if(currentPage <= 1){ %>
		[맨처음]
	<% }else if(searchTitle != null){ %>
		<a href="/math/fslist?page=1&title=<%=searchTitle%>&fOption=<%=fOption%>">[맨처음]</a>
	<% }else{ %>
		<a href="/math/fslist?page=1">[맨처음]</a>
	<%} if((currentPage - 5) <= startPage && (endPage - 5) >= 1){ %>
		<a href="/math/fslist?page=<%= (startPage - 5) + 4   %>&title=<%=searchTitle%>&fOption=<%=fOption%>">[이전]</a>
	<% }else{%>
		[이전]
	<%} for(int p = startPage; p <= endPage; p++){ 
			if(p == currentPage){%>
				<font>[<%=p %>]</font>
			<%}else if(searchTitle != null && fOption != null){ %>
				<a href="/math/fslist?page=<%=p%>&title=<%=searchTitle%>&fOption=<%=fOption%>"><%=p %></a>
				<%}else{ %>
				<a href="/math/fslist?page=<%=p%>"><%=p %></a>
	<% }} %>
	<% if((startPage + 5) <= maxPage && (currentPage + 5) >= startPage){ %>
		<a href="/math/fslist?page=<%=startPage+5%>&title=<%=searchTitle %>&fOption=<%=fOption%>">[다음]</a>
	<%}else{ %>
		[다음]
	<%} %>
	<% if(currentPage >= maxPage){ %>
		[마지막]
	<% }else if(searchTitle != null){ %>
		<a href="/math/fslist?page=<%=maxPage%>&title=<%=searchTitle%>&fOption=<%=fOption%>">[마지막]</a>
	<% }else{ %>
		<a href="/math/fslist?page=<%=maxPage%>">[마지막]</a>
	<%} %>
</div>
<form action="/math/fslist?page=1" method="post">
<div>
	<select name="fOption">
		<option value="">선택하세요</option>
		<option name="fTitle" value="fTitle">제목</option>
		<option name="fTContent" value="fTContent">제목+내용</option>
	</select>
	&nbsp;
	<input type="text" name="title">
	<input type="submit" value="검색">
</div>
</form>
<button id="faqBtn" onclick="faqWrite();">글쓰기</button>
<%@ include file="../common/footer.jsp" %>
</body>
</html>