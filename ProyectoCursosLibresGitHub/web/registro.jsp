<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Registro de estudiantes</title>
        <link href="CSS/registro.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <jsp:useBean id="estudiantes" class="cursosLibres.modelo.ConjuntoEstudiantes" scope="application">
        </jsp:useBean>
        <div id="wrapper">
            <div id="contents">
                <h1>Registro de estudiantes</h1>
                <form method="GET" action="ServicioEstudiante">
                    <table>
                        <tbody>
                            <tr>
                                <td>
                                    <p>
                                        <label>Identificación:&nbsp;</label>
                                    </p>
                                </td>
                                <td>
                                    <input class="inputField" type="text" name="id"
                                           placeholder="(digite la identificación)"/>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <p>
                                        <label>Identificación:&nbsp;</label>
                                    </p>
                                </td>
                                <td>
                                    <input class="inputField" type="text" name="usuario_id"
                                           placeholder="(digite la identificación)"/>
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
                                           placeholder="(nombre)"/>
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
                                           placeholder="(primer apellido)"/>
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
                                           placeholder="(segundo apellido)"/>
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
                                           placeholder="(telefono)"/>
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
                                           placeholder="(correo electronico)"/>
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
                <nav>
                    <p>
                        Ya tienes una cuenta? <a href="login.jsp">Iniciar Sesión</a>
                    </p>
                </nav>
            </footer>
        </div>
    </body>
</html>