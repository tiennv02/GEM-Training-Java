<%--
  Created by IntelliJ IDEA.
  User: Tu
  Date: 8/31/2017
  Time: 2:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>View Employee</title>
</head>
<body>
<h1>Employees List</h1>
<table border="2" width="70%" cellpadding="2">
    <tr><th>Id</th><th>Name</th><th>Salary</th><th>Designation</th><th>Edit</th><th>Delete</th></tr>
    <c:forEach var="emp" items="${list}">
        <tr>
            <td>${emp.id}</td>
            <td>${emp.name}</td>
            <td>${emp.salary}</td>
            <td>${emp.designation}</td>
            <td><a href="editemp/${emp.id}/">Edit</a></td>
            <td><a href="deleteemp/${emp.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="/empform">Add New Employee</a>
<a href="/">Home</a>

<a href="/viewemp/1/">1</a>
<a href="/viewemp/2/">2</a>
<a href="/viewemp/3/">3</a>

</body>
</html>
