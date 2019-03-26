<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>팝업등록</title>
</head>
<body>
<%@ include file="../common/Adminheader.jsp"  %>
<div class="content">
        <div class="container-fluid">
          <div class="card">
            <div class="card-header card-header-primary">
              <h4 class="card-title">공지사항</h4>
              <p class="card-category">공지사항 작성</p>
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
		<td><input type="text" name="ptitle" class="form-control"></td>
	</tr>
	<tr>
		<th>링크주소</th>
		<td><input type="text" name="plink" class="form-control"></td>
	</tr>
	<tr>
		<th>x좌표</th>
		<td><input type="number" name="x" class="form-control"></td>
	</tr>
	<tr>
		<th>y좌표</th>
		<td><input type="number" name="y" class="form-control"></td>
	</tr>
	<tr>
		<th>width</th>
		<td><input type="number" name="pwidth" class="form-control"></td>
	</tr>
	<tr>
		<th>height</th>
		<td><input type="number" name="pheight" class="form-control"></td>
	</tr>
	<tr>
		<td colspan="2">
		<label for="startDate">시작일</label>
		<input type="date" name="startDate" class="form-control">
		~
		<label for="endDate">종료일</label>
		<input type="date" name="endDate" class="form-control">
		</td>
	</tr>
	<tr>
		<th>이미지첨부파일</th>
		<td><input type="file" name="imagefile" class="form-control"></td>
	</tr>
	<tr>
		<th>설명</th>
		<td><textarea rows="2" cols="60" class="form-control"></textarea></td>
	</tr>
</table>
<div style="text-align:center;">
			<input type="submit" value="글 등록" class="btn btn-default">
			<input type="reset" value="작성취소" class="btn btn-default">
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