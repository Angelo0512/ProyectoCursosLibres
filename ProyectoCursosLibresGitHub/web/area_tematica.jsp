<!DOCTYPE html>

<html>
    <head>
        <title>Abrir area tematica</title>
        <meta charset="UTF-8">
        <link href="CSS/abrir_grupo.css" rel="stylesheet" type="text/css"/>
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
                        <!-- falta la refeencia -->
                        <a>Cerrar Sesion</a>
                    </p>
                </nav>
            </header>
            <div id="contents">
                <form method="GET" action="ServicioCrear">
                    <table class="abrir grupo">
                        <tbody>
                            <tr>
                                <td class="etiqueta">Id del grupo:&nbsp;</td>
                                <td>  
                                    <input class="inputField" type="text" name="idGrupo" id="idGrupo" size="25" placeholder="(Id del grupo)" required/>
                                </td>
                            </tr>
                            <tr>
                                <td class="etiqueta">Id del curso:&nbsp;</td>
                                <td>  
                                    <!-- Se tiene que validar que el curso exista o desplegar una lista -->
                                    <input class="inputField" type="text" name="idCurso" id="idCurso" size="25" placeholder="(Id del curso)" required/>
                                </td>
                            </tr>
                            <tr>
                                <td class="etiqueta">Id del curso:&nbsp;</td>
                                <td>  
                                    <!-- Se tiene que validar que el profesor exista o desplegar una lista -->
                                    <input class="inputField" type="text" name="idProfesor" id="idProfesor" size="25" placeholder="(Id del profesor)" required/>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2" class="botones">
                                    <p style="text-align: center;">
                                        <button type="submit">Crear</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        <!<!-- Verificar que el input de id no este vacio o que se haya seleccionado un grupo -->
                                        <button type="reset">Eliminar</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    </p>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </form>
            </div>
            <footer></footer>
        </div>
    </body>
</html>
