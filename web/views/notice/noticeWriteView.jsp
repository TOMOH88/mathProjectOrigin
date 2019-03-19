<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="notice.model.vo.Notice"  %>    
<%
	Notice notice = (Notice)request.getAttribute("notice");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 글쓰기</title>
</head>
<body>
<%@ include file="../common/Adminheader.jsp" %>
<hr style="clear:both;">
<h1 align="center">공지사항 글쓰기</h1>
<form action="/math/nwrite" method="post" enctype="multipart/form-data">
<table align="center" width="800" cellspacing="0">
<input type="hidden" name="writer" value="">
	<tr>
		<th>제목</th>
		<td><input type="text" name="title" ></td>
	</tr>
	<tr>
		<th>내용</th>
		<td><textarea rows="10" cols="100" name="content"></textarea></td>
	</tr>
	<tr>
		<th>첨부파일</th>
		<td><input type="file" name="upfile"></td>
	</tr>
	<tr>
		<th colspan="2">
			<input type="submit" value="글 등록">
		</th>
	</tr>
</table>
</form>
<%@ include file="../common/footer.jsp" %>
</body>
</html>