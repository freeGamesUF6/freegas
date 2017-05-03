<%-- 
    Document   : UsuarioPerfil
    Created on : 28-abr-2017, 16:35:46
    Author     : Xavier
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../template/head.jsp" %>
        <title>JSP Page</title>
        <%String nick=(String)request.getAttribute("nickname");%>
        <%String email=(String)request.getAttribute("mail");%>
    </head>
    <body>
        <%@include file="../template/Header.jsp" %>
        <div class="col-md-3">&nbsp;</div>
        
        <div class="col-md-6">
            <h2><i class="glyphicon glyphicon-user"></i>Nickname:<p><% request.getSession().getAttribute("nickname");%></p></h2>
            <hr>
            <h2><i class="glyphicon glyphicon-envelope"></i>Email:<p><% request.getSession().getAttribute("mail");%></p></h2>
            <hr>
            <br>
            <p><a href="listGames.jsp">Back!</a></p>
        </div>
        
        
        
        
        <div class="col-md-3">&nbsp;</div>
        <%@include file="../template/Footer.jsp" %>
    </body>
</html>
