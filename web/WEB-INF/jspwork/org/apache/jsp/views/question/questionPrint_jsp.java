/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.37
 * Generated at: 2019-04-17 09:28:46 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.question;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class questionPrint_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/views/question/../common/ufooter.jsp", Long.valueOf(1554899346928L));
    _jspx_dependants.put("/views/question/../common/header.jsp", Long.valueOf(1555485153058L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>감성수학</title>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("select {\r\n");
      out.write("\t width: 200px; /* 원하는 너비설정 */\r\n");
      out.write("    padding: .8em .5em; /* 여백으로 높이 설정 */\r\n");
      out.write("/*    font-family: inherit;   폰트 상속 */\r\n");
      out.write("    /* background: url('이미지 경로') no-repeat 95% 50%; */ /* 네이티브 화살표를 커스텀 화살표로 대체 */\r\n");
      out.write("    border: 1px solid #999;\r\n");
      out.write("    border-radius: 0px; /* iOS 둥근모서리 제거 */\r\n");
      out.write("    -webkit-appearance: none; /* 네이티브 외형 감추기 */\r\n");
      out.write("    -moz-appearance: none;\r\n");
      out.write("    appearance: none;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("div.q {\r\n");
      out.write("   float: left;\r\n");
      out.write("   width: 20%;\r\n");
      out.write("   height: 50px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/math/resources/js/jquery-3.3.1.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t$(function(){\r\n");
      out.write("\t\t$.ajax({\r\n");
      out.write("\t\t\turl: \"/math/semester\",\r\n");
      out.write("\t\t\ttype: \"post\",\r\n");
      out.write("\t\t\tdataType: \"json\",\r\n");
      out.write("\t\t\tsuccess: function(data){\r\n");
      out.write("\t\t\t\tvar jsonStr = JSON.stringify(data);\r\n");
      out.write("\t\t\t\tvar json = JSON.parse(jsonStr);\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tvar print = \"<option value=''>학기</option>\";\r\n");
      out.write("\t\t\t\tfor(var i in json.list){\r\n");
      out.write("\t\t\t\t\tprint += \"<option value='\" + decodeURIComponent(json.list[i].semester).replace(/\\+/gi, \" \") + \"'>\" + decodeURIComponent(json.list[i].semester).replace(/\\+/gi, \" \") + \"</option>\";\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\t$(\"#f1sel\").html(print);\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\terror: function(jqXHR, textStatus, errorThrown){\r\n");
      out.write("\t\t\t\tconsole.log(\"error: \" + jqXHR + \", \" + textStatus + \", \" + errorThrown);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t});\r\n");
      out.write("\tfunction f1change(){\r\n");
      out.write("\t\tvar semester = $(\"#f1sel option:selected\").val();\r\n");
      out.write("\t\t$.ajax({\r\n");
      out.write("\t\t\turl: \"/math/book\",\r\n");
      out.write("\t\t\ttype: \"post\",\r\n");
      out.write("\t\t\tdata: {semester : semester},\r\n");
      out.write("\t\t\tdataType: \"json\",\r\n");
      out.write("\t\t\tsuccess: function(data){\r\n");
      out.write("\t\t\t\tvar jsonStr = JSON.stringify(data);\r\n");
      out.write("\t\t\t\tvar json = JSON.parse(jsonStr);\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tvar print = \"<option value=''>교재</option>\";\r\n");
      out.write("\t\t\t\tfor(var i in json.list){\r\n");
      out.write("\t\t\t\t\tprint += \"<option value='\" + decodeURIComponent(json.list[i].book).replace(/\\+/gi, \" \") + \"'>\" + decodeURIComponent(json.list[i].book).replace(/\\+/gi, \" \") + \"</option>\";\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\t$(\"#f2sel\").html(print);\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\terror: function(jqXHR, textStatus, errorThrown){\r\n");
      out.write("\t\t\t\tconsole.log(\"error: \" + jqXHR + \", \" + textStatus + \", \" + errorThrown);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction f2change(){\r\n");
      out.write("\t\tvar semester = $(\"#f1sel option:selected\").val();\r\n");
      out.write("\t\tvar book = $(\"#f2sel option:selected\").val();\r\n");
      out.write("\t\t$.ajax({\r\n");
      out.write("\t\t\turl: \"/math/chapter\",\r\n");
      out.write("\t\t\ttype: \"post\",\r\n");
      out.write("\t\t\tdata: {semester : semester, book : book},\r\n");
      out.write("\t\t\tdataType: \"json\",\r\n");
      out.write("\t\t\tsuccess: function(data){\r\n");
      out.write("\t\t\t\tvar jsonStr = JSON.stringify(data);\r\n");
      out.write("\t\t\t\tvar json = JSON.parse(jsonStr);\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tvar print = \"<option value=''>챕터</option>\";\r\n");
      out.write("\t\t\t\tfor(var i in json.list){\r\n");
      out.write("\t\t\t\t\tprint += \"<option value='\" + decodeURIComponent(json.list[i].chapter).replace(/\\+/gi, \" \") + \"'>\" + decodeURIComponent(json.list[i].chapter).replace(/\\+/gi, \" \") + \"</option>\";\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\t$(\"#f3sel\").html(print);\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\terror: function(jqXHR, textStatus, errorThrown){\r\n");
      out.write("\t\t\t\tconsole.log(\"error: \" + jqXHR + \", \" + textStatus + \", \" + errorThrown);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction f3change(){\r\n");
      out.write("\t\tvar semester = $(\"#f1sel option:selected\").val();\r\n");
      out.write("\t\tvar book = $(\"#f2sel option:selected\").val();\r\n");
      out.write("\t\tvar chapter = $(\"#f3sel option:selected\").val();\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar imgPath = \"/math/workbook/\" + semester + \"/\" + book + \"/\" + chapter + \"/\";\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$.ajax({\r\n");
      out.write("\t\t\turl: \"/math/question\",\r\n");
      out.write("\t\t\ttype: \"post\",\r\n");
      out.write("\t\t\tdata: {semester : semester, book : book, chapter : chapter},\r\n");
      out.write("\t\t\tdataType: \"json\",\r\n");
      out.write("\t\t\tsuccess: function(data){\r\n");
      out.write("\t\t\t\tvar jsonStr = JSON.stringify(data);\r\n");
      out.write("\t\t\t\tvar json = JSON.parse(jsonStr);\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tvar print=\"\";\r\n");
      out.write("\t\t\t\tfor(var i in json.list){\r\n");
      out.write("\t\t\t\t\tvar qPath = imgPath + decodeURIComponent(json.list[i].question).replace(/\\+/gi, \" \");\r\n");
      out.write("\t\t\t\t\tprint += \"<div class='q'><input type='checkbox' name='img' value='\" + qPath + \"'>\" +\r\n");
      out.write("\t\t\t\t\tdecodeURIComponent(json.list[i].question).substring(0, decodeURIComponent(json.list[i].question).length-4) + \"</div>\";\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\t$(\"#left\").html(print);\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\terror: function(jqXHR, textStatus, errorThrown){\r\n");
      out.write("\t\t\t\tconsole.log(\"error: \" + jqXHR + \", \" + textStatus + \", \" + errorThrown);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t   function allCheck() {\r\n");
      out.write("\t\t      if($(\":checkbox\").prop(\"checked\")==false){\r\n");
      out.write("\t\t         $(\":checkbox\").prop(\"checked\",true);\r\n");
      out.write("\t\t      }else{\r\n");
      out.write("\t\t         $(\":checkbox\").prop(\"checked\",false);\r\n");
      out.write("\t\t      }\r\n");
      out.write("\t   }\r\n");
      out.write("\tfunction preview(){\r\n");
      out.write("\t\tvar items = [];\r\n");
      out.write("\t\t$(\"input:checkbox[type=checkbox]:checked\").each(function () {\r\n");
      out.write("\t\t    items.push($(this).val());\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\tvar title = $(\"#title\").val();\r\n");
      out.write("\t\tvar waterMark = $(\"#waterMark\").val();\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t/* window.open(\"/math/views/question/preview.jsp?items=\"+items+\"&title=\"+title+\"&waterMark=\"+waterMark, \"a\", \"width=1000, height=1000, left=100, top=50\"); */\r\n");
      out.write("\t\twindow.open(\"\", \"popup_window\", \"width=1000, height=1000, left=100, top=50\");\r\n");
      out.write("\t\t$(\"#qform\").submit();\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction textDown(){\r\n");
      out.write("\t\tvar semester = $(\"#f1sel option:selected\").val();\r\n");
      out.write("\t\tvar book = $(\"#f2sel option:selected\").val();\r\n");
      out.write("\t\tvar chapter = $(\"#f3sel option:selected\").val();\r\n");
      out.write("\t\tvar title = $(\"#title\").val();\r\n");
      out.write("\t\tvar name=\"\";\r\n");
      out.write("\t\t$('input:checkbox[type=checkbox]:checked').each(function () {\r\n");
      out.write("\t\t   name += $(this).val(); \r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t$.ajax({\r\n");
      out.write("\t\t\turl: \"/math/tdown\",\r\n");
      out.write("\t\t\ttype: \"post\",\r\n");
      out.write("\t\t\tdata: {semester: semester,\r\n");
      out.write("\t\t\t\t\tbook: book,\r\n");
      out.write("\t\t\t\t\tchapter: chapter,\r\n");
      out.write("\t\t\t\t\tname: name,\r\n");
      out.write("\t\t\t\t\ttitle : title},\r\n");
      out.write("\t\t\tsuccess: function(data) {\r\n");
      out.write("\t\t\t\t\tif(data == \"ok\"){\r\n");
      out.write("\t\t\t\t\t\talert(\"오답노트 생성 성공 다운로드 받아주세요!\");\r\n");
      out.write("\t\t\t\t\t\t$(\"#ddd\").html(\"<a href='/math/files/text/\"+$(\"#title\").val()+\".txt' download>오답노트<a>\");\r\n");
      out.write("\t\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t\talert(\"오답노트 생성 실패!\");\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\terror: function( jqXHR, textStatus, errorThrown) {\r\n");
      out.write("\t\t\t\tconsole.log(\"error : \"+  jqXHR +\", \"+textStatus+\", \"+errorThrown);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t};\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write('\r');
      out.write('\n');
 String userId = (String)session.getAttribute("userId"); 
      out.write("    \r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title>유저헤더</title>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <meta content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0\" name=\"viewport\" />\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\" />\r\n");
      out.write("    <link href=\"/math/resources/assets/css/material-kit.css?v=2.0.7\" rel=\"stylesheet\" />\r\n");
      out.write("    <link href=\"/math/resources/assets/css/reset.css\" rel=\"stylesheet\" />\r\n");
      out.write("    <script type=\"text/javascript\" src=\"/math/resources/js/jquery-3.3.1.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("function logout() {\r\n");
      out.write("\tif(confirm(\"로그아웃 합니다.\")){\r\n");
      out.write("\t\tlocation.href=\"/math/logout\";\r\n");
      out.write("\t\t\r\n");
      out.write("\t}else{\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("<style>\r\n");
      out.write("\t.navbar-brand {\r\n");
      out.write("\t\tfont-family: 'Nanum Myeongjo', 'Noto Sans KR', 'dotum';\r\n");
      out.write("\t\tfont-size: 2.5rem !important;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t.nav-item a {\r\n");
      out.write("\t\tfont-size: 1.15rem !important;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t.cursor {\r\n");
      out.write("\t\tcursor: pointer;\r\n");
      out.write("\t}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<nav class=\"navbar navbar-color-on-scroll navbar-transparent fixed-top navbar-expand-lg\" color-on-scroll=\"100\">\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("      <div class=\"navbar-translate\">\r\n");
      out.write("        \t<a class=\"navbar-brand\" href=\"/math/main.jsp\">\r\n");
      out.write("<!--         \t<i class=\"material-icons\" >account_balance</i> -->\r\n");
      out.write("         \t감성수학</a>\r\n");
      out.write("        <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n");
      out.write("          <span class=\"sr-only\">Toggle navigation</span>\r\n");
      out.write("          <span class=\"navbar-toggler-icon\"></span>\r\n");
      out.write("          <span class=\"navbar-toggler-icon\"></span>\r\n");
      out.write("          <span class=\"navbar-toggler-icon\"></span>\r\n");
      out.write("        </button>\r\n");
      out.write("      </div>\r\n");
      out.write("      <div class=\"collapse navbar-collapse\">\r\n");
      out.write("        <ul class=\"navbar-nav ml-auto\">\r\n");
      out.write("          <li class=\"nav-item\">\r\n");
      out.write("            <a href=\"/math/nuslist\" class=\"nav-link\">\r\n");
      out.write("             <!-- <i class=\"material-icons\">dashboard</i>--> 공지사항\r\n");
      out.write("            </a>\r\n");
      out.write("          </li>\r\n");
      out.write("          <li class=\"nav-item\">\r\n");
      out.write("            <a href=\"/math/fulist\" class=\"nav-link\">\r\n");
      out.write("            <!--  <i class=\"material-icons\">description</i>--> FAQ\r\n");
      out.write("            </a>\r\n");
      out.write("          </li>\r\n");
      out.write("          <li class=\"nav-item\">\r\n");
      out.write("            <a href=\"/math/qmuslist?userId=");
      out.print(userId );
      out.write("\" class=\"nav-link\">\r\n");
      out.write("             <!-- <i class=\"material-icons\">toc</i>--> QnA\r\n");
      out.write("            </a>\r\n");
      out.write("          </li>\r\n");
      out.write("          <li class=\"nav-item\" >\r\n");
      out.write("            <a href=\"/math/views/question/questionPrint.jsp\" class=\"nav-link\">\r\n");
      out.write("             <!-- <i class=\"material-icons\">import_contacts</i>--> 문제\r\n");
      out.write("            </a>\r\n");
      out.write("          </li>\r\n");
      out.write("          <li class=\"nav-item\">\r\n");
      out.write("            <a href=\"/math/culist?userId=");
      out.print(userId );
      out.write("\" class=\"nav-link\"> \r\n");
      out.write("            <!--  <i class=\"material-icons\">ondemand_video</i>--> 강의\r\n");
      out.write("            </a>\r\n");
      out.write("          </li>\r\n");
      out.write("          <li class=\"nav-item\">\r\n");
      out.write("            <a href=\"/math/myinfo\" class=\"nav-link\" style=\"font-size: 0.8rem !important;\">\r\n");
      out.write("              <i class=\"material-icons\">person</i> 마이페이지\r\n");
      out.write("            </a>\r\n");
      out.write("          </li>\r\n");
      out.write("          ");
if(userId != null){ 
      out.write("\r\n");
      out.write("          <li class=\"nav-item\">\r\n");
      out.write("            <a onclick=\"logout();\" class=\"nav-link cursor\" style=\"font-size: 0.8rem !important;\">\r\n");
      out.write("              <i class=\"material-icons\">power_settings_new</i> 로그아웃\r\n");
      out.write("            </a>\r\n");
      out.write("          </li>\r\n");
      out.write("          ");
}else{ 
      out.write("\r\n");
      out.write("          <li class=\"nav-item\">\r\n");
      out.write("            <a href=\"/math/views/common/login.jsp\" class=\"nav-link cursor\" style=\"font-size: 0.8rem !important;\">\r\n");
      out.write("              <i class=\"material-icons\">power_settings_new</i> 로그인\r\n");
      out.write("            </a>\r\n");
      out.write("          </li>\r\n");
      out.write("          ");
} 
      out.write("\r\n");
      out.write("        </ul>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("  </nav>\r\n");
      out.write("<script src=\"/math/resources/assets/js/core/jquery.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"/math/resources/assets/js/core/popper.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"/math/resources/assets/js/core/bootstrap-material-design.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"/math/resources/assets/js/plugins/moment.min.js\"></script>\r\n");
      out.write("<script src=\"/math/resources/assets/js/material-kit.js?v=2.0.5\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"/math/resources/assets/js/plugins/bootstrap-datetimepicker.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"/math/resources/assets/js/plugins/nouislider.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script async defer src=\"https://buttons.github.io/buttons.js\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"page-header header-filter\" data-parallax=\"true\" style=\"background-image: url('/math/resources/images/math-3986758_1920.jpg')\">\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("      <div class=\"row\">\r\n");
      out.write("        <div class=\"col-md-8 ml-auto mr-auto\">\r\n");
      out.write("          <div class=\"brand text-center\">\r\n");
      out.write("          ");
if(userId != null){ 
      out.write("\r\n");
      out.write("          <h1>문제</h1>\r\n");
      out.write("            <h3 class=\"title text-center\">문제지 출력</h3>\r\n");
      out.write("            ");
}else { 
      out.write("\r\n");
      out.write("            <h1>로그인 해주세요</h1>\r\n");
      out.write("            ");
} 
      out.write("\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("   <div class=\"main main-raised\">\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("      <div class=\"section text-center\">\r\n");
      out.write("      ");
if(userId != null){ 
      out.write("\r\n");
      out.write("      <table class=\"table\">\r\n");
      out.write("      <tr>\r\n");
      out.write("      <td>\r\n");
      out.write("<div align=\"center\">\r\n");
      out.write("<label for=\"exampleFormControlTextarea1\">학기선택</label>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<select id=\"f1sel\" onChange=\"f1change();\" class=\"form-control\">\r\n");
      out.write("\t</select>\r\n");
      out.write("</td>\r\n");
      out.write("<td>\r\n");
      out.write("<div align=\"center\">\r\n");
      out.write("<label for=\"exampleFormControlTextarea1\">교재선택</label>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<select id=\"f2sel\" onChange=\"f2change();\" class=\"form-control\">\r\n");
      out.write("\t</select>\r\n");
      out.write("</td>\r\n");
      out.write("\t<td>\r\n");
      out.write("\t<div align=\"center\">\r\n");
      out.write("\t<label for=\"exampleFormControlTextarea1\">챕터선택</label>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<select id=\"f3sel\" onChange=\"f3change();\" class=\"form-control\">\r\n");
      out.write("\t</select>\r\n");
      out.write("\t</td>\r\n");
      out.write("</tr>\r\n");
      out.write("</table>\r\n");
      out.write("<form id=\"qform\" name=\"qform\" method=\"post\" action=\"/math/views/question/preview.jsp\" target=\"popup_window\">\r\n");
      out.write("<table class=\"table\">\r\n");
      out.write("<tr><td>\r\n");
      out.write("<div class=\"form-group\">\r\n");
      out.write("<label for=\"exampleFormControlTextarea1\">문제지 Title</label><input type=\"text\" id=\"title\" name=\"title\" class=\"form-control\">\r\n");
      out.write("</div>\r\n");
      out.write("</td><td>\r\n");
      out.write("<div class=\"form-group\">\r\n");
      out.write("<label for=\"exampleFormControlTextarea1\">워터마크</label><input type=\"text\" id=\"waterMark\" name=\"waterMark\" class=\"form-control\">\r\n");
      out.write("</div>\r\n");
      out.write("</td>\r\n");
      out.write("</tr>\r\n");
      out.write("</table>\r\n");
      out.write("\t<button type=\"button\" onclick=\"preview();\" class=\"btn btn-default btn-sm\">미리보기</button>\r\n");
      out.write("\t<button type=\"button\" onclick=\"allCheck();\" class=\"btn btn-default btn-sm\">전체 선택</button>\r\n");
      out.write("\t<button type=\"button\" onclick=\"textDown();\" class=\"btn btn-default btn-sm\">오답 체크</button>\r\n");
      out.write("\t<div id=\"ddd\"></div>\r\n");
      out.write("<div id=\"qImg\" class=\"border\" style=\" overflow:auto;\">\r\n");
      out.write("<div id=\"left\"></div>\r\n");
      out.write("</div>\r\n");
      out.write("</form>\r\n");
} 
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>감성수학</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write(" <footer class=\"footer footer-default\">\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("      <nav class=\"float-left\">\r\n");
      out.write("        <ul>\r\n");
      out.write("          <li>\r\n");
      out.write("            <a href=\"#\">\r\n");
      out.write("              감성수학\r\n");
      out.write("            </a>\r\n");
      out.write("          </li>\r\n");
      out.write("        </ul>\r\n");
      out.write("      </nav>\r\n");
      out.write("      <div class=\"copyright float-right\">\r\n");
      out.write("        &copy;\r\n");
      out.write("        <script>\r\n");
      out.write("          document.write(new Date().getFullYear())\r\n");
      out.write("        </script>, made with <i class=\"material-icons\">favorite</i> by\r\n");
      out.write("        <a href=\"#\" target=\"blank\">감성수학</a> for a better web.\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("  </footer>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
