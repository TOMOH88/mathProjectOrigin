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
<hr style="clear:both;">

<%if(admin != null){ %>
<table>
<tr><td>회원 아이디 </td><td>회원 이름</td><td>가입일</td></tr>
<%for(Member m : list){ %>
<tr><th><%=m.getUserId() %> </th><th><a href="/math/mdetail?userid=<%=m.getUserId() %>"><%=m.getUserName() %></a></th><th><%=m.getRegistDate() %></th></tr>
<%} %>
</table>
<%}else{ %>
<h1>로그인 해주세요</h1>
<%} %>

<%@ include file="../common/footer.jsp" %>
</body>
</html>