package modelo.beans.servicios;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.beans.ConjuntoGrupos;
import modelo.beans.ConjuntoMatricula;
import modelo.beans.Grupo;
import modelo.beans.Matricula;
import modelo.beans.Usuario;

@WebServlet(name = "ServicioMatricula", urlPatterns = {"/ServicioMatricula"})
public class ServicioMatricula extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        System.out.println("Servlet ServicioMatricula...");

        try {
            ConjuntoGrupos grupos = (ConjuntoGrupos) getServletContext().getAttribute("grupo");            
            Grupo grupo = grupos.retrieve(Integer.parseInt(request.getParameter("grupo")));
            
            Usuario user2 = (Usuario) request.getSession(true).getAttribute("user");
            
            Matricula matricula = new Matricula(
                    Integer.parseInt(user2.getId_usuario()),
                   grupo.getNum_grupo(),
                    grupo.getCurso_id(),
                    1,
                    0);

            ConjuntoMatricula matriculas
                    = new ConjuntoMatricula();
            matriculas.add(matricula);

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