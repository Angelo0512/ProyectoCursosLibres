<!DOCTYPE html>

<html>
    <head>
        <title>Regisdtro de notas</title>
        <meta charset="UTF-8">
        <link href="CSS/registro_notas.css" rel="stylesheet" type="text/css"/>
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
                    <div class="estudiantescolumnas">
                        <section id="secc1">
                            <table class="tablaEstudiantes">
                                <caption><u>ESTUDIANTES</u></caption>
                                <thead>
                                    <tr>
                                        <th>&nbsp;</th>
                                        <th>ID</th>
                                        <th>Nombre</th>
                                        <th>Apellido 1</th>
                                        <th>Apelllido 2</th>
                                        <th>Email</th>
                                        <th>Nota</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>1</td>
                                        <td>123798456</td>
                                        <td>Juan</td>
                                        <td>Perez</td>
                                        <td>Gamboa</td>
                                        <td>juan@gmail.com</td>
                                        <td>85</td>
                                    </tr>
                                    <tr>
                                        <td>2</td>
                                        <td>123789456</td>
                                        <td>Maria</td>
                                        <td>Gamboa</td>
                                        <td>Perez</td>
                                        <td>maria@gmail.com</td>
                                        <td>90</td>
                                    </tr>
                                    <tr>
                                        <td>3</td>
                                        <td>147963258</td>
                                        <td>Armando</td>
                                        <td>Casas</td>
                                        <td>Rojas</td>
                                        <td>armando@gmail.com</td>
                                        <td>75</td>
                                    </tr>
                                    <tr>
                                        <td>4</td>
                                        <td>213456789</td>
                                        <td>Susana</td>
                                        <td>Oria</td>
                                        <td>Naranjo</td>
                                        <td>susana@gmail.com</td>
                                        <td>60</td>
                                    </tr>
                                    <tr>
                                        <td>5</td>
                                        <td>123789456</td>
                                        <td>Pedro</td>
                                        <td>Piedra</td>
                                        <td>Del Rio</td>
                                        <td>pedro@gmail.com</td>
                                        <td>92</td>
                                    </tr>
                                    <tr>
                                        <td>5</td>
                                        <td>321654897</td>
                                        <td>Peter</td>
                                        <td>Parker</td>
                                        <td>Mora</td>
                                        <td>peter@gmail.com</td>
                                        <td>88</td>
                                    </tr>
                                    <tr>
                                        <td>6</td>
                                        <td>412536987</td>
                                        <td>Harry</td>
                                        <td>Potter</td>
                                        <td>Ruiz</td>
                                        <td>harry@gmail.com</td>
                                        <td>73</td>
                                    </tr>
                                    <tr>
                                        <td>7</td>
                                        <td>541236987</td>
                                        <td>Billie</td>
                                        <td>Eilish</td>
                                        <td>Castro</td>
                                        <td>billie@gmail.com</td>
                                        <td>100</td>
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
