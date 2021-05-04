<%@page import="modelo.beans.Curso"%>

<html>
    <head>
        <title>Cursos Libres</title>
        <meta charset="UTF-8">
        <link href="CSS/default.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <jsp:useBean id="cursos" class="modelo.beans.ConjuntoCursos" scope="application">
        </jsp:useBean>
        <%@ include file="header.jsp" %> 
        <div id="wrapper">       
            <div id="contents">
                <form method="GET" action="ServicioBusquedaCurso">
                    <table class="busqueda">
                        <tbody>                            
                            <tr>
                                <td class="etiqueta">Nombre:&nbsp;</td>
                                <td>  
                                    <input class="inputField" type="text" name="descripcion" id="descripcion" size="25" placeholder="(descripcion)"/>
                                </td>
                            </tr>
                            <tr>
                                <td class="etiqueta">Tematica:&nbsp;</td>
                                <td> 
                                    <input class="inputField" type="text" name="tematica" id="tematica" size="25" placeholder="(tematica)"/>
                                </td>
                        
                            </tr>
                            <tr>
                                <td colspan="2" class="botones">
                                    <p style="text-align: center;">
                                        <button type="submit">Buscar</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        <a href="crearEditarCurso.jsp">Crear o editar un curso</a>&nbsp;
                                    </p>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                    <div class="d2columnas">

                        <%
                            Curso c = (Curso) request.getAttribute("busquedaCurso");
                            if (c != null) {
                        %>

                        <table class="tablaCursos">
                            <caption> CURSOS </caption>
                            <thead>
                                <tr>
                                    <th>ID curso</th>
                                    <th>Nombre</th>
                                    <th>Area Tematica</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                <%= c.toStringHTML()%>
                            </tbody>
                        </table>

                        <%
                        } else {
                            String descripcion = request.getParameter("descripcion");
                            if ((descripcion != null) && !descripcion.isEmpty()) {
                        %>

                        <p class="mensajeError">
                            No se encuentran cursos con el nombre: <strong><%= descripcion%></strong>
                        </p>

                        <%
                        } else {
                        %>

                        ${cursos.tabla}

                        <%
                                }
                            }
                        %>
                    </div>
                </form>
            </div>
            <footer></footer>
        </div>
    </body>
</html>