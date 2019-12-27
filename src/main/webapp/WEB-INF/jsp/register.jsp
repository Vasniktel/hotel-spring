<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title><spring:message code="data.sign_up"/></title>
</head>
<body>
<form action="/register" method="post">
    <input name="login" type="text" placeholder="<spring:message code="data.login"/>"/><br>
    <input name="password" type="text" placeholder="<spring:message code="data.password"/>"/><br>
    <input name="isAdmin" type="checkbox" value="" checked/> <spring:message code="data.admin"/><br>
    <input type="submit" value="<spring:message code="data.sign_up"/>"/>
    <input type="hidden"
           name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>

<a href="/login"><spring:message code="data.sign_in"/></a>
</body>
</html>
