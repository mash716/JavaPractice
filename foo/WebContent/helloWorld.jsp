<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Hello World</title>
</head>
<body>
  <!-- filter="false"にするとHTMLの自動エスケープがオフになる -->
  <bean:write name="helloWorldForm" property="message" filter="false" />
</body>
</html>