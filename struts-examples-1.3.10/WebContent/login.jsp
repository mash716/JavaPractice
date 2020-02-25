<%-- (1) --%>
<%@ page contentType="text/html; charset=Shift_JIS" %>
<%-- (2) --%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<html>
<head><title>login画面</title></head>
<body>

<html:errors/>  <%-- (3) --%>

ID・パスワードを入力してください。
<html:form action="/authentication" focus="id">  <%-- (4) --%>
    <html:text property="id" size="16"/>  <%-- (5) --%>
    <br>
    <%-- (6) --%>
    <html:password property="pass" size="16" redisplay="false"/>
    <br>
    <html:submit property="submit" value="送信"/>
    <html:reset value="リセット"/>
</html:form>

</body>
</html>