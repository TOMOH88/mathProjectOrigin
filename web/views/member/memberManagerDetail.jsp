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
/* $(function() {
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
}); */
function changePwd() {
	var pwd1 = $("#password").val();
	var pwd2 = $("#password1").val();
	if(pwd1 != pwd2){
		alert("암호와 암호 확인이 일치하지 않습니다.\n"
				+"다시 입력하십시요.");
		$("#password").select();
	}else{
		$.ajax({
			url: "/math/mpwdchange",
			type: "post",
			data: {password : $("#password").val(),
				userid: $("#userid").val()},
			success: function(data) {
					if(data == "ok"){
						alert("변경되였습니다.");
					}else{
						alert("변경실패!");
					}
			},
			error: function( jqXHR, textStatus, errorThrown) {
				console.log("error : "+  jqXHR +", "+textStatus+", "+errorThrown);
			}
		});
	}
};
</script>
</head>
<body>
<%@ include file="../common/Adminheader.jsp" %>
<<<<<<< HEAD
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
=======
<hr style="clear:both;">

<table border="1" cellspacing="0">
<tr><td>회원 아이디 </td><th><input type="text" id="userid" value="<%=member.getUserId()%>" readonly="readonly"></th></tr>
<tr><td>회원 이름</td><th><%=member.getUserName() %></th></tr>
<tr><td>전화번호</td><th><%=member.getPhone() %></th></tr>
<tr><td>비밀번호</td><th><input type="password" name="password" id="password" value="<%=member.getUserPwd() %>"></th></tr>
<tr><td>비밀번호 확인</td><th><input type="password" name="password" id="password1" value="<%=member.getUserPwd() %>"><button onclick="changePwd();">변경</button></th></tr>
<tr><td>가입일</td><th><%=member.getRegistDate() %></th></tr>
>>>>>>> b68da3285039aad70a53f42e6a653fdb7a1cb7e9
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