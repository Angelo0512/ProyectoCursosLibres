package modelo.beans.servicios;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.beans.ConjuntoGrupos;
import modelo.beans.ConjuntoMatricula;
import modelo.beans.Grupo;
import modelo.beans.Matricula;

@WebServlet(name = "ServicioRegistro", urlPatterns = {"/ServicioRegistro"})
public class ServicioRegistro extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        System.out.println("Servlet ServicioRegistro...");

        String id_estudiante = null;
        String nota_estudiante = null;
        String grupo_num = null;
        id_estudiante = request.getParameter("estudiante_id");
        nota_estudiante = request.getParameter("nota");
        grupo_num = request.getParameter("grupo_num");

        if (id_estudiante != null && nota_estudiante != null) {
            try {
                int id = Integer.parseInt(id_estudiante);
                int grupo = Integer.parseInt(grupo_num);
                int nota = Integer.parseInt(nota_estudiante);
                ConjuntoMatricula matriculas = new ConjuntoMatricula();
                Matricula matricula = matriculas.getWithGroup(id, grupo);
                matricula.setNota(nota);
                matriculas.update(id, matricula);
                response.sendRedirect("registro_notas.jsp");
            } catch (SQLException ex) {
                Logger.getLogger(ServicioRegistro.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                ConjuntoGrupos grupos = (ConjuntoGrupos) getServletContext().getAttribute("grupo");
                Grupo grupo = grupos.retrieve(Integer.parseInt(request.getParameter("grupoModificar")));
                getServletContext().setAttribute("grupoRegistro", grupo);
                response.sendRedirect("registro_notas.jsp");

            } catch (IOException | NumberFormatException | SQLException ex) {
                System.err.printf("Excepción: '%s'%n", ex.getCause());
                response.sendRedirect("error.jsp");
            }
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
        return "Short description";
    }

}
