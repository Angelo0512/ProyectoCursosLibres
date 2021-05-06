package modelo.beans.servicios;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.beans.Area_tematica;
import modelo.beans.ConjuntoAreasTematicas;

@WebServlet(name = "ServicioAreaTematica", urlPatterns = {"/ServicioAreaTematica"})
public class ServicioAreaTematica extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        System.out.println("Servlet ServicioAreaTematica...");
        //Se crea el area tematica y se obtienen las variables
        try {
            Area_tematica area = new Area_tematica(
                    Integer.parseInt(request.getParameter("idArea")),
                    request.getParameter("descripcion"));

            ConjuntoAreasTematicas areasTematicas
                    = (ConjuntoAreasTematicas) getServletContext().getAttribute("areasTematicas");
            areasTematicas.add(area);
            System.out.println(areasTematicas);

            response.sendRedirect("area_tematica.jsp");

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