<%@taglib prefix="ej" uri="/WEB-INF/tlds/ejemplo" %>
<!DOCTYPE html>

<html>
    <head>
        <title>Carga asignada</title>
        <meta charset="UTF-8">
        <link href="CSS/grupo.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <jsp:useBean id="cargas" class="modelo.beans.ConjuntoGrupos" scope="application">
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
                        <!<!-- falta la referencia -->
                        <a>Cerrar Sesion</a>
                    </p>
                </nav>
            </header>
            <div id="contents">
                <form method="GET" action="ServicioGrupo">
                    <table class="busqueda grupo">
                        <tbody>
                            <tr>
                                <td class="etiqueta">Id del grupo:&nbsp;</td>
                                <td>  
                                    <input class="inputField" type="text" name="idGrupo" id="idGrupo" size="25" placeholder="(Id del grupo)" required/>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2" class="botones">
                                    <p style="text-align: center;">
                                        <button type="submit">Buscar</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        <button type="submit">Modificar nota</button>&nbsp;
                                        <a href="registro_notas.jsp">modificar</a>
                                    </p>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                    <div class="d2columnas">
                        ${ej:getTablaCarga(cargas, user.id_usuario)}
                    </div>
                </form>
            </div>
            <footer></footer>
        </div>
    </body>
</html>
