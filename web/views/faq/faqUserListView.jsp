<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, faq.model.vo.Faq" %>    
<%
   ArrayList<Faq> fList = (ArrayList<Faq>)request.getAttribute("fList"); 
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>감성수학</title>
<link href="https://fonts.googleapis.com/css?family=Do+Hyeon" rel="stylesheet">
<script type="text/javascript" src="/math/resources/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
$(function(){
   $(document).bind("contextmenu",function(){   return false;}); //우클릭방지
   $(document).bind('selectstart',function() {return false;}); //선택방지
   $(document).bind('dragstart',function(){return false;}); //드래그방지
});
</script>
<body>
<%@ include file="../common/header.jsp" %>
<div class="page-header header-filter" data-parallax="true" style="background-image: url('/math/resources/images/math-3986758_1920.jpg')">
    <div class="container">
      <div class="row">
        <div class="col-md-8 ml-auto mr-auto">
          <div class="brand text-center">
          <h1>FAQ</h1>
            <h3 class="title text-center">목록보기</h3>
          </div>
        </div>
      </div>
    </div>
  </div>
   <div class="main main-raised">
    <div class="container">
      <div class="section text-center">
        <div id="accordion">
  <div class="card" >
    <div class="card-header card-header-primary" id="heading0" style="height:50px;">
        <button style="float:left; padding:0px; margin:1px;"class="btn btn-link btn-lg" data-toggle="collapse" data-target="#collapse0" aria-expanded="true" aria-controls="collapse0">
          <div class="card-text">
              <h4 class="card-title" style="font-family: 'Do Hyeon', sans-serif;"><%=fList.get(0).getQuestionContent() %></h4>
            </div>
        </button>
    </div>
    <div id="collapse0" class="collapse show" aria-labelledby="heading0" data-parent="#accordion">
      <div class="card-body" style="float:left">
        <h5 style="font-family: 'Do Hyeon', sans-serif;"><%=fList.get(0).getAnswerContent() %></h5>
      </div>
    </div>
  </div>
  <br>
  <% for(int i =1; i < fList.size(); i++){ %>
  <div class="card">
    <div class="card-header card-header-primary" id="heading<%= i %>" style="height:50px;">
      <button style="float:left; padding:0px; margin:1px;"class="btn btn-link btn-lg" data-toggle="collapse" data-target="#collapse<%= i %>" aria-expanded="true" aria-controls="collapse<%= i %>">
          <div class="card-text">
              <h4 class="card-title" style="font-family: 'Do Hyeon', sans-serif;"><%=fList.get(i).getQuestionContent() %></h4>
            </div>
        </button>
    </div>
    <div id="collapse<%= i %>" class="collapse" aria-labelledby="heading<%= i %>" data-parent="#accordion">
      <div class="card-body" style="float:left;">
        <h5 style="font-family: 'Do Hyeon', sans-serif;"><%=fList.get(i).getAnswerContent() %></h5>
      </div>
    </div>
  </div>
  <br>
  <% } %>
</div>
</div>
</div>
</div>
<%@ include file="../common/ufooter.jsp" %>
</body>
</html>