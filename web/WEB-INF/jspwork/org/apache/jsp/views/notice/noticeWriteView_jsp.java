/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.37
 * Generated at: 2019-03-25 08:26:24 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.notice;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import notice.model.vo.Notice;

public final class noticeWriteView_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/views/notice/../common/Adminheader.jsp", Long.valueOf(1553497676907L));
    _jspx_dependants.put("/views/notice/../common/footer.jsp", Long.valueOf(1552500476847L));
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

	Notice notice = (Notice)request.getAttribute("notice");
	String ctx = request.getContextPath();

      out.write("    \r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>공지사항 글쓰기</title>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(ctx );
      out.write("/SE2/js/HuskyEZCreator.js\" charset=\"utf-8\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/math/resources/js/jquery-3.3.1.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("var oEditors = [];\r\n");
      out.write("$(function(){\r\n");
      out.write("      nhn.husky.EZCreator.createInIFrame({\r\n");
      out.write("          oAppRef: oEditors,\r\n");
      out.write("          elPlaceHolder: \"con1\", //textarea에서 지정한 id와 일치해야 합니다. \r\n");
      out.write("          //SmartEditor2Skin.html 파일이 존재하는 경로\r\n");
      out.write("          sSkinURI: \"/math/SE2/SmartEditor2Skin.html\",  \r\n");
      out.write("          htParams : {\r\n");
      out.write("              // 툴바 사용 여부 (true:사용/ false:사용하지 않음)\r\n");
      out.write("              bUseToolbar : true,             \r\n");
      out.write("              // 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)\r\n");
      out.write("              bUseVerticalResizer : true,     \r\n");
      out.write("              // 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)\r\n");
      out.write("              bUseModeChanger : true,      \r\n");
      out.write("              bSkipXssFilter : true,\r\n");
      out.write("              fOnBeforeUnload : function(){\r\n");
      out.write("                   \r\n");
      out.write("              }\r\n");
      out.write("          }, \r\n");
      out.write("          fOnAppLoad : function(){\r\n");
      out.write("              //기존 저장된 내용의 text 내용을 에디터상에 뿌려주고자 할때 사용\r\n");
      out.write("              oEditors.getById[\"con1\"].exec(\"PASTE_HTML\",[\"\"]);\r\n");
      out.write("          },\r\n");
      out.write("          fCreator: \"createSEditor2\"\r\n");
      out.write("      });\r\n");
      out.write("      \r\n");
      out.write("      //저장버튼 클릭시 form 전송\r\n");
      out.write("      $(\"#save\").click(function(){\r\n");
      out.write("          oEditors.getById[\"con1\"].exec(\"UPDATE_CONTENTS_FIELD\", []);\r\n");
      out.write("          $(\"#nform\").submit();\r\n");
      out.write("      });    \r\n");
      out.write("      \r\n");
      out.write("      $(\"#con1\").css(\"display\",\"none\");\r\n");
      out.write("});\r\n");
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
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>감성수학</title>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/math/resources/js/jquery-3.3.1.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("$(\".hover\").mouseleave(\r\n");
      out.write("        function () {\r\n");
      out.write("          $(this).removeClass(\"hover\");\r\n");
      out.write("        }\r\n");
      out.write("      );\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<ul class=\"snip1485\">\r\n");
      out.write("  <div class=\"box\" >\r\n");
      out.write("  </div>\r\n");
      out.write("  <li class=\"current\"><a href=\"#\" data-hover=\"Home\">감성수학</a></li>\r\n");
      out.write("  ");
if(adminId != null){ 
      out.write("\r\n");
      out.write("  <li><a href=\"/math/nslist\"  data-hover=\"Notice\">공지사항</a></li>\r\n");
      out.write("  <li><a href=\"/math/fslist\" data-hover=\"FAQ\">FAQ</a></li>\r\n");
      out.write("  <li><a href=\"/math/qslist\" data-hover=\"QnA\">QnA</a></li>\r\n");
      out.write("  <li><a href=\"#\" data-hover=\"Matter\">문제</a></li>\r\n");
      out.write("  <li><a href=\"/math/mmanager\" data-hover=\"My Page\">회원관리페이지</a></li>\r\n");
      out.write("  <li><a href=\"/math/alogout\" data-hover=\"logout\">로그아웃</a></li>\r\n");
      out.write("  ");
}else{ 
      out.write("\r\n");
      out.write(" \t<script type=\"text/javascript\">\r\n");
      out.write(" \t\talert(\"로그인해주세요\");\r\n");
      out.write(" \t\tlocation.href=\"/math/admin.jsp\";\r\n");
      out.write(" \t</script>\r\n");
      out.write("  ");
} 
      out.write("\r\n");
      out.write("</ul>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("<hr style=\"clear:both;\">\r\n");
      out.write("<h1 align=\"center\">공지사항 글쓰기</h1>\r\n");
      out.write("<form name=\"nform\"  id=\"nform\"  action=\"/math/nwrite\" method=\"post\" accept-charset=\"utf-8\" enctype=\"multipart/form-data\">\r\n");
      out.write("<table align=\"center\" width=\"800\" cellspacing=\"0\">\r\n");
      out.write("<input type=\"hidden\" name=\"writer\" value=\"");
      out.print(adminId);
      out.write("\">\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<th>제목</th>\r\n");
      out.write("\t\t<td><input type=\"text\" id=\"title\" name=\"title\" ></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<th>내용</th>\r\n");
      out.write("\t\t<td><textarea row=\"10\" cols=\"30\" id=\"con1\" name=\"content\" style=\"width:650px; height: 350px;\"></textarea></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<th>첨부파일</th>\r\n");
      out.write("\t\t<td><input type=\"file\" name=\"upfile\"></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<th colspan=\"2\">\r\n");
      out.write("\t\t\t<input type=\"button\" id=\"save\" value=\"글 등록\">\r\n");
      out.write("\t\t\t<input type=\"reset\" value=\"작성취소\">\r\n");
      out.write("\t\t\t<button onclick=\"javascript:location.href='/math/nslist'; return false;\">목록가기</button>\r\n");
      out.write("\t\t</th>\r\n");
      out.write("\t</tr>\r\n");
      out.write("</table>\r\n");
      out.write("</form>\r\n");
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
