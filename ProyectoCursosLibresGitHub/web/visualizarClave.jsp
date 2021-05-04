<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.beans.Usuario"%>
<% Usuario usuario = (Usuario) session.getAttribute("generacionClave");%>
<!DOCTYPE html>
<html>
    <head>
        <title>Generacion clave</title>
        <meta charset="UTF-8">

        <link href="CSS/registro.css" rel="stylesheet" type="text/css"/>

    </head>
    <body>

        <%@ include file="header.jsp" %>

        <div id="wrapper">            
            <div id="contents">
                <p>
                    La clave para el usuario con identification: <%=usuario.getId_usuario()%> es: <%=usuario.getClave()%>
                </p>
                <p style="text-align: center;">
                    <% if (estudiante != null) {%>
                    <a href="login.jsp">Iniciar sesión</a>
                    <%}%>
                    
                    <% if (administrador != null) {%>
                    <a href="profesor.jsp">Volver</a>
                    <%}%> 
                </p>

            </div>
            <footer></footer>
        </div>
    </body>
</html>
