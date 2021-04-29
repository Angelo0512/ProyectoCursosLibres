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
import modelo.beans.Especialidad;
import modelo.dao.crud.EspecialidadCRUD;

/**
 *
 * @author Angelo
 */
public class EspecialidadDAO  extends AbstractDAO<Integer, Especialidad>{
    
    public EspecialidadDAO() throws Exception {
        super(new EspecialidadCRUD());
    }
    
    public EspecialidadDAO(AbstractCRUD crud) throws Exception {
        super(crud);
    }
    
    @Override
    public Especialidad getRecord(ResultSet rs)
            throws SQLException {
        return new Especialidad(
                rs.getInt("profesor_id_profesor"),
                rs.getInt("area_tematica_id"));
    }

    @Override
    public void setAddParameters(PreparedStatement stm,
            Integer id, Especialidad e )
            throws SQLException {
        stm.setInt(1, id);
        stm.setInt(2, e.getArea_tematica_id());
    }

    @Override
    public void setUpdateParameters(PreparedStatement stm,
            Integer id, Especialidad a)
            throws SQLException {
        stm.setInt(1, a.getArea_tematica_id());
        stm.setInt(2, id);
    }
}
