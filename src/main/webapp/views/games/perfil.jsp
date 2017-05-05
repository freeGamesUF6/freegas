<%-- 
    Document   : perfil
    Created on : 05-may-2017, 4:26:43
    Author     : Jhona
--%>


<%@page import="com.freegames.model.Game"%>
<%@page import="java.util.List"%>
<%@page import="com.freegames.model.GameDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../template/head.jsp" %>
    </head>
    <body>
        <!-- Table games-->
        <%@include file="../template/Header.jsp" %>
        <%
            GameDAO gd = new GameDAO();
            List<Game> games = gd.queryGames();
        %>

        <h2>Session de : <%= session.getAttribute("nickname")%></h2>
        <div class="row">
            <div class="col-md-6 col-md-offset-3">
                <div class="thumbnail">

                    <img src=" <%= request.getAttribute("img")%> " class="img-responsive">
                    <div class="caption">
                        <h3><%= request.getAttribute("name")%></h3>
                        <p><%= request.getAttribute("description")%></p>
                        <p>Developer: <%= request.getAttribute("developer")%></p>
                          
                          <a href="<%= request.getAttribute("url")%>" class="btn btn-danger btn-lg" role="button">Descarga</a>
                          <br />
                           <br />
                        <div class="list-group">
                            <a href="#" class="list-group-item active">
                               List User:
                            </a>
                            <a href="#" class="list-group-item">pepe</a>
                            <a href="#" class="list-group-item">Juanito</a>
                            <a href="#" class="list-group-item">menganito</a>
                            <a href="#" class="list-group-item">JA!</a>
                        </div>


                    </div>
                </div>
            </div>

        </div>
        <%@include file="../template/Footer.jsp" %>
    </body>
</html>
