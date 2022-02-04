<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Get customers</title>
</head>
<body>
<center>
    <h1>Get customers</h1>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Customers</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Contact Person</th>
<%--            <th>Actions</th>--%>
        </tr>
        <c:forEach var="customer" items="${customerList}">
            <tr>
                <td><c:out value="${customer.id}" /></td>
                <td><c:out value="${customer.name}" /></td>
                <td><c:out value="${customer.contactPerson}" /></td>
<%--                <td>--%>
<%--                    <a href="edit?id=<c:out value='${customer.id}' />">Edit</a>--%>
<%--                    &nbsp;&nbsp;&nbsp;&nbsp;--%>
<%--                    <a href="delete?id=<c:out value='${customer.id}' />">Delete</a>--%>
<%--                </td>--%>
            </tr>
        </c:forEach>
    </table>
</div>
</body>