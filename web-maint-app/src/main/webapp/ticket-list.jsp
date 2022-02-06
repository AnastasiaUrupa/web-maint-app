<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Maint App</title>
</head>
<body>
<h1>Ticket list</h1>
<div >
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Description</th>
            <th>Priority</th>
            <th>Customer</th>
            <th>Component</th>
        </tr>
        <c:forEach var="ticket" items="${ticketList}">
            <tr>
                <td><c:out value="${ticket.id}" /></td>
                <td><c:out value="${ticket.title}" /></td>
                <td><c:out value="${ticket.description}" /></td>
                <td><c:out value="${ticket.priority}" /></td>
                <td><c:out value="${ticket.customer.name}" /></td>
                <td><c:out value="${ticket.component.name}" /></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>