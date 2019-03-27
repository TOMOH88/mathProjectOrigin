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
   <div class="content">
        <div class="container-fluid">
          <div class="card">
            <div class="card-header card-header-primary">
              <h4 class="card-title">QnA</h4>
               <p class="card-category">현재게시글 수 : <%= allSearchListCount %></p>
            </div>
            <div class="card-body">
              <div id="typography">
                <div class="card-title">
                <table class="table">
                <thead class="text-primary">
	<tr>
		<th></th>
		<th>질문내용</th>
		<th>작성자</th>
		<th>등록일자</th>
	</tr>
	</thead>
	<% for(Qna qna : qList){ %>
	<tr>
		<td><%=qna.getQnaNo() %></td>
		<%if(qna.getQnaLevel() == 0){ %>
			<td><a href="/math/qdetail?no=<%=qna.getQnaNo()%>"><%=qna.getQnaTitle() %></a></td>
		<%} else { %>
			<td><a href="/math/qdetail?no=<%=qna.getQnaNo()%>">[re]<%=qna.getQnaTitle() %></a></td>
		<%} %>
		<td><%=qna.getAdminId() %></td>
		<td><%=qna.getQnaDate() %></td>
	</tr>
	<% } %>
</table>
<ul class="pagination pagination-primary" style="justify-content: center;">
	<% if(currentPage <= 1){ %>
	<li class="page-item">
		<a class="page-link"> [맨처음] </a>
		</li>
	<% }else if(searchTitle != null){ %>
	<li class="page-item">
		<a href="/math/qslist?page=1&title=<%=searchTitle%>&qOption=<%=qOption%>" class="page-link">[맨처음]</a>
		</li>
	<% }else{ %>
	<li class="page-item">
		<a href="/math/qslist?page=1" class="page-link">[맨처음]</a>
		</li>
	<%} if((currentPage - 5) <= startPage && (endPage - 5) >= 1){ %>
	<li class="page-item">
		<a href="/math/qslist?page=<%= (startPage - 5) + 4   %>&title=<%=searchTitle%>&qOption=<%=qOption%>" class="page-link">[이전]</a>
		</li>
	<% }else{%>
	<li class="page-item">
		<a class="page-link"> [이전] </a>
		</li>
	<%} for(int p = startPage; p <= endPage; p++){ 
			if(p == currentPage){%>
			<li class="page-item">
				<a class="page-link"> <font>[<%=p %>]</font> </a>
				</li>
			<%}else if(searchTitle != null && qOption != null){ %>
			<li class="page-item">
				<a href="/math/qslist?page=<%=p%>&title=<%=searchTitle%>&qOption=<%=qOption%>" class="page-link"><%=p %></a>
				</li>
				<%}else{ %>
				<li class="page-item">
				<a href="/math/qslist?page=<%=p%>" class="page-link"><%=p %></a>
				</li>
	<% }} %>
	<% if((startPage + 5) <= maxPage && (currentPage + 5) >= startPage){ %>
	<li class="page-item">
		<a href="/math/qslist?page=<%=startPage+5%>&title=<%=searchTitle %>&qOption=<%=qOption%>" class="page-link">[다음]</a>
		</li>
	<%}else{ %>
	<li class="page-item">
		<a class="page-link"> [다음] </a>
		<li>
	<%} %>
	<% if(currentPage >= maxPage){ %>
	<li class="page-item">
		<a class="page-link"> [마지막] </a>
		</li>
	<% }else if(searchTitle != null){ %>
	<li class="page-item">
		<a href="/math/qslist?page=<%=maxPage%>&title=<%=searchTitle%>&qOption=<%=qOption%>" class="page-link">[마지막]</a>
		</li>
	<% }else{ %>
	<li class="page-item">
		<a href="/math/qslist?page=<%=maxPage%>" class="page-link">[마지막]</a>
		</li>
	<%} %>
</ul>
<div align="center">
<form action="/math/qslist" method="post" class="form-inline ml-auto">
<div class="container" >
<select name="qOption" class="form-control">
	<option value="">선택하세요</option>
	<option name="qTitle" value="qTitle">제목</option>
	<option name="qTContent" value="qTContent">제목+내용</option>
	<option name="qnaUser" value="qUserId">작성자</option>
</select>
<input type="text" name="title" class="form-control" placeholder="Search">
	<button type="submit" class="btn btn-white btn-raised btn-fab btn-round">
                    <i class="material-icons">search</i>
                  </button>
                  </div>
</div>
</form>
</div>
<div align="center">
</div>
</div>
</div>
</div>
</div>
</div>
<%@ include file="../common/footer.jsp" %>
</body>
</html>