<!DOCTYPE html>

<html>
    <head>
        <title>Grupos</title>
        <meta charset="UTF-8">
        <link href="CSS/grupo.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
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
                <form method="GET" action="ServicioBusqueda">
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
                                        <!<!-- Verificar que el input de id no este vacio o que se haya seleccionado un grupo -->
                                        <button type="reset">Eliminar</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                       <a href="abrir_grupo.jsp">Abrir grupo</a>&nbsp;
                                       <a href="carga_asignada.jsp">Carga asignada de profesores</a>&nbsp;
                                    </p>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                    <div class="gruposcolumnas">
                        <section id="secc1">
                            <table class="tablaGrupos">
                                <caption><u>GRUPOS</u></caption>
                                <thead>
                                    <tr>
                                        <th>&nbsp;</th>
                                        <th>ID</th>
                                        <th>Curso ID</th>
                                        <th>Profesor ID</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>1</td>
                                        <td>40060</td>
                                        <td>2255</td>
                                        <td>123456789</td>
                                    </tr>
                                    <tr>
                                        <td>2</td>
                                        <td>40061</td>
                                        <td>2255</td>
                                        <td>123456789</td>
                                    </tr>
                                    <tr>
                                        <td>3</td>
                                        <td>40062</td>
                                        <td>2255</td>
                                        <td>123456789</td>
                                    </tr>
                                    <tr>
                                        <td>4</td>
                                        <td>4073</td>
                                        <td>5522</td>
                                        <td>987654321</td>
                                    </tr>
                                    <tr>
                                        <td>5</td>
                                        <td>4074</td>
                                        <td>5522</td>
                                        <td>987654321</td>
                                    </tr>
                                    <tr>
                                        <td>5</td>
                                        <td>4075</td>
                                        <td>5522</td>
                                        <td>987654321</td>
                                    </tr>
                                    <tr>
                                        <td>6</td>
                                        <td>40064</td>
                                        <td>2525</td>
                                        <td>147852369</td>
                                    </tr>
                                    <tr>
                                        <td>7</td>
                                        <td>40065</td>
                                        <td>2525</td>
                                        <td>147852369</td>
                                    </tr>
                                </tbody>
                            </table>
                        </section>
                    </div>
                </form>
            </div>
            <footer></footer>
        </div>
    </body>
</html>
