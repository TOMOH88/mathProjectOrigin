<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//스크립트릿(scriptlet) 태그 영역
	//자바 코드 작성 영역임
	String message = (String)request.getAttribute("message");
%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/math/resources/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		alert("<%= message %>");
		history.go(-1);
	});
</script>
</head>
<body>
</body>
</html>