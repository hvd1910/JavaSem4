<%-- Created by IntelliJ IDEA. User: tendu Date: 5/20/2024 Time: 8:29 AM To change this template use File | Settings | File Templates. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="Entity.Employee" %>
<html>
<head>
    <title>Employee</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<header>
    <nav class="navbar navbar-expand-md navbar-dark">
        <div>
            <a href="" class="navbar-brand">Employee Management App</a>
        </div>
        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/list" class="nav-link">Employees</a></li>
        </ul>
    </nav>
</header>
<br>
<div class="row">
    <div class="container">
        <h3 class="text-center">List of Employees</h3>
        <hr>

        <div class="container text-left">
            <a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add New Employee</a>
        </div>
        <br>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Country</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <%
                List<Employee> listEmp = (List<Employee>) request.getAttribute("listEmployee");
                for (Employee emp : listEmp) {
            %>
            <tr>
                <td><%= emp.getId() %></td>
                <td><%= emp.getCMND() %></td>
                <td><%= emp.getFull_Name() %></td>
                <td><%= emp.getBirthday() %></td>
                <td><%= emp.getAddress() %></td>
                <td><%= emp.getPosition() %></td>
                <td><%= emp.getDepartment() %></td>

                <td>
                    <a href="edit?id=<%= emp.getId() %>">Edit</a>
                    <a href="delete?id=<%= emp.getId() %>">Delete</a>
                </td>
            </tr>
            <%
                }
            %>
            </tbody>
        </table>
    </div>
</div>

</body>
</html>
