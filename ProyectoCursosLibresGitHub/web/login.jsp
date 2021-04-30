<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Iniciar Sesión</title>
        <link href="CSS/login.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div id="wrapper">
            <div id="contents">
                <form action="Login" method="POST">
                    <input class="inputField" type="text" placeholder="Identificacion" name="id_usuario" required>
                    <div class="pass">
                        <input id="pass1" class="passField" type="password" name="clave" placeholder="Contraseña" required>
                    </div>      
                    <button id="botonlogin" type="submit">Iniciar sesión</button>
                </form>
            </div>
            <footer>
                <nav>
                    <p>
                        No tienes una cuenta? <a href="registro.jsp">Regístrate</a>
                    </p>
                </nav>
                <nav>
                    <p style="text-align: center;">
                        Regresar a la <a href="index.jsp">Pagina principal</a>
                    </p>
                </nav>
            </footer>
        </div>
    </body>
</html>