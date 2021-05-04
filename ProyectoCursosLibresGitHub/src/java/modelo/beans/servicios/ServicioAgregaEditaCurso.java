package modelo.beans.servicios;

import java.io.IOException;
import java.sql.SQLException;
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

        id = request.getParameter("id_curso");
        descripcion = request.getParameter("descripcion");
        tematica = request.getParameter("tematica");

        ConjuntoCursos cursos1 = (ConjuntoCursos) getServletContext().getAttribute("cursos");

        Curso curso = null;
        try {
            curso = cursos1.retrieve(Integer.parseInt(id));
        } catch (SQLException ex) {
            //Logger.getLogger(ServicioAgregaEditaCurso.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (curso == null) {// el curso no existe
            try {
                cursos1.add(new Curso(Integer.parseInt(id), descripcion, Integer.parseInt(tematica)));
            } catch (SQLException ex) {
                //Logger.getLogger(ServicioAgregaEditaCurso.class.getName()).log(Level.SEVERE, null, ex);   
            }
        } else {
            // el curso existe, debe ser actualizado
            ConjuntoCursos cursos2 = (ConjuntoCursos) getServletContext().getAttribute("cursos");
            try {
                curso.setDescripcion(descripcion);
                curso.setArea_tematica_id(Integer.parseInt(tematica));
                cursos2.update(Integer.parseInt(id), curso);
            } catch (SQLException ex) {
                System.out.println("error de:");
                System.out.println(ex.getMessage());
                //Logger.getLogger(ServicioAgregaEditaCurso.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("crearEditarCurso.jsp");
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
