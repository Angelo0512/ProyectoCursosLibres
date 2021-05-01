<!DOCTYPE html>

<%@taglib prefix="ej" uri="/WEB-INF/tlds/ejemplo" %>
<html>
    <head>
        <title>Grupos</title>
        <meta charset="UTF-8">
        <link href="CSS/grupo.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <jsp:useBean id="grupo" class="modelo.beans.ConjuntoGrupos" scope="application">
            <jsp:setProperty name="gr" property="*"></jsp:setProperty> 
        </jsp:useBean>
        <jsp:useBean id="user" class="modelo.beans.Usuario" scope="session">
            <jsp:setProperty name="user" property="id_usuario" value="${user.id_usuario}"></jsp:setProperty>
        </jsp:useBean>
        <div id="wrapper">
            <header style="overflow: hidden;">
                <nav id="menuHeader">
                    <p>
                        <a href="index.jsp">Inicio</a>
                    </p>
                </nav>
                <nav id="menuHeader">
                    <p>
                        <a href="index.jsp">Cursos</a>
                    </p>
                </nav>
                <nav id="menuHeader">
                    <p>
                        <a href="grupo.jsp">Grupos</a>
                    </p>
                </nav>
                <nav id="menuHeader">
                    <p>
                        <a href="index.jsp">Estudiantes</a>
                    </p>
                </nav>
                <nav id="menuHeader">
                    <p>
                        <a href="index.jsp">Profesores</a>
                    </p>
                </nav>
                <nav id="logoutHeader">
                    <p>
                        <!<!-- falta la refeencia -->
                        <a>Cerrar Sesion</a>
                    </p>
                </nav>
            </header>
            <div id="contents">
                    <table class="busqueda grupo">
                        <tbody>
                            <tr>
                                <td class="etiqueta">Id del grupo:&nbsp;</td>
                                <td>  
                                    <input class="inputField" type="text" name="num_grupo" id="num_grupo" size="25" placeholder="(Id del grupo)" required/>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2" class="botones">
                                    <p style="text-align: center;">
                                        <button type="submit">Buscar</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        <!<!-- Verificar que el input de id no este vacio o que se haya seleccionado un grupo -->
                                        <button type="reset">Eliminar</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                       <a href="abrir_grupo.jsp">Abrir grupo</a>&nbsp;
                                       <a href="carga_asignada.jsp">Carga asignada de profesores</a>&nbsp;
                                       <a href="area_tematica.jsp">Area tematica</a>
                                    </p>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                   <div class="d2columnas">                      
                        ${grupo.tabla}
                    </div>
            </div>
            <footer></footer>
        </div>
    </body>
</html>
