<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="notice.model.vo.Notice" %>    
<%
	Notice notice = (Notice)request.getAttribute("notice");
	String ctx = request.getContextPath();
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<<<<<<< HEAD
<meta charset="utf-8">
<title>수정페이지</title>
=======
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>수정페이지</title>
<script type="text/javascript" src="<%=ctx %>/SE2/js/HuskyEZCreator.js" charset="utf-8"></script>
>>>>>>> 99f4a28b079353512139db284dc29b8b799cf226
<script type="text/javascript" src="/math/resources/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
function listView(){
	location.href = '/math/nslist';
}
<<<<<<< HEAD
=======
var oEditors = [];
$(function(){
      nhn.husky.EZCreator.createInIFrame({
          oAppRef: oEditors,
          elPlaceHolder: "con1", //textarea에서 지정한 id와 일치해야 합니다. 
          //SmartEditor2Skin.html 파일이 존재하는 경로
          sSkinURI: "/math/SE2/SmartEditor2Skin.html",  
          htParams : {
              // 툴바 사용 여부 (true:사용/ false:사용하지 않음)
              bUseToolbar : true,             
              // 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
              bUseVerticalResizer : true,     
              // 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
              bUseModeChanger : true,      
              bSkipXssFilter : true,
              fOnBeforeUnload : function(){
                   
              }
          }, 
          fOnAppLoad : function(){
              //기존 저장된 내용의 text 내용을 에디터상에 뿌려주고자 할때 사용
              oEditors.getById["con1"].exec("PASTE_HTML",[""]);
          },
          fCreator: "createSEditor2"
      });
      
      //저장버튼 클릭시 form 전송
      $("#save").click(function(){
          oEditors.getById["con1"].exec("UPDATE_CONTENTS_FIELD", []);
          $("#nform").submit();
      });    
});
>>>>>>> 99f4a28b079353512139db284dc29b8b799cf226
</script>
</head>
<body>
<%@ include file="../common/Adminheader.jsp" %>
<<<<<<< HEAD
<div class="content">
        <div class="container-fluid">
          <div class="card">
            <div class="card-header card-header-primary">
              <h4 class="card-title">공지사항</h4>
              <p class="card-category"><%=notice.getNoticeNo() %>번글 수정페이지</p>
            </div>
            <div class="card-body">
              <div id="typography">
                <div class="card-title">
<form action="/math/nupdate" method="post" enctype="multipart/form-data">
<input type="hidden" name="no" value="<%=notice.getNoticeNo() %>">
<input type="hidden" name="ofile" value="<%=notice.getOriginalFileName() %>">
<input type="hidden" name="rfile" value="<%=notice.getRenameFileName() %>">
	<table class="table">
	<tr>
	</tr>
=======
<hr style="clear:both;">
<h1 align="center"><%=notice.getNoticeNo() %>번 글 수정페이지</h1>
<form id="nform" action="/math/nupdate" method="post" enctype="multipart/form-data">
<input type="hidden" name="no" value="<%=notice.getNoticeNo() %>">
<input type="hidden" name="ofile" value="<%=notice.getOriginalFileName() %>">
<input type="hidden" name="rfile" value="<%=notice.getRenameFileName() %>">
	<table	align="center" width="800" cellspacing="0">
>>>>>>> 99f4a28b079353512139db284dc29b8b799cf226
		<tr>
			<th>제목</th>
			<td><input type="text" name="title" value="<%=notice.getNoticeTitle() %>"  class="form-control"></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><input type="text" name="writer" value="<%=notice.getWriterName() %>" readonly class="form-control"></td>
		</tr>
		<tr>
			<th>내용</th>
<<<<<<< HEAD
			<td>
			<label for="exampleFormControlTextarea1">내용작성</label>
			<textarea class="form-control" id="exampleFormControlTextarea1" rows="3" name="content"><%=notice.getNoticeContent().replaceAll("<br>","\r\n")%></textarea></td>
=======
			<td><textarea row="10" cols="30" id="con1" name="content" style="width:650px; height: 350px;"><%=notice.getNoticeContent() %></textarea></td>
>>>>>>> 99f4a28b079353512139db284dc29b8b799cf226
		</tr>
		<tr height="50">
			<th>첨부파일</th>
			<td id="filetd">
				<% if(notice.getOriginalFileName() != null && !notice.getOriginalFileName().equals("null")){ %>
					<%=notice.getOriginalFileName() %>
				<% }else{ %>
					첨부파일없음
				<% } %>&nbsp;
				<input type="file" value="첨부파일 변경"  name="upfile" class="form-control">
			</td>
		</tr>
<<<<<<< HEAD
=======
		<tr>
			<th colspan="2">
				<input type="button" id="save" value="수정하기">
				<button onclick="listView(); return false;">목록으로 돌아가기</button>
			</th>
		</tr>
>>>>>>> 99f4a28b079353512139db284dc29b8b799cf226
	</table>
	<div style="text-align:center;">
	<input type="submit" value="수정하기" class="btn btn-default">
				<button onclick="listView(); return false;" class="btn btn-default">목록으로 돌아가기</button>
				</div>
</form>
</div>
</div>
</div>
</div>
</div>
</div>
<%@ include file="../common/footer.jsp" %>
</body>
</html>