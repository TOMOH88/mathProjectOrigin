/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.37
 * Generated at: 2019-03-29 06:04:34 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.notice;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import notice.model.vo.Notice;

public final class noticeUpdateView_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/views/notice/../common/Adminheader.jsp", Long.valueOf(1553837803208L));
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
      out.write("<title>수정페이지</title>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(ctx );
      out.write("/SE2/js/HuskyEZCreator.js\" charset=\"utf-8\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/math/resources/js/jquery-3.3.1.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("function listView(){\r\n");
      out.write("\tlocation.href = '/math/nslist';\r\n");
      out.write("}\r\n");
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
      out.write("<h1 align=\"center\">");
      out.print(notice.getNoticeNo() );
      out.write("번 글 수정페이지</h1>\r\n");
      out.write("<form id=\"nform\" action=\"/math/nupdate\" method=\"post\" enctype=\"multipart/form-data\">\r\n");
      out.write("<input type=\"hidden\" name=\"no\" value=\"");
      out.print(notice.getNoticeNo() );
      out.write("\">\r\n");
      out.write("<input type=\"hidden\" name=\"ofile\" value=\"");
      out.print(notice.getOriginalFileName() );
      out.write("\">\r\n");
      out.write("<input type=\"hidden\" name=\"rfile\" value=\"");
      out.print(notice.getRenameFileName() );
      out.write("\">\r\n");
      out.write("\t<table\talign=\"center\" width=\"800\" cellspacing=\"0\">\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<th>제목</th>\r\n");
      out.write("\t\t\t<td><input type=\"text\" name=\"title\" value=\"");
      out.print(notice.getNoticeTitle() );
      out.write("\"></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<th>작성자</th>\r\n");
      out.write("\t\t\t<td><input type=\"text\" name=\"writer\" value=\"");
      out.print(notice.getWriterName() );
      out.write("\" readonly ></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<th>내용</th>\r\n");
      out.write("\t\t\t<td><textarea row=\"10\" cols=\"30\" id=\"con1\" name=\"content\" style=\"width:650px; height: 350px;\">");
      out.print(notice.getNoticeContent() );
      out.write("</textarea></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr height=\"50\">\r\n");
      out.write("\t\t\t<th>첨부파일</th>\r\n");
      out.write("\t\t\t<td id=\"filetd\">\r\n");
      out.write("\t\t\t\t");
 if(notice.getOriginalFileName() != null && !notice.getOriginalFileName().equals("null")){ 
      out.write("\r\n");
      out.write("\t\t\t\t\t");
      out.print(notice.getOriginalFileName() );
      out.write("\r\n");
      out.write("\t\t\t\t");
 }else{ 
      out.write("\r\n");
      out.write("\t\t\t\t\t첨부파일없음\r\n");
      out.write("\t\t\t\t");
 } 
      out.write("&nbsp;\r\n");
      out.write("\t\t\t\t<input type=\"file\" value=\"첨부파일 변경\"  name=\"upfile\">\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<th colspan=\"2\">\r\n");
      out.write("\t\t\t\t<input type=\"button\" id=\"save\" value=\"수정하기\">\r\n");
      out.write("\t\t\t\t<button onclick=\"listView(); return false;\">목록으로 돌아가기</button>\r\n");
      out.write("\t\t\t</th>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</table>\r\n");
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
