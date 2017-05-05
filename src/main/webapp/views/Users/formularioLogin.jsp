<%-- 
    Document   : formulario
    Created on : 21-abr-2017, 16:02:36
    Author     : Xavier
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
     <%@include file="../template/head.jsp" %>
    </head>
    <body>
        <%@include file="../template/Header.jsp" %>
        
        <div class="container-fluid">

            <div class="form-inline">
                <jsp:useBean id="User" scope="request" class="com.freegames.model.User"></jsp:useBean>
                <jsp:setProperty name="User" property="*" />
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
                <jsp:forward page="/GestorUsuarios?accio=login"/>
                <%}%>
                <p>if you haven't an account, <a href="InsertarUsuario.jsp">sign in!</a></p>

            </div>


            <%@include file="../template/Footer.jsp" %>




    </body>
</html>
