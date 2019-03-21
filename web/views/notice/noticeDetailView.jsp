<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="notice.model.vo.Notice" %>    
<%
	Notice notice = (Notice)request.getAttribute("notice");
	String searchTitle = (String)request.getAttribute("searchTitle");
	String nOption = (String)request.getAttribute("noption");
	int noticeBack = (Integer)request.getAttribute("noticeBack");
	int noticeNext = (Integer)request.getAttribute("noticeNext");
	int noticeMin = (Integer)request.getAttribute("noticeMin");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>감성수학 관리자 상세보기창</title>
<script type="text/javascript">
</script>
</head>
<body>
<%@ include file="../common/Adminheader.jsp" %>
<h1 align="center"><%=notice.getNoticeNo() %>번 상세보기페이지</h1>
	<table border="1" cellspacing="0" width="600"  height="200" align="center">
		<tr>
			<th>제목</th>
			<td><%=notice.getNoticeTitle() %></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><%=notice.getWriterName()%></td>
		</tr>
		<tr>
			<th>글내용</th>
			<td><%=notice.getNoticeContent().replaceAll("\r\n", "<br>") %></td>
		</tr>
		<tr>
			<th>첨부파일</th>
			<td>
				<% if(notice.getOriginalFileName() != null && !notice.getOriginalFileName().equals("null")){ %>
					<a href="/math/nfdown?ofile=<%=notice.getOriginalFileName() %>&rfile=<%=notice.getRenameFileName()%>"><%=notice.getOriginalFileName() %></a>
				<% }else{ %>
					첨부파일없음
				<% } %>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<a href="/math/nupview?no=<%=notice.getNoticeNo() %>">글수정</a>
				<a href="/math/ndelete?no=<%=notice.getNoticeNo()%>">글삭제</a>
				<a href="/math/nslist">목록가기</a>
				<%if(notice.getNoticeNo() > noticeMin){ %>
					<button name="btn" onclick="javascript:location.href='/math/nback?no=<%=notice.getNoticeNo()%>'">이전글</button>
				<%} if(notice.getNoticeNo() < noticeNext){ %>
					<button name="btn" onclick="javascript:location.href='/math/nnext?no=<%=notice.getNoticeNo()%>'">다음글</button>
				<%} %>
			</td>
		</tr>
	</table>
</body>
</html>