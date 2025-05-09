package filter;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class LogFileFilter implements Filter{
   PrintWriter writer;
   public void init(FilterConfig config) throws ServletException{
      String filename = config.getInitParameter("filename");
      if(filename == null) {
         throw new ServletException("로그 파일의 이름을 찾을 수 없습니다.");
      }
      try {
         writer = new PrintWriter(new FileWriter(filename,true),true);
      } catch (IOException e) {
         // TODO: handle exception
         throw new ServletException("로그 파일을 열 수 없습니다.");
      }
   }
   public void doFilter(ServletRequest request, ServletResponse response,
          FilterChain chain) throws java.io.IOException, ServletException {
      System.out.println("접속한 클라이언트 IP : " + request.getRemoteAddr());
      
      long start = System.currentTimeMillis();
      
      System.out.println("접근한 URL 경로 : " + getURLPath(request));
      System.out.println("요청 처리 시작 시각 : " + getCurrentTime());
      
      // 다음 필터 또는 최종 대상 리소스 호출
      chain.doFilter(request, response);
      
      long end = System.currentTimeMillis();
      System.out.println("요청 처리 종료 시각 : " + getCurrentTime());
      System.out.println("요청 처리 소요 시각 : " + (end - start) + "ms");
      System.out.println("==========================================");
   }
   
   public void destroy() {
      // 필터 종료 시 리소스 해제 로직이 있다면 여기에 작성
   }
   
   private String getURLPath(ServletRequest request) {
      HttpServletRequest req;
      String currentPath = "";
      String queryString = "";
      if (request instanceof HttpServletRequest) {
      req = (HttpServletRequest) request;
      currentPath = req.getRequestURI();
      queryString = req.getQueryString();
      queryString = (queryString == null) ? "" : "?" + queryString;
      }
      return currentPath + queryString;
   }
   
   private String getCurrentTime() {
      DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
      Calendar calendar = Calendar.getInstance();
      calendar.setTimeInMillis(System.currentTimeMillis());
      return formatter.format(calendar.getTime());
   }
}
