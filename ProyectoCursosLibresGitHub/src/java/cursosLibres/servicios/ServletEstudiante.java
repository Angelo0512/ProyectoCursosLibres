package cursosLibres.servicios;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cursosLibres.modelo.dao.ServicioEstudiante;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(name = "ServletEstudiante", urlPatterns = {"/ServletEstudiante"})
public class ServletEstudiante extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id_estudiante = request.getParameter("id_estudiante");
        if (id_estudiante != null) {
            // request.setAttribute("registroEstudiante", null);
            servicio.obtenerEstudiante(checkId(id_estudiante))
                    .ifPresent(e -> request.setAttribute("registroEstudiante", e));
        }
        // response.sendRedirect("...");
        RequestDispatcher dispatcher = request.getRequestDispatcher(
                "/WEB-INF/ejemplo/vista/registro-estudiante.jsp");
        dispatcher.forward(request, response);
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

    private String checkId(String txt) {
        String r = txt;

        Pattern pat = Pattern.compile("([1-9,A])-?([0-9]{4})-?([0-9]{4})");
        Matcher m = pat.matcher(txt);
        if (m.find()) {
            r = String.format("%s%s%s", m.group(1), m.group(2), m.group(3));
        }

        return r;
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
    
    private final ServicioEstudiante servicio = new ServicioEstudiante();
}
