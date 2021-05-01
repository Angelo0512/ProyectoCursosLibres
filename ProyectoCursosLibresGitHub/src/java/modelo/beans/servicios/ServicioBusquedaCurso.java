package modelo.beans.servicios;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.beans.ConjuntoCursos;

@WebServlet(name = "ServicioBusquedaCurso", urlPatterns = {"/ServicioBusquedaCurso"})
public class ServicioBusquedaCurso extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String nombre = request.getParameter("descripcion");
        String tematica = request.getParameter("tematica");
        if (nombre != "") {
            servicio.obtenerCursoNombre(nombre)
                    .ifPresent(c -> request.setAttribute("busquedaCurso", c));
        } else if (tematica != "") {
            request.setAttribute("busquedaCursoTematica",servicio.obtenerListaCursosTematica(tematica));
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
