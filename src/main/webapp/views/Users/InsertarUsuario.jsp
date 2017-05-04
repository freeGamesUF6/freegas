<%-- 
    Document   : Insertar
    Created on : 02-abr-2017, 21:28:27
    Author     : Xavibana
    Pàgina web per crear usuaris a la BBDD
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="loginError.jsp" %>
<!DOCTYPE html>
<html>
    <head>
          <%@include file="../template/head.jsp" %>
    </head>
    <body>
        <jsp:useBean id="registro" scope="request" class="com.freegames.model.User"></jsp:useBean>
        <jsp:setProperty name="registro" property="*" />
        <% if (request.getParameter("nick") == null) {%>

        <%@include file="../template/Header.jsp" %>
        

        <div class="col-md-3">&nbsp;</div>

        <div class="col-md-6">
            <form role="form" method="post">
                <h4>You are so close to be part of amazing players comunity, let's start!:</h4>
                <div class="form-group">
                        <label for="nick"><i class="glyphicon glyphicon-user"></i>NickName:</label>
                        <input type="text" class="form-control" id="nick" placeholder="Instert your nickname here!" name="nick" size="30">
                    </div>
                    <div class="form-group">
                        <label for="password"><i class="glyphicon glyphicon-lock"></i>Password:</label>
                        <input type="password" class="form-control" id="password" placeholder="Insert your password here!" name="password" size="30">
                    </div>
                    <div class="form-group">
                        <label for="email"><i class="glyphicon glyphicon-envelope"></i>Email:</label>
                        <input type="email" class="form-control" id="password" placeholder="Insert your email here!" name="mail" size="30">
                    </div>
                    <button type="submit" class="btn btn-default">Send</button>
                    </div>
                    <p>if you have an account, <a href="formularioLogin.jsp">log in!</a></p>
                </form>
            
            </div>
            <div class="col-md-3">&nbsp;</div>
            <%@include file="../template/Footer.jsp" %>
            
            <%}else{ %>
            <jsp:forward page="GestorUsuarios?accio=singin"/>
            <%}%>




    </body>
</html>
