/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.1.40
 * Generated at: 2025-05-02 03:34:02 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.member;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;
import java.util.*;

public final class processLoginMember_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports,
                 org.apache.jasper.runtime.JspSourceDirectives {

  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("jar:file:/D:/KGH/jsp/work/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/BookMarket/WEB-INF/lib/jstl-1.2.jar!/META-INF/sql.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1745981797903L));
    _jspx_dependants.put("jar:file:/D:/KGH/jsp/work/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/BookMarket/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(6);
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("jakarta.servlet");
    _jspx_imports_packages.add("jakarta.servlet.http");
    _jspx_imports_packages.add("jakarta.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fsql_005fsetDataSource_0026_005fvar_005fuser_005furl_005fpassword_005fdriver_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fsql_005fquery_0026_005fvar_005fdataSource;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fsql_005fparam_0026_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fredirect_0026_005furl_005fnobody;

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
    _005fjspx_005ftagPool_005fsql_005fsetDataSource_0026_005fvar_005fuser_005furl_005fpassword_005fdriver_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fsql_005fquery_0026_005fvar_005fdataSource = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fsql_005fparam_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fredirect_0026_005furl_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fsql_005fsetDataSource_0026_005fvar_005fuser_005furl_005fpassword_005fdriver_005fnobody.release();
    _005fjspx_005ftagPool_005fsql_005fquery_0026_005fvar_005fdataSource.release();
    _005fjspx_005ftagPool_005fsql_005fparam_0026_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
    _005fjspx_005ftagPool_005fc_005fredirect_0026_005furl_005fnobody.release();
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      if (_jspx_meth_sql_005fsetDataSource_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("   \r\n");
      out.write("   <!-- select쓸때만 sql:query  -->\r\n");
      //  sql:query
      org.apache.taglibs.standard.tag.rt.sql.QueryTag _jspx_th_sql_005fquery_005f0 = (org.apache.taglibs.standard.tag.rt.sql.QueryTag) _005fjspx_005ftagPool_005fsql_005fquery_0026_005fvar_005fdataSource.get(org.apache.taglibs.standard.tag.rt.sql.QueryTag.class);
      _jspx_th_sql_005fquery_005f0.setPageContext(_jspx_page_context);
      _jspx_th_sql_005fquery_005f0.setParent(null);
      // /member/processLoginMember.jsp(19,0) name = dataSource type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_sql_005fquery_005f0.setDataSource((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${dataSource}", java.lang.Object.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      // /member/processLoginMember.jsp(19,0) name = var type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_sql_005fquery_005f0.setVar("resultSet");
      int[] _jspx_push_body_count_sql_005fquery_005f0 = new int[] { 0 };
      try {
        int _jspx_eval_sql_005fquery_005f0 = _jspx_th_sql_005fquery_005f0.doStartTag();
        if (_jspx_eval_sql_005fquery_005f0 != jakarta.servlet.jsp.tagext.Tag.SKIP_BODY) {
          if (_jspx_eval_sql_005fquery_005f0 != jakarta.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
            _jspx_push_body_count_sql_005fquery_005f0[0]++;
            out = org.apache.jasper.runtime.JspRuntimeLibrary.startBufferedBody(_jspx_page_context, _jspx_th_sql_005fquery_005f0);
          }
          do {
            out.write("  \r\n");
            out.write("	select * from member where id = ? and password = ?\r\n");
            out.write("	");
            //  sql:param
            org.apache.taglibs.standard.tag.rt.sql.ParamTag _jspx_th_sql_005fparam_005f0 = (org.apache.taglibs.standard.tag.rt.sql.ParamTag) _005fjspx_005ftagPool_005fsql_005fparam_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.sql.ParamTag.class);
            _jspx_th_sql_005fparam_005f0.setPageContext(_jspx_page_context);
            _jspx_th_sql_005fparam_005f0.setParent((jakarta.servlet.jsp.tagext.Tag) _jspx_th_sql_005fquery_005f0);
            // /member/processLoginMember.jsp(21,1) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
            _jspx_th_sql_005fparam_005f0.setValue(id );
            int _jspx_eval_sql_005fparam_005f0 = _jspx_th_sql_005fparam_005f0.doStartTag();
            if (_jspx_th_sql_005fparam_005f0.doEndTag() == jakarta.servlet.jsp.tagext.Tag.SKIP_PAGE) {
              return;
            }
            _005fjspx_005ftagPool_005fsql_005fparam_0026_005fvalue_005fnobody.reuse(_jspx_th_sql_005fparam_005f0);
            out.write('\r');
            out.write('\n');
            out.write('	');
            //  sql:param
            org.apache.taglibs.standard.tag.rt.sql.ParamTag _jspx_th_sql_005fparam_005f1 = (org.apache.taglibs.standard.tag.rt.sql.ParamTag) _005fjspx_005ftagPool_005fsql_005fparam_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.sql.ParamTag.class);
            _jspx_th_sql_005fparam_005f1.setPageContext(_jspx_page_context);
            _jspx_th_sql_005fparam_005f1.setParent((jakarta.servlet.jsp.tagext.Tag) _jspx_th_sql_005fquery_005f0);
            // /member/processLoginMember.jsp(22,1) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
            _jspx_th_sql_005fparam_005f1.setValue(password);
            int _jspx_eval_sql_005fparam_005f1 = _jspx_th_sql_005fparam_005f1.doStartTag();
            if (_jspx_th_sql_005fparam_005f1.doEndTag() == jakarta.servlet.jsp.tagext.Tag.SKIP_PAGE) {
              return;
            }
            _005fjspx_005ftagPool_005fsql_005fparam_0026_005fvalue_005fnobody.reuse(_jspx_th_sql_005fparam_005f1);
            out.write('\r');
            out.write('\n');
            int evalDoAfterBody = _jspx_th_sql_005fquery_005f0.doAfterBody();
            if (evalDoAfterBody != jakarta.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
          if (_jspx_eval_sql_005fquery_005f0 != jakarta.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
            out = _jspx_page_context.popBody();
            _jspx_push_body_count_sql_005fquery_005f0[0]--;
          }
        }
        if (_jspx_th_sql_005fquery_005f0.doEndTag() == jakarta.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
      } catch (java.lang.Throwable _jspx_exception) {
        while (_jspx_push_body_count_sql_005fquery_005f0[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_sql_005fquery_005f0.doCatch(_jspx_exception);
      } finally {
        _jspx_th_sql_005fquery_005f0.doFinally();
      }
      _005fjspx_005ftagPool_005fsql_005fquery_0026_005fvar_005fdataSource.reuse(_jspx_th_sql_005fquery_005f0);
      out.write("\r\n");
      out.write("\r\n");
      //  c:forEach
      org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
      _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fforEach_005f0.setParent(null);
      // /member/processLoginMember.jsp(25,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setVar("row");
      // /member/processLoginMember.jsp(25,0) name = items type = jakarta.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/member/processLoginMember.jsp(25,0) '${resultSet.rows}'",_jsp_getExpressionFactory().createValueExpression(_jspx_page_context.getELContext(),"${resultSet.rows}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
      int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
      try {
        int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
        if (_jspx_eval_c_005fforEach_005f0 != jakarta.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write('\r');
            out.write('\n');
            out.write('	');

		session.setAttribute("sessionId",id);
	
            out.write("\r\n");
            out.write("   ");
            if (_jspx_meth_c_005fredirect_005f0(_jspx_th_c_005fforEach_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
              return;
            out.write('\r');
            out.write('\n');
            int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
            if (evalDoAfterBody != jakarta.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_005fforEach_005f0.doEndTag() == jakarta.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
      } catch (java.lang.Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_005fforEach_005f0.doFinally();
      }
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
      out.write("\r\n");
      out.write("\r\n");
      if (_jspx_meth_c_005fredirect_005f1(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
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

  private boolean _jspx_meth_sql_005fsetDataSource_005f0(jakarta.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    jakarta.servlet.jsp.PageContext pageContext = _jspx_page_context;
    //  sql:setDataSource
    org.apache.taglibs.standard.tag.rt.sql.SetDataSourceTag _jspx_th_sql_005fsetDataSource_005f0 = (org.apache.taglibs.standard.tag.rt.sql.SetDataSourceTag) _005fjspx_005ftagPool_005fsql_005fsetDataSource_0026_005fvar_005fuser_005furl_005fpassword_005fdriver_005fnobody.get(org.apache.taglibs.standard.tag.rt.sql.SetDataSourceTag.class);
    _jspx_th_sql_005fsetDataSource_005f0.setPageContext(_jspx_page_context);
    _jspx_th_sql_005fsetDataSource_005f0.setParent(null);
    // /member/processLoginMember.jsp(14,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_sql_005fsetDataSource_005f0.setVar("dataSource");
    // /member/processLoginMember.jsp(14,0) name = url type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_sql_005fsetDataSource_005f0.setUrl("jdbc:mysql://localhost:3306/BookMarketDB");
    // /member/processLoginMember.jsp(14,0) name = driver type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_sql_005fsetDataSource_005f0.setDriver("com.mysql.jdbc.Driver");
    // /member/processLoginMember.jsp(14,0) name = user type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_sql_005fsetDataSource_005f0.setUser("root");
    // /member/processLoginMember.jsp(14,0) name = password type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_sql_005fsetDataSource_005f0.setPassword("1234");
    int _jspx_eval_sql_005fsetDataSource_005f0 = _jspx_th_sql_005fsetDataSource_005f0.doStartTag();
    if (_jspx_th_sql_005fsetDataSource_005f0.doEndTag() == jakarta.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      return true;
    }
    _005fjspx_005ftagPool_005fsql_005fsetDataSource_0026_005fvar_005fuser_005furl_005fpassword_005fdriver_005fnobody.reuse(_jspx_th_sql_005fsetDataSource_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fredirect_005f0(jakarta.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f0, jakarta.servlet.jsp.PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws java.lang.Throwable {
    jakarta.servlet.jsp.PageContext pageContext = _jspx_page_context;
    //  c:redirect
    org.apache.taglibs.standard.tag.rt.core.RedirectTag _jspx_th_c_005fredirect_005f0 = (org.apache.taglibs.standard.tag.rt.core.RedirectTag) _005fjspx_005ftagPool_005fc_005fredirect_0026_005furl_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.RedirectTag.class);
    _jspx_th_c_005fredirect_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fredirect_005f0.setParent((jakarta.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f0);
    // /member/processLoginMember.jsp(29,3) name = url type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fredirect_005f0.setUrl("resultMember.jsp?msg=2");
    int _jspx_eval_c_005fredirect_005f0 = _jspx_th_c_005fredirect_005f0.doStartTag();
    if (_jspx_th_c_005fredirect_005f0.doEndTag() == jakarta.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fredirect_0026_005furl_005fnobody.reuse(_jspx_th_c_005fredirect_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fredirect_005f1(jakarta.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    jakarta.servlet.jsp.PageContext pageContext = _jspx_page_context;
    //  c:redirect
    org.apache.taglibs.standard.tag.rt.core.RedirectTag _jspx_th_c_005fredirect_005f1 = (org.apache.taglibs.standard.tag.rt.core.RedirectTag) _005fjspx_005ftagPool_005fc_005fredirect_0026_005furl_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.RedirectTag.class);
    _jspx_th_c_005fredirect_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fredirect_005f1.setParent(null);
    // /member/processLoginMember.jsp(32,0) name = url type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fredirect_005f1.setUrl("loginMember.jsp?error=1");
    int _jspx_eval_c_005fredirect_005f1 = _jspx_th_c_005fredirect_005f1.doStartTag();
    if (_jspx_th_c_005fredirect_005f1.doEndTag() == jakarta.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fredirect_0026_005furl_005fnobody.reuse(_jspx_th_c_005fredirect_005f1);
    return false;
  }
}
