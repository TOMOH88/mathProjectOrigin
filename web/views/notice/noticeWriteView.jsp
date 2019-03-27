<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="notice.model.vo.Notice"  %>    
<%
	Notice notice = (Notice)request.getAttribute("notice");
	String ctx = request.getContextPath();
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지사항 글쓰기</title>
<script type="text/javascript" src="<%=ctx %>/SE2/js/HuskyEZCreator.js" charset="utf-8"></script>
<script type="text/javascript" src="/math/resources/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
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
      
      $("#con1").css("display","none");
});
</script>
</head>
<body>
<%@ include file="../common/Adminheader.jsp" %>
<hr style="clear:both;">
<h1 align="center">공지사항 글쓰기</h1>
<form name="nform"  id="nform"  action="/math/nwrite" method="post" accept-charset="utf-8" enctype="multipart/form-data">
<input type="hidden" name="writer" value="<%=admin%>">
<table align="center" width="800" cellspacing="0">
	<tr>
		<th>제목</th>
		<td><input type="text" id="title" name="title" ></td>
	</tr>
	<tr>
		<th>내용</th>
		<td><textarea row="10" cols="30" id="con1" name="content" style="width:650px; height: 350px;"></textarea></td>
	</tr>
	<tr>
		<th>첨부파일</th>
		<td><input type="file" name="upfile"></td>
	</tr>
	<tr>
		<th colspan="2">
			<input type="button" id="save" value="글 등록">
			<input type="reset" value="작성취소">
			<button onclick="javascript:location.href='/math/nslist'; return false;">목록가기</button>
		</th>
	</tr>
</table>
</form>
<%@ include file="../common/footer.jsp" %>
</body>
</html>