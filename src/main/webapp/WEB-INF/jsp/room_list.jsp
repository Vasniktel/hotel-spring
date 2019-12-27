<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page import="ua.kpi.hotel.model.Room" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title><spring:message code="data.room_title"/></title>
</head>
<body>
<form action="/assign" method="post" id="assign-form">
    <input type="hidden" name="templateId" value="${templateId}"/>
    <input type="hidden"
           name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>
<table border="1">
    <tr>
        <th><spring:message code="data.id"/></th>
        <th><spring:message code="data.size"/></th>
        <th><spring:message code="data.type"/></th>
        <th><spring:message code="data.status"/></th>
        <th><spring:message code="data.price"/></th>
        <th><spring:message code="data.action"/></th>
    </tr>
    <% for (Room room : (Iterable<Room>) request.getAttribute("roomList")) { %>
    <tr>
        <td><%= room.getId() %></td>
        <td><%= room.getSize() %></td>
        <td><%= room.getType() %></td>
        <td><%= room.getStatus() %></td>
        <td><%= room.getPrice() %></td>
        <td>
            <input type="hidden" name="roomId" value="<%= room.getId() %>" form="assign-form"/>
            <input type="submit" value="<spring:message code="data.assign_room"/>" form="assign-form"/>
        </td>
    </tr>
    <% } %>
</table>
</body>
</html>
