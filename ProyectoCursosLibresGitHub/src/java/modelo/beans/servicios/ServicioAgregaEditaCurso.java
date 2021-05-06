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
import modelo.beans.ConjuntoCursos;
import modelo.beans.Curso;

@WebServlet(name = "ServicioAgregaEditaCurso", urlPatterns = {"/ServicioAgregaEditaCurso"})
public class ServicioAgregaEditaCurso extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String id = null;
        String descripcion = null;
        String tematica = null;

        
        //Se obtienen las variables
        id = request.getParameter("id_curso");
        descripcion = request.getParameter("descripcion");
        tematica = request.getParameter("tematica");

        ConjuntoCursos cursos = (ConjuntoCursos) getServletContext().getAttribute("cursos");

        Curso curso = null;

        //primero se intenta insertar el curso, si da error es porque ya existe
        try {
            cursos.add(new Curso(Integer.parseInt(id), descripcion, Integer.parseInt(tematica)));
        } catch (SQLException ex) {
            //el curso existe, debe ser actualizado
            curso = new Curso(Integer.parseInt(id), descripcion, Integer.parseInt(tematica));
            try {
                cursos.update(Integer.parseInt(id), curso);
                //Logger.getLogger(ServicioAgregaEditaCurso.class.getName()).log(Level.SEVERE, null, ex);   
            } catch (SQLException ex1) {
                Logger.getLogger(ServicioAgregaEditaCurso.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("CrearEditarCurso.jsp");
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
