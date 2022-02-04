<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Maint App</title>
</head>
<body>
    <h1>Get components</h1>
<div >
    <table border="1" cellpadding="5">
        <h2>List of Customers</h2>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Contact Person</th>
        </tr>
        <c:forEach var="component" items="${componentList}">
            <tr>
                <td><c:out value="${component.id}" /></td>
                <td><c:out value="${component.name}" /></td>
                <td><c:out value="${component.team}" /></td>
                <td>
                   <a href="component?id=<c:out value='${component.id}' />">Details</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>