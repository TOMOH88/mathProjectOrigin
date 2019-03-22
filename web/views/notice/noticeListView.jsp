<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, notice.model.vo.Notice" %>    
<%
	ArrayList<Notice> nsList = (ArrayList<Notice>)request.getAttribute("nslist");
	int AllSearchListCount = ((Integer)request.getAttribute("AllSearchListCount")).intValue();
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
<meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  <!--     Fonts and icons     -->
  <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
  <!-- Material Kit CSS -->
  <link href="/math/resources/assets/css/material-dashboard.css?v=2.1.1" rel="stylesheet" />
</head>
<style>
.box1 ul li{
	text-align:center;
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
                  <h4 class="card-title ">공지사항</h4>
                  <p class="card-category"> 현재 게시글 수 : <%=AllSearchListCount %></p>
                </div>
                <div class="card-body">
                  <div class="table-responsive">
                    <table class="table">
                      <thead class=" text-primary">
                        <th>
                          글번호
                        </th>
                        <th>
                          제목
                        </th>
                        <th>
                          작성자
                        </th>
                        <th>
                          등록일자
                        </th>
                      </thead>
                      <tbody>
                        <tr>
                        <% for(int n = 0; n < nsList.size(); n++){ %>
                          <td>
                          <%=nsList.get(n).getNoticeNo() %>
                          </td>
                          <td>
                          <a href="/math/ndetail?no=<%=nsList.get(n).getNoticeNo()%>"><%=nsList.get(n).getNoticeTitle() %></a>
                          </td>
                          <td>
                          <%=nsList.get(n).getWriterName() %>
                          </td>
                          <td>
                          <%=nsList.get(n).getNoticeDate() %>
                          </td>
                        </tr>
                        <% } %>
                      </tbody>
                    </table>
                    <center>
                    <div class="col-md-6">
                    <ul class="pagination pagination-primary">
	<% if(currentPage <= 1){ %>
	<li class="page-item">
		<a class="page-link"> prev </a>
		</li>
	<% }else if(searchTitle != null){ %>
	<li class="page-item">
		<a href="/math/nslist?page=1&title=<%=searchTitle%>&noption=<%=nOption%>" class="page-link"> prev </a>
		</li>
	<% }else{ %>
	<li class="page-item">
		<a href="/math/nslist?page=1" class="page-link"> prev </a>
		</li>
	<%} if((currentPage - 5) <= startPage && (endPage - 5) >= 1){ %>
	<li class="page-item">
		<a href="/math/nslist?page=<%= (startPage - 5) + 4   %>&title=<%=searchTitle%>&noption=<%=nOption%>" class="page-link">[이전]</a>&nbsp;
		</li>
	<% }else{%>
	<li class="page-item">
		<a class="page-link"> [이전] </a>
		</li>
	<%} for(int p = startPage; p <= endPage; p++){ 
			if(p == currentPage){%>
			<li class="page-item">
				<a class="page-link"><font><%=p %></font></a>
				</li>
			<%}else if(searchTitle != null && nOption != null){ %>
			<li class="page-item">
				<a href="/math/nslist?page=<%=p%>&title=<%=searchTitle%>&noption=<%=nOption%>" class="page-link"><%=p %></a>
				</li>
				<%}else{ %>
				<li class="page-item">
				<a href="/math/nslist?page=<%=p%>" class="page-link"><%=p %></a>
				</li>
	<% }} %>
	<% if((startPage + 5) <= maxPage && (currentPage + 5) >= startPage){ %>
	<li class="page-item">
		<a href="/math/nslist?page=<%=startPage+5%>&title=<%=searchTitle %>&noption=<%=nOption%>" class="page-link">&nbsp;[다음]</a>
		</li>
	<%}else{ %>
	<li class="page-item">
		<a class="page-link"> [다음] </a>
		</li>
	<%} %>
	<% if(currentPage >= maxPage){ %>
	<li class="page-item">
		<a class="page-link"> next </a>
		</li>
	<% }else if(searchTitle != null){ %>
	<li>
		<a href="/math/nslist?page=<%=maxPage%>&title=<%=searchTitle%>&noption=<%=nOption%>" class="page-link"> next </a>
		</li>
	<% }else{ %>
	<li class="page-item">
		<a href="/math/nslist?page=<%=maxPage%>" class="page-link"> next </a>
		</li>
	<%} %>
	</ul>
	</center>
	<div style="float:left; margin-right:20px;">
<form action="/math/nslist?page=1" method="post" class="form-inline ml-auto">
	<select name="noption" class="form-control">
		<option value="">선택하시오</option>
		<option name="ntitle" value="ntitle" >제목</option>
		<option name="ntContent" value="ntContent">제목+내용</option>
	</select>
	&nbsp;
	&nbsp;&nbsp;
	&nbsp;
                  <div class="form-group has-black">
                    <input type="text" class="form-control" placeholder="Search" name="title">
                  </div>
                  <button type="submit" class="btn btn-black btn-raised btn-fab btn-round">
                    <i class="material-icons">search</i>
                  </button>
</form>
</div>
<div style="float:left;">
<button onclick="javascript:location.href='views/notice/noticeWriteView.jsp'" type="button" class="btn btn-primary">글쓰기</button>
</div>
</div>
                  </div>
                </div>
              </div>
            </div>
          <!-- your content here -->
        </div>
      </div>
<%@ include file="../common/footer.jsp" %>
</body>
</html>