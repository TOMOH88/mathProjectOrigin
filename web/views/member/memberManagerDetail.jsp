<%@page import="member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% Member member = (Member)request.getAttribute("member"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>감성수학</title>
</head>
<body>
<%@ include file="../common/Adminheader.jsp" %>
<div class="content">
        <div class="container-fluid">
          <div class="card">
            <div class="card-header card-header-primary">
              <h4 class="card-title">회원정보</h4>
              <p class="card-category">회원정보수정</p>
            </div>
            <div class="card-body">
              <div id="typography">
                <div class="card-title">
<table>
<tr><td>회원 아이디 </td><td>회원 이름</td><td>가입일</td></tr>
<tr><th><%=member.getUserId() %> </th><th><%=member.getUserName() %></th><th><%=member.getRegistDate() %></th></tr>
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