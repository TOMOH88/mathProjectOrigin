<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="popup.model.vo.Popup" %>    
<%
	Popup popup = (Popup)request.getAttribute("popup");
	String psearchTitle = (String)request.getAttribute("psearchTitle");
	String pOption = (String)request.getAttribute("poption");
	int popupBack = (Integer)request.getAttribute("popupBack");
	int popupNext = (Integer)request.getAttribute("popupNext");
	int popupMin = (Integer)request.getAttribute("popupMin");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>팝업상세보기</title>
</head>
<body>
<%@ include file="../common/Adminheader.jsp" %>
 <div class="content">
        <div class="container-fluid">
          <div class="card">
            <div class="card-header card-header-primary">
              <h4 class="card-title">팝업상세보기</h4>
              <p class="card-category"><%=popup.getPopupNo() %>번글 상세보기페이지</p>
            </div>
            <div class="card-body">
              <div id="typography">
                <div class="card-title">
	<table class="table">
	<tr>
	</tr>
		<tr>
			<th>제목</th>
			<td><%=popup.getPopupName() %></td>
		</tr>
		<tr>
			<th>팝업메모</th>
			<td><%=popup.getPopupExplan()%></td>
		</tr>
	</table>
	<div style="text-align:center;">
	<a href="/math/pupview?no=<%=popup.getPopupNo() %>" class="btn btn-default">글수정</a>
				<a href="/math/pdelete?no=<%=popup.getPopupNo()%>" class="btn btn-default">글삭제</a>
				<a href="/math/plist" class="btn btn-default">목록가기</a>
				<%if(popup.getPopupNo() > popupMin){ %>
					<button name="btn" onclick="javascript:location.href='/math/pback?no=<%=popup.getPopupNo()%>'" class="btn btn-primary btn-link">이전글</button>
				<%} if(popup.getPopupNo() < popupNext){ %>
					<button name="btn" onclick="javascript:location.href='/math/pnext?no=<%=popup.getPopupNo()%>'" class="btn btn-primary btn-link">다음글</button>
				<%} %>
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