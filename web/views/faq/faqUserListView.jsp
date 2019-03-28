<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, faq.model.vo.Faq" %>    
<%
	ArrayList<Faq> fList = (ArrayList<Faq>)request.getAttribute("fList"); 
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FAQ 목록</title>
<%@ include file="../common/header.jsp" %>
<hr style="clear:both;">
<table align="center" border="1"  width="600"  cellspacing="0" >
	<tr>
		<th>자주묻는질문</th>
	</tr>
	<% for(int i =0; i < fList.size(); i++){ %>
	<tr>
		<td><%=fList.get(i).getQuestionContent() %></td>
	</tr>
	<% } %>
</table>
<%@ include file="../common/footer.jsp" %>
</body>
</html>