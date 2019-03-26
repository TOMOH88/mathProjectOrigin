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
		if(confirm("적용하시겠습니까?")){
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
		}else{
			return false;
			}
		}
};

function sendmail(){
	if(confirm("적용하시겠습니까?")){
	$.ajax({
		url: "/math/sendemail",
		type: "post",
		data: {userid: $("#userid").val()},
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
	}else{
		return false;	
	}
	};
</script>
</head>
<body>
<%@ include file="../common/Adminheader.jsp" %>
<hr style="clear:both;">

<table border="1" cellspacing="0">
<tr><td>회원 아이디 </td><th><input type="text" id="userid" value="<%=member.getUserId()%>" readonly="readonly"></th></tr>
<tr><td>회원 이름</td><th><%=member.getUserName() %></th></tr>
<tr><td>전화번호</td><th><%=member.getPhone() %></th></tr>
<tr><td>비밀번호</td><th><input type="password" name="password" id="password" value="<%=member.getUserPwd() %>"></th></tr>
<tr><td>비밀번호 확인</td><th><input type="password" name="password" id="password1" value="<%=member.getUserPwd() %>"></th></tr>
<tr><td colspan="2"><button onclick="changePwd();">변경</button>&nbsp;&nbsp;<button onclick="sendmail();">비밀번호 초기화</button></td></tr>
<tr><td>가입일</td><th><%=member.getRegistDate() %></th></tr>
</table>

<%@ include file="../common/footer.jsp" %>
</body>
</html>