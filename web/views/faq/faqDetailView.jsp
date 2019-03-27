<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="faq.model.vo.Faq" %>    
<%
	Faq faq = (Faq)request.getAttribute("faq");
	int faqNext = ((Integer)request.getAttribute("faqNext")).intValue();
	int faqMin = ((Integer)request.getAttribute("faqMin")).intValue();
	int currentPage = ((Integer)request.getAttribute("currentPage")).intValue();
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FAQ상세페이지</title>
<script type="text/javascript">
	function faqUpView(){
		location.href="/math/fupview?no="+<%=faq.getFaqNo()%>+"&page="+<%=currentPage%>;
	}
	function faqDelete(){
		if(confirm("정말 삭제하시겠습니까?") == true){
			location.href=location.href = "/math/fdelete?no="+<%=faq.getFaqNo() %>;
		}else {
			return;
		}
	}
	function faqList(){
		location.href="/math/fslist?page="+<%=currentPage%>;
	}
</script>
</head>
<body>
<%@ include file="../common/Adminheader.jsp" %>
<hr style="clear:both;">
<H1 align="center">FAQ <%=faq.getFaqNo()%>번 상세페이지</H1>
<table align="center" cellspacing="0" width="800">
	<tr>
		<th>제목</th>
		<td><%=faq.getQuestionContent() %></td>
	</tr>
	<tr>
		<th>작성자</th>
		<td><%=faq.getAdminId() %></td>
	</tr>
	<tr>
		<th>내용</th>
		<td><%=faq.getAnswerContent() %></td>
	</tr>
</table>
<button onclick="faqUpView();">글수정</button>
<button onclick="faqDelete();">글삭제</button>
<button onclick="faqList();">목록으로가기</button>
<% if(faq.getFaqNo() > faqMin){ %>
<button onclick="javascript:location.href='/math/fback?no=<%=faq.getFaqNo()%>'">이전글</button>
<% } if(faq.getFaqNo() < faqNext){%>
<button onclick="javascript:location.href='/math/fnext?no=<%=faq.getFaqNo()%>'">다음글</button>
<% } %>
</body>
</html>