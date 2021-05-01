package modelo.beans.servicios;

import cursolibres.db.Database;
import modelo.beans.ConjuntoEstudiantes;
import modelo.beans.Estudiante;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    
    public Estudiante obtenerEstudiante(String id_usuario) {
        Estudiante est = new Estudiante();
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(EstudianteCRUD.RETRIEVE_CMD);) {
            stm.clearParameters();
            stm.setString(1, id_usuario);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    est.setId_estudiante(rs.getInt("id_estudiante"));
                    est.setUsuario_id(rs.getString("usuario_id"));
                    est.setApellido1(rs.getString("apellido1"));
                    est.setApellido2(rs.getString("apellido2"));
                    est.setNombre(rs.getString("nombre"));
                    est.setTelefono(rs.getString("telefono"));
                    est.setE_mail(rs.getString("e_mail"));
                }
            }
        } catch (IOException
                | ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return est;
    }
    
    public Connection obtenerConexion() throws
            ClassNotFoundException,
            IllegalAccessException,
            InstantiationException,
            IOException,
            SQLException {
        Database db = Database.getInstance();
        Connection cnx = db.getConnection();
        return cnx;
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