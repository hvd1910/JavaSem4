<%@ page import="com.example.demo.LoginBean" %><%--
  Created by IntelliJ IDEA.
  User: tendu
  Date: 5/10/2024
  Time: 11:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Controller</title>
    <%
        //Step 1 call Controller
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        // Step2: Call instance of JavaBean(model)
        LoginBean loginBean = new LoginBean();
        boolean status = false;
        status = loginBean.checkLogin(username, password);
        if (status) { %>
        <%--Step 3: --%>
        <jsp:forward page="success.jsp"/>
        <%}else {%>
        <jsp:forward page="false.jsp"/>
        <%} %>
    %>
</head>
<body>

</body>
</html>
