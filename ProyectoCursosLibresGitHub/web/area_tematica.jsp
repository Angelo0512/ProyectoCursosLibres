<html>
    <head>
        <title>Abrir area tematica</title>
        <meta charset="UTF-8">
        <link href="CSS/area_tematica.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <jsp:useBean id="areasTematicas" class="modelo.beans.ConjuntoAreasTematicas" scope="application">
            <jsp:setProperty name="at" property="*"></jsp:setProperty> 
        </jsp:useBean>
        <div id="wrapper">   
            <%@ include file="header.jsp" %>          
            <div id="contents">
                <form method="GET" action="ServicioAreaTematica">
                    <table class="abrir area tematica">
                        <tbody>
                            <tr>
                                <td class="etiqueta">Id del area tematica&nbsp;</td>
                                <td>  
                                    <input class="inputField" type="text" name="idArea" id="idArea" size="25" placeholder="(Id del area)" required/>
                                </td>
                            </tr>
                            <tr>
                                <td class="etiqueta">Descripcion:&nbsp;</td>
                                <td>  
                                    <input class="inputField" type="text" name="descripcion" id="descripcion" size="25" placeholder="(Descripcion)" required/>
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
                    <div class="d2columnas">
                        ${areasTematicas.tabla}
                    </div>
                </form>
            </div>
            <footer></footer>
        </div>
    </body>
</html>
