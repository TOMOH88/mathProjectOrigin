<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
    <title>BLUEB</title>

<script>
function popimage(imagesrc,winwidth,winheight){
    var look='width='+winwidth+',height='+winheight+','
        popwin=window.open("","",look)
        popwin.document.open()
        popwin.document.writｅ('<title>Image Window</title><body topmargin=0 leftmargin=0><img style=cursor:hand; onclick="self.close()" src="'+imagesrc+'"></body>')
        popwin.document.close()
}
</script>
</head>

<body>

<b>
<a href="/math/views/main/test.jsp" onClick="popimage('http://www.blueb.co.kr/SRC/javascript/image/img01.jpg',250,167);return false">이미지 팝업 1</a>
<a href="#" onClick="popimage('http://www.blueb.co.kr/SRC/javascript/image/img02.jpg',300,424);return false">이미지 팝업 2</a>


</body>
</html>