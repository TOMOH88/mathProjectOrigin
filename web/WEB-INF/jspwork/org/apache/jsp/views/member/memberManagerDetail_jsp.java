/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.37
 * Generated at: 2019-03-28 11:44:05 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import admin.model.vo.Semester;
import java.util.ArrayList;
import member.model.vo.Member;

public final class memberManagerDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/views/member/../common/footer.jsp", Long.valueOf(1552500476847L));
    _jspx_dependants.put("/views/member/../common/Adminheader.jsp", Long.valueOf(1553598609823L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("admin.model.vo.Semester");
    _jspx_imports_classes.add("member.model.vo.Member");
    _jspx_imports_classes.add("java.util.ArrayList");
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
 Member member = (Member)request.getAttribute("member");
	ArrayList<Semester> slist = (ArrayList<Semester>)request.getAttribute("semester");
	ArrayList<Semester> mylist = (ArrayList<Semester>)request.getAttribute("permission");

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>감성수학</title>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/math/resources/js/jquery-3.3.1.min.js\"></script>\r\n");
      out.write(" <script type=\"text/javascript\">\r\n");
      out.write("function changePwd() {\r\n");
      out.write("\tvar pwd1 = $(\"#password\").val();\r\n");
      out.write("\tvar pwd2 = $(\"#password1\").val();\r\n");
      out.write("\tif(pwd1 != pwd2){\r\n");
      out.write("\t\talert(\"암호와 암호 확인이 일치하지 않습니다.\\n\"\r\n");
      out.write("\t\t\t\t+\"다시 입력하십시요.\");\r\n");
      out.write("\t\t$(\"#password\").select();\r\n");
      out.write("\t}else{\r\n");
      out.write("\t\tif(confirm(\"적용하시겠습니까?\")){\r\n");
      out.write("\t\t$.ajax({\r\n");
      out.write("\t\t\turl: \"/math/mpwdchange\",\r\n");
      out.write("\t\t\ttype: \"post\",\r\n");
      out.write("\t\t\tdata: {password : $(\"#password\").val(),\r\n");
      out.write("\t\t\t\tuserid: $(\"#userid\").val()},\r\n");
      out.write("\t\t\tsuccess: function(data) {\r\n");
      out.write("\t\t\t\t\tif(data == \"ok\"){\r\n");
      out.write("\t\t\t\t\t\talert(\"변경되였습니다.\");\r\n");
      out.write("\t\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t\talert(\"변경실패!\");\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\terror: function( jqXHR, textStatus, errorThrown) {\r\n");
      out.write("\t\t\t\tconsole.log(\"error : \"+  jqXHR +\", \"+textStatus+\", \"+errorThrown);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t}else{\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("};\r\n");
      out.write("\r\n");
      out.write("function sendmail(){\r\n");
      out.write("\tif(confirm(\"적용하시겠습니까?\")){\r\n");
      out.write("\t$.ajax({\r\n");
      out.write("\t\turl: \"/math/sendemail\",\r\n");
      out.write("\t\ttype: \"post\",\r\n");
      out.write("\t\tdata: {userid: $(\"#userid\").val()},\r\n");
      out.write("\t\tsuccess: function(data) {\r\n");
      out.write("\t\t\t\tif(data == \"ok\"){\r\n");
      out.write("\t\t\t\t\talert(\"변경되였습니다.\");\r\n");
      out.write("\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\talert(\"변경실패!\");\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t},\r\n");
      out.write("\t\terror: function( jqXHR, textStatus, errorThrown) {\r\n");
      out.write("\t\t\tconsole.log(\"error : \"+  jqXHR +\", \"+textStatus+\", \"+errorThrown);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t});\r\n");
      out.write("\t}else{\r\n");
      out.write("\t\treturn false;\t\r\n");
      out.write("\t}\r\n");
      out.write("\t};\r\n");
      out.write("\t\r\n");
      out.write("\tvar arr = new Array();\r\n");
      out.write("\tfunction addPermission() {\r\n");
      out.write("\t\tvar per = $(\"#s1\").val();\t\r\n");
      out.write("\t\tvar arr2 = new Array();\r\n");
      out.write("\t\tvar per2 = \"\";\r\n");
      out.write("\t\tarr.push(per);\r\n");
      out.write("\t\tarr2 =arr.slice().sort(function(a,b){return a - b}).reduce(function(a,b){if (a.slice(-1)[0] !== b) a.push(b);return a;},[]);\r\n");
      out.write("\t\tfor(var i= 0; i<arr2.length;i++){\r\n");
      out.write("\t\t\tper2 += arr2[i]+\" \";\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t$(\"#d1\").html(per2); \r\n");
      out.write("\t\tconsole.log(arr2); \r\n");
      out.write("\r\n");
      out.write("\t};\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\tfunction sendAddPer() {\r\n");
      out.write("\t\tif(confirm(\"권한을 적용하시겠습니까?\")){\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\turl: \"/math/addper\",\r\n");
      out.write("\t\t\t\ttype: \"post\",\r\n");
      out.write("\t\t\t\tdata: {userid : $(\"#userid\").val(),\r\n");
      out.write("\t\t\t\t\t    per: $(\"#d1\").text()},\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tsuccess: function(data) {\r\n");
      out.write("\t\t\t\t\t\tif(data == \"ok\"){\r\n");
      out.write("\t\t\t\t\t\t\talert(\"변경되였습니다.\");\r\n");
      out.write("\t\t\t\t\t\t\twindow.location.reload();\r\n");
      out.write("\t\t\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t\t\talert(\"권한주기 오류 확인후 다시해주세요\");\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\terror: function( jqXHR, textStatus, errorThrown) {\r\n");
      out.write("\t\t\t\t\tconsole.log(\"error : \"+  jqXHR +\", \"+textStatus+\", \"+errorThrown);\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t}else{\r\n");
      out.write("\t\t\t$(\"#d1\").html(\"\");\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t};\r\n");
      out.write("\tfunction remove1() {\r\n");
      out.write("\t\tarr=Array();\r\n");
      out.write("\t\t$(\"#d1\").html(\"\");\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction allCheck() {\r\n");
      out.write("\t\t$(\":checkbox\").prop(\"checked\",true);\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction unCheck() {\r\n");
      out.write("\t\t$(\":checkbox\").prop(\"checked\",false);\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction removePermission() {\r\n");
      out.write("\t\tvar items = \"\";\r\n");
      out.write("\t\t$(\"input:checkbox[type=checkbox]:checked\").each(function() {\r\n");
      out.write("\t\t\titems+= $(this).val()+\" \";\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\tif(confirm(\"권한을 삭제하시겠습니까?\")){\r\n");
      out.write("\r\n");
      out.write("\t\t\tconsole.log(items);\r\n");
      out.write("\t\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\t\turl: \"/math/removeper\",\r\n");
      out.write("\t\t\t\t\ttype: \"post\",\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\tdata: {userid : $(\"#userid\").val(),\r\n");
      out.write("\t\t\t\t\t\t    per: items },\r\n");
      out.write("\t\t\t\t\tsuccess: function(data) {\r\n");
      out.write("\t\t\t\t\t\t\tif(data == \"ok\"){\r\n");
      out.write("\t\t\t\t\t\t\t\talert(\"변경되였습니다.\");\r\n");
      out.write("\t\t\t\t\t\t\t\twindow.location.reload();\r\n");
      out.write("\t\t\t\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t\t\t\talert(\"권한주기 오류 확인후 다시해주세요\");\r\n");
      out.write("\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\terror: function( jqXHR, textStatus, errorThrown) {\r\n");
      out.write("\t\t\t\t\t\tconsole.log(\"error : \"+  jqXHR +\", \"+textStatus+\", \"+errorThrown);\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t} else {\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write('\n');
  
	String adminId = (String)session.getAttribute("admin");

      out.write("    \n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta charset=\"utf-8\">\n");
      out.write("  <meta content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0\" name=\"viewport\" />\n");
      out.write("  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\" />\n");
      out.write("  <!--     Fonts and icons     -->\n");
      out.write("  <link rel=\"stylesheet\" type=\"text/css\" href=\"https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons\" />\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css\">\n");
      out.write("  <!-- Material Kit CSS -->\n");
      out.write("  <link href=\"/math/resources/assets/css/material-dashboard.css?v=2.1.1\" rel=\"stylesheet\" />\n");
      out.write("    <title>adminheader</title>\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("<title>감성수학</title>\n");
      out.write("<script type=\"text/javascript\" src=\"/math/resources/js/jquery-3.3.1.min.js\"></script>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("</script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<div class=\"wrapper \">\n");
      out.write("    <div class=\"sidebar\" data-color=\"purple\" data-background-color=\"white\">\n");
      out.write("      <!--\n");
      out.write("      Tip 1: You can change the color of the sidebar using: data-color=\"purple | azure | green | orange | danger\"\n");
      out.write("\n");
      out.write("      Tip 2: you can also add an image using data-image tag\n");
      out.write("  -->\n");
      out.write("      <div class=\"logo\">\n");
      out.write("        <a href=\"#\" class=\"simple-text logo-normal\">\n");
      out.write("          감성수학\n");
      out.write("        </a>\n");
      out.write("      </div>\n");
      out.write("      <div class=\"sidebar-wrapper\">\n");
      out.write("        <ul class=\"nav\">\n");
      out.write("          <li class=\"nav-item active  \">\n");
      out.write("            <a class=\"nav-link\" href=\"#\">\n");
      out.write("              <i class=\"material-icons\">dashboard</i>\n");
      out.write("              <p>감성수학</p>\n");
      out.write("            </a>\n");
      out.write("          </li>\n");
      out.write("          <li class=\"nav-item \">\n");
      out.write("            <a class=\"nav-link\" href=\"/math/nslist\">\n");
      out.write("              <i class=\"material-icons\">dashboard</i>\n");
      out.write("              <p>공지사항관리</p>\n");
      out.write("            </a>\n");
      out.write("          </li>\n");
      out.write("          <li class=\"nav-item \">\n");
      out.write("            <a class=\"nav-link\" href=\"/math/fslist\">\n");
      out.write("              <i class=\"material-icons\">dashboard</i>\n");
      out.write("              <p>FAQ관리</p>\n");
      out.write("            </a>\n");
      out.write("          </li>\n");
      out.write("          <li class=\"nav-item \">\n");
      out.write("            <a class=\"nav-link\" href=\"/math/qslist\">\n");
      out.write("              <i class=\"material-icons\">dashboard</i>\n");
      out.write("              <p>QnA관리</p>\n");
      out.write("            </a>\n");
      out.write("          </li>\n");
      out.write("          <li class=\"nav-item \">\n");
      out.write("            <a class=\"nav-link\" href=\"#\">\n");
      out.write("              <i class=\"material-icons\">dashboard</i>\n");
      out.write("              <p>문제관리</p>\n");
      out.write("            </a>\n");
      out.write("          </li>\n");
      out.write("          <li class=\"nav-item \">\n");
      out.write("            <a class=\"nav-link\" href=\"#\">\n");
      out.write("              <i class=\"material-icons\">dashboard</i>\n");
      out.write("              <p>강의관리</p>\n");
      out.write("            </a>\n");
      out.write("          </li>\n");
      out.write("          <li class=\"nav-item \">\n");
      out.write("            <a class=\"nav-link\" href=\"/math/plist\">\n");
      out.write("              <i class=\"material-icons\">dashboard</i>\n");
      out.write("              <p>팝업관리</p>\n");
      out.write("            </a>\n");
      out.write("          </li>\n");
      out.write("          <li class=\"nav-item \">\n");
      out.write("            <a class=\"nav-link\" href=\"/math/mmanager\">\n");
      out.write("              <i class=\"material-icons\">dashboard</i>\n");
      out.write("              <p>회원관리</p>\n");
      out.write("            </a>\n");
      out.write("          </li>\n");
      out.write("          <li class=\"nav-item \">\n");
      out.write("            <a class=\"nav-link\" href=\"/math/views/main/test.jsp\">\n");
      out.write("              <i class=\"material-icons\">dashboard</i>\n");
      out.write("              <p>테스트</p>\n");
      out.write("            </a>\n");
      out.write("          </li>\n");
      out.write("          <li class=\"nav-item \">\n");
      out.write("            <a class=\"nav-link\" href=\"/math/views/main/test2.jsp\">\n");
      out.write("              <i class=\"material-icons\">dashboard</i>\n");
      out.write("              <p>테스트2</p>\n");
      out.write("            </a>\n");
      out.write("          </li>\n");
      out.write("          <!-- your sidebar here -->\n");
      out.write("        </ul>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"main-panel\">\n");
      out.write("      <!-- Navbar -->\n");
      out.write("      <nav class=\"navbar navbar-expand-lg navbar-transparent navbar-absolute fixed-top \">\n");
      out.write("        <div class=\"container-fluid\">\n");
      out.write("          <div class=\"navbar-wrapper\">\n");
      out.write("            <a class=\"navbar-brand\" href=\"#\">Dashboard</a>\n");
      out.write("          </div>\n");
      out.write("          <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" aria-controls=\"navigation-index\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("            <span class=\"sr-only\">Toggle navigation</span>\n");
      out.write("            <span class=\"navbar-toggler-icon icon-bar\"></span>\n");
      out.write("            <span class=\"navbar-toggler-icon icon-bar\"></span>\n");
      out.write("            <span class=\"navbar-toggler-icon icon-bar\"></span>\n");
      out.write("          </button>\n");
      out.write("          <div class=\"collapse navbar-collapse justify-content-end\">\n");
      out.write("            <ul class=\"navbar-nav\">\n");
      out.write("              <li class=\"nav-item\">\n");
      out.write("                <a class=\"nav-link\" href=\"/math/alogout\">\n");
      out.write("                  <i class=\"material-icons\">notifications</i> logout\n");
      out.write("                </a>\n");
      out.write("              </li>\n");
      out.write("              <!-- your navbar here -->\n");
      out.write("            </ul>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("      </nav>\n");
      out.write("</body>\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("<div class=\"content\">\r\n");
      out.write("        <div class=\"container-fluid\">\r\n");
      out.write("          <div class=\"card\">\r\n");
      out.write("            <div class=\"card-header card-header-primary\">\r\n");
      out.write("              <h4 class=\"card-title\">회원정보</h4>\r\n");
      out.write("              <p class=\"card-category\">회원정보수정</p>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"card-body\">\r\n");
      out.write("              <div id=\"typography\">\r\n");
      out.write("                <div class=\"card-title\">\r\n");
      out.write("<table class=\"table\">\r\n");
      out.write("<tr></tr>\r\n");
      out.write("<tr><td>회원 아이디 </td><th><input type=\"text\" id=\"userid\" value=\"");
      out.print(member.getUserId());
      out.write("\" readonly=\"readonly\"></th></tr>\r\n");
      out.write("<tr><td>회원 이름</td><th>");
      out.print(member.getUserName() );
      out.write("</th></tr>\r\n");
      out.write("<tr><td>전화번호</td><th>");
      out.print(member.getPhone() );
      out.write("</th></tr>\r\n");
      out.write("<tr><td>비밀번호</td><th><input type=\"password\" name=\"password\" id=\"password\" value=\"");
      out.print(member.getUserPwd() );
      out.write("\"></th></tr>\r\n");
      out.write("<tr><td>비밀번호 확인</td><th><input type=\"password\" name=\"password\" id=\"password1\" value=\"");
      out.print(member.getUserPwd() );
      out.write("\"></th></tr>\r\n");
      out.write("<tr><td colspan=\"2\"><button onclick=\"changePwd();\" class=\"btn btn-default\">변경</button>&nbsp;&nbsp;<button onclick=\"sendmail();\" class=\"btn btn-default\">비밀번호 초기화</button></td></tr>\r\n");
      out.write("<tr><td>가입일</td><th>");
      out.print(member.getRegistDate() );
      out.write("</th></tr>\r\n");
      out.write("<tr><td>최종 수정일</td><th>");
      out.print(member.getLastModified() );
      out.write("</th></tr>\r\n");
      out.write("<tr><td>권한 주기</td>\r\n");
      out.write("<th>\r\n");
      out.write("<Select id=\"s1\">\r\n");
      out.write("\t<option selected=\"selected\">모든권한</option>\r\n");
      out.write("\t");
for(Semester s : slist){ 
      out.write("\r\n");
      out.write("\t<option>");
      out.print(s.getSemesterName() );
      out.write("</option>\r\n");
      out.write("\t");
} 
      out.write("\r\n");
      out.write("</Select>\r\n");
      out.write("<button onclick=\"addPermission();\">권한추가</button>\r\n");
      out.write("</th></tr>\r\n");
      out.write("<tr><th><div id=\"d1\"></div></th><th><button onclick=\"sendAddPer();\">권한 주기</button><button onclick=\"remove1();\">선택한 권한지우기</button></th></tr>\r\n");
      out.write("<tr><td>보유 권한</td><th>\r\n");
      out.write("<tr><td colspan=\"2\">\r\n");
for(int i =0 ; i<mylist.size();i++){
      out.write("\r\n");
      out.write("<input type=\"checkbox\" id=\"ckd\" value=\"");
      out.print(mylist.get(i).getSemesterName());
      out.write('"');
      out.write('>');
      out.print(mylist.get(i).getSemesterName() );
      out.write("</input>&nbsp;&nbsp;\r\n");
if((i+1)%4==0){
	out.print("<br>");
}}

      out.write("\r\n");
      out.write("</td></tr>\r\n");
      out.write("<tr><td colspan=\"2\">\r\n");
      out.write("<button onclick=\"allCheck();\">모두 선택</button>&nbsp;&nbsp;\r\n");
      out.write("<button onclick=\"unCheck();\">모두 해제</button>&nbsp;&nbsp;\r\n");
      out.write("<button onclick=\"removePermission();\">권한삭제</button>\r\n");
      out.write("</td></tr>\r\n");
      out.write("</table>\r\n");
      out.write("</div>\r\n");
      out.write("</div>\r\n");
      out.write("</div>\r\n");
      out.write("</div>\r\n");
      out.write("</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<style>\r\n");
      out.write("</style>\r\n");
      out.write("<title>감성수학</title>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<hr>\r\n");
      out.write("<footer align=\"center\">\r\n");
      out.write("<h1>감성수학</h1> \r\n");
      out.write("</footer>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
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
