<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="qna.model.vo.Qna" %>
<%
	Qna qna = (Qna)request.getAttribute("qna");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QnA수정페이지</title>
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
<h1 align="center"><%=qna.getQnaNo() %>번 수정페이지</h1>
<form id="nform" action="/math/qaupdate" method="post" enctype="multipart/form-data">	
<input type="hidden" name="qno" value="<%=qna.getQnaNo()%>">
<input type="hidden" name="admin" value="<%=admin%>">
<input type="hidden" name="ofile" value="<%=qna.getOriginalQname() %>">
<input type="hidden" name="rfile" value="<%=qna.getRenameQname() %>">
<table align="center" cellspacing="0" width="800px">
	<tr>
		<td>제목</td>
		<td><input type="text" name="qQTitle"  value="<%=qna.getQnaTitle()%>" ></td>
	</tr>
	<tr>
		<td>답변내용</td>
		<td><textarea row="10" cols="30" id="con1" name="content" style="width:650px; height: 350px;"><%=qna.getQnaContent()%></textarea></td>
	</tr>
	<tr>
		<td>첨부파일</td>
		<td>
		<% if(qna.getOriginalQname() != null && !qna.getOriginalQname().equals("null")){ %>
			<%=qna.getOriginalQname() %>
		<% }else{ %>
			첨부파일없음
		<% } %>
			<input type="file" name="upfile" value="첨부파일변경">
		</td>
	</tr>
</table>
<input type="button" id="save" value="수정하기">
</form>
</body>
</html>