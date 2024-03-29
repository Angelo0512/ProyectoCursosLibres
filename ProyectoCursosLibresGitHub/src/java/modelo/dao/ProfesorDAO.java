package modelo.dao;

import cursolibres.db.dao.AbstractDAO;
import cursolibres.db.dao.crud.AbstractCRUD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.beans.Profesor;
import modelo.beans.servicios.ProfesorCRUD;


public class ProfesorDAO extends AbstractDAO<Integer, Profesor> {

    public ProfesorDAO() throws Exception {
        super(new ProfesorCRUD());
    }
    
    public ProfesorDAO(AbstractCRUD crud) {
        super(crud);
    }  

    @Override
    public Profesor getRecord(ResultSet rs)
            throws SQLException {
        return new Profesor(
                rs.getInt("id_profesor"),
                rs.getString("usuario_id"),
                rs.getString("apellido1"),
                rs.getString("apellido2"),
                rs.getString("nombre"),
                rs.getString("telefono"),
                rs.getString("e_mail"));
    }

    @Override
    public void setAddParameters(PreparedStatement stm,
            Integer id, Profesor e)
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
            Integer id, Profesor e)
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