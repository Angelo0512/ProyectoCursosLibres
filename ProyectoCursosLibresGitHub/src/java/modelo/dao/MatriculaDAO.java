package modelo.dao;

import modelo.beans.Curso;
import cursolibres.db.dao.AbstractDAO;
import cursolibres.db.dao.crud.AbstractCRUD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import cursolibres.db.Database;
import modelo.beans.Matricula;
import modelo.dao.crud.MatriculaCRUD;


public class MatriculaDAO extends AbstractDAO<Integer, Matricula> {

    public MatriculaDAO() throws Exception {
        super(new MatriculaCRUD());
    }
    
    public MatriculaDAO(AbstractCRUD crud) {
        super(crud);
    }  

    @Override
    public Matricula getRecord(ResultSet rs)
            throws SQLException {
        return new Matricula(
                rs.getInt("estudiante_id"),
                rs.getInt("grupo_num"),
                rs.getInt("curso_id"),
                rs.getInt("estado_id"),
                rs.getInt("nota"));
    }

    @Override
    public void setAddParameters(PreparedStatement stm,
            Integer id, Matricula m)
            throws SQLException {
        stm.setInt(1, id);
        stm.setInt(2, m.getGrupo_num());
        stm.setInt(3, m.getCurso_id());
        stm.setInt(4, m.getEstado_id());
        stm.setInt(5, m.getNota());
    }

    @Override
    public void setUpdateParameters(PreparedStatement stm,
            Integer id, Matricula m)
            throws SQLException {
        stm.setInt(1, m.getGrupo_num());
        stm.setInt(2, m.getCurso_id());
        stm.setInt(3, m.getEstado_id());
        stm.setInt(4, m.getNota());
        stm.setInt(5, id);
    }
}