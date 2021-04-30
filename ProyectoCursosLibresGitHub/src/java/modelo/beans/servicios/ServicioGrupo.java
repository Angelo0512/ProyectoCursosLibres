package modelo.beans.servicios;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.beans.ConjuntoGrupos;
import modelo.beans.Grupo;

@WebServlet(name = "ServicioGrupo", urlPatterns = {"/ServicioGrupo"})
public class ServicioGrupo extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        System.out.println("Servlet ServicioGrupo...");

        try {
            Grupo grupo = new Grupo(
                    Integer.parseInt(request.getParameter("num_grupo")),
                    Integer.parseInt(request.getParameter("curso_id")),
                    Integer.parseInt(request.getParameter("profesor_id")));

            ConjuntoGrupos grupos
                    = (ConjuntoGrupos) getServletContext().getAttribute("grupos");
            grupos.add(grupo);
            System.out.println(grupos);

            response.sendRedirect("grupo.jsp");

        } catch (IOException | NumberFormatException | SQLException  ex) {
            System.err.printf("Excepción: '%s'%n", ex.getCause());
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
        return "ServicioAreaTematica";
    }
}