<%@page import="modelo.beans.Curso"%>

<html>
    <head>
        <title>Agregar o editar curso</title>
        <meta charset="UTF-8">
        <link href="CSS/default.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <jsp:useBean id="cursos" class="modelo.beans.ConjuntoCursos" scope="application">
        </jsp:useBean>
        <%@ include file="header.jsp" %>
        <div id="wrapper">       
            <div id="contents">
                <form method="GET" action="ServicioAgregaEditaCurso">
                    <table class="busqueda">
                        <tbody>
                            <tr>
                                <td class="etiqueta">Id del curso:&nbsp;</td>
                                <td>  
                                    <input class="inputField" type="text" name="id_curso" id="id_curso" size="25" placeholder="(id del curso)" required/>
                                </td>
                            </tr>
                            <tr>
                                <td class="etiqueta">Descripcion:&nbsp;</td>
                                <td>  
                                    <input class="inputField" type="text" name="descripcion" id="descripcion" size="25" placeholder="(descripcion)" required/>
                                </td>
                            </tr>
                            <tr>
                                <td class="etiqueta">Tematica:&nbsp;</td>
                                <td> 
                                    <input class="inputField" type="text" name="tematica" id="tematica" size="25" placeholder="(tematica)" required/>
                                </td>
                        
                            </tr>
                            <tr>
                                <td colspan="2" class="botones">
                                    <p style="text-align: center;">
                                        <button type="submit">Agregar o editar</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        <button formaction="area_tematica.jsp" type="submit">Areas tematicas</button>&nbsp;
                                        <button formaction="abrir_grupo.jsp" type="submit">Abrir grupo</button>&nbsp;
                                    </p>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                    <div class="d2columnas">
                        ${cursos.tabla}
                    </div>
                </form>
            </div>
            <footer></footer>
        </div>
    </body>
</html>