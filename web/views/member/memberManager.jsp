<%@page import="member.model.vo.Member"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% ArrayList<Member> list = (ArrayList<Member>)request.getAttribute("list"); 
	 String admin = (String)session.getAttribute("admin"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="../common/Adminheader.jsp" %>
<div class="content">
        <div class="container-fluid">
          <div class="card">
            <div class="card-header card-header-primary">
              <h4 class="card-title">회원관리</h4>
              <p class="card-category">현재인원수</p>
            </div>
            <div class="card-body">
              <div id="typography">
                <div class="card-title">
<table class="table">
<tr><td>회원 아이디 </td><td>회원 이름</td><td>가입일</td></tr>
<%for(Member m : list){ %>
<tr><th><%=m.getUserId() %> </th><th><a href="/math/mdetail?userid=<%=m.getUserId() %>"><%=m.getUserName() %></a></th><th><%=m.getRegistDate() %></th></tr>
<%} %>
</table>
</div>
</div>
</div>
</div>
</div>
</div>
<%@ include file="../common/footer.jsp" %>
</body>
</html>