<%@page import="member.model.vo.Semester"%>
<%@page import="java.util.ArrayList"%>
<%@page import="member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% Member member = (Member)request.getAttribute("member");
	ArrayList<Semester> mypermi = (ArrayList<Semester>)request.getAttribute("permission");
	ArrayList<Semester> slist = (ArrayList<Semester>)request.getAttribute("semester");
	

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css?family=Jua" rel="stylesheet">
<title>회원관리 : 감성수학</title>
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
function goSubmit() {
	if(confirm("적용하시겠습니까?")){
		console.log("확인");
		$("#myinfoporm").submit();
		return false;
	}else{
		console.log("노");
		window.location.reload();
		return; 
	}
    
}; 

</script>
</head>
<style>
table{
	font-family: 'Jua', sans-serif;
}

div > h4{
	font-family: 'Jua', sans-serif;
}

div > p{
	font-family: 'Jua', sans-serif;
}

ul {
	font-family: 'Jua', sans-serif;
}

#d1{
	font-family: 'Jua', sans-serif;
}
</style>
<body>
<%@ include file="../common/header.jsp" %>
<div class="page-header header-filter" data-parallax="true" style="background-image: url('/math/resources/images/math-3986758_1920.jpg')">
    <div class="container">
      <div class="row">
        <div class="col-md-8 ml-auto mr-auto">
          <div class="brand text-center">
	        <%if(userId != null){ %>
	        <h1>마이페이지</h1>
	        <%}else{ %>
			<h1>로그인해주세요</h1>
			<%} %>
            <h3 class="title text-center">회원정보수정</h3>
          </div>
        </div>
      </div>
    </div>
  </div>
<%if(userId != null){ %>
   <div class="main main-raised">
    <div class="container">
      <div class="section text-center">
<form action="/math/mupdate" method="post" id="myinfoporm" onsubmit="false check()">
<table class="table"> 
<tr><th>아이디</th><th><input type="text" id="userid" name="userid" value="<%=member.getUserId()%>" readonly="readonly" class="form-control"></th></tr>
<tr><th>비밀번호</th><th><input type="password" id="password" name="password" value="<%=member.getUserPwd()%>" class="form-control"></th></tr>
<tr><th>비밀번호</th><th><input type="password" id="password1" value="<%=member.getUserPwd()%>" class="form-control"></th></tr>
<tr><th>이름</th><th><input type="text" name="username" value="<%=member.getUserName()%>" class="form-control"></th></tr>
<tr><th>전화번호</th><th><input type="text" name="phone" value="<%=member.getPhone()%>" class="form-control"></th></tr>
<tr><th>가입일</th><th><input type="text" value="<%=member.getRegistDate()%>" readonly="readonly" class="form-control"></th></tr>
<% if(member.getMemberLevel().equals("1")){ %>
<tr><th>회원 등급</th><td>정회원</td></tr>
<%}else{ %>
<tr><th>회원 등급</th><td>준회원</td></tr>
<%} %>
<tr><th>문제집 권한목록</th>
<td>
<div id="permission"></div>
<% if(mypermi.size()==0){ %>
가지고있는 권한이 없습니다.
<%}else if(slist.size()==mypermi.size()){%>
모든 권한을 가지고 있습니다.
<%}else{ 
	for(int i =0 ; i<mypermi.size();i++){
%>
<%=mypermi.get(i).getSemesterName() %>
<%if((i+1)%4==0){
	out.print("<br>");
}}}
%>
</td></tr>
<tr><th colspan="2"><input type="button" onclick="goSubmit();" value="변경하기" class="btn btn-default btn-sm"></th></tr>
</table>
</form>
<%}%>

</div>
</div>
</div>
<%@ include file="../common/ufooter.jsp" %>
</body>
</html>