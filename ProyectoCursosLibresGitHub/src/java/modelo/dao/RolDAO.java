package modelo.dao;

import cursolibres.db.dao.AbstractDAO;
import cursolibres.db.dao.crud.AbstractCRUD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.beans.Rol;
import modelo.dao.crud.RolCRUD;


public class RolDAO extends AbstractDAO<Integer, Rol> {

    public RolDAO() throws Exception {
        super(new RolCRUD());
    }
    
    public RolDAO(AbstractCRUD crud) {
        super(crud);
    }  

    @Override
    public Rol getRecord(ResultSet rs)
            throws SQLException {
        return new Rol(
                rs.getInt("id_rol"),
                rs.getString("descripcion"));
    }

    @Override
    public void setAddParameters(PreparedStatement stm,
            Integer id, Rol c)
            throws SQLException {
        stm.setInt(1, id);
        stm.setString(2, c.getDescripcion());
        
    }

    @Override
    public void setUpdateParameters(PreparedStatement stm,
            Integer id, Rol c)
            throws SQLException {
        stm.setString(1, c.getDescripcion());
        stm.setInt(3, id);
    }
}