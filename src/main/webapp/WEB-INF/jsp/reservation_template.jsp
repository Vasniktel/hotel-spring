<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page import="ua.kpi.hotel.model.Room" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title><spring:message code="data.create_template"/></title>
</head>
<body>
<form action="/template" method="post">
    <input name="roomSize" type="number" placeholder="<spring:message code="data.room_size"/>"/><br>
    <select name="roomType">
        <% for (Room.Type type : Room.Type.values()) { %>
        <option value="<%= type %>"><%= type %></option>
        <% } %>
    </select><br>
    <input name="startDate" type="date" placeholder="<spring:message code="data.start_date"/>"/><br>
    <input name="endDate" type="date" placeholder="<spring:message code="data.end_date"/>"/><br>
    <input type="submit" value="<spring:message code="data.create_template"/>"/>
    <input type="hidden"
           name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>

<a href="/pay"><spring:message code="data.pay"/></a>
<a href="/logout"><spring:message code="data.sign_out"/></a>
</body>
</html>