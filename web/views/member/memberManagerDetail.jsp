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
<hr style="clear:both;">

<table>
<tr><td>회원 아이디 </td><td>회원 이름</td><td>가입일</td></tr>
<tr><th><%=member.getUserId() %> </th><th><%=member.getUserName() %></th><th><%=member.getRegistDate() %></th></tr>
</table>

<%@ include file="../common/footer.jsp" %>
</body>
</html>