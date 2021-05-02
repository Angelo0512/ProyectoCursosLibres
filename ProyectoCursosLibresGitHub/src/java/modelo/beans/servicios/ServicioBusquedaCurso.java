package modelo.beans.servicios;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.beans.ConjuntoCursos;
import modelo.beans.Curso;

@WebServlet(name = "ServicioBusquedaCurso", urlPatterns = {"/ServicioBusquedaCurso"})
public class ServicioBusquedaCurso extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String nombre = request.getParameter("descripcion");
        String tematica = request.getParameter("tematica");
        
        ConjuntoCursos cursos = (ConjuntoCursos) getServletContext().getAttribute("cursos");
        String cursoId = null;
        cursoId = request.getParameter("grupos");
        Curso curso = null;
        if (cursoId != null){
            try {
                curso = cursos.retrieve(Integer.parseInt(cursoId));
            } catch (SQLException ex) {
                Logger.getLogger(ServicioBusquedaCurso.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        if (nombre != "" && nombre !=null) {
            servicio.obtenerCursoNombre(nombre)
                    .ifPresent(c -> request.setAttribute("busquedaCurso", c));
        } else if (tematica != "" && tematica != null) {
            request.setAttribute("busquedaCursoTematica",servicio.obtenerListaCursosTematica(tematica));
        }

        else if(curso != null){
            getServletContext().setAttribute("cursoVer", curso);
            request.getRequestDispatcher("ver_grupos_curso.jsp").
                            forward(request, response);
        }
            
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
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
