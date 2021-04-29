package modelo.dao;

import cursolibres.db.dao.AbstractDAO;
import cursolibres.db.dao.crud.AbstractCRUD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.beans.Usuario;
import modelo.dao.crud.UsuarioCRUD;
import java.sql.Timestamp;



public class UsuarioDAO extends AbstractDAO<Integer, Usuario> {

    public UsuarioDAO() throws Exception {
        super(new UsuarioCRUD());
    }
    
    public UsuarioDAO(AbstractCRUD crud) {
        super(crud);
    }  

    @Override
    public Usuario getRecord(ResultSet rs)
            throws SQLException {
        return new Usuario(
                rs.getString("id_usuario"),
                rs.getInt("rol_id"),
                rs.getString("clave"),
                rs.getTimestamp("utlimo_aceso"),
                rs.getBoolean("activo"));
    }

    @Override
    public void setAddParameters(PreparedStatement stm,
            Integer id, Usuario c)
            throws SQLException {
        String idString = String.valueOf(id);
        stm.setString(1, idString);
        stm.setInt(2, c.getRol_id());
        stm.setString(3, c.getClave());
        Timestamp time = new Timestamp(c.getUltimo_acceso().getTime());
        stm.setTimestamp(4, time);
        stm.setBoolean(5, c.isActivo());
        
    }

    @Override
    public void setUpdateParameters(PreparedStatement stm,
            Integer id, Usuario c)
            throws SQLException {
        String idString = String.valueOf(id);
        stm.setInt(1, c.getRol_id());
        stm.setString(2, c.getClave());
        Timestamp time = new Timestamp(c.getUltimo_acceso().getTime());
        stm.setTimestamp(3, time);
        stm.setBoolean(4, c.isActivo());
        stm.setString(5, idString);
    }
}