<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css?family=Jua" rel="stylesheet">
<title>Insert title here</title>
<style type="text/css">
select {
	 width: 200px; /* 원하는 너비설정 */
    padding: .8em .5em; /* 여백으로 높이 설정 */
    font-family: inherit;  /* 폰트 상속 */
    /* background: url('이미지 경로') no-repeat 95% 50%; */ /* 네이티브 화살표를 커스텀 화살표로 대체 */
    border: 1px solid #999;
    border-radius: 0px; /* iOS 둥근모서리 제거 */
    -webkit-appearance: none; /* 네이티브 외형 감추기 */
    -moz-appearance: none;
    appearance: none;
}

div.q {
   float: left;
   width: 20%;
   height: 50px;
}

table{
	font-family: 'Jua', sans-serif;
}

div > h4{
	font-family: 'Jua', sans-serif;
}

div {
	font-family: 'Jua', sans-serif;
}
</style>
<script type="text/javascript" src="/math/resources/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$.ajax({
			url: "/math/semester",
			type: "post",
			dataType: "json",
			success: function(data){
				var jsonStr = JSON.stringify(data);
				var json = JSON.parse(jsonStr);
				
				var print = "<option value=''>학기</option>";
				for(var i in json.list){
					print += "<option value='" + decodeURIComponent(json.list[i].semester) + "'>" + decodeURIComponent(json.list[i].semester) + "</option>";
				}
				$("#f1sel").html(print);
			},
			error: function(jqXHR, textStatus, errorThrown){
				console.log("error: " + jqXHR + ", " + textStatus + ", " + errorThrown);
			}
		});
	});
	function f1change(){
		var semester = $("#f1sel option:selected").val();
		$.ajax({
			url: "/math/book",
			type: "post",
			data: {semester : semester},
			dataType: "json",
			success: function(data){
				var jsonStr = JSON.stringify(data);
				var json = JSON.parse(jsonStr);
				
				var print = "<option value=''>교재</option>";
				for(var i in json.list){
					print += "<option value='" + decodeURIComponent(json.list[i].book) + "'>" + decodeURIComponent(json.list[i].book) + "</option>";
				}
				$("#f2sel").html(print);
			},
			error: function(jqXHR, textStatus, errorThrown){
				console.log("error: " + jqXHR + ", " + textStatus + ", " + errorThrown);
			}
		});
	}
	function f2change(){
		var semester = $("#f1sel option:selected").val();
		var book = $("#f2sel option:selected").val();
		$.ajax({
			url: "/math/chapter",
			type: "post",
			data: {semester : semester, book : book},
			dataType: "json",
			success: function(data){
				var jsonStr = JSON.stringify(data);
				var json = JSON.parse(jsonStr);
				
				var print = "<option value=''>챕터</option>";
				for(var i in json.list){
					print += "<option value='" + decodeURIComponent(json.list[i].chapter) + "'>" + decodeURIComponent(json.list[i].chapter) + "</option>";
				}
				$("#f3sel").html(print);
			},
			error: function(jqXHR, textStatus, errorThrown){
				console.log("error: " + jqXHR + ", " + textStatus + ", " + errorThrown);
			}
		});
	}
	function f3change(){
		var semester = $("#f1sel option:selected").val();
		var book = $("#f2sel option:selected").val();
		var chapter = $("#f3sel option:selected").val();
		
		var imgPath = "/math/workbook/" + semester + "/" + book + "/" + chapter + "/";
		
		$.ajax({
			url: "/math/question",
			type: "post",
			data: {semester : semester, book : book, chapter : chapter},
			dataType: "json",
			success: function(data){
				var jsonStr = JSON.stringify(data);
				var json = JSON.parse(jsonStr);
				
				var print="";
				for(var i in json.list){
					var qPath = imgPath + decodeURIComponent(json.list[i].question);
					print += "<div class='q'><input type='checkbox' name='img' value='" + qPath + "'>" +
					decodeURIComponent(json.list[i].question).substring(0, decodeURIComponent(json.list[i].question).length-4) + "</div>";
					
				}
				$("#left").html(print);
			},
			error: function(jqXHR, textStatus, errorThrown){
				console.log("error: " + jqXHR + ", " + textStatus + ", " + errorThrown);
			}
		});
	}
	
	function allCheck(){
		$(":checkbox").prop("checked", true);
	}
	
	function unCheck(){
		$(":checkbox").prop("checked", false);
	}
	
	function preview(){
		var items = [];
		$("input:checkbox[type=checkbox]:checked").each(function () {
		    items.push($(this).val());
		});
		var title = $("#title").val();
		var waterMark = $("#waterMark").val();
		console.log(title, waterMark);
		window.open("/math/views/question/preview.jsp?items="+items+"&title="+title+"&waterMark="+waterMark, "a", "width=1000, height=1000, left=100, top=50");
	}
	function textDown(){
		var semester = $("#f1sel option:selected").val();
		var book = $("#f2sel option:selected").val();
		var chapter = $("#f3sel option:selected").val();
		var title = $("#title").val();
		var name="";
		$('input:checkbox[type=checkbox]:checked').each(function () {
		   name += $(this).val(); 
		});
		$.ajax({
			url: "/math/tdown",
			type: "post",
			data: {semester: semester,
					book: book,
					chapter: chapter,
					name: name,
					title : title},
			success: function(data) {
					if(data == "ok"){
						alert("오답노트 생성 성공 다운로드 받아주세요!");
						$("#ddd").html("<a href='/math/files/text/"+$("#title").val()+".txt' download>오답노트<a>");
					}else{
						alert("오답노트 생성 실패!");
					}
			},
			error: function( jqXHR, textStatus, errorThrown) {
				console.log("error : "+  jqXHR +", "+textStatus+", "+errorThrown);
			}
		});
	
	
	
	
	};
	
</script>
</head>
<body>
<%@ include file="../common/header.jsp" %>
<div class="page-header header-filter" data-parallax="true" style="background-image: url('/math/resources/images/math-3986758_1920.jpg')">
    <div class="container">
      <div class="row">
        <div class="col-md-8 ml-auto mr-auto">
          <div class="brand text-center">
          <h1>문제</h1>
            <h3 class="title text-center">문제지 출력</h3>
          </div>
        </div>
      </div>
    </div>
  </div>
   <div class="main main-raised">
    <div class="container">
      <div class="section text-center">
      <table class="table">
      <tr>
      <td>
<div align="center">
<label for="exampleFormControlTextarea1">학기선택</label>
	</div>
	<select id="f1sel" onChange="f1change();" class="form-control">
	</select>
</td>
<td>
<div align="center">
<label for="exampleFormControlTextarea1">교재선택</label>
	</div>
	<select id="f2sel" onChange="f2change();" class="form-control">
	</select>
</td>
	<td>
	<div align="center">
	<label for="exampleFormControlTextarea1">챕터선택</label>
	</div>
	<select id="f3sel" onChange="f3change();" class="form-control">
	</select>
	</td>
</tr>
</table>
<table class="table">
<tr><td>
<div class="form-group">
<label for="exampleFormControlTextarea1">문제지 Title</label><input type="text" id="title" class="form-control">
</div>
</td><td>
<div class="form-group">
<label for="exampleFormControlTextarea1">워터마크</label><input type="text" id="waterMark" class="form-control">
</div>
</td>
</tr>
</table>
	<button onclick="preview();" class="btn btn-default btn-sm">미리보기</button>
	<button onclick="allCheck();" class="btn btn-default btn-sm">전체 선택</button>
	<button onclick="unCheck();" class="btn btn-default btn-sm">전체 해제</button>
	<button onclick="textDown();" class="btn btn-default btn-sm">오답 체크</button>
	<div id="ddd"></div>
	<div id="qImg" class="border" style=" overflow:auto;">
<div id="left"></div>
</div>
</div>
</div>
</div>
<%@ include file="../common/ufooter.jsp" %>
</body>
</html>