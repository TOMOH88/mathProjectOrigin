<%@page import="member.model.vo.Member"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% ArrayList<Member> list = (ArrayList<Member>)request.getAttribute("list"); 
	String admin = (String)session.getAttribute("admin");
	int currentPage = ((Integer)request.getAttribute("currentPage")).intValue();
	int startPage = ((Integer)request.getAttribute("startPage")).intValue();
	int endPage = ((Integer)request.getAttribute("endPage")).intValue();
	int maxPage = ((Integer)request.getAttribute("maxPage")).intValue();
	int limit = ((Integer)request.getAttribute("limit")).intValue();
	int allSearchListCount = ((Integer)request.getAttribute("allSearchListCount")).intValue();
	String searchTitle = (String)request.getAttribute("searchTitle");
	String fOption = (String)request.getAttribute("fOption");
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
	function memberDetail(i) {
	var name = $("#" + i).html();
	location.href="/math/mdetail?userid="+name+"&page="+<%=currentPage%>;	
	}
	
	$(function() {
		$.ajax({
			url: "/math/cmember",
			type: "post",
			success: function(data) {
				$("#cmember").html("현재 인원수 :"+data);
			},
			error: function( jqXHR, textStatus, errorThrown) {
				console.log("error : "+  jqXHR +", "+textStatus+", "+errorThrown);
			}
		});
	});
</script>
</head>
<body>
<%@ include file="../common/Adminheader.jsp" %>
<div class="content">
        <div class="container-fluid">
          <div class="card">
            <div class="card-header card-header-primary">
              <h4 class="card-title">회원관리</h4>
              <p class="card-category" id="cmember"></p>
            </div>
            <div class="card-body">
              <div id="typography">
                <div class="card-title">
<table id="t1" class="table">
<tr><td>회원 아이디 </td><td>회원 이름</td><td>가입일</td><td>권한</td><td></td><td>회원정보</td></tr>
<%for(int i=0 ; i<list.size();i++){
String name = list.get(i).getUserId();
%>
<tr>
<th id="<%= i %>"><%=list.get(i).getUserId()%></th>
<th><%=list.get(i).getUserName() %></th>
<th><%=list.get(i).getRegistDate() %></th>
<th>
<%if(Integer.parseInt(list.get(i).getMemberLevel())==1){ %>
<select name="level" id="level<%= i%>" class="form-control">
    <option value="1" selected="selected">정회원</option>
    <option value="0">준회원</option>
</select>
<%}else{ %>
<select name="level" id="level<%=i%>" class="form-control">
    <option value="1">정회원</option>
    <option value="0" selected="selected">준회원</option>
</select>
<%} %>
</th>
<th><button onclick="levelChange(<%= i %>);" class="btn btn-default">등급변경</button></th>
<th><button onclick="memberDetail(<%= i %>);" class="btn btn-default">회원정보</button></th>
</tr>
<%} %>
</table>
<div style="text-align:center">
	<% if(currentPage <= 1){ %>
		[맨처음]
	<% }else if(searchTitle != null){ %>
		<a href="/math/mmanager?page=1&title=<%=searchTitle%>&fOption=<%=fOption%>">[맨처음]</a>
	<% }else{ %>
		<a href="/math/mmanager?page=1">[맨처음]</a>
	<%} if((currentPage - 5) <= startPage && (endPage - 5) >= 1){ %>
		<a href="/math/mmanager?page=<%= (startPage - 5) + 4   %>&title=<%=searchTitle%>&fOption=<%=fOption%>">[이전]</a>
	<% }else{%>
		[이전]
	<%} for(int p = startPage; p <= endPage; p++){ 
			if(p == currentPage){%>
				<font>[<%=p %>]</font>
			<%}else if(searchTitle != null && fOption != null){ %>
				<a href="/math/mmanager?page=<%=p%>&title=<%=searchTitle%>&fOption=<%=fOption%>"><%=p %></a>
				<%}else{ %>
				<a href="/math/mmanager?page=<%=p%>"><%=p %></a>
	<% }} %>
	<% if((startPage + 5) <= maxPage && (currentPage + 5) >= startPage){ %>
		<a href="/math/mmanager?page=<%=startPage+5%>&title=<%=searchTitle %>&fOption=<%=fOption%>">[다음]</a>
	<%}else{ %>
		[다음]
	<%} %>
	<% if(currentPage >= maxPage){ %>
		[마지막]
	<% }else if(searchTitle != null){ %>
		<a href="/math/mmanager?page=<%=maxPage%>&title=<%=searchTitle%>&fOption=<%=fOption%>">[마지막]</a>
	<% }else{ %>
		<a href="/math/mmanager?page=<%=maxPage%>">[마지막]</a>
	<%} %>
<form action="/math/mmanager?page=1" method="post">
<div>
	<select name="fOption">
		<option value="">선택하세요</option>
		<option name="userid" value="userid">아이디</option>
		<option name="username" value="username">이름</option>
		<option name="phone" value="phone">핸드폰번호</option>
	</select>
	&nbsp;
	<input type="text" name="title">
	<input type="submit" value="검색">
</div>
</form>
</div>
</div>
</div>
</div>
</div>
</div>
</div>
<%@ include file="../common/footer.jsp" %>

</body>
</html>