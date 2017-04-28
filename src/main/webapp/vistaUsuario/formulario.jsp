<%-- 
    Document   : formulario
    Created on : 21-abr-2017, 16:02:36
    Author     : Xavier
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>FreeGames</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
        <%@include file="Header.jsp" %>

        <div class="container-fluid">

            <div class="form-inline">
                <jsp:useBean id="logueo" scope="request" class="model.User"></jsp:useBean>
                <jsp:setProperty name="logueo" property="*" />
                <% if (request.getParameter("nick") == null) {%>

                <form role="form" method="post">
                    <div class="form-group">
                        <label for="nick"><i class="glyphicon glyphicon-user"></i>NickName:</label>
                        <input type="text" class="form-control" id="nick" placeholder="Instert your nickname here!" name="nick" size="30">
                    </div>
                    <div class="form-group">
                        <label for="password"><i class="glyphicon glyphicon-lock"></i>Password:</label>
                        <input type="password" class="form-control" id="password" placeholder="Insert your password here!" name="password" size="30">
                    </div>
                    <button type="submit" class="btn btn-default">Send</button>
                </form>
                <%} else { %>
                <jsp:forward page="Controlador?accio=login"/>
                <%}%>
                <p>if you haven't an account, <a href="Insertar.jsp">sign in!</a></p>

            </div>


            <%@include file="Footer.jsp" %>




    </body>
</html>
