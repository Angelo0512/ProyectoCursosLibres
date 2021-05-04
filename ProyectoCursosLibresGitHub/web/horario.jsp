<%@page import="modelo.beans.Curso"%>

<html>
    <head>
        <title>Horarios</title>
        <meta charset="UTF-8">
        <link href="CSS/horario.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <jsp:useBean id="horarios" class="modelo.beans.ConjuntoHorarios" scope="application">
        </jsp:useBean>
        <%@ include file="header.jsp" %>
        <div id="wrapper">       
            <div id="contents">
                <form method="POST" action="ServicioHorario">
                    <table class="busqueda">
                        <tbody>
                            <tr>
                                <td class="etiqueta">Id del horario:&nbsp;</td>
                                <td>  
                                    <input class="inputField" type="text" name="seq" id="seq" size="25" placeholder="(id del horario)" required/>
                                </td>
                            </tr>
                            <tr>
                                <td class="etiqueta">Id del grupo:&nbsp;</td>
                                <td>  
                                    <input class="inputField" type="text" name="grupo_num" id="grupo_num" size="25" placeholder="(id del grupo)" required/>
                                </td>
                            </tr>
                            <tr>
                                <td class="etiqueta">Id del curso:&nbsp;</td>
                                <td> 
                                    <input class="inputField" type="text" name="grupo_curso_id" id="grupo_curso_id" size="25" placeholder="(id del curso)" required/>
                                </td>
                        
                            </tr>
                            <tr>
                                <td class="etiqueta">Dia:&nbsp;</td>
                                <td> 
                                   <select id="dia" name="dia" size="1">
                                        <option value="1">Domingo</option>
                                        <option value="2">Lunes</option>
                                        <option value="3">Martes</option>
                                        <option value="4">Miercoles</option>
                                        <option value="5">Jueves</option>
                                        <option value="6">Viernes</option>
                                        <option value="7">Sabado</option>
                                    </select>
                                </td>                        
                            </tr>
                            <tr>
                                <td class="etiqueta">Hora:&nbsp;</td>
                                <td> 
                                    <select id="hora" name="hora" size="1">
                                        <option value="1">1</option>
                                        <option value="2">2</option>
                                        <option value="3">3</option>
                                        <option value="4">4</option>
                                        <option value="5">5</option>
                                        <option value="6">6</option>
                                        <option value="7">7</option>
                                        <option value="8">8</option>
                                        <option value="9">9</option>
                                        <option value="10">10</option>
                                        <option value="11">11</option>
                                        <option value="12">12</option>
                                    </select>
                                </td>                        
                            </tr>
                            <tr>
                                <td class="etiqueta">am/pm:&nbsp;</td>
                                <td> 
                                    <select id="am_pm" name="am_pm" size="1">
                                        <option value="1">a.m.</option>
                                        <option value="2">p.m.</option>
                                    </select>
                                </td>                        
                            </tr>
                            <tr>
                                <td colspan="2" class="botones">
                                    <p style="text-align: center;">
                                        <button type="submit">Crear</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    </p>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                    <div class="d2columnas">
                        ${horarios.tabla}
                    </div>
                </form>
            </div>
            <footer></footer>
        </div>
    </body>
</html>