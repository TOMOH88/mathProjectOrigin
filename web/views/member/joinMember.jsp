<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>감성수학</title>
<script type="text/javascript" src="/math/resources/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
function checkId() {
	$.ajax({
		url: "/math/chkid",
		type: "post",
		data: {userid: $("#email").val()},
		success: function(data) {
				console.log("success : "+ data);
				if(data == "ok"){
					alert("사용 가능한 아이디입니다.");
					$("#password").focus();
				}else{
					alert("이미 사용중인 아이디입니다.\n"
							+"다시 입력하십시요.");
					$("#email").select();
				}
		},
		error: function( jqXHR, textStatus, errorThrown) {
			console.log("error : "+  jqXHR +", "+textStatus+", "+errorThrown);
		}
	});
	return false;
}
$(function() {
	//암호확인 입력상자가 focus가 사라졌을 때
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
<div>
<form action="math/mjoin" method="post" >
<table>
<tr><td>아이디</td><th><input type="email" name="email" id="email" required="required"/></th>
						<th><button onclick="return checkId();">중복확인</button></th></tr>
<tr><td>비밀번호</td><th><input type="password" name="password" id="password"required="required"/></th></tr>
<tr><td>비밀번호 확인</td><th><input type="password" name="password1" id="password1" required="required"/></th></tr>
<tr><td>이름</td><th><input type="text" name="username" required="required"/></th></tr>
<tr><td>핸드폰</td><th><input type="tel" name="phone" required="required"/></th></tr>
<tr><td colspan="2"><input type="submit" value="회원가입" />&nbsp;&nbsp;</td></tr>
</table>
</form>
</div>
</body>
</html>