package modelo.dao;

import modelo.beans.servicios.UsuarioCRUD;
import cursolibres.db.dao.AbstractDAO;
import cursolibres.db.dao.crud.AbstractCRUD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.beans.Usuario;
import java.sql.Timestamp;
import java.util.Date;



public class UsuarioDAO extends AbstractDAO<String, Usuario> {

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
                rs.getTimestamp("ultimo_aceso"),
                rs.getBoolean("activo"));
    }

    @Override
    public void setAddParameters(PreparedStatement stm,
            String id, Usuario c)
            throws SQLException {
        
        stm.setString(1, id);
        stm.setInt(2, c.getRol_id());
        stm.setString(3, c.getClave());
        stm.setTimestamp(4, c.getUltimo_acceso());
        stm.setBoolean(5, c.isActivo());
        
    }

    @Override
    public void setUpdateParameters(PreparedStatement stm,
            String id, Usuario c)
            throws SQLException {
        stm.setInt(1, c.getRol_id());
        stm.setString(2, c.getClave());
        stm.setTimestamp(3, (Timestamp) c.getUltimo_acceso());
        stm.setBoolean(4, c.isActivo());
        stm.setString(5, id);
    }
}