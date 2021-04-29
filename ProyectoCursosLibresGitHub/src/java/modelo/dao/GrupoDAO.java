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
import modelo.beans.Grupo;
import modelo.dao.crud.GrupoCRUD;


/**
 *
 * @author Angelo
 */
public class GrupoDAO  extends AbstractDAO<Integer, Grupo>{
    
    public GrupoDAO() throws Exception {
        super(new GrupoCRUD());
    }
    
    public GrupoDAO(AbstractCRUD crud) throws Exception {
        super(crud);
    }
    
    @Override
    public Grupo getRecord(ResultSet rs)
            throws SQLException {
        return new Grupo(
                rs.getInt("num_grupo"),
                rs.getInt("curso_id"),
                rs.getInt("profesor_id"));
    }

    @Override
    public void setAddParameters(PreparedStatement stm,
            Integer id, Grupo g)
            throws SQLException {
        stm.setInt(1, id);
        stm.setInt(2, g.getCurso_id());
        stm.setInt(3, g.getProfesor_id());
    }

    @Override
    public void setUpdateParameters(PreparedStatement stm,
            Integer id, Grupo g)
            throws SQLException {
        stm.setInt(1, g.getCurso_id());
        stm.setInt(2, g.getProfesor_id());
        stm.setInt(3, id);
    }
}
