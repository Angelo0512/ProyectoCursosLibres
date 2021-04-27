<!DOCTYPE html>

<html>
    <head>
        <title>Cursos Libres</title>
        <meta charset="UTF-8">
        <link href="CSS/default.css" rel="stylesheet" type="text/css"/>
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
                <nav id="loginHeader">
                    <p>
                        <a href="login.jsp">Iniciar Sesión</a>
                    </p>
                </nav>
                </nav>
                <nav id="loginHeader">
                    <p>
                        <a href="registro.jsp">Registrarse</a>
                    </p>
                </nav>
            </header>
            <div id="contents">
                <form method="GET" action="ServicioBusqueda">
                    <table class="busqueda">
                        <tbody>
                            <tr>
                                <td class="etiqueta">Nombre:&nbsp;</td>
                                <td>  
                                    <input class="inputField" type="text" name="nombre" id="nombre" size="25" placeholder="(nombre)"/>
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
                        <section id="secc1">
                            <table class="tablaCursos">
                                <caption><u>CURSOS</u></caption>
                                <thead>
                                    <tr>
                                        <th>&nbsp;</th>
                                        <th>ID</th>
                                        <th>Nombre</th>
                                        <th>Temática</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>1</td>
                                        <td>2468</td>
                                        <td>Soporte Tecnico</td>
                                        <td>Ingenieria en Sistemas</td>
                                    </tr>
                                    <tr>
                                        <td>2</td>
                                        <td>3932</td>
                                        <td>Estructuras de Datos</td>
                                        <td>Ingenieria en Sistemas</td>
                                    </tr>
                                    <tr>
                                        <td>3</td>
                                        <td>2255</td>
                                        <td>Programacion IV</td>
                                        <td>Ingenieria en Sistemas</td>
                                    </tr>
                                    <tr>
                                        <td>4</td>
                                        <td>1501</td>
                                        <td>Contabilidad</td>
                                        <td>Administracion de Empresas</td>
                                    </tr>
                                    <tr>
                                        <td>5</td>
                                        <td>4425</td>
                                        <td>Finanzas</td>
                                        <td>Administracion de Empresas</td>
                                    </tr>
                                    <tr>
                                        <td>6</td>
                                        <td>9402</td>
                                        <td>Estadistica</td>
                                        <td>Matematicas</td>
                                    </tr>
                                    <tr>
                                        <td>7</td>
                                        <td>2311</td>
                                        <td>Metodos de Investigacion</td>
                                        <td>Ingenieria en Sistemas</td>
                                    </tr>
                                    <tr>
                                        <td>8</td>
                                        <td>6224</td>
                                        <td>Programacion II</td>
                                        <td>Ingenieria en Sistemas</td>
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
