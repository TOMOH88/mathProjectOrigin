<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="notice.model.vo.Notice" %>    
<%
	Notice notice = (Notice)request.getAttribute("notice");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>수정페이지</title>
<script type="text/javascript" src="/math/resources/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
function listView(){
	location.href = '/math/nslist';
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
              <p class="card-category"><%=notice.getNoticeNo() %>번글 수정페이지</p>
            </div>
            <div class="card-body">
              <div id="typography">
                <div class="card-title">
<form action="/math/nupdate" method="post" enctype="multipart/form-data">
<input type="hidden" name="no" value="<%=notice.getNoticeNo() %>">
<input type="hidden" name="ofile" value="<%=notice.getOriginalFileName() %>">
<input type="hidden" name="rfile" value="<%=notice.getRenameFileName() %>">
	<table class="table">
	<tr>
	</tr>
		<tr>
			<th>제목</th>
			<td><input type="text" name="title" value="<%=notice.getNoticeTitle() %>"  class="form-control"></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><input type="text" name="writer" value="<%=notice.getWriterName() %>" readonly class="form-control"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td>
			<label for="exampleFormControlTextarea1">내용작성</label>
			<textarea class="form-control" id="exampleFormControlTextarea1" rows="3" name="content"><%=notice.getNoticeContent().replaceAll("<br>","\r\n")%></textarea></td>
		</tr>
		<tr height="50">
			<th>첨부파일</th>
			<td id="filetd">
				<% if(notice.getOriginalFileName() != null && !notice.getOriginalFileName().equals("null")){ %>
					<%=notice.getOriginalFileName() %>
				<% }else{ %>
					첨부파일없음
				<% } %>&nbsp;
				<input type="file" value="첨부파일 변경"  name="upfile" class="form-control">
			</td>
		</tr>
	</table>
	<div style="text-align:center;">
	<input type="submit" value="수정하기" class="btn btn-default">
				<button onclick="listView(); return false;" class="btn btn-default">목록으로 돌아가기</button>
				</div>
</form>
</div>
</div>
</div>
</div>
</div>
</div>
<%@ include file="../common/footer.jsp" %>
</body>
</html>