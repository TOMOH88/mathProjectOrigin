/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.37
 * Generated at: 2019-03-26 08:41:44 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.notice;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import notice.model.vo.Notice;

public final class noticeListView_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/views/notice/../common/Adminheader.jsp", Long.valueOf(1553586335313L));
    _jspx_dependants.put("/views/notice/../common/footer.jsp", Long.valueOf(1553578571042L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("notice.model.vo.Notice");
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
      out.write("    \r\n");

	ArrayList<Notice> nsList = (ArrayList<Notice>)request.getAttribute("nslist");
	int AllSearchListCount = ((Integer)request.getAttribute("AllSearchListCount")).intValue();
	int currentPage = ((Integer)request.getAttribute("currentPage")).intValue();
	int startPage = ((Integer)request.getAttribute("startPage")).intValue();
	int endPage = ((Integer)request.getAttribute("endPage")).intValue();
	int maxPage = ((Integer)request.getAttribute("maxPage")).intValue();
	String searchTitle = (String)request.getAttribute("searchTitle");
	String nOption = (String)request.getAttribute("noption");

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
      out.write("</head>\r\n");
      out.write("<style>\r\n");
      out.write(".box1 ul li{\r\n");
      out.write("\ttext-align:center;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<body>\r\n");
      out.write('\r');
      out.write('\n');
  
	String adminId = (String)session.getAttribute("admin");

      out.write("    \r\n");
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
      out.write("    <title>adminheader</title>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>감성수학</title>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/math/resources/js/jquery-3.3.1.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
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
      out.write("        <a href=\"#\" class=\"simple-text logo-normal\">\r\n");
      out.write("          감성수학\r\n");
      out.write("        </a>\r\n");
      out.write("      </div>\r\n");
      out.write("      <div class=\"sidebar-wrapper\">\r\n");
      out.write("        <ul class=\"nav\">\r\n");
      out.write("          <li class=\"nav-item active  \">\r\n");
      out.write("            <a class=\"nav-link\" href=\"#\">\r\n");
      out.write("              <i class=\"material-icons\">dashboard</i>\r\n");
      out.write("              <p>감성수학</p>\r\n");
      out.write("            </a>\r\n");
      out.write("          </li>\r\n");
      out.write("          <li class=\"nav-item \">\r\n");
      out.write("            <a class=\"nav-link\" href=\"/math/nslist\">\r\n");
      out.write("              <i class=\"material-icons\">dashboard</i>\r\n");
      out.write("              <p>공지사항관리</p>\r\n");
      out.write("            </a>\r\n");
      out.write("          </li>\r\n");
      out.write("          <li class=\"nav-item \">\r\n");
      out.write("            <a class=\"nav-link\" href=\"#\">\r\n");
      out.write("              <i class=\"material-icons\">dashboard</i>\r\n");
      out.write("              <p>FAQ관리</p>\r\n");
      out.write("            </a>\r\n");
      out.write("          </li>\r\n");
      out.write("          <li class=\"nav-item \">\r\n");
      out.write("            <a class=\"nav-link\" href=\"#\">\r\n");
      out.write("              <i class=\"material-icons\">dashboard</i>\r\n");
      out.write("              <p>QnA관리</p>\r\n");
      out.write("            </a>\r\n");
      out.write("          </li>\r\n");
      out.write("          <li class=\"nav-item \">\r\n");
      out.write("            <a class=\"nav-link\" href=\"#\">\r\n");
      out.write("              <i class=\"material-icons\">dashboard</i>\r\n");
      out.write("              <p>문제관리</p>\r\n");
      out.write("            </a>\r\n");
      out.write("          </li>\r\n");
      out.write("          <li class=\"nav-item \">\r\n");
      out.write("            <a class=\"nav-link\" href=\"#\">\r\n");
      out.write("              <i class=\"material-icons\">dashboard</i>\r\n");
      out.write("              <p>강의관리</p>\r\n");
      out.write("            </a>\r\n");
      out.write("          </li>\r\n");
      out.write("          <li class=\"nav-item \">\r\n");
      out.write("            <a class=\"nav-link\" href=\"/math/plist\">\r\n");
      out.write("              <i class=\"material-icons\">dashboard</i>\r\n");
      out.write("              <p>팝업관리</p>\r\n");
      out.write("            </a>\r\n");
      out.write("          </li>\r\n");
      out.write("          <li class=\"nav-item \">\r\n");
      out.write("            <a class=\"nav-link\" href=\"/math/mmanager\">\r\n");
      out.write("              <i class=\"material-icons\">dashboard</i>\r\n");
      out.write("              <p>회원관리</p>\r\n");
      out.write("            </a>\r\n");
      out.write("          </li>\r\n");
      out.write("          <li class=\"nav-item \">\r\n");
      out.write("            <a class=\"nav-link\" href=\"/math/views/main/test.jsp\">\r\n");
      out.write("              <i class=\"material-icons\">dashboard</i>\r\n");
      out.write("              <p>테스트</p>\r\n");
      out.write("            </a>\r\n");
      out.write("          </li>\r\n");
      out.write("          <li class=\"nav-item \">\r\n");
      out.write("            <a class=\"nav-link\" href=\"/math/views/main/test2.jsp\">\r\n");
      out.write("              <i class=\"material-icons\">dashboard</i>\r\n");
      out.write("              <p>테스트2</p>\r\n");
      out.write("            </a>\r\n");
      out.write("          </li>\r\n");
      out.write("          <!-- your sidebar here -->\r\n");
      out.write("        </ul>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"main-panel\">\r\n");
      out.write("      <!-- Navbar -->\r\n");
      out.write("      <nav class=\"navbar navbar-expand-lg navbar-transparent navbar-absolute fixed-top \">\r\n");
      out.write("        <div class=\"container-fluid\">\r\n");
      out.write("          <div class=\"navbar-wrapper\">\r\n");
      out.write("            <a class=\"navbar-brand\" href=\"#\">Dashboard</a>\r\n");
      out.write("          </div>\r\n");
      out.write("          <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" aria-controls=\"navigation-index\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n");
      out.write("            <span class=\"sr-only\">Toggle navigation</span>\r\n");
      out.write("            <span class=\"navbar-toggler-icon icon-bar\"></span>\r\n");
      out.write("            <span class=\"navbar-toggler-icon icon-bar\"></span>\r\n");
      out.write("            <span class=\"navbar-toggler-icon icon-bar\"></span>\r\n");
      out.write("          </button>\r\n");
      out.write("          <div class=\"collapse navbar-collapse justify-content-end\">\r\n");
      out.write("            <ul class=\"navbar-nav\">\r\n");
      out.write("              <li class=\"nav-item\">\r\n");
      out.write("                <a class=\"nav-link\" href=\"/math/alogout\">\r\n");
      out.write("                  <i class=\"material-icons\">notifications</i> logout\r\n");
      out.write("                </a>\r\n");
      out.write("              </li>\r\n");
      out.write("              <!-- your navbar here -->\r\n");
      out.write("            </ul>\r\n");
      out.write("          </div>\r\n");
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
      out.write("                  <h4 class=\"card-title \">공지사항</h4>\r\n");
      out.write("                  <p class=\"card-category\"> 현재 게시글 수 : ");
      out.print(AllSearchListCount );
      out.write("</p>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"card-body\">\r\n");
      out.write("                  <div class=\"table-responsive\">\r\n");
      out.write("                    <table class=\"table\">\r\n");
      out.write("                      <thead class=\" text-primary\">\r\n");
      out.write("                        <th>\r\n");
      out.write("                          글번호\r\n");
      out.write("                        </th>\r\n");
      out.write("                        <th>\r\n");
      out.write("                          제목\r\n");
      out.write("                        </th>\r\n");
      out.write("                        <th>\r\n");
      out.write("                          작성자\r\n");
      out.write("                        </th>\r\n");
      out.write("                        <th>\r\n");
      out.write("                          등록일자\r\n");
      out.write("                        </th>\r\n");
      out.write("                      </thead>\r\n");
      out.write("                      <tbody>\r\n");
      out.write("                        <tr>\r\n");
      out.write("                        ");
 for(int n = 0; n < nsList.size(); n++){ 
      out.write("\r\n");
      out.write("                          <td>\r\n");
      out.write("                          ");
      out.print(nsList.get(n).getNoticeNo() );
      out.write("\r\n");
      out.write("                          </td>\r\n");
      out.write("                          <td>\r\n");
      out.write("                          <a href=\"/math/ndetail?no=");
      out.print(nsList.get(n).getNoticeNo());
      out.write('"');
      out.write('>');
      out.print(nsList.get(n).getNoticeTitle() );
      out.write("</a>\r\n");
      out.write("                          </td>\r\n");
      out.write("                          <td>\r\n");
      out.write("                          ");
      out.print(nsList.get(n).getWriterName() );
      out.write("\r\n");
      out.write("                          </td>\r\n");
      out.write("                          <td>\r\n");
      out.write("                          ");
      out.print(nsList.get(n).getNoticeDate() );
      out.write("\r\n");
      out.write("                          </td>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                        ");
 } 
      out.write("\r\n");
      out.write("                      </tbody>\r\n");
      out.write("                    </table>\r\n");
      out.write("                    <center>\r\n");
      out.write("                    <div class=\"col-md-6\">\r\n");
      out.write("                    <ul class=\"pagination pagination-primary\">\r\n");
      out.write("\t");
 if(currentPage <= 1){ 
      out.write("\r\n");
      out.write("\t<li class=\"page-item\">\r\n");
      out.write("\t\t<a class=\"page-link\"> prev </a>\r\n");
      out.write("\t\t</li>\r\n");
      out.write("\t");
 }else if(searchTitle != null){ 
      out.write("\r\n");
      out.write("\t<li class=\"page-item\">\r\n");
      out.write("\t\t<a href=\"/math/nslist?page=1&title=");
      out.print(searchTitle);
      out.write("&noption=");
      out.print(nOption);
      out.write("\" class=\"page-link\"> prev </a>\r\n");
      out.write("\t\t</li>\r\n");
      out.write("\t");
 }else{ 
      out.write("\r\n");
      out.write("\t<li class=\"page-item\">\r\n");
      out.write("\t\t<a href=\"/math/nslist?page=1\" class=\"page-link\"> prev </a>\r\n");
      out.write("\t\t</li>\r\n");
      out.write("\t");
} if((currentPage - 5) <= startPage && (endPage - 5) >= 1){ 
      out.write("\r\n");
      out.write("\t<li class=\"page-item\">\r\n");
      out.write("\t\t<a href=\"/math/nslist?page=");
      out.print( (startPage - 5) + 4   );
      out.write("&title=");
      out.print(searchTitle);
      out.write("&noption=");
      out.print(nOption);
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
      out.write("\t\t\t\t<a class=\"page-link\"><font>");
      out.print(p );
      out.write("</font></a>\r\n");
      out.write("\t\t\t\t</li>\r\n");
      out.write("\t\t\t");
}else if(searchTitle != null && nOption != null){ 
      out.write("\r\n");
      out.write("\t\t\t<li class=\"page-item\">\r\n");
      out.write("\t\t\t\t<a href=\"/math/nslist?page=");
      out.print(p);
      out.write("&title=");
      out.print(searchTitle);
      out.write("&noption=");
      out.print(nOption);
      out.write("\" class=\"page-link\">");
      out.print(p );
      out.write("</a>\r\n");
      out.write("\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t");
}else{ 
      out.write("\r\n");
      out.write("\t\t\t\t<li class=\"page-item\">\r\n");
      out.write("\t\t\t\t<a href=\"/math/nslist?page=");
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
      out.write("\t<li class=\"page-item\">\r\n");
      out.write("\t\t<a href=\"/math/nslist?page=");
      out.print(startPage+5);
      out.write("&title=");
      out.print(searchTitle );
      out.write("&noption=");
      out.print(nOption);
      out.write("\" class=\"page-link\">&nbsp;[다음]</a>\r\n");
      out.write("\t\t</li>\r\n");
      out.write("\t");
}else{ 
      out.write("\r\n");
      out.write("\t<li class=\"page-item\">\r\n");
      out.write("\t\t<a class=\"page-link\"> [다음] </a>\r\n");
      out.write("\t\t</li>\r\n");
      out.write("\t");
} 
      out.write('\r');
      out.write('\n');
      out.write('	');
 if(currentPage >= maxPage){ 
      out.write("\r\n");
      out.write("\t<li class=\"page-item\">\r\n");
      out.write("\t\t<a class=\"page-link\"> next </a>\r\n");
      out.write("\t\t</li>\r\n");
      out.write("\t");
 }else if(searchTitle != null){ 
      out.write("\r\n");
      out.write("\t<li>\r\n");
      out.write("\t\t<a href=\"/math/nslist?page=");
      out.print(maxPage);
      out.write("&title=");
      out.print(searchTitle);
      out.write("&noption=");
      out.print(nOption);
      out.write("\" class=\"page-link\"> next </a>\r\n");
      out.write("\t\t</li>\r\n");
      out.write("\t");
 }else{ 
      out.write("\r\n");
      out.write("\t<li class=\"page-item\">\r\n");
      out.write("\t\t<a href=\"/math/nslist?page=");
      out.print(maxPage);
      out.write("\" class=\"page-link\"> next </a>\r\n");
      out.write("\t\t</li>\r\n");
      out.write("\t");
} 
      out.write("\r\n");
      out.write("\t</ul>\r\n");
      out.write("\t</center>\r\n");
      out.write("\t<div style=\"float:left; margin-right:20px;\">\r\n");
      out.write("<form action=\"/math/nslist?page=1\" method=\"post\" class=\"form-inline ml-auto\">\r\n");
      out.write("\t<select name=\"noption\" class=\"form-control\">\r\n");
      out.write("\t\t<option value=\"\">선택하시오</option>\r\n");
      out.write("\t\t<option name=\"ntitle\" value=\"ntitle\" >제목</option>\r\n");
      out.write("\t\t<option name=\"ntContent\" value=\"ntContent\">제목+내용</option>\r\n");
      out.write("\t</select>\r\n");
      out.write("\t&nbsp;\r\n");
      out.write("\t&nbsp;&nbsp;\r\n");
      out.write("\t&nbsp;\r\n");
      out.write("                  <div class=\"form-group has-black\">\r\n");
      out.write("                    <input type=\"text\" class=\"form-control\" placeholder=\"Search\" name=\"title\">\r\n");
      out.write("                  </div>\r\n");
      out.write("                  <button type=\"submit\" class=\"btn btn-black btn-raised btn-fab btn-round\">\r\n");
      out.write("                    <i class=\"material-icons\">search</i>\r\n");
      out.write("                  </button>\r\n");
      out.write("</form>\r\n");
      out.write("</div>\r\n");
      out.write("<div style=\"float:left;\">\r\n");
      out.write("<button onclick=\"javascript:location.href='views/notice/noticeWriteView.jsp'\" type=\"button\" class=\"btn btn-primary\">글쓰기</button>\r\n");
      out.write("</div>\r\n");
      out.write("</div>\r\n");
      out.write("                  </div>\r\n");
      out.write("                </div>\r\n");
      out.write("              </div>\r\n");
      out.write("            </div>\r\n");
      out.write("          <!-- your content here -->\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
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
      out.write("    <title>footer</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<footer class=\"footer\">\r\n");
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
