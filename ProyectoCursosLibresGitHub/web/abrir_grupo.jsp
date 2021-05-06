<html>
    <head>
        <title>Abrir grupo</title>
        <meta charset="UTF-8">
        <link href="CSS/abrir_grupo.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <jsp:useBean id="grupos" class="modelo.beans.ConjuntoGrupos" scope="application">
        </jsp:useBean>
        <div id="wrapper">
            <%@ include file="header.jsp" %>        
            <div id="contents">
                <form method="GET" action="ServicioGrupo">
                    <table class="abrir grupo">
                        <tbody>
                            <tr>
                                <td class="etiqueta">Id del grupo:&nbsp;</td>
                                <td>  
                                    <input class="inputField" type="text" name="num_grupo" id="num_grupo" size="25" placeholder="(Id del grupo)" required/>
                                </td>
                            </tr>
                            <tr>
                                <td class="etiqueta">Id del curso:&nbsp;</td>
                                <td>  
                                    <!-- Se tiene que validar que el curso exista o desplegar una lista -->
                                    <input class="inputField" type="text" name="curso_id" id="curso_id" size="25" placeholder="(Id del curso)" required/>
                                </td>
                            </tr>
                            <tr>
                                <td class="etiqueta">Id del profesor:&nbsp;</td>
                                <td>  
                                    <!-- Se tiene que validar que el profesor exista o desplegar una lista -->
                                    <input class="inputField" type="text" name="profesor_id" id="profesor_id" size="25" placeholder="(Id del profesor)" required/>
                                </td>
                            </tr>
                            <tr> 
                                <td>
                                    <button formaction="horario.jsp" type="submit">Crear y ver horario</button>&nbsp;
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
