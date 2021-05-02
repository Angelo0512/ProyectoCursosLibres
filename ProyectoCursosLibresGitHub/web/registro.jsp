<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Registro de estudiantes</title>
        <link href="CSS/registro.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <jsp:useBean id="estudiantes" class="modelo.beans.ConjuntoEstudiantes" scope="application">
        </jsp:useBean>
        <jsp:useBean id="usuarios" class="modelo.beans.ConjuntoUsuarios" scope="application">
        </jsp:useBean>

        <%@ include file="header.jsp" %>

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
                                    <input class="inputField" type="number" name="id"
                                           placeholder="(digite la identificación)" min=100000000 max=999999999 required/>
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
                                           placeholder="(nombre)" required/>
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
                                           placeholder="(primer apellido)" required/>
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
                                           placeholder="(segundo apellido)" required/>
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
                                           placeholder="(telefono)" required/>
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
                                           placeholder="(correo electronico)" required/>
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