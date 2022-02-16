<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.example.webmaintapp.entity.Priority" %>
<html>
<head>
    <title>Maint App</title>
</head>
<body>
    <h1>Create new MAINT ticket</h1>

<%--    <h3>Select component</h3>--%>
<%--    <form action="ticket?id=<c:out value='${component.id}'/>" method="get">--%>
<%--        <select name="component" >--%>
<%--            <c:forEach var="component" items="${componentList}">--%>
<%--                <option value="${component.id}">${component.name}</option>--%>
<%--            </c:forEach>--%>

<%--        </select>--%>
<%--        <input type="submit" value="Submit" />--%>

    </form>

    <form action=ticket?id=<c:out value='${component}'/>" method="post">
        <table style="with: 50%">
            <tr>
                <td>Title</td>
                <td><input type="text" name="title" /></td>
            </tr>
            <tr>
                <td>Description</td>
                <td><input type="text" name="description" /></td>
            </tr>
            <tr>
                <td>Customer</td>
                <td> <select name="customer" >
                    <c:forEach var="customer" items="${customerList}">
                        <option value="${customer.id}">${customer.name}</option>
                    </c:forEach>
                </select></td>
            </tr>
            <tr>
                <td>Priority</td>
                <td> <select name="priority" >
                    <c:forEach var="priority" items="${Priority.values()}">
                        <option value="${priority}">${priority}</option>
                    </c:forEach>
                </select></td>
            </tr>
            <tr>
                <td>Component</td>
                <td> <select name="component" >
                    <c:forEach var="component" items="${componentList}">
                        <option value="${component.id}">${component.name}</option>
                    </c:forEach>
                </select></td>
            </tr>
<%--            <tr>--%>
<%--                <td>Version</td>--%>
<%--                <td> <select name="version" >--%>
<%--                    <c:forEach var="version" items="${versionList}">--%>
<%--                        <option value="${version.versionNumber}">${version.versionNumber}</option>--%>
<%--                    </c:forEach>--%>
<%--                </select></td>--%>
<%--            </tr>--%>
        </table>
        <input type="submit" value="Submit" /></form>
    <br><br>
</body>
</html>
