<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <title>Error</title>
        <meta charset="UTF-8">
        <link href="CSS/registro.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@ include file="header.jsp" %>
        <div id="wrapper">            
            <div id="contents">
                <p class="error">
                    Ocurrió un error al procesar los datos del formulario.
                </p>
                <p style="text-align: center;">
                    <% if (estudiante != null) {%>
                    <a href="registro.jsp">Reintentar</a>
                    <%}%>
                    <% if (administrador != null) {%>
                    <a href="ingresoProfesor.jsp">Reintentar</a>
                    <%}%>
                </p>
            </div>
            <footer></footer>
        </div>
    </body>
</html>
