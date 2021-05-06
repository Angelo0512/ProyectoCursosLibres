<%@page import="modelo.beans.Grupo"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="ej" uri="/WEB-INF/tlds/ejemplo" %>

<!DOCTYPE html>

<html>
    <head>
        <title>Grupos del curso</title>
        <meta charset="UTF-8">
        <link href="CSS/grupo.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <jsp:useBean id="cursoVer" class="modelo.beans.Curso" scope="application">            
        </jsp:useBean>
        <jsp:useBean id="cargas" class="modelo.beans.ConjuntoGrupos" scope="application">
        </jsp:useBean>
        <div id="wrapper">

            <%@ include file="header.jsp" %>
            
            <div id="contents">
                <form method="GET" action="ServicioGrupo">
                    <table class="busqueda grupo">
                        <tbody>
                            <tr>
                                <td class="etiqueta">Id del grupo:&nbsp;</td>
                                <td>  
                                    <input class="inputField" type="text" name="idGrupo" id="idGrupo" size="25" placeholder="(Id del grupo)" required/>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2" class="botones">
                                    <p style="text-align: center;">
                                        <button type="submit">Buscar</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        <% if (profesor != null) {%>
                                        <button type="submit">Modificar nota</button>&nbsp;
                                        <a href="registro_notas.jsp">modificar</a>
                                        <%}%>
                                    </p>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </form>
                    <div class="d2columnas">
                        <table class="tablaGrupos">
                            <caption>GRUPOS</caption>
                            <thead>
                                <tr>
                                    <th>Numero Grupo</th>
                                    <th>Id Curso</th>
                                    <th>Id Profesor</th>
                                    
                                    <% if (profesor != null) {%>
                                    <th></th>
                                    <%}%>
                                </tr>
                            </thead>
                            <tbody>
                                <%List<Grupo> t = cargas.getListaGrupos();
                                for(Grupo c : t){
                                    if(c.getCurso_id()==cursoVer.getId_curso()){
                                
                                %>
                                <tr>
                                    <td><%=c.getNum_grupo()%></td>
                                    <td><%=c.getCurso_id()%></td>
                                    <td><%=c.getProfesor_id()%></td>
                                    <% if (profesor != null) {%>
                                    <td>
                                        <form method="GET" action="ServicioRegistro">
                                            <button name="grupoModificar" value="<%=c.getNum_grupo()%>">Modificar</button>
                                        </form> 
                                    </td>
                                    <%}
                                        }
                                        }%>
       
                            </tbody>
                        </table>                    
        
                    </div>
            </div>
            <footer></footer>
        </div>
    </body>
</html>
