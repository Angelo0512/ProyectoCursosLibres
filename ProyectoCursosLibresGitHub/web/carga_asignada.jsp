<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="ej" uri="/WEB-INF/tlds/ejemplo" %>

<html>
    <head>
        <title>Carga asignada</title>
        <meta charset="UTF-8">
        <link href="CSS/grupo.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <jsp:useBean id="cargas" class="modelo.beans.ConjuntoGrupos" scope="application">
        </jsp:useBean>
        <jsp:useBean id="user" class="modelo.beans.Usuario" scope="session">
            <jsp:setProperty name="user" property="id_usuario" value="${user.id_usuario}"></jsp:setProperty>
        </jsp:useBean>
        <%@ include file="header.jsp" %>     
        <div id="wrapper">
            <div id="contents">                
                <div class="d2columnas">
                    ${ej:getTablaCarga(cargas, user.id_usuario)}
                    
                </div>
            </div>
            <footer></footer>
        </div>
    </body>
</html>
