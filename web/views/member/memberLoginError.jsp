<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
<%
    String message = (String)request.getAttribute("message");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 관련 에러!</title>
<script type="text/javascript">
window.onload = function () {
	 
	alert("<%=message %>");
	location.href="/math/views/common/login.jsp";
	}
</script>
</head>
<body>
</body>
</html>