<%-- 
    Document   : errorsGames
    Created on : 03-may-2017, 12:44:38
    Author     : Jhona
--%>

<%@ page import="com.freegames.game.GameRepetitException"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" contentType="text/html" %>

<!DOCTYPE html>
<html>
       <head>
        <%@include file="../template/head.jsp" %>
    </head>
    <body>
        <%@include file="../template/Header.jsp" %>
         <div class="col-md-6 col-md-offset-3">
        <%
            if (exception.getCause() instanceof GameRepetitException) {
                out.print("Juego Repetido");
            } else {
                String s = exception.getMessage();
                out.print(s);
                out.print("otro tipo de error");
            }

        %>
         </div>
         <%@include file="../template/Footer.jsp" %>

    </body>
</html>
