<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Maint web app</title>
</head>
<body>
<h1>Maint Web App</h1>
<h2>
    <h1>Create new customer</h1>
    <form action="customer" method="post">
        <table style="with: 50%">
            <tr>
                <td>Customer Name</td>
                <td><input type="text" name="name" /></td>
            </tr>
            <tr>
                <td>Customer Contact Person</td>
                <td><input type="text" name="person" /></td>
            </tr></table>
        <input type="submit" value="Submit" /></form>
    <br><br>

    <br><br>
    <a href="customer">List all customers</a>

    <h1>Create new component</h1>
    <form action="components" method="post">
        <table style="with: 50%">
            <tr>
                <td>Component Name</td>
                <td><input type="text" name="name" /></td>
            </tr>
            <tr>
                <td>Team responsible for component</td>
                <td><input type="text" name="team" /></td>
            </tr>
            <tr>
                <td>Version (optional)</td>
                <td><input type="text" name="version" /></td>
            </tr>
        </table>
        <input type="submit" value="Submit" /></form>

    <br><br>
    <a href="components">List all components</a>
    <br><br>
    <a href="ticket">Create ticket</a>
    <br><br>
</h2>
</body>
</html>