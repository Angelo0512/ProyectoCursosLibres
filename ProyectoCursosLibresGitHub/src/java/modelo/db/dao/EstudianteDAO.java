package modelo.db.dao;

import modelo.db.AbstractDAO;
import modelo.db.AbstractCRUD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import cursosLibres.modelo.Estudiante;
import modelo.db.dao.EstudianteCRUD;
import modelo.db.Database;

public class EstudianteDAO extends AbstractDAO<Integer, Estudiante> {

    public EstudianteDAO() throws Exception {
        super(new EstudianteCRUD());
    }

    @Override
    public Estudiante getRecord(ResultSet rs)
            throws SQLException {
        return new Estudiante(
                rs.getInt("id_estudiante"),
                rs.getString("usuario_id"),
                rs.getString("apellido1"),
                rs.getString("apellido2"),
                rs.getString("nombre"),
                rs.getString("telefono"),
                rs.getString("e_mail"));
    }

    @Override
    public void setAddParameters(PreparedStatement stm,
            Integer id, Estudiante e)
            throws SQLException {
        stm.setInt(1, id);
        stm.setString(2, e.getUsuario_id());
        stm.setString(3, e.getApellido1());
        stm.setString(4, e.getApellido2());
        stm.setString(5, e.getNombre());
        stm.setString(6, e.getTelefono());
        stm.setString(7, e.getE_mail());
    }

    @Override
    public void setUpdateParameters(PreparedStatement stm,
            Integer id, Estudiante e)
            throws SQLException {
        stm.setString(1, e.getUsuario_id());
        stm.setString(2, e.getApellido1());
        stm.setString(3, e.getApellido2());
        stm.setString(4, e.getNombre());
        stm.setString(5, e.getTelefono());
        stm.setString(6, e.getE_mail());
        stm.setInt(7, id);
    }
}