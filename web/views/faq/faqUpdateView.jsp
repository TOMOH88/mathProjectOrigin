<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="faq.model.vo.Faq" %>    
<%
	Faq faq = (Faq)request.getAttribute("faq");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>faq수정페이지</title>
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
<%@ include file="../common/Adminheader.jsp" %>
<hr style="clear:both;">
<h1 align="center"><%=faq.getFaqNo() %>번 수정페이지</h1>
<form id="nform" action="/math/fupdate" method="post" >
<input type="hidden" name="no" value="<%=faq.getFaqNo()%>">
<input  type="hidden" name="writer" value="<%=faq.getAdminId() %>">
<table align="center" cellspacing="0" width="800">
	<tr>
		<th>제목</th>
		<td><input type="text" name="title"  value="<%=faq.getQuestionContent() %>"></td>
	</tr>
	<tr>
		<th>내용</th>
		<td><textarea row="10" cols="30" id="con1" name="content" style="width:650px; height: 350px;"><%=faq.getAnswerContent() %></textarea></td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="button" id="save" value="수정하기" >
			<button onclick="javascript:location.href='/math/fslist';">목록으로가기</button>
		</td>
	</tr>
</table>
</form>
</body>
</html>