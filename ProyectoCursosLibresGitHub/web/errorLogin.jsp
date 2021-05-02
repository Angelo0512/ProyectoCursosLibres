<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login Incorrecto</title>    
        <link href="CSS/login.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <jsp:useBean id="error" scope="request" type="java.lang.String" class="java.lang.String" />
        <%@ include file="header.jsp" %>
        <div id="wrapper">   
            <div id ="contents">   
                <div style="color:red; font-size: 16px;"> <%=error%></div>
                <div style="color:red; font-size: 16px;"> Intente <a href="login.jsp"> ingresar</a> de nuevo</div>
            </div>
        </div>
    </body>
</html>