package modelo.beans.servicios;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
        
        List<Curso> listAux = new ArrayList<>();
        Curso cursoAux = null;
        out.print("hola");
            
        if (!"".equals(nombre) && nombre !=null) {
            //System.out.print("hola");
            
            
            for(int i=0;i<cursos.getListaCursos().size();i++){
                if(nombre==cursos.getListaCursos().get(i).getDescripcion())
                    cursoAux = cursos.getListaCursos().get(i);
            }
            
            //servicio.obtenerCursoNombre(nombre)
                    //.ifPresent(c -> request.setAttribute("busquedaCurso", c));
        } else if (tematica != "" && tematica != null) {
            listAux = servicio.obtenerListaCursosTematica(tematica);
            request.setAttribute("busquedaCursoTematica",servicio.obtenerListaCursosTematica(tematica));
        }

        else if(curso != null){
            getServletContext().setAttribute("cursoVer", curso);
            request.getRequestDispatcher("ver_grupos_curso.jsp").
                            forward(request, response);
        }
            
        request.setAttribute("busquedaCurso", cursoAux);
        request.setAttribute("busquedaCursoTematica",listAux);
        
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
