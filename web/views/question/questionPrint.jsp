<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
div#top {
	position: absolute; 
	left: 100px;
	top: 100px;
	width: 900px;
	height: 100px;
	border: 1px solid black;
}
div#f1 {
	width: 300px;
	height: 100px;
	border: 1px solid black;
}
div#f2 {
	width: 300px;
	height: 100px;
	border: 1px solid black;
	position: absolute; 
	left: 300px;
	top: 0px;
}
div#f3 {
	width: 300px;
	height: 100px;
	border: 1px solid black;
	position: absolute; 
	left: 600px;
	top: 0px;
}
div#upload {
	position: absolute; 
	left: 100px;
	top: 230px;
	width: 900px;
	border: 1px solid black;
}
div#titleDiv {
	position: absolute; 
	left: 100px;
	top: 350px;
	width: 900px;

	border: 1px solid black;
}

div#qImg {  /* 문제 리스트 체크박스 출력 */
	width: 1000px;
	border: 1px solid black;
	position: absolute; 
	left: 100px;
	top: 500px;
}

div#right {
	width: 15%;
	float: left;
	border: 1px solid black;
}

div#left {
	width: 80%;
	float: left;
	border: 1px solid black;
}
div.q {
	float: left;
	width: 20%;
	height: 50px;
	/* height: 50px; */
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
	
	function makeSemester(){
		var newSemester = prompt("생성할 학기 이름");
		if(confirm("정말로 생성하시겠습니까?")){	
			location.href = "/math/mSemester?newSemester="+newSemester;
		}else{
			return;
		}
	}
	
	function makeBook(){
		var semester = $("#f1sel option:selected").val();
		if(semester == ""){
			alert("학기를 선택해주세요");
			return;
		}
		var newBook = prompt("생성할 교재 이름");
		if(confirm("정말로 생성하시겠습니까?")){	
			location.href = "/math/mBook?newBook="+newBook+"&semester="+semester;
		}else{
			return;
		}
	}
	
	function makeChapter(){
		var semester = $("#f1sel option:selected").val();
		var book = $("#f2sel option:selected").val();
		if(semester == ""){
			alert("학기를 선택해주세요");
			return;
		}
		if(book == ""){
			alert("교재를 선택해주세요");
			return;
		}
		var newChapter = prompt("생성할 챕터 이름");
		if(confirm("정말로 생성하시겠습니까?")){	
			location.href = "/math/mChapter?newChapter="+newChapter+"&semester="+semester+"&book="+book;
		}else{
			return;
		}
	}
	
	function uploadImg(){
		var semester = $("#f1sel option:selected").val();
		var book = $("#f2sel option:selected").val();
		var chapter = $("#f3sel option:selected").val();
		
		if(semester == ""){
			alert("학기를 선택해주세요");
			return;
		}
		if(book == ""){
			alert("교재를 선택해주세요");
			return;
		}
		if(chapter == ""){
			alert("챕터를 선택해주세요");
			return;
		}
		$("#semester").val(semester);
		$("#book").val(book);
		$("#chapter").val(chapter);
		var imgName = $("#upImg").val();
		alert(imgName);
		$("form").attr("action", "/math/upImg");
		$("form").submit();
	}
	
	function delSemester(){
		var semester = $("#f1sel option:selected").val();
		if(semester == ""){
			alert("학기를 선택해주세요");
			return;
		}
		location.href = "/math/dSemester?semester="+semester;
	}
	
	function delBook(){
		var semester = $("#f1sel option:selected").val();
		var book = $("#f2sel option:selected").val();
		if(semester == ""){
			alert("학기를 선택해주세요");
			return;
		}
		if(book == ""){
			alert("교재를 선택해주세요");
			return;
		}
		location.href = "/math/dBook?semester="+semester+"&book="+book;
	}
	
	function delChapter(){
		var semester = $("#f1sel option:selected").val();
		var book = $("#f2sel option:selected").val();
		var chapter = $("#f3sel option:selected").val();
		
		if(semester == ""){
			alert("학기를 선택해주세요");
			return;
		}
		if(book == ""){
			alert("교재를 선택해주세요");
			return;
		}
		if(chapter == ""){
			alert("챕터를 선택해주세요");
			return;
		}
		
		location.href = "/math/dChapter?semester="+semester+"&book="+book+"&chapter="+chapter;
	}
	
	function delImg(){
		var semester = $("#f1sel option:selected").val();
		var book = $("#f2sel option:selected").val();
		var chapter = $("#f3sel option:selected").val();
		
		if(semester == ""){
			alert("학기를 선택해주세요");
			return;
		}
		if(book == ""){
			alert("교재를 선택해주세요");
			return;
		}
		if(chapter == ""){
			alert("챕터를 선택해주세요");
			return;
		}
		
		var items = [];
		$('input:checkbox[type=checkbox]:checked').each(function () {
		    items.push($(this).val());
		});
		
		location.href = "/math/dImg?semester="+semester+"&book="+book+"&chapter="+chapter+"&items="+items;
	}
	
	function superUpload(){
		location.href = "/math/sUpload";
	}
</script>
</head>
<body>
<h1>문제지 출력 페이지</h1>
<div id="top">
	<div id="f1">
	<select id="f1sel" onChange="f1change();">
	</select><br><br>
	<button onclick="makeSemester();">추가</button>&nbsp;&nbsp;&nbsp;&nbsp;
	<button onclick="delSemester();">삭제</button>
	</div>
	
	<div id="f2">
	<select id="f2sel" onChange="f2change();">
	</select><br><br>
	<button onclick="makeBook();">추가</button>&nbsp;&nbsp;&nbsp;&nbsp;
	<button onclick="delBook();">삭제</button>
	</div>
	
	<div id="f3">
	<select id="f3sel" onChange="f3change();">
	</select><br><br>
	<button onclick="makeChapter();">추가</button>&nbsp;&nbsp;&nbsp;&nbsp;
	<button onclick="delChapter();">삭제</button>
	</div>
</div>

<br><br>
<div id="upload">
	<form method="post" enctype="multipart/form-data">
	<input type="hidden" name="semester" id="semester">
	<input type="hidden" name="book" id="book">
	<input type="hidden" name="chapter" id="chapter">
	<input multiple="multiple" type="file" id="upImg" name="upImg">
</form><br>
<button onclick="uploadImg();">문제 등록</button>
<button onclick="superUpload();">Super Upload</button>
</div>
<div id="titleDiv">
문제지 Title : <input type="text" id="title"> <br><br>
워터마크 : <input type="text" id="waterMark">
</div>
<br><br>
<div id="qImg">
<div id="left"></div>
<div id="right">
	<button onclick="preview();">미리보기</button> <br><br>
	<button onclick="allCheck();">전체 선택</button> <br><br>
	<button onclick="unCheck();">전체 해제</button> <br><br>
	<button onclick="delImg();">문제 삭제</button>
</div>
</div>
</body>
</html>