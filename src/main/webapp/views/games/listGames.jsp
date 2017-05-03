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
        <%@include file="../template/Header.jsp" %>
        <%
            GameDAO gd=new GameDAO();
            List<Game> games=gd.queryGames();
        %>
        <table class="table table-striped">
            <tr><th>Name</th><th>Developer</th></tr>
            <%
                for (Game game : games) {
                 System.out.println("<tr><td>"+game.getName()+"</td><td>"+game.getDeveloper()+"</td><tr>");  
                }
            %>
        </table>
        
        <%@include file="../template/Footer.jsp" %>
    </body>
</html>
