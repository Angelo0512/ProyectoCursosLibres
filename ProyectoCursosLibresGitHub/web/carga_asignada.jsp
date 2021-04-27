<!DOCTYPE html>

<html>
    <head>
        <title>Carga asignada</title>
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
                        <!<!-- falta la referencia -->
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
                                        <button type="submit">Modificar nota</button>&nbsp;
                                        <a href="registro_notas.jsp">modificar</a>
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
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>1</td>
                                        <td>40060</td>
                                        <td>2255</td>
                                    </tr>
                                    <tr>
                                        <td>2</td>
                                        <td>40061</td>
                                        <td>2255</td>
                                    </tr>
                                    <tr>
                                        <td>3</td>
                                        <td>40062</td>
                                        <td>2255</td>
                                    </tr>
                                    <tr>
                                        <td>4</td>
                                        <td>4073</td>
                                        <td>5522</td>
                                    </tr>
                                    <tr>
                                        <td>5</td>
                                        <td>4074</td>
                                        <td>5522</td>
                                    </tr>
                                    <tr>
                                        <td>5</td>
                                        <td>4075</td>
                                        <td>5522</td>
                                    </tr>
                                    <tr>
                                        <td>6</td>
                                        <td>40064</td>
                                        <td>2525</td>
                                    </tr>
                                    <tr>
                                        <td>7</td>
                                        <td>40065</td>
                                        <td>2525</td>
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
