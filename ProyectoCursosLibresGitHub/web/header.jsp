<%@page import="modelo.beans.Profesor"%>
<%@page import="modelo.beans.Administrador"%>
<%@page import="modelo.beans.Estudiante"%>
<% Estudiante estudiante = (Estudiante) session.getAttribute("estudiante");%>
<% Administrador administrador = (Administrador) session.getAttribute("administrador");%>
<% Profesor profesor = (Profesor) session.getAttribute("profesor");%>

<link href="CSS/header.css" rel="stylesheet" type="text/css"/>

<div id="header" style="width:100%; background-color: #333;">

    <ul>
        <li><a href="index.jsp">Inicio</a></li>

        <% if (estudiante != null) {%>
        <li><a href="grupo.jsp">Grupos</a></li>
        <li><a href="historial.jsp">Historial</a></li>
        <li style="float: right"> <a href="Logout">Salir</a></li>
        <li style="float: right"> <p style="color: white; font-size: 14px; margin-right: 10px;"><%=estudiante.getNombre()%> <%=estudiante.getApellido1()%> - <%=estudiante.getUsuario_id()%></p></li>

        <% }%>
        <% if (administrador != null) {%>
        <li><a href="index.jsp">Cursos</a></li>
        <li><a href="grupo.jsp">Grupos</a></li>
        <li><a href="profesor.jsp">Profesores</a></li>
        <li style="float: right"> <a href="Logout">Salir</a></li>
        <li style="float: right"> <p style="color: white; font-size: 14px; margin-right: 10px;"><%=administrador.getNombre()%> <%=administrador.getApellido1()%> - <%=administrador.getUsuario_id()%></p></li>

        <% }%>
        <% if (profesor != null) {%>
        <li><a href="index.jsp">Cursos</a></li>
        <li><a href="grupo.jsp">Grupos</a></li>
        <li style="float: right"> <a href="Logout">Salir</a></li>
        <li style="float: right"> <p style="color: white; font-size: 14px; margin-right: 10px;"><%=profesor.getNombre()%> <%=profesor.getApellido1()%> - <%=profesor.getUsuario_id()%></p></li>
            <% }%>

        <% if (estudiante == null && administrador == null && profesor == null) {%>
        <li><a href="registro.jsp">Registro</a></li>
        <li style="float: right"><a href="login.jsp">Iniciar Sesión</a></li>
            <% }%>    
    </ul>
</div>