
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Error</title>
        <meta charset="UTF-8">
        <link href="css/default.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div id="wrapper">

            <%@ include file="header.jsp" %>
            
            <nav>
                <p>
                    <a href="index.jsp">Ir a la pagina principal</a>
                </p>
            </nav>
            <div id="contents">
                <p class="error">
                    Ocurrió un error al procesar los datos del formulario.
                </p>
            </div>
            <footer></footer>
        </div>
    </body>
</html>
