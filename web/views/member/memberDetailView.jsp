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
<title>감성수학</title>
<meta charset="utf-8">
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
  <div class="page-header header-filter" data-parallax="true" style="background-image: url('/math/resources/images/math-3986758_1920.jpg')">
    <div class="container">
      <div class="row">
        <div class="col-md-8 ml-auto mr-auto">
          <div class="brand text-center">
          <h1>마이페이지</h1>
            <h3 class="title text-center">회원정보수정</h3>
          </div>
        </div>
      </div>
    </div>
  </div>
   <div class="main main-raised">
    <div class="container">
      <div class="section text-center">
<form action="/math/mupdate" method="post">
<table align="center" class="table"> 
<tr><td>아이디</td><th><input type="text" id="userid" name="userid" value="<%= member.getUserId()%>" readonly="readonly" class="form-control"></th></tr>
<tr><td>비밀번호</td><th><input type="password" id="password" name="password" value="<%=member.getUserPwd()%>" class="form-control"></th></tr>
<tr><td>비밀번호</td><th><input type="password" id="password1" value="<%= member.getUserPwd()%>" class="form-control"></th></tr>
<tr><td>이름</td><th><input type="text" name="username" value="<%= member.getUserName()%>" class="form-control"></th></tr>
<tr><td>전화번호</td><th><input type="text" name="phone" value="<%= member.getPhone()%>"  class="form-control"></th></tr>
<tr><td>가입일</td><th><input type="text" value="<%= member.getRegistDate()%>" readonly="readonly" class="form-control"></th></tr>
<tr><td colspan="2">문제집 권한목록</td></tr>
<tr><td colspan="2">
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
</table>
<input type="submit" value="수정하기" class="btn btn-default btn-sm">
</form>
</div>
    </div>
  </div>
<%@ include file="../common/ufooter.jsp" %>
</body>
</html>