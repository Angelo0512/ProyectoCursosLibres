package modelo.beans.servicios;

import cursolibres.db.Database;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import javax.servlet.http.HttpServlet;
import modelo.beans.Usuario;

public class ServicioUsuario extends HttpServlet {

    public Usuario obtenerUsuario(String id_usuario) throws
            ClassNotFoundException,
            IllegalAccessException,
            InstantiationException,
            IOException,
            SQLException{
        Usuario user = new Usuario();
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(UsuarioCRUD.RETRIEVE_CMD);) {
            stm.clearParameters();
            stm.setString(1, id_usuario);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    user.setId_usuario(rs.getString("id_usuario"));
                    user.setRol_id(rs.getInt("rol_id"));
                    user.setClave(rs.getString("clave"));
                    user.setUltimo_acceso(rs.getTimestamp("ultimo_aceso"));
                    user.setActivo(rs.getBoolean("activo"));
                }
            }
        } catch (IOException
                | ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return user;
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
}
