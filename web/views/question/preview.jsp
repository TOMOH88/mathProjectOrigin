<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String value = request.getParameter("items");
		
    String[] strArr = value.split(",");
    
    int page2 = (strArr.length - 4) / 4;
    int img=4;
    
    String title = request.getParameter("title");
    String waterMark = request.getParameter("waterMark");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/math/resources/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("div.paper").on("click",function(){
			var index = $(this).index() - 1;
			$("div.paper:gt(" + index + ")").remove();
			
			<%-- $("div#one").html($("div#one").html() + $("div#one").html("zzzzzzzzzzzz"));
			var $h1 = $('<% for(int i=0; i<2; i++){out.println("<h1>hi</h1><br>"); } %>');
			$("div.paper").eq(index).append($h1); --%>
		});

	});
	
	var initBody;
		    function beforePrint()
		    {
		        initBody = document.body.innerHTML;
		        document.body.innerHTML = one.innerHTML;
		    }
		    function afterPrint()
		    {
		        document.body.innerHTML = initBody;
		    }
		    function pageprint()
		    {
		        window.onbeforeprint = beforePrint;
		        window.onafterprint = afterPrint;
		        window.print();
		    }


</script>
<style type="text/css">
    body {
    width: 100%;
    height: 100%;
    margin: 0;
    padding: 0;
    background-color: #ddd;  
}
* {
    box-sizing: border-box;
    -moz-box-sizing: border-box;
}
.paper {
    width: 210mm;
	min-height: 297mm;
    padding: 20mm;  /* set contents area */
    margin: 10mm auto;
    border-radius: 5px;
    background: #fff;
    box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);
    
    background-image: url("/math/resources/logo/보노보노.jpg");
    background-repeat: no-repeat;
    background-position: bottom right;
    background-size: 150px;

	position:relative;
}
.content {
    padding: 0;
    /* border: 1px #888 dotted; */
    height: 257mm;
  /*  position:relative;
   z-index: 1; */
}
 
@page {
    size: A4;
    margin: 0;
}
@media print {
    html, body {
        width: 210mm;
        height: 297mm;
        background: #fff;
    }
    .paper {
        margin: 0;
        border: initial;
        border-radius: initial;
        width: initial;
        min-height: initial;
        box-shadow: initial;
        /* background: initial; */
        -webkit-print-color-adjust: exact;
        page-break-after: always;
        
    } 
} 


table {
    width: 100%;
    height: 10%;
    border: 1px solid #444444;
  }
  th, td {
    border: 1px solid #444444;
    vertical-align:top;
    text-align:center; 
    vertical-align: middle;
  }
  
div.p {
   width: 50%;
   height: 50%;
   float: left;
}  

div.main {
	width: 50%;
	height: 45%;
	float: left;
}

span.waterMark {
	font-weight: bold;
	opacity: 0.5;
	position:relative;
   	z-index: 10; 
   	left: 290px;
   	top: -550px;
}
</style>

</head>
<body>
<center><button style="width:100px;height:50px;" onclick="pageprint();">인쇄하기</button></center>

<div id="one">
<div class="paper">
	<div class="content">
		<table>
			<tr><td rowspan="2" width="70%"><%= title %></td><td width="10%" height="40%">채점일</td><td width="10%">채점자</td><td width="10%">점수</td></tr>
			<tr><td></td><td></td><td></td></tr>
		</table>
<% 
for(int i=0; i<4; i++){
	out.println("<div class='main'><img src='"+strArr[i]+"' width='100%'></div>");
	if(i == strArr.length - 1)
		break;
}
%>
<%-- <div class="main"><img src="<%= strArr[1] %>" width="100%"></div>
<div class="main"><img src="<%= strArr[2] %>" width="100%"></div>
<div class="main"><img src="<%= strArr[3] %>" width="100%"></div> --%>
		<%-- <img src="<%= strArr[0] %>"> --%>
		<span class="waterMark"><%= waterMark %></span>
	</div>
</div>
<% 
if(strArr.length > 4){
	for(int i=0; i<=page2; i++){ 
	out.println("<div class='paper' id='" + i + "'>");
	out.println("<div class='content'>");
		for(int j=img; j<img+4; j++){
			//out.println("<div class='p' id='" + j + "'> <img src='" + strArr[j] + "' width='100%'></div>");
			out.println("<div class='p'> <img src='" + strArr[j] + "' width='100%'></div>");
			if(j == strArr.length - 1 && (1 == strArr.length % 4)){
				out.println("<div class='p'></div>"); 
				out.println("<div class='p'></div>");
				out.println("<div class='p'></div>");
				break;
			}else if(j == strArr.length - 1 && (2 == strArr.length % 4)){
				out.println("<div class='p'></div>"); 
				out.println("<div class='p'></div>");
				break;
			}else if(j == strArr.length - 1 && (3 == strArr.length % 4)){
				out.println("<div class='p'></div>");
				break;
			}
		}
	img = img + 4;
	out.println("<span class='waterMark'>" + waterMark + "</span>");
	out.println("</div>");
	out.println("</div>"); 
	if(img == strArr.length)
		break;
	} 
}
%>
    <!-- <div class="paper">
        <div class="content">Page 2</div>    
    </div> -->

</div>

</body>
</html>