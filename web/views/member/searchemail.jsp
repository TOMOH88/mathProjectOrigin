<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  <!--     Fonts and icons     -->
  <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
  <!-- Material Kit CSS -->
  <link href="/math/resources/assets/css/material-dashboard.css?v=2.1.1" rel="stylesheet" />
<title>Search Email</title>
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
			type: "get",
			data: {phone : $("#phone").val()},
			success: function(data) {
				console.log(data)
				if(data=="no"){
				$("#p1").html("검색결과 없음");
				}else{
				var jsonStr = JSON.stringify(data);
				var json = JSON.parse(jsonStr);
				var values = "<tr><td>아이디</td></tr>";
				for(var i in json.list){
						values += "<tr><td>" + json.list[i].email+"</td></tr>";
				}
				
				$("#p1").html($("#p1").html() + values);
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
<div align="center">
<h3>아이디 찾기</h1>
<div class="container">
전화번호 입력:<input type="text" name="phone" id="phone" class="form-control" style="width:140px;"></input><button onclick="searchid();" class="btn btn-default btn-sm">확인</button>
</div>
<div>
<table id="p1" class="table">
</table>
</div>
</body>
</html>