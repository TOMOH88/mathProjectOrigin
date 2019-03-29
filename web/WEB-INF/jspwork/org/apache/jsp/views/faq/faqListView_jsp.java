/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.37
 * Generated at: 2019-03-29 05:39:57 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.faq;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import faq.model.vo.Faq;

public final class faqListView_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/views/faq/../common/footer.jsp", Long.valueOf(1552500476847L));
    _jspx_dependants.put("/views/faq/../common/Adminheader.jsp", Long.valueOf(1553837803208L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("faq.model.vo.Faq");
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

	ArrayList<Faq> fList = (ArrayList<Faq>)request.getAttribute("fList"); 
	int currentPage = ((Integer)request.getAttribute("currentPage")).intValue();
	int startPage = ((Integer)request.getAttribute("startPage")).intValue();
	int endPage = ((Integer)request.getAttribute("endPage")).intValue();
	int maxPage = ((Integer)request.getAttribute("maxPage")).intValue();
	int limit = ((Integer)request.getAttribute("limit")).intValue();
	int allSearchListCount = ((Integer)request.getAttribute("allSearchListCount")).intValue();
	String searchTitle = (String)request.getAttribute("searchTitle");
	String fOption = (String)request.getAttribute("fOption");

      out.write("    \r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>faq목록페이지</title>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("function faqWrite(){\r\n");
      out.write("\tlocation.href = \"/math/views/faq/faqWriteView.jsp\";\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
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
      out.write("            <a class=\"nav-link\" href=\"/math/fslist\">\r\n");
      out.write("              <i class=\"material-icons\">dashboard</i>\r\n");
      out.write("              <p>FAQ관리</p>\r\n");
      out.write("            </a>\r\n");
      out.write("          </li>\r\n");
      out.write("          <li class=\"nav-item \">\r\n");
      out.write("            <a class=\"nav-link\" href=\"/math/qslist\">\r\n");
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
      out.write("<hr style=\"clear:both;\">\r\n");
      out.write("<h1>총 게시물 수 : ");
      out.print(allSearchListCount );
      out.write("</h1>\r\n");
      out.write("<table align=\"center\" border=\"1\"  width=\"600\"  cellspacing=\"0\" id=\"faqTable\">\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<th></th>\r\n");
      out.write("\t\t<th>글제목</th>\r\n");
      out.write("\t\t<th>등록일자</th>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t");
 for(int i =0; i < fList.size(); i++){ 
      out.write("\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>");
      out.print(fList.get(i).getFaqNo() );
      out.write("</td>\r\n");
      out.write("\t\t<td><a href=\"/math/fdetail?no=");
      out.print(fList.get(i).getFaqNo());
      out.write('"');
      out.write('>');
      out.print(fList.get(i).getQuestionContent() );
      out.write("</a></td>\r\n");
      out.write("\t\t<td>");
      out.print(fList.get(i).getFaqDate() );
      out.write("</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t");
 } 
      out.write("\r\n");
      out.write("</table>\r\n");
      out.write("<div style=\"text-align:center\">\r\n");
      out.write("\t");
 if(currentPage <= 1){ 
      out.write("\r\n");
      out.write("\t\t[맨처음]\r\n");
      out.write("\t");
 }else if(searchTitle != null){ 
      out.write("\r\n");
      out.write("\t\t<a href=\"/math/fslist?page=1&title=");
      out.print(searchTitle);
      out.write("&fOption=");
      out.print(fOption);
      out.write("\">[맨처음]</a>\r\n");
      out.write("\t");
 }else{ 
      out.write("\r\n");
      out.write("\t\t<a href=\"/math/fslist?page=1\">[맨처음]</a>\r\n");
      out.write("\t");
} if((currentPage - 5) <= startPage && (endPage - 5) >= 1){ 
      out.write("\r\n");
      out.write("\t\t<a href=\"/math/fslist?page=");
      out.print( (startPage - 5) + 4   );
      out.write("&title=");
      out.print(searchTitle);
      out.write("&fOption=");
      out.print(fOption);
      out.write("\">[이전]</a>\r\n");
      out.write("\t");
 }else{
      out.write("\r\n");
      out.write("\t\t[이전]\r\n");
      out.write("\t");
} for(int p = startPage; p <= endPage; p++){ 
			if(p == currentPage){
      out.write("\r\n");
      out.write("\t\t\t\t<font>[");
      out.print(p );
      out.write("]</font>\r\n");
      out.write("\t\t\t");
}else if(searchTitle != null && fOption != null){ 
      out.write("\r\n");
      out.write("\t\t\t\t<a href=\"/math/fslist?page=");
      out.print(p);
      out.write("&title=");
      out.print(searchTitle);
      out.write("&fOption=");
      out.print(fOption);
      out.write('"');
      out.write('>');
      out.print(p );
      out.write("</a>\r\n");
      out.write("\t\t\t\t");
}else{ 
      out.write("\r\n");
      out.write("\t\t\t\t<a href=\"/math/fslist?page=");
      out.print(p);
      out.write('"');
      out.write('>');
      out.print(p );
      out.write("</a>\r\n");
      out.write("\t");
 }} 
      out.write('\r');
      out.write('\n');
      out.write('	');
 if((startPage + 5) <= maxPage && (currentPage + 5) >= startPage){ 
      out.write("\r\n");
      out.write("\t\t<a href=\"/math/fslist?page=");
      out.print(startPage+5);
      out.write("&title=");
      out.print(searchTitle );
      out.write("&fOption=");
      out.print(fOption);
      out.write("\">[다음]</a>\r\n");
      out.write("\t");
}else{ 
      out.write("\r\n");
      out.write("\t\t[다음]\r\n");
      out.write("\t");
} 
      out.write('\r');
      out.write('\n');
      out.write('	');
 if(currentPage >= maxPage){ 
      out.write("\r\n");
      out.write("\t\t[마지막]\r\n");
      out.write("\t");
 }else if(searchTitle != null){ 
      out.write("\r\n");
      out.write("\t\t<a href=\"/math/fslist?page=");
      out.print(maxPage);
      out.write("&title=");
      out.print(searchTitle);
      out.write("&fOption=");
      out.print(fOption);
      out.write("\">[마지막]</a>\r\n");
      out.write("\t");
 }else{ 
      out.write("\r\n");
      out.write("\t\t<a href=\"/math/fslist?page=");
      out.print(maxPage);
      out.write("\">[마지막]</a>\r\n");
      out.write("\t");
} 
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("<form action=\"/math/fslist?page=1\" method=\"post\">\r\n");
      out.write("<div>\r\n");
      out.write("\t<select name=\"fOption\">\r\n");
      out.write("\t\t<option value=\"\">선택하세요</option>\r\n");
      out.write("\t\t<option name=\"fTitle\" value=\"fTitle\">제목</option>\r\n");
      out.write("\t\t<option name=\"fTContent\" value=\"fTContent\">제목+내용</option>\r\n");
      out.write("\t</select>\r\n");
      out.write("\t&nbsp;\r\n");
      out.write("\t<input type=\"text\" name=\"title\">\r\n");
      out.write("\t<input type=\"submit\" value=\"검색\">\r\n");
      out.write("</div>\r\n");
      out.write("</form>\r\n");
      out.write("<button id=\"faqBtn\" onclick=\"faqWrite();\">글쓰기</button>\r\n");
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
