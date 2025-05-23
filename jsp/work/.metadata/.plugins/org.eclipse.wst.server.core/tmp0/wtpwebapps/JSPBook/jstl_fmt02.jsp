<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<title>Internationalization</title>
</head>
<body>
<fmt:setLocale value="ko_KR" />
<fmt:setBundle basename="bundle.Bundle" var="resourceBundle" />


	<p>숫자 : <fmt:formatNumber value="3200100" />	
	<p><fmt:formatNumber value="3200100" type="number" />
	<p><fmt:formatNumber value="3200100" type="number" groupingUsed="false" />	
	<p><fmt:formatNumber value="3200100" type="currency" groupingUsed="true" />
	<p><fmt:formatNumber value="3200100" type="currency" currencySymbol="&" />	 
	<p><fmt:formatNumber value="0.45" type="percent" />
	<p><fmt:formatNumber value="3200100" minIntegerDigits="10" minFractionDigits="2" />
	<p><fmt:formatNumber value="3200100.45" pattern=".000" />
	<p><fmt:formatNumber value="3200100.456" pattern="#,#00.0#" />
</body>
</html>