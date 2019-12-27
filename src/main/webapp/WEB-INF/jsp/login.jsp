<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title><spring:message code="data.sign_in"/></title>
</head>
<body>
<form name="loginForm" action="/login" method="post">
    <input name="login" type="text" placeholder="<spring:message code="data.login"/>" value=""/><br>
    <input name="password" type="password" placeholder="<spring:message code="data.password"/>" value=""/><br>
    <input type="submit" value="<spring:message code="data.sign_in"/>"/>
    <input type="hidden"
           name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>

<a href="/register"><spring:message code="data.sign_up"/></a>
</body>
</html>
