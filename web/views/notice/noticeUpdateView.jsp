<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="notice.model.vo.Notice" %>    
<%
	Notice notice = (Notice)request.getAttribute("notice");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정페이지</title>
<script type="text/javascript" src="/math/resoures/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
function listView(){
	location.href = '/math/nlist';
}

</script>
</head>
<body>
<%@ include file="../common/Adminheader.jsp" %>
<hr style="clear:both;">
<h1 align="center"><%=notice.getNoticeNo() %>번 글 수정페이지</h1>
<form action="/math/nupdate" method="post" enctype="multipart/form-data">
<input type="hidden" name="no" value="<%=notice.getNoticeNo() %>">
<input type="hidden" name="ofile" value="<%=notice.getOriginalFileName() %>">
<input type="hidden" name="rfile" value="<%=notice.getRenameFileName() %>">
	<table	align="center" border="1" width="500" cellspacing="0">
		<tr>
			<th>제목</th>
			<td><input type="text" name="title" value="<%=notice.getNoticeTitle() %>"></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><input type="text" name="writer" value="<%=notice.getWriterName() %>" readonly ></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea rows="10" cols="100" name="content" class="etext"><%=notice.getNoticeContent().replaceAll("<br>","\r\n")%></textarea></td>
		</tr>
		<tr height="50">
			<th>첨부파일</th>
			<td id="filetd">
				<% if(notice.getOriginalFileName() != null && !notice.getOriginalFileName().equals("null")){ %>
					<%=notice.getOriginalFileName() %>
				<% }else{ %>
					첨부파일없음
				<% } %>&nbsp;
				<input type="file" value="첨부파일 변경"  name="upfile">
			</td>
		</tr>
		<tr>
			<th colspan="2">
				<input type="submit" value="수정하기">
				<button onclick="listView(); return false;">목록으로 돌아가기</button>
			</th>
		</tr>
	</table>
</form>
<%@ include file="../common/footer.jsp" %>
</body>
</html>