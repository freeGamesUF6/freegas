<%-- 
    Document   : prova
    Created on : 03-may-2017, 18:02:27
    Author     : Xavier
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <h1><p><% request.getSession().getAttribute("nickname");%></p></h1>
    </body>
</html>
