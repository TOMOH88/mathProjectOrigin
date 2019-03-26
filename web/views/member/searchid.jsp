<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/math/resources/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">

function searchid() {
	var phone = $("#phone").val();
	
	num = /^[0-9]+$/;
	if(!num.test(phone)){
		alert("숫자만 입력해주세요");
		phone = "";
		phone.focus();
		return;
	}else{
		$.ajax({
			url: "/math/semail",
			type: "post",
			data: {phone : $("#phone").val()},
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
}
</script>
</head>
<body>
<h1>아이디 찾기</h1>
전화번호 입력:<input type="text" name="phone" id="phone"></input><button onclick="searchid();"></button>
</body>
</html>