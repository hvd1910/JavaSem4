<%@ page import="Entity.Employee" %><%-- Created by IntelliJ IDEA. User: tendu Date: 5/20/2024 Time: 8:28 AM To change this template use File | Settings | File Templates. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Employee Management Application</title>
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
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
            <% Employee employee = (Employee) request.getAttribute("employee"); %>
            <form action="<%= (employee != null) ? "update" : "insert" %>" method="post">
                <h2>
                    <%= (employee != null) ? "Edit Employee" : "Add New Employee" %>
                </h2>
                <% if (employee != null) { %>
                <input type="hidden" name="id" value="<%= employee.getId() %>"/>
                <% } %>
                <fieldset class="form-group">
                    <label>CMND</label>
                    <input maxlength="10" type="text" value="<%= (employee != null) ? employee.getCMND() : "" %>"
                           class="form-control" name="CMND" required="required">
                </fieldset>
                <fieldset class="form-group">
                    <label>Full Name</label>
                    <input type="text" value="<%= (employee != null) ? employee.getFull_Name() : "" %>"
                           class="form-control" name="Full_Name">
                </fieldset>
                <fieldset class="form-group">
                    <label>Birthday</label>
                    <input type="date" value="<%= (employee != null) ? employee.getBirthday() : "" %>"
                           class="form-control" name="Birthday">
                </fieldset>
                <fieldset class="form-group">
                    <label>Address</label>
                    <input type="text" value="<%= (employee != null) ? employee.getAddress() : "" %>"
                           class="form-control" name="Address">
                </fieldset>
                <fieldset class="form-group">
                    <label>Position</label>
                    <input type="text" value="<%= (employee != null) ? employee.getPosition() : "" %>"
                           class="form-control" name="Position">
                </fieldset>
                <fieldset class="form-group">
                    <label>Department</label>
                    <input type="text" value="<%= (employee != null) ? employee.getDepartment() : "" %>"
                           class="form-control" name="Department">
                </fieldset>

                <button type="submit" class="btn btn-success">Save</button>
                <button type="reset" class="btn btn-success">Reset</button>

            </form>
        </div>
    </div>
</div>

</body>
</html>
