/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import cursolibres.db.dao.AbstractDAO;
import cursolibres.db.dao.crud.AbstractCRUD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.beans.Estado;
import modelo.dao.crud.EstadoCRUD;


/**
 *
 * @author Angelo
 */
public class EstadoDAO  extends AbstractDAO<Integer, Estado>{
    
    public EstadoDAO() throws Exception {
        super(new EstadoCRUD());
    }
    
    public EstadoDAO(AbstractCRUD crud) throws Exception {
        super(crud);
    }
    
    @Override
    public Estado getRecord(ResultSet rs)
            throws SQLException {
        return new Estado(
                rs.getInt("id_estado"),
                rs.getString("descripcion"));
    }

    @Override
    public void setAddParameters(PreparedStatement stm,
            Integer id, Estado e)
            throws SQLException {
        stm.setInt(1, id);
        stm.setString(2, e.getDescripcion());
    }

    @Override
    public void setUpdateParameters(PreparedStatement stm,
            Integer id, Estado e)
            throws SQLException {
        stm.setString(1, e.getDescripcion());
        stm.setInt(2, id);
    }
}
