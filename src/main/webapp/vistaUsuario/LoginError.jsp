<%-- 
    Document   : LoginError
    Created on : 28-abr-2017, 16:23:55
    Author     : Xavier
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" contentType="text/html" %>
<%--
RUTAS DE LOS ARCHIVOS EXCEPTION
<%@page import="control.UsuariRepetitException"%>
<%@page import="control.PasswordFailException"%>

--%>
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
        <div class="col-md-3">&nbsp;</div>
        <div class="col-md-6">
        <h2>Error!</h2>
            <%
        
        if(exception.getCause() instanceof PasswordFailException){
        %> <h4>We are sorry, but your password is wrong, you should try again!</h4>
            <a href="formulario.jsp">
                <button type="submit" class="btn btn-default">Back</button>
            </a><%;}
        else {
            if(exception.getCause() instanceof UsuariRepetitException){
        %><h4>We are sorry, but your nickname is used, you should choose another one!</h4>
            <a href="Insertar.jsp">
                <button type="submit" class="btn btn-default">Back</button>
            </a><%;}
        }
      
%>
            
        </div>
        <div class="col-md-3">&nbsp;</div>
        <%@include file="Footer.jsp" %>
    </body>
</html>
