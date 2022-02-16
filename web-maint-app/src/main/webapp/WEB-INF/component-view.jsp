<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Maint App</title>
</head>
<body>
    <h1>Get component info</h1>
<div >
    <table border="1" cellpadding="5">
        <h2><c:out value="${component.name}"/> versions</h2>
        <tr>
            <th>ID</th>
            <th>Version</th>
        </tr>
        <c:forEach var="version" items="${component.versions}">
            <tr>
                <td><c:out value="${version.id}" /></td>
                <td><c:out value="${version.versionNumber}" /></td>
            </tr>
        </c:forEach>
    </table>
    <br><br>
    <form action="component?id=<c:out value='${component.id}' />" method="post">
        <tr>
            <td>Add version</td>
            <td><input type="text" name="version" /></td>
        </tr>
        <input type="submit" value="Submit" />
    </form>
</div>
</body>