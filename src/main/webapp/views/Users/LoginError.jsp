<%-- 
    Document   : LoginError
    Created on : 28-abr-2017, 16:23:55
    Author     : Xavier
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" contentType="text/html" %>
<%--
RUTAS DE LOS ARCHIVOS EXCEPTION
--%>
<%@page import="com.freegames.control.UsuariRepetitException"%>
<%@page import="com.freegames.control.PasswordFailException"%>
<%@page import="com.freegames.control.NickErrorException"%>
<!DOCTYPE html>
<html>
    <head>
       <%@include file="../template/head.jsp" %>
    </head>
    <body>
        
        <%@include file="../template/Header.jsp" %>
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
            </a><%;}else{
                        %>
            <h4>We are sorry, but your Nickname is wrong, you should try again!</h4>
            <a href="formulario.jsp">
                <button type="submit" class="btn btn-default">Back</button>
            </a>
        <%
                        }
        }
      
%>
            
        </div>
        <div class="col-md-3">&nbsp;</div>
        <%@include file="../template/Footer.jsp" %>
    </body>
</html>
