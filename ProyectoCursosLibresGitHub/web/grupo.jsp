<%@taglib prefix="ej" uri="/WEB-INF/tlds/ejemplo" %>
<html>
    <head>
        <title>Grupos</title>
        <meta charset="UTF-8">
        <link href="CSS/grupo.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <jsp:useBean id="grupo" class="modelo.beans.ConjuntoGrupos" scope="application">
            <jsp:setProperty name="gr" property="*"></jsp:setProperty> 
        </jsp:useBean>
        <jsp:useBean id="user" class="modelo.beans.Usuario" scope="session">
            <jsp:setProperty name="user" property="id_usuario" value="${user.id_usuario}"></jsp:setProperty>
        </jsp:useBean>        
        <%@ include file="header.jsp" %>
        <div id="wrapper">         
            <div id="contents">
                <table class="busqueda grupo">
                    <tbody>
                        <tr>
                            <td class="etiqueta">Id del grupo:&nbsp;</td>
                            <td>  
                                <input class="inputField" type="text" name="num_grupo" id="num_grupo" size="25" placeholder="(Id del grupo)" required/>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2" class="botones">
                                <p style="text-align: center;">
                                    <button type="submit">Buscar</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    <!<!-- Verificar que el input de id no este vacio o que se haya seleccionado un grupo -->
                                    <button type="reset">Eliminar</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                </p>
                            </td>
                        </tr>
                    </tbody>
                </table>
                <div class="d2columnas"> 
                    <%                            
                           if (user.getRol_id() == 3){
                        %>
                        ${grupo.tabla}
                            <%
                        } else{
                        %>
                        ${grupo.tablaSinMatricula}
                        <%
                        }
                        %>
                </div>
            </div>
            <footer></footer>
        </div>
    </body>
</html>
