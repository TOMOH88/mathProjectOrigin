<%@page import="admin.model.vo.Semester"%>
<%@page import="java.util.ArrayList"%>
<%@page import="member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% Member member = (Member)request.getAttribute("member");
	ArrayList<Semester> slist = (ArrayList<Semester>)request.getAttribute("semester");
	ArrayList<Semester> mylist = (ArrayList<Semester>)request.getAttribute("permission");
%>
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
<table class="table">
<tr></tr>
<tr><td>회원 아이디 </td><th><input type="text" id="userid" value="<%=member.getUserId()%>" readonly="readonly" class="form-control"></th></tr>
<tr><td>회원 이름</td><th><%=member.getUserName() %></th></tr>
<tr><td>전화번호</td><th><%=member.getPhone() %></th></tr>
<tr><td>비밀번호</td><th><input type="password" name="password" id="password" value="<%=member.getUserPwd() %>" class="form-control"></th></tr>
<tr><td>비밀번호 확인</td><th><input type="password" name="password" id="password1" value="<%=member.getUserPwd() %>" class="form-control"></th></tr>
<tr><td colspan="2"><button onclick="changePwd();" class="btn btn-default">변경</button>&nbsp;&nbsp;<button onclick="sendmail();" class="btn btn-default">비밀번호 초기화</button></td></tr>
<tr><td>가입일</td><th><%=member.getRegistDate() %></th></tr>
<tr><td>최종 수정일</td><th><%=member.getLastModified() %></th></tr>
<tr><td>권한 주기</td>
<th>
<Select class="form-control">
	<option selected="selected">권한 선택</option>
	<option>모든권한</option>
	<%for(Semester s : slist){ %>
	<option><%=s.getSemesterName() %></option>
	<%} %>
</Select>
<button onclick="addPermission();" class="btn btn-default btn-sm">권한추가</button>
</th></tr>
<tr><td>보유 권한</td><th>
<Select class="form-control">
	<option selected="selected" >보유 권한</option>
	<%for(Semester m : mylist){ %>
	<option><%=m.getSemesterName() %></option>
	<%} %>
</Select>
<button onclick="removePermission();" class="btn btn-default btn-sm">권한삭제</button>
</th></tr>
</table>
</div>
</div>
</div>
</div>
</div>
</div>
<%@ include file="../common/footer.jsp" %>
<script src="/math/resources/assets/js/core/jquery.min.js"></script>
  <script src="/math/resources/assets/js/core/popper.min.js"></script>
  <script src="/math/resources/assets/js/core/bootstrap-material-design.min.js"></script>
  <script src="/math/resources/assets/js/plugins/perfect-scrollbar.jquery.min.js"></script>
  <!-- Include a polyfill for ES6 Promises (optional) for IE11, UC Browser and Android browser support SweetAlert -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/core-js/2.4.1/core.js"></script>
  <!-- Library for adding dinamically elements -->
  <script src="/math/resources/assets/js/plugins/arrive.min.js"></script>
  <!-- Chartist JS -->
  <script src="/math/resources/assets/js/plugins/chartist.min.js"></script>
  <!--  Notifications Plugin    -->
  <script src="/math/resources/assets/js/plugins/bootstrap-notify.js"></script>
  <!-- Control Center for Material Dashboard: parallax effects, scripts for the example pages etc -->
  <script src="/math/resources/assets/js/material-dashboard.js?v=2.1.1" type="text/javascript"></script>
  <!-- Material Dashboard DEMO methods, don't include it in your project! -->
  <script src="/math/resources/assets/demo/demo.js"></script>
</body>
</html>