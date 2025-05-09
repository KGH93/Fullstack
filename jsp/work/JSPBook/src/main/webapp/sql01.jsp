<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<html>
<head>
<title>JSTL</title>
</head>
<body>
   <sql:setDataSource var="dataSource"
      url="jdbc:mysql://localhost:3306/JSPBookDB"
      driver="com.mysql.jdbc.Driver" user="root" password="1234" />

   <sql:query var="resultSet" dataSource="${dataSource}">
      select * from member
   </sql:query>

   <table border="1">
      <tr>
      <!-- resultSet.columnNames : 모든 컬럼이름 리스트 -->
         <c:forEach var="columnName" items="${resultSet.columnNames}">
            <th width="100"><c:out value="${columnName}" /></th>
            <!-- columnName : 변수에 하나씩 담아 컬럼이름을 반복 -->
         </c:forEach>
      </tr>
      <c:forEach var="row" items="${resultSet.rowsByIndex}">
      <!-- 각 행을 리스트 형태로 반환 var="row" 행을 반복-->
      <tr>
         <c:forEach var="column" items="${row}" varStatus="i">
         <td>
            <c:if test="${column != null}">
               <c:out value="${column}" />
            </c:if> 
            <c:if test="${column == null}">
               &nbsp;
            </c:if>
         </td>
         </c:forEach>
      </tr>
      </c:forEach>
   </table>
</body>
</html>