/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.37
 * Generated at: 2019-03-26 05:38:55 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class admin_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

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

      out.write('\r');
      out.write('\n');
 String admin = (String)session.getAttribute("admin"); 
      out.write("\r\n");
      out.write("<!doctype html>\r\n");
      out.write("<html lang=\"kr\">\r\n");
      out.write("\t<head>\r\n");
      out.write("\t<meta charset=\"UTF-8\">\r\n");
      out.write("\t<title>감성수학</title>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/math/resources/js/jquery-3.3.1.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
 if(admin != null){
      out.write("\r\n");
      out.write("$(function() {\r\n");
      out.write("\tlocation.href=\"/main/nslit.jsp\";\r\n");
      out.write("});\t\r\n");
}
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("<style rel=\"stylesheet\">\r\n");
      out.write("@charset \"UTF-8\";\r\n");
      out.write("@import url(https://fonts.googleapis.com/css?family=Lato:400,700);\r\n");
      out.write("* {\r\n");
      out.write("  -moz-box-sizing: border-box;\r\n");
      out.write("  -webkit-box-sizing: border-box;\r\n");
      out.write("  box-sizing: border-box;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("body {\r\n");
      out.write("  font-family: 'Lato', sans-serif;\r\n");
      out.write("  background-color: #f8f8f8;\r\n");
      out.write("}\r\n");
      out.write("body .container {\r\n");
      out.write("  position: relative;\r\n");
      out.write("  overflow: hidden;\r\n");
      out.write("  width: 700px;\r\n");
      out.write("  height: 700px;\r\n");
      out.write("  margin: 80px auto 0;\r\n");
      out.write("  background-color: #ffffff;\r\n");
      out.write("  -moz-box-shadow: rgba(0, 0, 0, 0.1) 0px 10px 30px;\r\n");
      out.write("  -webkit-box-shadow: rgba(0, 0, 0, 0.1) 0px 10px 30px;\r\n");
      out.write("  box-shadow: rgba(0, 0, 0, 0.1) 0px 10px 30px;\r\n");
      out.write("}\r\n");
      out.write("body .container .half {\r\n");
      out.write("  float: left;\r\n");
      out.write("  width: 50%;\r\n");
      out.write("  height: 100%;\r\n");
      out.write("  padding: 58px 40px 0;\r\n");
      out.write("}\r\n");
      out.write("body .container .half.bg {\r\n");
      out.write("  background-image: url(resources/images/math-3986758_1920.jpg);\r\n");
      out.write("  background-size: cover;\r\n");
      out.write("  background-repeat: no-repeat;\r\n");
      out.write("}\r\n");
      out.write("body .container h1 {\r\n");
      out.write("  font-size: 18px;\r\n");
      out.write("  font-weight: 700;\r\n");
      out.write("  margin-bottom: 23px;\r\n");
      out.write("  text-align: center;\r\n");
      out.write("  text-indent: 6px;\r\n");
      out.write("  letter-spacing: 7px;\r\n");
      out.write("  text-transform: uppercase;\r\n");
      out.write("  color: #263238;\r\n");
      out.write("}\r\n");
      out.write("body .container .tabs {\r\n");
      out.write("  width: 100%;\r\n");
      out.write("  margin-bottom: 29px;\r\n");
      out.write("  border-bottom: 1px solid #d9d9d9;\r\n");
      out.write("}\r\n");
      out.write("body .container .tabs .tab {\r\n");
      out.write("  display: inline-block;\r\n");
      out.write("  margin-bottom: -1px;\r\n");
      out.write("  padding: 20px 15px 10px;\r\n");
      out.write("  cursor: pointer;\r\n");
      out.write("  letter-spacing: 0;\r\n");
      out.write("  border-bottom: 1px solid #d9d9d9;\r\n");
      out.write("  -moz-user-select: -moz-none;\r\n");
      out.write("  -ms-user-select: none;\r\n");
      out.write("  -webkit-user-select: none;\r\n");
      out.write("  user-select: none;\r\n");
      out.write("  transition: all 0.1s ease-in-out;\r\n");
      out.write("}\r\n");
      out.write("body .container .tabs .tab a {\r\n");
      out.write("  font-size: 11px;\r\n");
      out.write("  text-decoration: none;\r\n");
      out.write("  text-transform: uppercase;\r\n");
      out.write("  color: #d9d9d9;\r\n");
      out.write("  transition: all 0.1s ease-in-out;\r\n");
      out.write("}\r\n");
      out.write("body .container .tabs .tab.active a, body .container .tabs .tab:hover a {\r\n");
      out.write("  color: #263238;\r\n");
      out.write("}\r\n");
      out.write("body .container .tabs .tab.active {\r\n");
      out.write("  border-bottom: 1px solid #263238;\r\n");
      out.write("}\r\n");
      out.write("body .container .content form {\r\n");
      out.write("  position: relative;\r\n");
      out.write("  height: 287px;\r\n");
      out.write("}\r\n");
      out.write("body .container .content label:first-of-type, body .container .content input:first-of-type, body .container .content .more:first-of-type {\r\n");
      out.write("  -moz-animation: slideIn 0.4s cubic-bezier(0.37, 0.82, 0.2, 1);\r\n");
      out.write("  -webkit-animation: slideIn 0.4s cubic-bezier(0.37, 0.82, 0.2, 1);\r\n");
      out.write("  animation: slideIn 0.4s cubic-bezier(0.37, 0.82, 0.2, 1);\r\n");
      out.write("}\r\n");
      out.write("body .container .content label:nth-of-type(2), body .container .content input:nth-of-type(2), body .container .content .more:nth-of-type(2) {\r\n");
      out.write("  -moz-animation: slideIn 0.5s cubic-bezier(0.37, 0.82, 0.2, 1);\r\n");
      out.write("  -webkit-animation: slideIn 0.5s cubic-bezier(0.37, 0.82, 0.2, 1);\r\n");
      out.write("  animation: slideIn 0.5s cubic-bezier(0.37, 0.82, 0.2, 1);\r\n");
      out.write("}\r\n");
      out.write("body .container .content label:nth-of-type(3), body .container .content input:nth-of-type(3), body .container .content .more:nth-of-type(3) {\r\n");
      out.write("  -moz-animation: slideIn 0.6s cubic-bezier(0.37, 0.82, 0.2, 1);\r\n");
      out.write("  -webkit-animation: slideIn 0.6s cubic-bezier(0.37, 0.82, 0.2, 1);\r\n");
      out.write("  animation: slideIn 0.6s cubic-bezier(0.37, 0.82, 0.2, 1);\r\n");
      out.write("}\r\n");
      out.write("body .container .content label {\r\n");
      out.write("  font-size: 12px;\r\n");
      out.write("  color: #263238;\r\n");
      out.write("  -moz-user-select: -moz-none;\r\n");
      out.write("  -ms-user-select: none;\r\n");
      out.write("  -webkit-user-select: none;\r\n");
      out.write("  user-select: none;\r\n");
      out.write("}\r\n");
      out.write("body .container .content label:not([for='remember']) {\r\n");
      out.write("  display: none;\r\n");
      out.write("}\r\n");
      out.write("body .container .content input.inpt {\r\n");
      out.write("  font-size: 14px;\r\n");
      out.write("  display: block;\r\n");
      out.write("  width: 100%;\r\n");
      out.write("  height: 42px;\r\n");
      out.write("  margin-bottom: 12px;\r\n");
      out.write("  padding: 16px 13px;\r\n");
      out.write("  color: #999999;\r\n");
      out.write("  border: 1px solid #d9d9d9;\r\n");
      out.write("  background: transparent;\r\n");
      out.write("  -moz-border-radius: 2px;\r\n");
      out.write("  -webkit-border-radius: 2px;\r\n");
      out.write("  border-radius: 2px;\r\n");
      out.write("}\r\n");
      out.write("body .container .content input.inpt::-webkit-input-placeholder {\r\n");
      out.write("  font-size: 14px;\r\n");
      out.write("  color: #999999;\r\n");
      out.write("  font-family: 'Lato', sans-serif;\r\n");
      out.write("}\r\n");
      out.write("body .container .content input.inpt:-moz-placeholder {\r\n");
      out.write("  font-size: 14px;\r\n");
      out.write("  color: #999999;\r\n");
      out.write("  font-family: 'Lato', sans-serif;\r\n");
      out.write("}\r\n");
      out.write("body .container .content input.inpt::-moz-placeholder {\r\n");
      out.write("  font-size: 14px;\r\n");
      out.write("  color: #999999;\r\n");
      out.write("  font-family: 'Lato', sans-serif;\r\n");
      out.write("}\r\n");
      out.write("body .container .content input.inpt:-ms-input-placeholder {\r\n");
      out.write("  font-size: 14px;\r\n");
      out.write("  color: #999999;\r\n");
      out.write("  font-family: 'Lato', sans-serif;\r\n");
      out.write("}\r\n");
      out.write("body .container .content input.inpt:focus {\r\n");
      out.write("  border-color: #999999;\r\n");
      out.write("}\r\n");
      out.write("body .container .content input.submit {\r\n");
      out.write("\r\n");
      out.write("  font-size: 12px;\r\n");
      out.write("  line-height: 42px;\r\n");
      out.write("  display: block;\r\n");
      out.write("  width: 100%;\r\n");
      out.write("  height: 42px;\r\n");
      out.write("  cursor: pointer;\r\n");
      out.write("  vertical-align: middle;\r\n");
      out.write("  letter-spacing: 2px;\r\n");
      out.write("  text-transform: uppercase;\r\n");
      out.write("  color: #263238;\r\n");
      out.write("  border: 1px solid #263238;\r\n");
      out.write("  background: transparent;\r\n");
      out.write("  -moz-border-radius: 2px;\r\n");
      out.write("  -webkit-border-radius: 2px;\r\n");
      out.write("  border-radius: 2px;\r\n");
      out.write("}\r\n");
      out.write("body .container .content input.submit:hover {\r\n");
      out.write("  background-color: #263238;\r\n");
      out.write("  color: #ffffff;\r\n");
      out.write("  -moz-transition: all 0.2s;\r\n");
      out.write("  -o-transition: all 0.2s;\r\n");
      out.write("  -webkit-transition: all 0.2s;\r\n");
      out.write("  transition: all 0.2s;\r\n");
      out.write("}\r\n");
      out.write("body .container .content input:focus {\r\n");
      out.write("  outline: none;\r\n");
      out.write("}\r\n");
      out.write("body .container .content .checkbox {\r\n");
      out.write("  margin-top: 4px;\r\n");
      out.write("  overflow: hidden;\r\n");
      out.write("  clip: rect(0 0 0 0);\r\n");
      out.write("  width: 0;\r\n");
      out.write("  height: 0;\r\n");
      out.write("  margin: 17px -1px;\r\n");
      out.write("  padding: 0;\r\n");
      out.write("  border: 0;\r\n");
      out.write("}\r\n");
      out.write("body .container .content .checkbox + label {\r\n");
      out.write("  vertical-align: middle;\r\n");
      out.write("  display: inline-block;\r\n");
      out.write("  width: 50%;\r\n");
      out.write("}\r\n");
      out.write("body .container .content .checkbox + label:before {\r\n");
      out.write("  content: \"\\A\";\r\n");
      out.write("  color: #999999;\r\n");
      out.write("  font-family: Verdana;\r\n");
      out.write("  font-weight: bold;\r\n");
      out.write("  font-size: 8px;\r\n");
      out.write("  line-height: 10px;\r\n");
      out.write("  text-align: center;\r\n");
      out.write("  display: inline-block;\r\n");
      out.write("  vertical-align: middle;\r\n");
      out.write("  position: relative;\r\n");
      out.write("  -moz-border-radius: 2px;\r\n");
      out.write("  -webkit-border-radius: 2px;\r\n");
      out.write("  border-radius: 2px;\r\n");
      out.write("  background: transparent;\r\n");
      out.write("  border: 1px solid #d9d9d9;\r\n");
      out.write("  width: 11px;\r\n");
      out.write("  height: 11px;\r\n");
      out.write("  margin: -2px 8px 0 0;\r\n");
      out.write("}\r\n");
      out.write("body .container .content .checkbox:checked + label:before {\r\n");
      out.write("  content: \"✓\";\r\n");
      out.write("}\r\n");
      out.write("body .container .content .submit-wrap {\r\n");
      out.write("  position: none;\r\n");
      out.write("  bottom: 0;\r\n");
      out.write("  width: 100%;\r\n");
      out.write("}\r\n");
      out.write("body .container .content .submit-wrap a {\r\n");
      out.write("  font-size: 12px;\r\n");
      out.write("  display: block;\r\n");
      out.write("  margin-top: 20px;\r\n");
      out.write("  text-align: center;\r\n");
      out.write("  text-decoration: none;\r\n");
      out.write("  color: #999999;\r\n");
      out.write("}\r\n");
      out.write("body .container .content .submit-wrap a:hover {\r\n");
      out.write("  text-decoration: underline;\r\n");
      out.write("}\r\n");
      out.write("body .container .content .signup-cont {\r\n");
      out.write("  display: none;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("@keyframes slideIn {\r\n");
      out.write("  0% {\r\n");
      out.write("    filter: progid:DXImageTransform.Microsoft.Alpha(Opacity=0);\r\n");
      out.write("    opacity: 0;\r\n");
      out.write("    margin-left: -320px;\r\n");
      out.write("  }\r\n");
      out.write("  100% {\r\n");
      out.write("    filter: progid:DXImageTransform.Microsoft.Alpha(enabled=false);\r\n");
      out.write("    opacity: 1;\r\n");
      out.write("    margin-left: 0px;\r\n");
      out.write("  }\r\n");
      out.write("}\r\n");
      out.write("@-webkit-keyframes slideIn {\r\n");
      out.write("  0% {\r\n");
      out.write("    filter: progid:DXImageTransform.Microsoft.Alpha(Opacity=0);\r\n");
      out.write("    opacity: 0;\r\n");
      out.write("    margin-left: -320px;\r\n");
      out.write("  }\r\n");
      out.write("  100% {\r\n");
      out.write("    filter: progid:DXImageTransform.Microsoft.Alpha(enabled=false);\r\n");
      out.write("    opacity: 1;\r\n");
      out.write("    margin-left: 0px;\r\n");
      out.write("  }\r\n");
      out.write("}\r\n");
      out.write(".credits {\r\n");
      out.write("  display: block;\r\n");
      out.write("  position: absolute;\r\n");
      out.write("  right: 0;\r\n");
      out.write("  bottom: 0;\r\n");
      out.write("  color: #999999;\r\n");
      out.write("  font-size: 14px;\r\n");
      out.write("  margin: 0 10px 10px 0;\r\n");
      out.write("}\r\n");
      out.write(".credits a {\r\n");
      out.write("  filter: progid:DXImageTransform.Microsoft.Alpha(Opacity=80);\r\n");
      out.write("  opacity: 0.8;\r\n");
      out.write("  color: inherit;\r\n");
      out.write("  font-weight: 700;\r\n");
      out.write("  text-decoration: none;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<section class=\"container\">\r\n");
      out.write("\t\t    <article class=\"half\">\r\n");
      out.write("\t\t\t        <h1>감성수학 관리자모드</h1>\r\n");
      out.write("\t\t\t        <div class=\"tabs\">\r\n");
      out.write("\t\t\t\t            <span class=\"tab signin active\"><a href=\"#signin\">로그인</a></span>\r\n");
      out.write("\t\t\t        </div>\r\n");
      out.write("\t\t\t        <div class=\"content\">\r\n");
      out.write("\t\t\t\t            <div class=\"signin-cont cont\">\r\n");
      out.write("\t\t\t\t\t                <form action=\"/math/alogin\" method=\"post\">\r\n");
      out.write("\t\t\t\t\t\t                    <input type=\"text\" name=\"userid\" id=\"userid\" class=\"inpt\" required=\"required\" placeholder=\"아이디\">\r\n");
      out.write("\t\t\t\t\t\t                    <label for=\"email\">Your email</label>\r\n");
      out.write("\t\t\t\t\t\t                    <input type=\"password\" name=\"password\" id=\"password\" class=\"inpt\" required=\"required\" placeholder=\"비밀번호\">\r\n");
      out.write("                \t\t\t\t\t\t    <label for=\"password\">Your password</label>\r\n");
      out.write("\t\t\t\t\t\t                    <input type=\"checkbox\" id=\"remember\" class=\"checkbox\" checked>\r\n");
      out.write("\t\t\t\t\t\t                    <label for=\"remember\">Remember me</label>\r\n");
      out.write("\t\t\t\t\t\t                    <div class=\"submit-wrap\">\r\n");
      out.write("\t\t\t\t\t\t\t                        <input type=\"submit\" value=\"로그인 \" class=\"submit\">\r\n");
      out.write("\t\t\t\t\t\t\t                        <a href=\"#\" class=\"more\">Forgot your password?</a>\r\n");
      out.write("\t\t\t\t\t\t                    </div>\r\n");
      out.write("        \t\t\t\t\t        </form>\r\n");
      out.write("    \t\t\t\t        \r\n");
      out.write("\t\t\t        </div>\r\n");
      out.write("\t\t    </article>\r\n");
      out.write("\t\t    <div class=\"half bg\"></div>\r\n");
      out.write("\t</section>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js\"></script> \r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("$('.tabs .tab').click(function(){\r\n");
      out.write("    if ($(this).hasClass('signin')) {\r\n");
      out.write("        $('.tabs .tab').removeClass('active');\r\n");
      out.write("        $(this).addClass('active');\r\n");
      out.write("        $('.cont').hide();\r\n");
      out.write("        $('.signin-cont').show();\r\n");
      out.write("    } \r\n");
      out.write("    if ($(this).hasClass('signup')) {\r\n");
      out.write("        $('.tabs .tab').removeClass('active');\r\n");
      out.write("        $(this).addClass('active');\r\n");
      out.write("        $('.cont').hide();\r\n");
      out.write("        $('.signup-cont').show();\r\n");
      out.write("    }\r\n");
      out.write("});\r\n");
      out.write("$('.container .bg').mousemove(function(e){\r\n");
      out.write("    var amountMovedX = (e.pageX * -1 / 30);\r\n");
      out.write("    var amountMovedY = (e.pageY * -1 / 9);\r\n");
      out.write("    $(this).css('background-position', amountMovedX + 'px ' + amountMovedY + 'px');\r\n");
      out.write("});\r\n");
      out.write("</script>\r\n");
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
