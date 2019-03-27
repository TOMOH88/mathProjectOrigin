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
<title>감성수학</title>
<script type="text/javascript" src="/math/resources/js/jquery-3.3.1.min.js"></script>
 <script type="text/javascript">
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
	
	
	function addPermission() {
		var per = $("#s1").val();
		$("#d1").html($("#d1").text()+" "+per)

	};
	function sendAddPer() {
		if(confirm("권한을 적용하시겠습니까?")){
			$.ajax({
				url: "/math/addper",
				type: "post",
				data: {userid : $("#userid").val(),
					    per: $("#d1").text()},
				
				success: function(data) {
						if(data == "ok"){
							alert("변경되였습니다.");
							window.location.reload();
						}else{
							alert("권한주기 오류 확인후 다시해주세요");
						}
				
				},
				error: function( jqXHR, textStatus, errorThrown) {
					console.log("error : "+  jqXHR +", "+textStatus+", "+errorThrown);
				}
		});
		}else{
			$("#d1").html("");
			return false;
		}
	};
	function remove1() {
		$("#d1").html("");
	}
	function allCheck() {
		$(":checkbox").prop("checked",true);
	}
	function unCheck() {
		$(":checkbox").prop("checked",false);
	}
	function removePermission() {
		var items = "";
		$("input:checkbox[type=checkbox]:checked").each(function() {
			items+= $(this).val()+" ";
		});
		if(confirm("권한을 삭제하시겠습니까?")){

			console.log(items);
				$.ajax({
					url: "/math/removeper",
					type: "post",
					
					data: {userid : $("#userid").val(),
						    per: items },
					success: function(data) {
							if(data == "ok"){
								alert("변경되였습니다.");
								window.location.reload();
							}else{
								alert("권한주기 오류 확인후 다시해주세요");
							}
					
					},
					error: function( jqXHR, textStatus, errorThrown) {
						console.log("error : "+  jqXHR +", "+textStatus+", "+errorThrown);
					}
			});
			} else {
				return false;
			}
		}
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
<tr><td>회원 아이디 </td><th><input type="text" id="userid" value="<%=member.getUserId()%>" readonly="readonly"></th></tr>
<tr><td>회원 이름</td><th><%=member.getUserName() %></th></tr>
<tr><td>전화번호</td><th><%=member.getPhone() %></th></tr>
<tr><td>비밀번호</td><th><input type="password" name="password" id="password" value="<%=member.getUserPwd() %>"></th></tr>
<tr><td>비밀번호 확인</td><th><input type="password" name="password" id="password1" value="<%=member.getUserPwd() %>"></th></tr>
<tr><td colspan="2"><button onclick="changePwd();" class="btn btn-default">변경</button>&nbsp;&nbsp;<button onclick="sendmail();" class="btn btn-default">비밀번호 초기화</button></td></tr>
<tr><td>가입일</td><th><%=member.getRegistDate() %></th></tr>
<tr><td>최종 수정일</td><th><%=member.getLastModified() %></th></tr>
<tr><td>권한 주기</td>
<th>
<Select id="s1">
	<option selected="selected">권한 선택</option>
	<option>모든권한</option>
	<%for(Semester s : slist){ %>
	<option><%=s.getSemesterName() %></option>
	<%} %>
</Select>
<button onclick="addPermission();">권한추가</button>
</th></tr>
<tr><th><div id="d1"></div></th><th><button onclick="sendAddPer();">권한 주기</button><button onclick="remove1();">선택한 권한지우기</button></th></tr>
<tr><td>보유 권한</td><th>
<%-- <Select id="s2">
	<option selected="selected">보유 권한</option>
	<%for(Semester m : mylist){ %>
	<option><%=m.getSemesterName() %></option>
	<%} %>
</Select>
<button onclick="removePermission();">권한삭제</button>
</th></tr> --%>
<tr><td colspan="2">
<%for(int i =0 ; i<mylist.size();i++){%>
<input type="checkbox" id="ckd" value="<%=mylist.get(i).getSemesterName()%>"><%=mylist.get(i).getSemesterName() %></input>&nbsp;&nbsp;
<%if((i+1)%4==0){
	out.print("<br>");
}}
%>
</td></tr>
<tr><td colspan="2">
<button onclick="allCheck();">모두 선택</button>&nbsp;&nbsp;
<button onclick="unCheck();">모두 해제</button>&nbsp;&nbsp;
<button onclick="removePermission();">권한삭제</button>
</td></tr>
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