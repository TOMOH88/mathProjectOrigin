<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String value = request.getParameter("images");
	String link = request.getParameter("imglink");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>감성수학</title>
<script type="text/javascript" src="/math/resources/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">

</script>
</head>
<body>

<a href="http://<%= link %>"><img src="/math/files/popup/<%= value %>"></a>

</body>
</html>

