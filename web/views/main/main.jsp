<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="popup.model.vo.Popup, java.util.ArrayList" %>
    <% 
    	ArrayList<Popup> plist = (ArrayList<Popup>)request.getAttribute("plist");
    	System.out.print("plist" + plist);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  <!--     Fonts and icons     -->
  <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
  <!-- Material Kit CSS -->
  <link href="/math/resources/assets/css/material-kit.css?v=2.0.5" rel="stylesheet" />
<title>Insert title here</title>
</head>
<script type="text/javascript">
function OpenWindow(){
	var url;
	var top;
	var left;
	var width;
	var height;
	window.open("http://www.naver.com", "_blank", "top=0, left=0, width=600, height=600, resizable=1, scrollbars=yes");
}
</script>
<body onload="OpenWindow();">
<%@ include file="../common/header.jsp" %>
  <div class="page-header header-filter" data-parallax="true" style="background-image: url('/math/resources/images/math-3986758_1920.jpg')">
    <div class="container">
      <div class="row">
        <div class="col-md-8 ml-auto mr-auto">
          <div class="brand text-center">
            <h1>메인</h1>
            <h3 class="title text-center">Subtitle</h3>
          </div>
        </div>
      </div>
    </div>
  </div>
   <div class="main main-raised">
    <div class="container">
      <div class="section text-center">
        <h2 class="title">Your main section here</h2>
      </div>
    </div>
  </div>
<%@ include file="../common/ufooter.jsp" %>
</body>
</html>