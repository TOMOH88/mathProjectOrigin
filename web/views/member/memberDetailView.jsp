<%@page import="member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% Member member = (Member)request.getAttribute("member"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>감성수학</title>
<script type="text/javascript" src="/math/resources/js/jquery-3.3.1.min.js"></script>
 <script type="text/javascript">
$(function() {
	$("#password1").blur(function() {
		console.log("포커스 사라짐");
		var pwd1 = $("#password").val();
		var pwd2 = $("#password1").val();
		if(pwd1 != pwd2){
			alert("암호와 암호 확인이 일치하지 않습니다.\n"
					+"다시 입력하십시요.");
			$("#password").select();
		}
	});
});
</script>
</head>
<body>
<%@ include file="../common/header.jsp" %>
<form action="/math/mupdate" method="post">
<table align="center"> 
<tr><td>아이디</td><th><input type="text" name="userid" value="<%=member.getUserId()%>" readonly="readonly"></th></tr>
<tr><td>비밀번호</td><th><input type="password" id="password" name="password" value="<%=member.getUserPwd()%>"></th></tr>
<tr><td>비밀번호</td><th><input type="password" id="password1" value="<%=member.getUserPwd()%>"></th></tr>
<tr><td>이름</td><th><input type="text" name="username" value="<%=member.getUserName()%>" readonly="readonly"></th></tr>
<tr><td>전화번호</td><th><input type="text" name="phone" value="<%=member.getPhone()%>" ></th></tr>
<tr><td>가입일</td><th><input type="text" value="<%=member.getRegistDate()%>" readonly="readonly"></th></tr>
<tr><td colspan="2"><input type="submit" value="수정하기"/></td></tr>

</table>
</form>
<%@ include file="../common/footer.jsp" %>
</body>
</html>