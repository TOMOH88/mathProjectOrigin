/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.37
 * Generated at: 2019-04-04 15:47:08 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.popup;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import popup.model.vo.Popup;
import admin.model.vo.Admin;

public final class popupListView_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/views/popup/../common/Adminheader.jsp", Long.valueOf(1554387696873L));
    _jspx_dependants.put("/views/popup/../common/footer.jsp", Long.valueOf(1554204971503L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("popup.model.vo.Popup");
    _jspx_imports_classes.add("admin.model.vo.Admin");
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
 
	ArrayList<Popup> plist = (ArrayList<Popup>)request.getAttribute("plist");
	int AllSearchListCount = ((Integer)request.getAttribute("AllSearchListCount")).intValue();
	int currentPage = ((Integer)request.getAttribute("currentPage")).intValue();
	int startPage = ((Integer)request.getAttribute("startPage")).intValue();
	int endPage = ((Integer)request.getAttribute("endPage")).intValue();
	int maxPage = ((Integer)request.getAttribute("maxPage")).intValue();
	String searchTitle = (String)request.getAttribute("searchTitle");

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Popup</title>\r\n");
      out.write("<meta content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0\" name=\"viewport\" />\r\n");
      out.write("  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\" />\r\n");
      out.write("  <!--     Fonts and icons     -->\r\n");
      out.write("  <link rel=\"stylesheet\" type=\"text/css\" href=\"https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons\" />\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css\">\r\n");
      out.write("  <!-- Material Kit CSS -->\r\n");
      out.write("  <link href=\"/math/resources/assets/css/material-dashboard.css?v=2.1.1\" rel=\"stylesheet\" />\r\n");
      out.write("  <link href=\"https://fonts.googleapis.com/css?family=Jua\" rel=\"stylesheet\">\r\n");
      out.write("</head>\r\n");
      out.write("<style>\r\n");
      out.write("table{\r\n");
      out.write("\tfont-family: 'Jua', sans-serif;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("div > h4{\r\n");
      out.write("\tfont-family: 'Jua', sans-serif;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("div > p{\r\n");
      out.write("\tfont-family: 'Jua', sans-serif;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("ul {\r\n");
      out.write("\tfont-family: 'Jua', sans-serif;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#d1{\r\n");
      out.write("\tfont-family: 'Jua', sans-serif;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
 String admin = (String)session.getAttribute("admin");

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title>adminheader</title>\r\n");
      out.write(" <meta charset=\"utf-8\">\r\n");
      out.write("  <meta content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0\" name=\"viewport\" />\r\n");
      out.write("  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\" />\r\n");
      out.write("  <!--     Fonts and icons     -->\r\n");
      out.write("  <link rel=\"stylesheet\" type=\"text/css\" href=\"https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons\" />\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css\">\r\n");
      out.write("  <!-- Material Kit CSS -->\r\n");
      out.write("  <link href=\"/math/resources/assets/css/material-dashboard.css?v=2.1.1\" rel=\"stylesheet\" />\r\n");
      out.write("  <link href=\"https://fonts.googleapis.com/css?family=Black+Han+Sans\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css?family=Do+Hyeon\" rel=\"stylesheet\">\r\n");
      out.write("  <script type=\"text/javascript\" src=\"/math/resources/js/jquery-3.3.1.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("function logout() {\r\n");
      out.write("\t\r\n");
      out.write("\tif(confirm(\"로그아웃 하시겠습니다.\")){\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\tlocation.href=\"/math/alogout\";\r\n");
      out.write("\t\t\r\n");
      out.write("\t}else{\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"wrapper \">\r\n");
      out.write("    <div class=\"sidebar\" data-color=\"purple\" data-background-color=\"white\">\r\n");
      out.write("      <!--\r\n");
      out.write("      Tip 1: You can change the color of the sidebar using: data-color=\"purple | azure | green | orange | danger\"\r\n");
      out.write("\r\n");
      out.write("      Tip 2: you can also add an image using data-image tag\r\n");
      out.write("  -->\r\n");
      out.write("      <div class=\"logo\">\r\n");
      out.write("        <a href=\"#\" class=\"simple-text logo-normal\" style=\"font-family: Black Han Sans;\">\r\n");
      out.write("          감성수학\r\n");
      out.write("        </a>\r\n");
      out.write("      </div>\r\n");
      out.write("      <div class=\"sidebar-wrapper\">\r\n");
      out.write("        <ul class=\"nav\">\r\n");
      out.write("          <li class=\"nav-item\">\r\n");
      out.write("            <a class=\"nav-link\" href=\"/math/nslist\" style=\"font-family: Black Han Sans;\">\r\n");
      out.write("              <i class=\"material-icons\">dashboard</i>\r\n");
      out.write("              <p>공지사항</p>\r\n");
      out.write("            </a>\r\n");
      out.write("          </li>\r\n");
      out.write("           <li class=\"nav-item\">\r\n");
      out.write("            <a class=\"nav-link\" href=\"/math/fslist\" style=\"font-family: Black Han Sans;\">\r\n");
      out.write("              <i class=\"material-icons\">description</i>\r\n");
      out.write("              <p>FAQ</p>\r\n");
      out.write("            </a>\r\n");
      out.write("          </li>\r\n");
      out.write("           <li class=\"nav-item\">\r\n");
      out.write("            <a class=\"nav-link\" href=\"/math/qslist\" style=\"font-family: Black Han Sans;\">\r\n");
      out.write("              <i class=\"material-icons\">toc</i>\r\n");
      out.write("              <p>QnA</p>\r\n");
      out.write("            </a>\r\n");
      out.write("          </li>\r\n");
      out.write("          <li class=\"nav-item\">\r\n");
      out.write("            <a class=\"nav-link\" href=\"/math/plist\" style=\"font-family: Black Han Sans;\">\r\n");
      out.write("              <i class=\"material-icons\">style</i>\r\n");
      out.write("              <p>팝업관리</p>\r\n");
      out.write("            </a>\r\n");
      out.write("          </li>\r\n");
      out.write("           <li class=\"nav-item\">\r\n");
      out.write("            <a class=\"nav-link\" href=\"/math/views/question/adminQuestionPrint.jsp\" style=\"font-family: Black Han Sans;\">\r\n");
      out.write("              <i class=\"material-icons\">import_contacts</i>\r\n");
      out.write("              <p>문제관리</p>\r\n");
      out.write("            </a>\r\n");
      out.write("          </li>\r\n");
      out.write("           <li class=\"nav-item\">\r\n");
      out.write("            <a class=\"nav-link\" href=\"/math/clist\" style=\"font-family: Black Han Sans;\">\r\n");
      out.write("              <i class=\"material-icons\">ondemand_video</i>\r\n");
      out.write("              <p>강의관리</p>\r\n");
      out.write("            </a>\r\n");
      out.write("          </li>\r\n");
      out.write("           <li class=\"nav-item\">\r\n");
      out.write("            <a class=\"nav-link\" href=\"/math/mmanager\" style=\"font-family: Black Han Sans;\">\r\n");
      out.write("              <i class=\"material-icons\">people</i>\r\n");
      out.write("              <p>회원관리</p>\r\n");
      out.write("            </a>\r\n");
      out.write("            </li>\r\n");
      out.write("          <!-- your sidebar here -->\r\n");
      out.write("        </ul>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"main-panel\">\r\n");
      out.write("      <!-- Navbar -->\r\n");
      out.write("      <nav class=\"navbar navbar-expand-lg navbar-transparent navbar-absolute fixed-top \">\r\n");
      out.write("        <div class=\"container-fluid\">\r\n");
      out.write("          <div class=\"navbar-wrapper\">\r\n");
      out.write("            <a class=\"navbar-brand\" href=\"#\" style=\"font-family: Black Han Sans;\">Admin</a>\r\n");
      out.write("          </div>\r\n");
      out.write("          <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" aria-controls=\"navigation-index\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n");
      out.write("            <span class=\"sr-only\">Toggle navigation</span>\r\n");
      out.write("            <span class=\"navbar-toggler-icon icon-bar\"></span>\r\n");
      out.write("            <span class=\"navbar-toggler-icon icon-bar\"></span>\r\n");
      out.write("            <span class=\"navbar-toggler-icon icon-bar\"></span>\r\n");
      out.write("          </button>\r\n");
      out.write("          ");
if(admin!=null){ 
      out.write("\r\n");
      out.write("          <div class=\"collapse navbar-collapse justify-content-end\">\r\n");
      out.write("            <ul class=\"navbar-nav\">\r\n");
      out.write("              <li class=\"nav-item\">\r\n");
      out.write("                <a class=\"nav-link\" onclick=\"logout();\" style=\"font-family: Black Han Sans; cursor:pointer;\">\r\n");
      out.write("                  <i class=\"material-icons\">power_settings_new</i> logout\r\n");
      out.write("                </a>\r\n");
      out.write("              </li>\r\n");
      out.write("              <!-- your navbar here -->\r\n");
      out.write("            </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("            ");
}else{ 
      out.write("\r\n");
      out.write("                      <div class=\"collapse navbar-collapse justify-content-end\">\r\n");
      out.write("            <ul class=\"navbar-nav\">\r\n");
      out.write("              <li class=\"nav-item\">\r\n");
      out.write("                <a class=\"nav-link\" href=\"/math/admin.jsp\" style=\"font-family: Black Han Sans; cursor:pointer;\">\r\n");
      out.write("                  <i class=\"material-icons\">power_settings_new</i> login\r\n");
      out.write("                </a>\r\n");
      out.write("              </li>\r\n");
      out.write("              <!-- your navbar here -->\r\n");
      out.write("            </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("            ");
} 
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("      </nav>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write(" <div class=\"content\">\r\n");
      out.write("        <div class=\"container-fluid\">\r\n");
      out.write("          <div class=\"row\">\r\n");
      out.write("            <div class=\"col-md-12\">\r\n");
      out.write("              <div class=\"card\">\r\n");
      out.write("                <div class=\"card-header card-header-primary\">\r\n");
      out.write("                  <h4 class=\"card-title \">팝업관리</h4>\r\n");
      out.write("                  <p class=\"card-category\"> 현재 게시글 수 : ");
      out.print(AllSearchListCount );
      out.write("</p>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"card-body\">\r\n");
      out.write("                  <div class=\"table-responsive\">\r\n");
      out.write("                    <table class=\"table table-striped table-hover\">\r\n");
      out.write("                      <thead class=\" text-primary\">\r\n");
      out.write("\t<tr class=\"table-primary\">\r\n");
      out.write("\t\t<th>글번호</th>\r\n");
      out.write("\t\t<th>제목</th>\r\n");
      out.write("\t\t<th>이미지</th>\r\n");
      out.write("\t\t<th>등록날짜</th>\r\n");
      out.write("\t\t<th>종료날짜</th>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t</thead>\r\n");
      out.write("\t");
 for(int n = 0; n < plist.size(); n++){ 
      out.write("\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>");
      out.print(plist.get(n).getPopupNo() );
      out.write("</td>\r\n");
      out.write("\t\t<td><a href=\"/math/pdetail?no=");
      out.print(plist.get(n).getPopupNo());
      out.write('"');
      out.write('>');
      out.print(plist.get(n).getPopupName() );
      out.write("</a></td>\r\n");
      out.write("\t\t<td>");
      out.print(plist.get(n).getPopupImagePath() );
      out.write("</td>\r\n");
      out.write("\t\t<td>");
      out.print(plist.get(n).getPopupDate() );
      out.write("</td>\r\n");
      out.write("\t\t<td>");
      out.print(plist.get(n).getPopupEndDate() );
      out.write("</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t");
 } 
      out.write("\r\n");
      out.write("</table>\r\n");
      out.write("<ul class=\"pagination pagination-primary\" style=\"justify-content: center;\">\r\n");
      out.write("\t");
 if(currentPage <= 1){ 
      out.write("\r\n");
      out.write("\t<li class=\"page-item\">\r\n");
      out.write("\t\t<a class=\"page-link\">[맨처음]&nbsp; </a>\r\n");
      out.write("\t\t</li>\r\n");
      out.write("\t");
 }else if(searchTitle != null){ 
      out.write("\r\n");
      out.write("\t<li class=\"page-item\">\r\n");
      out.write("\t\t<a href=\"/math/plist?page=1&title=");
      out.print(searchTitle);
      out.write("\" class=\"page-link\">[맨처음]</a>\r\n");
      out.write("\t\t</li>\r\n");
      out.write("\t");
 }else{ 
      out.write("\r\n");
      out.write("\t<li class=\"page-item\">\r\n");
      out.write("\t\t<a href=\"/math/plist?page=1\">[맨처음]</a>&nbsp;\r\n");
      out.write("\t\t</li>\r\n");
      out.write("\t");
} if((currentPage - 5) <= startPage && (endPage - 5) >= 1){ 
      out.write("\r\n");
      out.write("\t<li class=\"page-item\">\r\n");
      out.write("\t\t<a href=\"/math/plist?page=");
      out.print( (startPage - 5) + 4   );
      out.write("&title=");
      out.print(searchTitle);
      out.write("\" class=\"page-link\">[이전]</a>&nbsp;\r\n");
      out.write("\t\t</li>\r\n");
      out.write("\t");
 }else{
      out.write("\r\n");
      out.write("\t<li class=\"page-item\">\r\n");
      out.write("\t\t<a class=\"page-link\"> [이전] </a>\r\n");
      out.write("\t\t</li>\r\n");
      out.write("\t");
} for(int p = startPage; p <= endPage; p++){ 
			if(p == currentPage){
      out.write("\r\n");
      out.write("\t\t\t<li class=\"page-item\">\r\n");
      out.write("\t\t\t\t<a class=\"page-link\"> <font>[");
      out.print(p );
      out.write("]</font> </a>\r\n");
      out.write("\t\t\t\t</li>\r\n");
      out.write("\t\t\t");
}else if(searchTitle != null){ 
      out.write("\r\n");
      out.write("\t\t\t<li class=\"page-item\">\r\n");
      out.write("\t\t\t\t<a href=\"/math/plist?page=");
      out.print(p);
      out.write("&title=");
      out.print(searchTitle);
      out.write("\" v>");
      out.print(p );
      out.write("</a>\r\n");
      out.write("\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t");
}else{ 
      out.write("\r\n");
      out.write("\t\t\t\t<li class=\"page-item\">\r\n");
      out.write("\t\t\t\t<a href=\"/math/plist?page=");
      out.print(p);
      out.write("\" class=\"page-link\">");
      out.print(p );
      out.write("</a>\r\n");
      out.write("\t\t\t\t</li>\r\n");
      out.write("\t");
 }} 
      out.write('\r');
      out.write('\n');
      out.write('	');
 if((startPage + 5) <= maxPage && (currentPage + 5) >= startPage){ 
      out.write("\r\n");
      out.write("\t<li>\r\n");
      out.write("\t\t<a href=\"/math/plist?page=");
      out.print(startPage+5);
      out.write("&title=");
      out.print(searchTitle );
      out.write("\">&nbsp;[다음]</a>\r\n");
      out.write("\t\t</li>\r\n");
      out.write("\t");
}else{ 
      out.write("\r\n");
      out.write("\t<li class=\"page-item\">\r\n");
      out.write("\t\t<a class=\"page-link\"> [다음]&nbsp; </a>\r\n");
      out.write("\t\t</li>\r\n");
      out.write("\t");
} 
      out.write('\r');
      out.write('\n');
      out.write('	');
 if(currentPage >= maxPage){ 
      out.write("\r\n");
      out.write("\t<li class=\"page-item\">\r\n");
      out.write("\t\t<a class=\"page-link\"> &nbsp;[마지막] </a>\r\n");
      out.write("\t\t</li>\r\n");
      out.write("\t");
 }else if(searchTitle != null){ 
      out.write("\r\n");
      out.write("\t<li class=\"page-item\">\r\n");
      out.write("\t\t<a href=\"/math/plist?page=");
      out.print(maxPage);
      out.write("&title=");
      out.print(searchTitle);
      out.write("\" class=\"page-link\">&nbsp;[마지막]</a>\r\n");
      out.write("\t\t</li>\r\n");
      out.write("\t");
 }else{ 
      out.write("\r\n");
      out.write("\t<li class=\"page-item\">\r\n");
      out.write("\t\t<a href=\"/math/plist?page=");
      out.print(maxPage);
      out.write("\" class=\"page-link\">&nbsp;[마지막]</a>\r\n");
      out.write("\t\t</li>\r\n");
      out.write("\t");
} 
      out.write("\r\n");
      out.write("\t</ul>\r\n");
      out.write("<div align=\"center\" id=\"d1\">\r\n");
      out.write("<form action=\"/math/plist?page=1\" method=\"post\" class=\"form-inline ml-auto\">\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("\t<select class=\"form-control\">\r\n");
      out.write("\t\t<option value=\"\">선택하시오</option>\r\n");
      out.write("\t\t<option name=\"title\" value=\"title\" >제목</option>\r\n");
      out.write("\t</select>\r\n");
      out.write("\t&nbsp;\r\n");
      out.write("\t<input type=\"text\" name=\"title\" class=\"form-control\" placeholder=\"Search\">\r\n");
      out.write("\t<button type=\"submit\" class=\"btn btn-white btn-raised btn-fab btn-round\">\r\n");
      out.write("                    <i class=\"material-icons\">search</i>\r\n");
      out.write("                  </button>\r\n");
      out.write("                  </div>\r\n");
      out.write("</form>\r\n");
      out.write("<button onclick=\"javascript:location.href='views/popup/popupWriteView.jsp'\" type=\"button\" class=\"btn btn-primary btn-sm\">팝업등록</button>\r\n");
      out.write("</div>\r\n");
      out.write("</div>\r\n");
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
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("  <meta content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0\" name=\"viewport\" />\r\n");
      out.write("  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\" />\r\n");
      out.write("  <!--     Fonts and icons     -->\r\n");
      out.write("  <link rel=\"stylesheet\" type=\"text/css\" href=\"https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons\" />\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css\">\r\n");
      out.write("  <!-- Material Kit CSS -->\r\n");
      out.write("  <link href=\"/math/resources/assets/css/material-dashboard.css?v=2.1.1\" rel=\"stylesheet\" />\r\n");
      out.write("  <link href=\"https://fonts.googleapis.com/css?family=Jua\" rel=\"stylesheet\">\r\n");
      out.write("    <title>footer</title>\r\n");
      out.write("</head>\r\n");
      out.write("<style>\r\n");
      out.write("\tfooter{\r\n");
      out.write("\t\tfont-family: 'Jua', sans-serif;\r\n");
      out.write("\t}\r\n");
      out.write("</style>\r\n");
      out.write("<body>\r\n");
      out.write("      <footer class=\"footer\">\r\n");
      out.write("        <div class=\"container-fluid\">\r\n");
      out.write("          <nav class=\"float-left\">\r\n");
      out.write("            <ul>\r\n");
      out.write("              <li>\r\n");
      out.write("                <a href=\"#\">\r\n");
      out.write("                  감성수학\r\n");
      out.write("                </a>\r\n");
      out.write("              </li>\r\n");
      out.write("            </ul>\r\n");
      out.write("          </nav>\r\n");
      out.write("          <div class=\"copyright float-right\">\r\n");
      out.write("            &copy;\r\n");
      out.write("            <script>\r\n");
      out.write("              document.write(new Date().getFullYear())\r\n");
      out.write("            </script>, made with <i class=\"material-icons\">favorite</i> by\r\n");
      out.write("            <a href=\"#\" target=\"_blank\">감성수학</a> for a better web.\r\n");
      out.write("          </div>\r\n");
      out.write("          <!-- your footer here -->\r\n");
      out.write("        </div>\r\n");
      out.write("      </footer>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script src=\"/math/resources/assets/js/core/jquery.min.js\"></script>\r\n");
      out.write("  <script src=\"/math/resources/assets/js/core/popper.min.js\"></script>\r\n");
      out.write("  <script src=\"/math/resources/assets/js/core/bootstrap-material-design.min.js\"></script>\r\n");
      out.write("  <script src=\"/math/resources/assets/js/plugins/perfect-scrollbar.jquery.min.js\"></script>\r\n");
      out.write("  <!-- Include a polyfill for ES6 Promises (optional) for IE11, UC Browser and Android browser support SweetAlert -->\r\n");
      out.write("  <script src=\"https://cdnjs.cloudflare.com/ajax/libs/core-js/2.4.1/core.js\"></script>\r\n");
      out.write("  <!-- Library for adding dinamically elements -->\r\n");
      out.write("  <script src=\"/math/resources/assets/js/plugins/arrive.min.js\"></script>\r\n");
      out.write("  <!-- Chartist JS -->\r\n");
      out.write("  <script src=\"/math/resources/assets/js/plugins/chartist.min.js\"></script>\r\n");
      out.write("  <!--  Notifications Plugin    -->\r\n");
      out.write("  <script src=\"/math/resources/assets/js/plugins/bootstrap-notify.js\"></script>\r\n");
      out.write("  <!-- Control Center for Material Dashboard: parallax effects, scripts for the example pages etc -->\r\n");
      out.write("  <script src=\"/math/resources/assets/js/material-dashboard.js?v=2.1.1\" type=\"text/javascript\"></script>\r\n");
      out.write("  <!-- Material Dashboard DEMO methods, don't include it in your project! -->\r\n");
      out.write("  <script src=\"/math/resources/assets/demo/demo.js\"></script>\r\n");
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
