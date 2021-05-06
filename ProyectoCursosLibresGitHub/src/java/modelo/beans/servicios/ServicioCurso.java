package modelo.beans.servicios;

import cursolibres.db.Database;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import modelo.beans.Curso;

public class ServicioCurso {

    //Metodo que se encarga de realizar una busqueda en la base de datos para obtener el curso cuando la busqueda se hace por medio del nombre
    //primero intenta contectar con la base de datos y si es exitosa este corre el query para obtener el dato correspondiente al curso
    public Optional<Curso> obtenerCursoNombre(String nombre) {
        Optional<Curso> r = Optional.empty();
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(CursoCRUD.RETRIEVE_CMD);) {
            stm.clearParameters();
            stm.setString(1, nombre);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    r = Optional.of(new Curso(
                            rs.getInt("id_curso"),
                            rs.getString("descripcion"),
                            rs.getInt("area_tematica_id")
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

    //Metodo que se encarga de realizar una busqueda en la base de datos para obtener el curso cuando la busqueda se hace por medio de la tematica
    //primero intenta contectar con la base de datos y si es exitosa este corre el query para obtener el dato correspondiente al curso
    public List<Curso> obtenerListaCursosTematica(String tematica) {
        List<Curso> r = new ArrayList<>();
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(CursoCRUD.RETRIEVE_CMD_TEM);) {
            stm.clearParameters();
            stm.setString(1, tematica);
            try (ResultSet rs = stm.executeQuery()) {
                while (rs.next()) {
                    Curso c = new Curso(
                            rs.getInt("id_curso"),
                            rs.getString("descripcion"),
                            rs.getInt("area_tematica_id")
                    );
                    r.add(c);
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

    //Metodo que se al conectarse con la base de datos retorna la lista completa de los cursos existentes
    public List<Curso> obtenerListaCursos() {
        List<Curso> r = new ArrayList<>();
        try (Connection cnx = obtenerConexion();
                Statement stm = cnx.createStatement();
                ResultSet rs = stm.executeQuery(CursoCRUD.LIST_CMD)) {
            while (rs.next()) {
                Curso c = new Curso(
                        rs.getInt("id_curso"),
                        rs.getString("descripcion"),
                        rs.getInt("area_tematica_id")
                );
                r.add(c);
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
        Database db = Database.getInstance();
        Connection cnx = db.getConnection();
        return cnx;
    }
}
