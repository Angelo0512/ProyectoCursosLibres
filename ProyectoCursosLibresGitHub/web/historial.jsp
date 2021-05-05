<%-- 
    Document   : historial
    Created on : 02/05/2021, 05:48:48 PM
    Author     : Angelo
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
                <form method="POST" action="ServicioHistorial">
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
