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
import modelo.beans.Horario;
import modelo.dao.crud.HorarioCRUD;


/**
 *
 * @author Angelo
 */
public class HorarioDAO  extends AbstractDAO<Integer, Horario>{
    
    public HorarioDAO() throws Exception {
        super(new HorarioCRUD());
    }
    
    public HorarioDAO(AbstractCRUD crud) throws Exception {
        super(crud);
    }
    
    @Override
    public Horario getRecord(ResultSet rs)
            throws SQLException {
        return new Horario(
                rs.getInt("seq"),
                rs.getInt("grupo_num"),
                rs.getInt("grupo_curso_id"),
                rs.getInt("dia"),
                rs.getInt("hora"));
    }

    @Override
    public void setAddParameters(PreparedStatement stm,
            Integer id, Horario h)
            throws SQLException {
        stm.setInt(1, id);
        stm.setInt(2, h.getGrupo_num());
        stm.setInt(3, h.getCurso_id());
        stm.setInt(4, h.getDia());
        stm.setInt(5, h.getHora());
    }

    @Override
    public void setUpdateParameters(PreparedStatement stm,
            Integer id, Horario h)
            throws SQLException {
        stm.setInt(1, h.getGrupo_num());
        stm.setInt(2, h.getCurso_id());
        stm.setInt(3, h.getDia());
        stm.setInt(4, h.getHora());
        stm.setInt(5, id);
    }
}
