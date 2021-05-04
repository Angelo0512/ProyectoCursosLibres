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
        <div id="wrapper">
            <%@ include file="header.jsp" %>
            <div id="contents">
                <form method="POST" action="ServicioBusquedaProfesor">
                    <table class="busqueda">
                        <tbody>
                            <tr>
                                <td class="etiqueta">Id Usuario: &nbsp;</td>
                                <td>  
                                    <input class="inputField" type="text" name="idProfesor" id="idProfesor" size="25" placeholder="(Identificacion)"/>
                                </td>
                                <td colspan="2" class="botones">
                                    <p style="text-align: center;">
                                        <button type="submit">Buscar</button>&nbsp;
                                        
                                    </p>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                    <div>
                        <%
                            String id = request.getParameter("idProfesor");
                            Profesor p = (Profesor) request.getAttribute("busquedaProfesor");
                            
                            if(p != null){  
                        %>
                        
                       <table class="tablaProfesor">
                            <caption> PROFESORES </caption>
                            <thead>
                                <tr>
                                    <th>Id Profesor</th>
                                    <th>Id Usuario</th>
                                    <th>Apellido 1</th>
                                    <th>Apellido 2</th>
                                    <th>Nombre</th>
                                    <th>Telefono</th>
                                    <th>Email</th>
                                </tr>
                            </thead>
                            <tbody>
                                <% if(p.getId_profesor()!=0){%>
                                <%= p.toStringHTML()%>
                                <%}%>
                            </tbody>
                        </table>
                        
                        
                        <%
                            }else{       
                        %>
                        ${profesores.tabla}
                        <%}%>
                        
                    </div>
                    
                </form>
                
            </div>
        </div>
    </body>
</html>
