package cursosLibres.modelo.dao;

//import cursosLibres.datos.BaseDatos;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import cursosLibres.modelo.Estudiante;

public class ServicioEstudiante {

    public Optional<Estudiante> obtenerEstudiante(String id) {
        Optional<Estudiante> r = Optional.empty();
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC_Estudiante.CONSULTAR.obtenerComando());) {
            stm.clearParameters();
            stm.setString(1, id);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    r = Optional.of(new Estudiante(
                            rs.getInt("id_estudiante"),
                            rs.getString("usuario_id"),
                            rs.getString("apellido1"),
                            rs.getString("apellido2"),
                            rs.getString("nombre"),
                            rs.getString("telefono"),
                            rs.getString("e_mail")
                    ));
                }
            }
        } catch (IOException
                | ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return r;
    }

    public List<Estudiante> obtenerListaEstudiantes() {
        List<Estudiante> r = new ArrayList<>();
        try (Connection cnx = obtenerConexion();
                Statement stm = cnx.createStatement();
                ResultSet rs = stm.executeQuery(IMEC_Estudiante.LISTAR.obtenerComando())) {
            while (rs.next()) {
                Estudiante e = new Estudiante(
                        rs.getInt("id_estudiante"),
                        rs.getString("usuario_id"),
                        rs.getString("apellido1"),
                        rs.getString("apellido2"),
                        rs.getString("nombre"),
                        rs.getString("telefono"),
                        rs.getString("e_mail")
                );
                r.add(e);
            }
        } catch (IOException
                | ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return r;
    }

    public Connection obtenerConexion() throws
            ClassNotFoundException,
            IllegalAccessException,
            InstantiationException,
            IOException,
            SQLException {
        //BaseDatos bd = BaseDatos.obtenerInstancia();
        //Connection cnx = bd.obtenerConexion();
        return null;
    }

    public static void main(String[] args) {
        ServicioEstudiante se = new ServicioEstudiante();
        List<Estudiante> estudiantes = se.obtenerListaEstudiantes();
        int i = 0;
        for (Estudiante e : estudiantes) {
            System.out.printf("%4d: %s,%n", ++i, e);
        }
    }
}