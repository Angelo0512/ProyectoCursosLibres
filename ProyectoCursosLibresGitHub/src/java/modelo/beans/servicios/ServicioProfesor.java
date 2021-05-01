package modelo.beans.servicios;

import cursolibres.db.Database;
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
import modelo.beans.Profesor;

@WebServlet(name = "ServicioProfesor", urlPatterns = {"/ServicioProfesor"})
public class ServicioProfesor extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        System.out.println("Servlet ServicioProfesor..");
    }

    public Profesor obtenerProfesor(String id_usuario) {
        Profesor profe = new Profesor();
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(ProfesorCRUD.RETRIEVE_CMD);) {
            stm.clearParameters();
            stm.setString(1, id_usuario);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    profe.setId_profesor(rs.getInt("id_profesor"));
                    profe.setUsuario_id(rs.getString("usuario_id"));
                    profe.setApellido1(rs.getString("apellido1"));
                    profe.setApellido2(rs.getString("apellido2"));
                    profe.setNombre(rs.getString("nombre"));
                    profe.setTelefono(rs.getString("telefono"));
                    profe.setE_mail(rs.getString("e_mail"));
                }
            }
        } catch (IOException
                | ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return profe;
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
        return "ServicioProfesor";
    }
}