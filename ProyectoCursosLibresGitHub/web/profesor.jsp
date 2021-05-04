<%-- 
    Document   : profesor
    Created on : 03/05/2021, 01:32:37 PM
    Author     : Angelo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="CSS/profesor.css" rel="stylesheet" type="text/css"/>
        <title>Profesores</title>
    </head>
    <body>
        <jsp:useBean id="profesores" class="modelo.beans.ConjuntoProfesores" scope="application">
        </jsp:useBean>
        <%@ include file="header.jsp" %>
        <div id="wrapper">            
            <div id="contents">
                <form method="POST" action="ServicioBusquedaProfesor">
                    <table class="busqueda">
                        <tbody>
                            <tr>
                                <td class="etiqueta">Id Profesor: &nbsp;</td>
                                <td>  
                                    <input class="inputField" type="text" name="idProfesor" id="idProfesor" size="25" placeholder="(Identificacion)"/>
                                </td>
                                <td colspan="2" class="botones">
                                    <p style="text-align: center;">
                                        <button type="submit">Buscar</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        <button type="reset">Borrar</button>&nbsp;
                                    </p>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                    <div>
                        
                    </div>
                    
                </form>
                ${profesores.tabla}
            </div>
        </div>
    </body>
</html>
