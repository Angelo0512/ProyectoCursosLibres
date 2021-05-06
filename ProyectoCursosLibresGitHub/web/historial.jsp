<%-- 
    Document   : historial
    Created on : 02/05/2021, 05:48:48 PM
    Author     : Angelo
--%>

<%--
Este JSP esta dedicado para mostrar el historial de curso de un estudiante en especifico
--%>

<%@page import="modelo.beans.ConjuntoEstados"%>
<%@page import="modelo.beans.Matricula"%>
<%@page import="modelo.beans.ConjuntoMatricula"%>
<%@page import="modelo.beans.ConjuntoCursos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Historial</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="CSS/historial.css" rel="stylesheet" type="text/css"/>   
    </head>
    <body>
        <jsp:useBean id="cursos" class="modelo.beans.ConjuntoCursos" scope="application">
        </jsp:useBean>
        <jsp:useBean id="matriculas" class="modelo.beans.ConjuntoMatricula" scope="application">
        </jsp:useBean>
        <jsp:useBean id="estados" class="modelo.beans.ConjuntoEstados" scope="application">
        </jsp:useBean>
        <div id="wrapper">
            <%@include file="header.jsp" %>
            <div id="contents">
                <%--
                Para lograr ver los cursos en el historial del estudiante
                se hace el uso del servlet ServicioHistorial 
                Este Servlet cumple todas las funciones relacionadas con el Historial
                --%>
                <form method="POST" action="ServicioHistorial">
                    <%--
                    Se crea un formulario el cual crea una tabla que despliega automaticamente 
                    el historial academico del estudiante
                    Ademas incluye un boton que genera un pdf de la tabla asignada al historial
                    --%>
                    <table class="tablaHistorial">
                        <caption> HISTORIAL </caption>
                        <thead>
                            <tr>
                                <th>Id Curso</th>
                                <th>Descripcion</th>
                                <th>Numero Grupo</th>
                                <th>Estado</th>
                                <th>Nota</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%--
                            Se realiza un ciclo que busca el ConjuntoMatriculas todos las matriculas asignadas a ese estudiante
                            y a partir de ahi empieza a sacar toda la informacion necesaria
                            --%>
                            <%for (Matricula matricula : matriculas.getListaMatriculaIdEstudiate(estudiante.getId_estudiante())) {%>
                            <tr>
                                <td><%= matricula.getCurso_id()%></td>
                                <td><%= cursos.retrieve(matricula.getCurso_id()).getDescripcion()%></td>
                                <td><%= matricula.getGrupo_num()%></td>
                                <td><%= estados.retrieve(matricula.getEstado_id()).getDescripcion()%></td>
                                <td><%= matricula.getNota()%></td>
                            </tr>
                            <%}%>
                            <tr>
                                <td colspan="5">
                                    <%--
                                    Existe un input invicible que tiene la funcion de mandar el id del estudiante al servlet
                                    Y tambien un boton que descargar la tabla como un pdf
                                    --%>
                                    <input type="hidden" value="<% estudiante.getId_estudiante();%>" name="idEst">
                                    <input type="submit" value="Descargar PDF">
                                </td>
                            </tr>                     

                        </tbody>
                        <tfoot>
                        </tfoot>
                    </table>
                </form>
            </div>
        </div>
    </body>
</html>
