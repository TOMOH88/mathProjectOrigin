<%@page import="member.model.vo.Member"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% ArrayList<Member> list = (ArrayList<Member>)request.getAttribute("list"); 
	 String admin = (String)session.getAttribute("admin");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/math/resources/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	function levelChange(i) {
		if(confirm("적용하시겠습니까?")){
			var name = $("#" + i).html();
			var level= $("#level"+ i).val();
			$.ajax({
				url: "/math/lvchange",
				type: "post",
				data: {level2: level,
					userid2: name},
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
</script>
</head>
<body>
<%@ include file="../common/Adminheader.jsp" %>
<hr style="clear:both;">


<table id="t1" border="1" cellspacing="0">
<tr><td>회원 아이디 </td><td>회원 이름</td><td>가입일</td><td>권한</td><td>회원정보</td><td>비밀번호 초기화</td></tr>
<%for(int i=0 ; i<list.size();i++){
String name = list.get(i).getUserId();
%>
<tr><th id="<%= i %>"><%=list.get(i).getUserId()%></th><th><a href="/math/mdetail?userid=<%=list.get(i).getUserId() %>"><%=list.get(i).getUserName() %></a></th><th><%=list.get(i).getRegistDate() %></th>
<th>
<%if(Integer.parseInt(list.get(i).getMemberLevel())==1){ %>
<select name="level" id="level<%= i%>">
    <option value="1" selected="selected">정회원</option>
    <option value="0">준회원</option>
</select>
<%}else{ %>
<select name="level" id="level<%=i%>">
    <option value="1">정회원</option>
    <option value="0" selected="selected">준회원</option>
</select>
<%} %>
<button onclick="levelChange(<%= i %>);">등급변경</button>
</th>
<th><button>회원정보</button></th><th><button>비밀번호 초기화</button></th>

</tr>
<%} %>
</table>


<%@ include file="../common/footer.jsp" %>

</body>
</html>