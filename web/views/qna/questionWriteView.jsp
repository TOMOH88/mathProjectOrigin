<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/math/SE2/js/HuskyEZCreator.js" charset="utf-8"></script>
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
      
});
</script>
</head>
<body>
<%@ include file="../common/header.jsp" %>
<hr style="clear:both;">
<h1 align="center">질문쓰기페이지</h1>
<form id="nform" action="/math/qqwrite" method="post" enctype="multipart/form-data">
<input type="hidden" name="userId" value="<%=userId%>">
<table align="center" cellspacing="0" width="800px">
	<tr>
		<td>제목</td>
		<td><input type="text"  name="qQTitle" ></td>
	</tr>
	<tr>
		<td>질문내용</td>
		<td><textarea row="10" cols="30" id="con1" name="content" style="width:650px; height: 350px;"></textarea></td>
	</tr>
	<tr>
		<td>첨부파일</td>
		<td><input type="file" name="upfile"></td>
	</tr>
</table>
<input type="button" id="save" value="질문작성">
</form>
<button onclick="javascript:location.href='/math/quslist?userId=<%=userId%>'">목록으로가기</button>
</body>
</html>