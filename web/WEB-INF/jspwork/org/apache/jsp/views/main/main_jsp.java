/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.37
 * Generated at: 2019-03-26 10:51:44 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.main;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class main_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/views/main/../common/footer.jsp", Long.valueOf(1553532198000L));
    _jspx_dependants.put("/views/main/../common/header.jsp", Long.valueOf(1553532198000L));
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
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write('\n');
 String userId = (String)session.getAttribute("userId"); 
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("<title>감성수학</title>\n");
      out.write("<script type=\"text/javascript\" src=\"resources/js/jquery-3.3.1.min.js\"></script>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("$(\".hover\").mouseleave(\n");
      out.write("        function () {\n");
      out.write("          $(this).removeClass(\"hover\");\n");
      out.write("        }\n");
      out.write("      );\n");
      out.write("\tfunction logout() {\n");
      out.write("\t\tlocation.href=\"math/logout\";\n");
      out.write("\t\treturn false;\n");
      out.write("\t}\n");
      out.write("</script>\n");
      out.write("<!-- <style>\n");
      out.write("@import url(https://fonts.googleapis.com/css?family=Work+Sans);\n");
      out.write(".snip1485 {\n");
      out.write("  font-family: 'Work Sans', Arial, sans-serif;\n");
      out.write("  text-align: center;\n");
      out.write("  text-transform: uppercase;\n");
      out.write("  font-weight: 400;\n");
      out.write("}\n");
      out.write(".snip1485 *,\n");
      out.write(".snip1485 *:after {\n");
      out.write("  box-sizing: border-box;\n");
      out.write("  -webkit-transition: all 0.2s linear;\n");
      out.write("  transition: all 0.2s linear;\n");
      out.write("}\n");
      out.write(".snip1485 li {\n");
      out.write("  display: inline-block;\n");
      out.write("  list-style: outside none none;\n");
      out.write("  margin: 0.5em 0.6em;\n");
      out.write("  -webkit-perspective: 50em;\n");
      out.write("  perspective: 50em;\n");
      out.write("}\n");
      out.write(".snip1485 a {\n");
      out.write("  backface-visibility: hidden;\n");
      out.write("  color: #ffffff;\n");
      out.write("  display: inline-block;\n");
      out.write("  line-height: 2.2em;\n");
      out.write("  padding: 0 1.4em;\n");
      out.write("  position: relative;\n");
      out.write("  text-decoration: none;\n");
      out.write("  -webkit-transform-style: preserve-3d;\n");
      out.write("  transform-style: preserve-3d;\n");
      out.write("  background-color: #667273;\n");
      out.write("  -webkit-transform-origin: 50% 50%;\n");
      out.write("  -ms-transform-origin: 50% 50%;\n");
      out.write("  transform-origin: 50% 50%;\n");
      out.write("}\n");
      out.write(".snip1485 a:after {\n");
      out.write("  background-color: #5c122e;\n");
      out.write("  color: transparent;\n");
      out.write("  content: attr(data-hover);\n");
      out.write("  bottom: 100%;\n");
      out.write("  line-height: 2.2em;\n");
      out.write("  position: absolute;\n");
      out.write("  left: 0;\n");
      out.write("  width: 100%;\n");
      out.write("  -webkit-transform: translateY(0%) rotateX(90deg);\n");
      out.write("  transform: translateY(0%) rotateX(90deg);\n");
      out.write("  -webkit-transform-origin: 50% 100%;\n");
      out.write("  -ms-transform-origin: 50% 100%;\n");
      out.write("  transform-origin: 50% 100%;\n");
      out.write("}\n");
      out.write(".snip1485 li:hover a,\n");
      out.write(".snip1485 li.current a {\n");
      out.write("  -webkit-transform: translateY(50%) rotateX(-90deg);\n");
      out.write("  transform: translateY(50%) rotateX(-90deg);\n");
      out.write("  background-color: #363c3d;\n");
      out.write("  color: transparent;\n");
      out.write("}\n");
      out.write(".snip1485 li:hover a:after,\n");
      out.write(".snip1485 li.current a:after {\n");
      out.write("  background-color: #b12358;\n");
      out.write("  color: #ffffff;\n");
      out.write("  cursor: pointer;\n");
      out.write("}\n");
      out.write(".box{\n");
      out.write("   width:5px;\n");
      out.write("   height:5px;\n");
      out.write("   float:left;\n");
      out.write("   z-index: 1;\n");
      out.write("}\n");
      out.write("</style> -->\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("<ul class=\"snip1485\">\n");
      out.write("  <div class=\"box\">\n");
      out.write("  </div>\n");
      out.write("  <li class=\"current\"><a href=\"#\" data-hover=\"Home\">감성수학</a></li>\n");
      out.write("  <li><a href=\"/math/nslist\"  data-hover=\"Notice\">공지사항</a></li>\n");
      out.write("  <li><a href=\"#\" data-hover=\"FAQ\">FAQ</a></li>\n");
      out.write("  <li><a href=\"#\" data-hover=\"QnA\">QnA</a></li>\n");
      out.write("  <li><a href=\"#\" data-hover=\"Matter\">문제</a></li>\n");
      out.write("  <li><a href=\"/math/myinfo\" data-hover=\"My Page\">마이페이지</a></li>\n");
      out.write("  <li><a href=\"/math/logout\" data-hover=\"logout\">로그아웃</a></li>\n");
      out.write("</ul>\n");
      out.write("</body>\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("<hr style=\"clear:both;\">\r\n");
      out.write("\n");
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
      out.write("    <title>footer</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<footer class=\"footer\">\n");
      out.write("        <div class=\"container-fluid\">\n");
      out.write("          <nav class=\"float-left\">\n");
      out.write("            <ul>\n");
      out.write("              <li>\n");
      out.write("                <a href=\"#\">\n");
      out.write("                  감성수학\n");
      out.write("                </a>\n");
      out.write("              </li>\n");
      out.write("            </ul>\n");
      out.write("          </nav>\n");
      out.write("          <div class=\"copyright float-right\">\n");
      out.write("            &copy;\n");
      out.write("            <script>\n");
      out.write("              document.write(new Date().getFullYear())\n");
      out.write("            </script>, made with <i class=\"material-icons\">favorite</i> by\n");
      out.write("            <a href=\"#\" target=\"_blank\">감성수학</a> for a better web.\n");
      out.write("          </div>\n");
      out.write("          <!-- your footer here -->\n");
      out.write("        </div>\n");
      out.write("      </footer>\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
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