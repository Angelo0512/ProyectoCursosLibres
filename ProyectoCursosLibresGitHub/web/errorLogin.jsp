<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login Incorrecto</title>
        <link href="css/default.css" rel="stylesheet" type="text/css"/>  
    </head>
    <body>
        
        <%@ include file="header.jsp" %>
        
        <div id="body" style="margin: 0 auto; width:85%; ">    
            <jsp:useBean id="error" scope="request" type="java.lang.String" class="java.lang.String" />
            <div class="area" style="width:70%">   
                <div style="color:red; font-size: 16px;"> <%=error%></div>
                <div style="color:red; font-size: 16px;"> Intente <a href="login.jsp"> ingresar</a> de nuevo</div>
            </div>
        </div>
    </body>
</html>