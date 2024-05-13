<%@ page import="java.util.Date" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %></h1>

<br/>
<h2>To string: <% Date date = new Date();
                    %></h2>
<h3><%=date.toString()%></h3>
<a href="hello-servlet">Hello Servlet</a>
</body>
</html>