package modelo.beans.servicios;

import modelo.beans.ConjuntoEstudiantes;
import modelo.beans.Estudiante;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServicioEstudiante", urlPatterns = {"/ServicioEstudiante"})
public class ServicioEstudiante extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        System.out.println("Servlet ServicioEstudiante..");

        try {
            Estudiante e = new Estudiante(
                    Integer.parseInt(request.getParameter("id")),
                    request.getParameter("usuario_id"),
                    request.getParameter("apellido1"),
                    request.getParameter("apellido2"),
                    request.getParameter("nombre"),
                    request.getParameter("telefono"),
                    request.getParameter("email"));

            ConjuntoEstudiantes estudiantes
                    = (ConjuntoEstudiantes) getServletContext().getAttribute("estudiantes");
            estudiantes.add(e);
            System.out.println(estudiantes);

            response.sendRedirect("index.jsp");

        } catch (IOException | NumberFormatException | SQLException  ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
            response.sendRedirect("error.jsp");
        }
    }

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
        return "ServicioEstudiante";
    }
}