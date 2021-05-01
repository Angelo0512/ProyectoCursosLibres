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
import modelo.beans.Administrador;

@WebServlet(name = "ServicioAdministrador", urlPatterns = {"/ServicioAdministrador"})
public class ServicioAdministrador extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        System.out.println("Servlet ServicioAdministrador..");
    }

    public Administrador obtenerAdministrador(String id_usuario) {
        Administrador admin = new Administrador();
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(AdministradorCRUD.RETRIEVE_CMD);) {
            stm.clearParameters();
            stm.setString(1, id_usuario);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    admin.setId_administrador(rs.getInt("id_administrador"));
                    admin.setUsuario_id(rs.getString("usuario_id"));
                    admin.setApellido1(rs.getString("apellido1"));
                    admin.setApellido2(rs.getString("apellido2"));
                    admin.setNombre(rs.getString("nombre"));
                    admin.setTelefono(rs.getString("telefono"));
                    admin.setE_mail(rs.getString("e_mail"));
                }
            }
        } catch (IOException
                | ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return admin;
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
        return "ServicioAdministrador";
    }
}