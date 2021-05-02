
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
                    <a href="registro.jsp">Reintentar</a>
                </p>
                
            </div>
            <footer></footer>
        </div>
    </body>
</html>
