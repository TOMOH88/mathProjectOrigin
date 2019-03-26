<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="popup.model.vo.Popup" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>팝업등록</title>
<script type="text/javascript" src="/math/resources/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
</script>
</head>
<body>
<%@ include file="../common/Adminheader.jsp"  %>
<div class="content">
        <div class="container-fluid">
          <div class="card">
            <div class="card-header card-header-primary">
              <h4 class="card-title">팝업</h4>
              <p class="card-category">팝업등록</p>
            </div>
            <div class="card-body">
              <div id="typography">
                <div class="card-title">
<form action="#" method="post">
<table class="table">
<tr>
</tr>
	<tr>
		<th>제목</th>
		<td><input type="text" name="ptitle" ></td>
	</tr>
	<tr>
		<th>링크주소</th>
		<td><input type="text" name="plink" id="plink"></td>
	</tr>
	<tr>
		<th>x좌표</th>
		<td><input type="number" name="x" id="x"></td>
	</tr>
	<tr>
		<th>y좌표</th>
		<td><input type="number" name="y" id="y"></td>
	</tr>
	<tr>
		<th>width</th>
		<td><input type="number" name="pwidth" id="pwidth"></td>
	</tr>
	<tr>
		<th>height</th>
		<td><input type="number" name="pheight" id="pheight"></td>
	</tr>
	<tr>
		<td colspan="2">
		<label for="startDate">시작일</label>
		<input type="date" name="startDate" >
		~
		<label for="endDate">종료일</label>
		<input type="date" name="endDate" >
		</td>
	</tr>
	<tr>
		<th>이미지첨부파일</th>
		<td><input type="file" name="imagefile" ></td>
	</tr>
	<tr>
		<th>설명</th>
		<td><textarea rows="2" cols="60" ></textarea></td>
	</tr>
</table>
<div style="text-align:center;">
			<input type="submit" value="팝업등록" class="btn btn-default">
			<input type="reset" value="등록취소" class="btn btn-default">
			<button onclick="javascript:location.href='/math/plist'; return false;" class="btn btn-default">목록가기</button>
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