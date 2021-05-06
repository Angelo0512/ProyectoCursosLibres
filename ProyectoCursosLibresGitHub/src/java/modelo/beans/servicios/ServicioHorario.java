package modelo.beans.servicios;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.beans.ConjuntoHorarios;
import modelo.beans.Horario;

@WebServlet(name = "ServicioHorario", urlPatterns = {"/ServicioHorario"})
public class ServicioHorario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        int id = 0;
        int idGrupo = 0;
        int idCurso = 0;
        int dia = 0;
        int hora = 0;
        int am_pm = 0;

        //se obtienen todas las variables para los horarios
        id = Integer.parseInt(request.getParameter("seq"));
        idGrupo = Integer.parseInt(request.getParameter("grupo_num"));
        idCurso = Integer.parseInt(request.getParameter("grupo_curso_id"));
        dia = Integer.parseInt(request.getParameter("dia"));
        hora = Integer.parseInt(request.getParameter("hora"));
        am_pm = Integer.parseInt(request.getParameter("am_pm"));
        
        
        if (am_pm == 2){
            hora += 12;
        }

        ConjuntoHorarios horarios = (ConjuntoHorarios) getServletContext().getAttribute("horarios");        
        try {       
            horarios.add(new Horario(id, idGrupo, idCurso, dia, hora));
        } catch (SQLException ex) {
            Logger.getLogger(ServicioHorario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        getServletContext().setAttribute("horarios", horarios);
        RequestDispatcher dispatcher = request.getRequestDispatcher("horario.jsp");
        dispatcher.forward(request, response);
    }

    private final ServicioCurso servicio = new ServicioCurso();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
