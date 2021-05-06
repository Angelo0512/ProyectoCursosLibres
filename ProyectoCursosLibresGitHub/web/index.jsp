<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.beans.ConjuntoCursos"%>
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
        <jsp:useBean id="cursoVer" class="modelo.beans.Curso" scope="application">            
        </jsp:useBean>
        <jsp:useBean id="areas" class="modelo.beans.ConjuntoAreasTematicas" scope="application">            
        </jsp:useBean>
        <%@ include file="header.jsp" %>
        <div id="wrapper">
            <div id="contents">
                <form method="POST" action="ServicioBusquedaCurso">
                    <table class="busqueda">
                        <tbody>
                            <tr>
                                <td class="etiqueta">Nombre:&nbsp;</td>
                                <td>  
                                    <input class="inputField" type="text" name="descripcion" id="descripcion" size="25" placeholder="(nombre)"/>
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
                                        <button type="reset">Borrar</button>&nbsp;
                                    </p>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                    <div class="d2columnas">
                         <%
                            Curso c = (Curso) request.getAttribute("busquedaCurso");
                            List<Curso> cc = (List<Curso>) request.getAttribute("busquedaCursoTematica");
                            //out.print(c.getArea_tematica_id());
                            if (c != null) {
                        %>
                        
                        <table class="tablaCursos">
                            <caption></caption>
                            <thead>
                                <tr>
                                    <th>Id Curso</th>
                                    <th>Descripcion</th>
                                    <th>Area Tematica</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                <%= c.toStringHTML()%>
                            </tbody>
                        </table>
                            <%
                        } else if (cc != null) {
                        %>

                        <table class="tablaCursos">
                            <caption> CURSOS </caption>
                            <thead>
                                <tr>
                                    <th>Id Curso</th>
                                    <th>Descripcion</th>
                                    <th>Area Tematica</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                <%for (Curso curso : cc) {%>
                                <tr>
                                    <td><%=curso.getId_curso()%></td>
                                    <td><%=curso.getDescripcion()%></td>
                                    <td><%=curso.getArea_tematica_id()%></td>
                                    <td>
                                    <button name="grupos" value="<%=curso.getId_curso()%>">Ver</button>
                                    </td>
                                </tr>
                                <%}%>
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
                            String tematica = request.getParameter("tematica");
                            if ((tematica != null) && !tematica.isEmpty()) {
                        %>

                        <p class="mensajeError">
                            No se encuentran cursos de la tematica: <strong><%= tematica%></strong>
                        </p>

                        <%
                        } else {
                        %>

                        ${cursos.tabla}

                        <%
                                    }
                                }
                            }
                        %>
                    </div>
                </form>
            </div>  
        </div>
    </body>
</html>