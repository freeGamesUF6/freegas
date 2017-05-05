<%-- 
    Document   : listGames
    Created on : 03/05/2017, 17:08:38
    Author     : Mark
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

        <h2>Session de : <%= session.getAttribute("nickname") %></h2>
        <div class="row">

            <%
                for (Game game : games) {

            %>
            <div class="col-sm-6 col-md-4">
                <div class="thumbnail">

                    <img src="<%out.println(game.getUrl_img()); %> " class="img-responsive">
                    <div class="caption">
                        <h3><a href="../../GestorGames?accio=perfil&idGame=<%out.println(game.getId()); %>"><%out.println(game.getName()); %></a></h3>
                        <p><%out.println(game.getDescription()); %></p>
                        <p>Developer: <%out.println(game.getDeveloper()); %></p>
                        <a href="../../GestorGames?accio=descargar&idGame=<%out.println(game.getId()); %>"><button class='btn btn-alert'>Descargar</button></a>


                    </div>
                </div>
            </div>


            <%
                }
            %>

        </div>
        
        <%@include file="../template/Footer.jsp" %>
    </body>
</html>
