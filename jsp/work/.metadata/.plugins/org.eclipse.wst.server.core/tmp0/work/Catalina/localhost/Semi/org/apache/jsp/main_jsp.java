/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.1.40
 * Generated at: 2025-05-07 08:53:11 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;

public final class main_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports,
                 org.apache.jasper.runtime.JspSourceDirectives {

  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(4);
    _jspx_imports_packages.add("jakarta.servlet");
    _jspx_imports_packages.add("jakarta.servlet.http");
    _jspx_imports_packages.add("jakarta.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile jakarta.el.ExpressionFactory _el_expressionfactory;
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

  public boolean getErrorOnELNotFound() {
    return false;
  }

  public jakarta.el.ExpressionFactory _jsp_getExpressionFactory() {
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

  public void _jspService(final jakarta.servlet.http.HttpServletRequest request, final jakarta.servlet.http.HttpServletResponse response)
      throws java.io.IOException, jakarta.servlet.ServletException {

    if (!jakarta.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final jakarta.servlet.jsp.PageContext pageContext;
    jakarta.servlet.http.HttpSession session = null;
    final jakarta.servlet.ServletContext application;
    final jakarta.servlet.ServletConfig config;
    jakarta.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    jakarta.servlet.jsp.JspWriter _jspx_out = null;
    jakarta.servlet.jsp.PageContext _jspx_page_context = null;


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
      out.write("<title>K-Culture Info Site</title>\r\n");
      out.write("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.print( request.getContextPath() );
      out.write("/resources/css/mainstyle.css\">\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("	<nav class=\"navbar navbar-expand-lg\" style=\"background-color: #005BAC;\">\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("      <a class=\"navbar-brand text-white fw-bold\" href=\"#\">K-Culture INFO</a>\r\n");
      out.write("\r\n");
      out.write("      <button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarNav\" aria-controls=\"navbarNav\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n");
      out.write("        <span class=\"navbar-toggler-icon\"></span>\r\n");
      out.write("      </button>\r\n");
      out.write("\r\n");
      out.write("      <div class=\"collapse navbar-collapse\" id=\"navbarNav\">\r\n");
      out.write("        <ul class=\"navbar-nav ms-auto\" style=\"margin-left: 100px;\"> <li class=\"nav-item dropdown me-4\">\r\n");
      out.write("            <a class=\"nav-link dropdown-toggle text-white\" href=\"#\" role=\"button\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\">\r\n");
      out.write("              K-FOOD\r\n");
      out.write("            </a>\r\n");
      out.write("            <ul class=\"dropdown-menu\">\r\n");
      out.write("              <li><a class=\"dropdown-item\" href=\"#\">Traditional Food</a></li>\r\n");
      out.write("              <li><a class=\"dropdown-item\" href=\"#\">Street Food</a></li>\r\n");
      out.write("              <li><a class=\"dropdown-item\" href=\"#\">Experience Program</a></li>\r\n");
      out.write("            </ul>\r\n");
      out.write("          </li>\r\n");
      out.write("\r\n");
      out.write("          <li class=\"nav-item dropdown me-4\">\r\n");
      out.write("            <a class=\"nav-link dropdown-toggle text-white\" href=\"#\" role=\"button\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\">\r\n");
      out.write("              K-BEAUTY\r\n");
      out.write("            </a>\r\n");
      out.write("            <ul class=\"dropdown-menu\">\r\n");
      out.write("              <li><a class=\"dropdown-item\" href=\"#\">Korean Skincare</a></li>\r\n");
      out.write("              <li><a class=\"dropdown-item\" href=\"#\">Makeup Trends</a></li>\r\n");
      out.write("              <li><a class=\"dropdown-item\" href=\"#\">Recommended Purchase Place</a></li>\r\n");
      out.write("            </ul>\r\n");
      out.write("          </li>\r\n");
      out.write("\r\n");
      out.write("          <li class=\"nav-item dropdown me-4\">\r\n");
      out.write("            <a class=\"nav-link dropdown-toggle text-white\" href=\"#\" role=\"button\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\">\r\n");
      out.write("              LOCATION\r\n");
      out.write("            </a>\r\n");
      out.write("            <ul class=\"dropdown-menu\">\r\n");
      out.write("              <li><a class=\"dropdown-item\" href=\"#\">Seoul</a></li>\r\n");
      out.write("              <li><a class=\"dropdown-item\" href=\"#\">Busan</a></li>\r\n");
      out.write("              <li><a class=\"dropdown-item\" href=\"#\">Jeju</a></li>\r\n");
      out.write("            </ul>\r\n");
      out.write("          </li>\r\n");
      out.write("\r\n");
      out.write("          <li class=\"nav-item dropdown me-4\">\r\n");
      out.write("            <a class=\"nav-link dropdown-toggle text-white\" href=\"#\" role=\"button\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\">\r\n");
      out.write("              LOGIN\r\n");
      out.write("            </a>\r\n");
      out.write("            <ul class=\"dropdown-menu\">\r\n");
      out.write("              <li><a class=\"dropdown-item\" href=\"#\">Login</a></li>\r\n");
      out.write("              <li><a class=\"dropdown-item\" href=\"#\">Sign Up</a></li>\r\n");
      out.write("              <li><a class=\"dropdown-item\" href=\"#\">Sign Out</a></li>\r\n");
      out.write("            </ul>\r\n");
      out.write("          </li>\r\n");
      out.write("        </ul>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("  </nav>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("  <div id=\"mainCarousel\" class=\"carousel slide\" data-bs-ride=\"carousel\">\r\n");
      out.write("    <div class=\"carousel-inner\">\r\n");
      out.write("      <div class=\"carousel-item active\">\r\n");
      out.write("        <img src=\"");
      out.print( request.getContextPath() );
      out.write("/resources/img/slideimg01.jpg\" class=\"d-block w-100\" alt=\"...\">\r\n");
      out.write("        <div class=\"fixed-caption\">\r\n");
      out.write("          <h3>Welcome to K-Culture</h3>\r\n");
      out.write("          <p>Explore the rich and vibrant world of Korean culture!</p>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("      <div class=\"carousel-item\">\r\n");
      out.write("        <img src=\"");
      out.print( request.getContextPath() );
      out.write("/resources/img/slideimg02.jpg\" class=\"d-block w-100\" alt=\"...\">\r\n");
      out.write("        <div class=\"fixed-caption\">\r\n");
      out.write("          <h3>Experience Korea</h3>\r\n");
      out.write("          <p>From food to fashion, discover everything Korean!</p>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <button class=\"carousel-control-prev\" type=\"button\" data-bs-target=\"#mainCarousel\" data-bs-slide=\"prev\">\r\n");
      out.write("      <span class=\"carousel-control-prev-icon\"></span>\r\n");
      out.write("    </button>\r\n");
      out.write("    <button class=\"carousel-control-next\" type=\"button\" data-bs-target=\"#mainCarousel\" data-bs-slide=\"next\">\r\n");
      out.write("      <span class=\"carousel-control-next-icon\"></span>\r\n");
      out.write("    </button>\r\n");
      out.write("  </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("  <div class=\"container mt-4 category-container\">\r\n");
      out.write("    <h4>CATEGORY</h4>\r\n");
      out.write("    <div class=\"row\">\r\n");
      out.write("      <div class=\"col-md-4 mb-4 category-item\">\r\n");
      out.write("        <a href=\"https://www.example.com/kfood\" target=\"_blank\" class=\"category-link\">\r\n");
      out.write("          <img src=\"");
      out.print( request.getContextPath() );
      out.write("/resources/img/KFOOD.JPG\" class=\"img-fluid rounded\" alt=\"K-푸드\">\r\n");
      out.write("          <div class=\"fw-bold\">K-푸드</div>\r\n");
      out.write("        </a>\r\n");
      out.write("      </div>\r\n");
      out.write("      <div class=\"col-md-4 mb-4 category-item\">\r\n");
      out.write("        <a href=\"https://www.example.com/kbeauty\" target=\"_blank\" class=\"category-link\">\r\n");
      out.write("          <img src=\"");
      out.print( request.getContextPath() );
      out.write("/resources/img/BEAUTY01.jpg\" class=\"img-fluid rounded\" alt=\"K-뷰티\">\r\n");
      out.write("          <div class=\"fw-bold\">K-뷰티</div>\r\n");
      out.write("        </a>\r\n");
      out.write("      </div>\r\n");
      out.write("      <div class=\"col-md-4 mb-4 category-item\">\r\n");
      out.write("        <a href=\"https://www.example.com/location\" target=\"_blank\" class=\"category-link\">\r\n");
      out.write("          <img src=\"");
      out.print( request.getContextPath() );
      out.write("/resources/img/img (1).jpg\" class=\"img-fluid rounded\" alt=\"LOCATION\">\r\n");
      out.write("          <div class=\"fw-bold\">LOCATION</div>\r\n");
      out.write("        </a>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("\r\n");
      out.write("  <div class=\"container mt-5\">\r\n");
      out.write("    <div class=\"row\">\r\n");
      out.write("      <div class=\"col-md-6\">\r\n");
      out.write("        <h4>Notice Board</h4>\r\n");
      out.write("        <ul class=\"list-group\">\r\n");
      out.write("          <li class=\"list-group-item\">[공지] K-팝 체험 신청 시작!</li>\r\n");
      out.write("          <li class=\"list-group-item\">[신청] k-푸드 체험 김장 프로그램 신청</li>\r\n");
      out.write("          <li class=\"list-group-item\">[질문] 종로에서 음식점 추천 해주세요</li>\r\n");
      out.write("        </ul>\r\n");
      out.write("      </div>\r\n");
      out.write("\r\n");
      out.write("      <div class=\"col-md-6 d-flex flex-column\" style=\"height: 100%;\">\r\n");
      out.write("        <h4>Attraction Experience Program</h4>\r\n");
      out.write("        <div id=\"adCarousel\" class=\"carousel slide ad-slide\" data-bs-ride=\"carousel\" style=\"flex-grow: 1;\">\r\n");
      out.write("          <div class=\"carousel-inner\">\r\n");
      out.write("            <div class=\"carousel-item active\">\r\n");
      out.write("              <img src=\"");
      out.print( request.getContextPath() );
      out.write("/resources/img/체험0.jpg\" class=\"d-block w-100\" style=\"max-height: 150px; object-fit: cover;\">\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"carousel-item\">\r\n");
      out.write("              <img src=\"");
      out.print( request.getContextPath() );
      out.write("/resources/img/체험1.png\" class=\"d-block w-100\" style=\"max-height: 150px; object-fit: cover;\">\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"carousel-item\">\r\n");
      out.write("              <img src=\"");
      out.print( request.getContextPath() );
      out.write("/resources/img/체험2.jpg\" class=\"d-block w-100\" style=\"max-height: 150px; object-fit: cover;\">\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"carousel-item\">\r\n");
      out.write("              <img src=\"");
      out.print( request.getContextPath() );
      out.write("/resources/img/체험3.jpg\" class=\"d-block w-100\" style=\"max-height: 150px; object-fit: cover;\">\r\n");
      out.write("            </div>\r\n");
      out.write("          </div>\r\n");
      out.write("          <button class=\"carousel-control-prev\" type=\"button\" data-bs-target=\"#adCarousel\" data-bs-slide=\"prev\">\r\n");
      out.write("            <span class=\"carousel-control-prev-icon\"></span>\r\n");
      out.write("          </button>\r\n");
      out.write("          <button class=\"carousel-control-next\" type=\"button\" data-bs-target=\"#adCarousel\" data-bs-slide=\"next\">\r\n");
      out.write("            <span class=\"carousel-control-next-icon\"></span>\r\n");
      out.write("          </button>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("\r\n");
      out.write("  <div class=\"w-100 border-top small-nav\" style=\"height: 50px; margin-top: 40px; background-color: #005BAC;\">\r\n");
      out.write("    <div class=\"d-flex justify-content-center align-items-center h-100\">\r\n");
      out.write("     <a class=\"mx-3 text-decoration-none fw-bold\" style=\"color: #fff;\">Posts</a>\r\n");
      out.write("     <a class=\"mx-3 text-decoration-none fw-bold\" style=\"color: #fff;\">View reserved </a>\r\n");
      out.write("     <a class=\"mx-3 text-decoration-none fw-bold\" style=\"color: #fff;\">View activity history</a>\r\n");
      out.write("     <a class=\"mx-3 text-decoration-none fw-bold\" style=\"color: #fff;\">Apply for experience</a>\r\n");
      out.write("     <a class=\"mx-3 text-decoration-none fw-bold\" style=\"color: #fff;\">View details</a>\r\n");
      out.write("    </div>\r\n");
      out.write("   </div>\r\n");
      out.write("\r\n");
      out.write("   <footer>\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <div class=\"footer-content\">\r\n");
      out.write("                <div class=\"footer-column\">\r\n");
      out.write("                    <h3>K-CULTURE GUIDE</h3>\r\n");
      out.write("                    <ul>\r\n");
      out.write("                        <li><a href=\"#\">소개</a></li>\r\n");
      out.write("                        <li><a href=\"#\">팀 소개</a></li>\r\n");
      out.write("                        <li><a href=\"#\">채용 정보</a></li>\r\n");
      out.write("                        <li><a href=\"#\">언론 보도</a></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"footer-column\">\r\n");
      out.write("                    <h3>가이드</h3>\r\n");
      out.write("                    <ul>\r\n");
      out.write("                        <li><a href=\"#\">음식 카테고리</a></li>\r\n");
      out.write("                        <li><a href=\"#\">지역별 맛집</a></li>\r\n");
      out.write("                        <li><a href=\"#\">추천 레스토랑</a></li>\r\n");
      out.write("                        <li><a href=\"#\">시즌 스페셜</a></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"footer-column\">\r\n");
      out.write("                    <h3>커뮤니티</h3>\r\n");
      out.write("                    <ul>\r\n");
      out.write("                        <li><a href=\"#\">포럼</a></li>\r\n");
      out.write("                        <li><a href=\"#\">이벤트</a></li>\r\n");
      out.write("                        <li><a href=\"#\">쿠킹 클래스</a></li>\r\n");
      out.write("                        <li><a href=\"#\">회원 혜택</a></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"footer-column\">\r\n");
      out.write("                    <h3>문의하기</h3>\r\n");
      out.write("                    <ul>\r\n");
      out.write("                        <li><a href=\"#\">고객 지원</a></li>\r\n");
      out.write("                        <li><a href=\"#\">제휴 문의</a></li>\r\n");
      out.write("                        <li><a href=\"#\">레스토랑 등록</a></li>\r\n");
      out.write("                        <li><a href=\"#\">피드백</a></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"copyright\">\r\n");
      out.write("                <p>&copy; 2025 K-FOOD GUIDE. All rights reserved.</p>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </footer>\r\n");
      out.write("\r\n");
      out.write("  <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof jakarta.servlet.jsp.SkipPageException)){
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
