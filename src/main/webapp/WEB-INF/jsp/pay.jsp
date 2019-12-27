<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page import="ua.kpi.hotel.model.Reservation" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title><spring:message code="data.pay_title"/></title>
</head>
<body>
<form action="/pay" method="post" id="pay-form">
    <input type="hidden"
           name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>

<table border="1">
    <tr>
        <th><spring:message code="data.id"/></th>
        <th><spring:message code="data.room_id"/></th>
        <th><spring:message code="data.start_date"/></th>
        <th><spring:message code="data.end_date"/></th>
        <th><spring:message code="data.price"/></th>
        <th><spring:message code="data.action"/></th>
    </tr>
    <% for (Reservation reservation : (Iterable<Reservation>) request.getAttribute("reservationList")) { %>
    <tr>
        <td><%= reservation.getId() %></td>
        <td><%= reservation.getRoom().getId() %></td>
        <td><%= reservation.getStartDate() %></td>
        <td><%= reservation.getEndDate() %></td>
        <td><%= reservation.getPrice() %></td>
        <td>
            <input name="reservationId" type="hidden" value="<%= reservation.getId() %>" form="pay-form"/>
            <input type="submit" value="<spring:message code="data.pay"/>" form="pay-form"/>
        </td>
    </tr>
    <% } %>
</table>

<a href="/template"><spring:message code="data.create_template"/></a>
<a href="/logout"><spring:message code="data.sign_out"/></a>
</body>
</html>