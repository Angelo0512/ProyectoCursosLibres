<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="ej" uri="/WEB-INF/tlds/ejemplo" %>

<!DOCTYPE html>

<html>
    <head>
        <title>Grupos del curso</title>
        <meta charset="UTF-8">
        <link href="CSS/grupo.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <jsp:useBean id="cursoVer" class="modelo.beans.Curso" scope="application">            
        </jsp:useBean>
        <jsp:useBean id="cargas" class="modelo.beans.ConjuntoGrupos" scope="application">
        </jsp:useBean>
        <div id="wrapper">

            <%@ include file="header.jsp" %>
            
            <div id="contents">
                <form method="GET" action="ServicioGrupo">
                    <table class="busqueda grupo">
                        <tbody>
                            <tr>
                                <td class="etiqueta">Id del grupo:&nbsp;</td>
                                <td>  
                                    <input class="inputField" type="text" name="idGrupo" id="idGrupo" size="25" placeholder="(Id del grupo)" required/>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2" class="botones">
                                    <p style="text-align: center;">
                                        <button type="submit">Buscar</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        <button type="submit">Modificar nota</button>&nbsp;
                                        <a href="registro_notas.jsp">modificar</a>
                                    </p>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                    <div class="d2columnas">
                        ${ej:getTablaCurso(cargas, cursoVer.id_curso)}
                    </div>
                </form>
            </div>
            <footer></footer>
        </div>
    </body>
</html>
