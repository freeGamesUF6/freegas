<%-- 
    Document   : form_game
    Created on : 03-may-2017, 11:10:07
    Author     : Jhonatan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <jsp:useBean id="game" scope="request" class="com.freegames.model.Game"></jsp:useBean>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../template/head.jsp" %>
    </head>
    <body>
        <%@include file="../template/Header.jsp" %>

        <div class="container-fluid">
           
            <div class="form col-md-6 col-md-offset-3">
                <h1> Form Game </h1>
                <jsp:setProperty name="game" property="*" />
                <% if (request.getParameter("name") == null) {%>

                <form role="form" method="post">
                    <div class="form-group">
                        <label for="name"><i class="glyphicon glyphicon-user"></i>Name:</label>
                        <input type="text" class="form-control" id="name" placeholder="name" name="name" size="30">
                    </div>
                    <div class="form-group">
                        <label for="developer"><i class="glyphicon glyphicon-user"></i>Developer</label>
                        <input type="text" class="form-control" id="developer" placeholder="Developer" name="developer" size="30">
                    </div>
                    <div class="form-group">
                       
                        hola
                        <label class="radio-inline"><input class="form-control" id="idcategory" type="radio" value="32" name="idcategory">Option 1</label>
                        <label class="radio-inline"><input class="form-control" id="idcategory" type="radio" value="32" name="idcategory">Option 2</label>
                        <label class="radio-inline"><input class="form-control" id="idcategory" type="radio" value="24" name="idcategory">Option 3</label>
                    </div>
                    <button type="submit" class="btn btn-default">Send</button>
                    <br />
                    <br />
                    <br /><br />
                    
                    
                </form>
                <%} else { %>
                <jsp:forward page="../../GestorGames?accio=insert"/>
                <%}%>
                <p>if you haven't an account, <a href="Insertar.jsp">sign in!</a></p>

            </div>
        </div>
        
            <%@include file="../template/Footer.jsp" %>

    </body>
</html>
