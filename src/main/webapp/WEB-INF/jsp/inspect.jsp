<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page import="ua.kpi.hotel.model.Reservation" %>
<%@ page import="java.time.LocalDate" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title><spring:message code="data.inspect_title"/></title>
</head>
<body>
<form action="/inspect" method="post" id="inspect-form">
    <input type="hidden"
           name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>

<table border="1">
    <tr>
        <th><spring:message code="data.id"/></th>
        <th><spring:message code="data.user_id"/></th>
        <th><spring:message code="data.room_id"/></th>
        <th><spring:message code="data.start_date"/></th>
        <th><spring:message code="data.end_date"/></th>
        <th><spring:message code="data.price"/></th>
        <th><spring:message code="data.action"/></th>
    </tr>
    <% for (Reservation reservation : (Iterable<Reservation>) request.getAttribute("reservationList")) { %>
    <tr>
        <td><%= reservation.getId() %></td>
        <td><%= reservation.getUser().getId() %></td>
        <td><%= reservation.getRoom().getId() %></td>
        <td><%= reservation.getStartDate() %></td>
        <td><%= reservation.getEndDate() %></td>
        <td><%= reservation.getPrice() %></td>
        <td>
            <% if (!LocalDate.now().isBefore(reservation.getStartDate())) { %>
            <input name="reservationId" type="hidden" value="<%= reservation.getId() %>" form="inspect-form"/>
            <input type="submit" value="<spring:message code="data.delete"/>" form="inspect-form"/>
            <% } else { %>
            <spring:message code="data.all_good"/>
            <% } %>
        </td>
    </tr>
    <% } %>
</table>

<a href="/reserve"><spring:message code="data.resolve_templates"/></a>
<a href="/logout"><spring:message code="data.sign_out"/></a>
</body>
</html>