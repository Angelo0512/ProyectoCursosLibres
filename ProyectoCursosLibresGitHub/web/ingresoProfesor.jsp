<%-- 
    Document   : ingresoProfesor
    Created on : 03/05/2021, 10:09:20 PM
    Author     : Angelo
--%>

<%@page import="modelo.beans.Area_tematica"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Ingreso de Profesores</title>
        <link href="CSS/registro.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <jsp:useBean id="profesores" class="modelo.beans.ConjuntoProfesores" scope="application">
        </jsp:useBean>
        <jsp:useBean id="usuarios" class="modelo.beans.ConjuntoUsuarios" scope="application">
        </jsp:useBean>
        <jsp:useBean id="areas" class="modelo.beans.ConjuntoAreasTematicas" scope="application">
        </jsp:useBean>
        <jsp:useBean id="especialidades" class="modelo.beans.ConjuntoEspecialidades" scope="application">
        </jsp:useBean>

        <%@ include file="header.jsp" %>

        <div id="wrapper">
            <div id="contents">
                <h1>Ingreso de profesores</h1>
                <form method="GET" action="ServicioProfesor">
                    <table>
                        <tbody>
                            <tr>
                                <td>
                                    <p>
                                        <label>Identificación:&nbsp;</label>
                                    </p>
                                </td>
                                <td>
                                    <input class="inputField" type="number" name="id"
                                           placeholder="(digite la identificación)" min=100000000 max=999999999 required/>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <p>
                                        <label>Nombre:&nbsp;</label>
                                    </p>
                                </td>
                                <td>
                                    <input class="inputField" type="text" name="nombre"
                                           placeholder="(nombre)" required/>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <p>
                                        <label>Primer Apellido:&nbsp;</label>
                                    </p>
                                </td>
                                <td>
                                    <input class="inputField" type="text" name="apellido1"
                                           placeholder="(primer apellido)" required/>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <p>
                                        <label>Segundo Apellido:&nbsp;</label>
                                    </p>
                                </td>
                                <td>
                                    <input class="inputField" type="text" name="apellido2"
                                           placeholder="(segundo apellido)" required/>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <p>
                                        <label>Telefono:&nbsp;</label>
                                    </p>
                                </td>
                                <td>
                                    <input class="inputField" type="text" name="telefono"
                                           placeholder="(telefono)" required/>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <p>
                                        <label>Correo electronico:&nbsp;</label>
                                    </p>
                                </td>
                                <td>
                                    <input class="inputField" type="text" name="email"
                                           placeholder="(correo electronico)" required/>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <p>
                                        <label>Especialidad:&nbsp;</label>
                                    </p>
                                </td>
                                <td>
                                    <select size="1" name="especialidad">
                                    <%List<Area_tematica> list = areas.getListaAreasTematicas();
                                    for(int i=0; i < list.size(); i++){
                                    %>
                                        <option value="<%=list.get(i).getId_area()%>"><%=list.get(i).getDescripcion()%></option>
                                    
                                    <%
                                        }
                                    %>
                                    </select>

                                </td>
                            </tr>
                            <tr>
                                <td class="botonRegistro" colspan="2">
                                    <p style="text-align: center;">
                                        <button type="submit">Registrar</button>
                                    </p>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </form>
            </div>
            <footer>
                
            </footer>
        </div>
    </body>
</html>