<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="faq.model.vo.Faq" %>    
<%
	Faq faq = (Faq)request.getAttribute("faq");
	int faqNext = ((Integer)request.getAttribute("faqNext")).intValue();
	int faqMin = ((Integer)request.getAttribute("faqMin")).intValue();
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FAQ상세페이지</title>
</head>
<body>
<%@ include file="../common/Adminheader.jsp" %>
<div class="content">
        <div class="container-fluid">
          <div class="row">
            <div class="col-md-12">
              <div class="card">
                <div class="card-header card-header-primary">
                  <h4 class="card-title ">FAQ</h4>
                  <p class="card-category"> FAQ <%=faq.getFaqNo()%>번글 상세페이지</p>
                </div>
                <div class="card-body">
                  <div class="table-responsive">
                    <table class="table" id="faqTable">
                      <thead class=" text-primary">
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
	</thead>
</table>
<div align="center">
<button onclick="javascript:location.href='/math/fupview?no=<%=faq.getFaqNo()%>'" class="btn btn-default btn-sm">글수정</button>
<button onclick="javascript:location.href='/math/fdelete?no=<%=faq.getFaqNo() %>'" class="btn btn-default btn-sm">글삭제</button>
<% if(faq.getFaqNo() > faqMin){ %>
<button onclick="javascript:location.href='/math/fback?no=<%=faq.getFaqNo()%>'" class="btn btn-default btn-sm">이전글</button>
<% } if(faq.getFaqNo() < faqNext){%>
<button onclick="javascript:location.href='/math/fnext?no=<%=faq.getFaqNo()%>'" class="btn btn-default btn-sm">다음글</button>
<% } %>
<button onclick="javascript:location.href='/math/fslist';" class="btn btn-default btn-sm">목록으로가기</button>
</div>
</div>
</div>
</div>
</div>
</div>
</div>
</div>
<%@ include file="../common/footer.jsp" %>
</body>
</html>