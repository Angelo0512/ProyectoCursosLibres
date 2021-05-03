<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="ej" uri="/WEB-INF/tlds/ejemplo" %>

<html>
    <head>
        <title>Regisdtro de notas</title>
        <meta charset="UTF-8">
        <link href="CSS/grupo.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <jsp:useBean id="matriculas" class="modelo.beans.ConjuntoMatricula" scope="application">            
        </jsp:useBean>
        <jsp:useBean id="grupoRegistro" class="modelo.beans.Grupo" scope="application">            
        </jsp:useBean>
        <div id="wrapper">
            
            <%@ include file="header.jsp" %>
            
            <div id="contents">
                <form method="GET" action="ServicioRegistro">
                    <div class="estudiantescolumnas">
                        <form method="POST" action="ServicioRegistro">
                            <table class="busqueda">
                                <tbody>
                                    <tr>
                                        <td class="etiqueta">Id del estudiante:&nbsp;</td>
                                        <td>  
                                            <input class="inputField" type="text" name="estudiante_id" id="estudiante_id" size="25" placeholder="(id del estudiante)" required/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="etiqueta">Id del grupo:&nbsp;</td>
                                        <td>  
                                            <input class="inputField" type="text" name="grupo_num" id="grupo_num" size="25" placeholder="(id del estudiante)" required/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="etiqueta">Nueva nota:&nbsp;</td>
                                        <td> 
                                            <input class="inputField" type="text" name="nota" id="nota" size="25" placeholder="(nota)" required/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="2" class="botones">
                                            <p style="text-align: center;">
                                                <button type="submit">Modificar</button>&nbsp;
                                            </p>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </form>
                        <div class="d2columnas">                      
                            ${ej:getTablaGrupos(matriculas, grupoRegistro.num_grupo)}
                        </div>
                    </div>
                </form>
            </div>
            <footer></footer>
        </div>
    </body>
</html>
