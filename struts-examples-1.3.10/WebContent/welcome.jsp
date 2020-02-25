<%@ page contentType="text/html; charset=Shift_JIS" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<logic:notPresent name="id" scope="session">  <%-- (1) --%>
    <logic:redirect forward="fail"/>
</logic:notPresent>

<html>
<head><title>welcom‰æ–Ê</title></head>
<body>

‚æ‚¤‚±‚»
<bean:write name="id" scope="session"/>  <%-- (2) --%>
‚³‚ñ

</body>
</html>