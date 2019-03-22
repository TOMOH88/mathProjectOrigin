<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="notice.model.vo.Notice"  %>    
<%
	Notice notice = (Notice)request.getAttribute("notice");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>공지사항 글쓰기</title>
</head>
<body>
<%@ include file="../common/Adminheader.jsp" %>
 <div class="content">
        <div class="container-fluid">
          <div class="card">
            <div class="card-header card-header-primary">
              <h4 class="card-title">공지사항</h4>
              <p class="card-category">공지사항 작성</p>
            </div>
            <div class="card-body">
              <div id="typography">
                <div class="card-title">
<form action="/math/nwrite" method="post" enctype="multipart/form-data">
<table class="table">
<input type="hidden" name="writer" value="" class="form-control">
	<tr>
	</tr>
		<th>제목</th>
		<td><input type="text" name="title" class="form-control"></td>
	</tr>
	<tr>
		<th>내용</th>
		<td>
		<label for="exampleFormControlTextarea1">내용작성</label>
		<textarea id="exampleFormControlTextarea1" rows="3"  name="content" class="form-control"></textarea></td>
	</tr>
	<tr>
		<th>첨부파일</th>
		<td><input type="file" name="upfile" class="form-control"></td>
	</tr>
</table>
<div style="text-align:center;">
			<input type="submit" value="글 등록" class="btn btn-default">
			<input type="reset" value="작성취소" class="btn btn-default">
			<button onclick="javascript:location.href='/math/nslist'; return false;" class="btn btn-default">목록가기</button>
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