<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page import="ua.kpi.hotel.model.ReservationTemplate" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title><spring:message code="data.template_list_title"/></title>
</head>
<body>
<form method="post" action="/reserve" id="reserve-form">
    <input type="hidden"
           name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>
<table border="1">
    <tr>
        <th><spring:message code="data.id"/></th>
        <th><spring:message code="data.room_size"/></th>
        <th><spring:message code="data.room_type"/></th>
        <th><spring:message code="data.start_date"/></th>
        <th><spring:message code="data.end_date"/></th>
        <th><spring:message code="data.creation_time"/></th>
        <th><spring:message code="data.action"/></th>
    </tr>
    <% for (ReservationTemplate template : (Iterable<ReservationTemplate>) request.getAttribute("templateList")) { %>
    <tr>
        <td><%= template.getId() %></td>
        <td><%= template.getRoomSize() %></td>
        <td><%= template.getRoomType() %></td>
        <td><%= template.getStartDate() %></td>
        <td><%= template.getEndDate() %></td>
        <td><%= template.getCreationTime() %></td>
        <td>
            <input type="submit" value="<spring:message code="data.assign_room"/>" form="reserve-form"/>
            <input type="hidden" name="templateId" value="<%= template.getId() %>" form="reserve-form"/>
        </td>
    </tr>
    <% } %>
</table>

<a href="/inspect"><spring:message code="data.inspect_title"/></a>
<a href="/logout"><spring:message code="data.sign_out"/></a>
</body>
</html>
