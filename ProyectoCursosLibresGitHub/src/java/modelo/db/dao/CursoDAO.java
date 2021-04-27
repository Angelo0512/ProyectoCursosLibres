package modelo.db.dao;

import cursosLibres.modelo.Curso;
import modelo.db.AbstractDAO;
import modelo.db.AbstractCRUD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.db.Database;

public class CursoDAO extends AbstractDAO<Integer, Curso> {

    public CursoDAO() throws Exception {
        super(new CursoCRUD());
    }

    @Override
    public Curso getRecord(ResultSet rs)
            throws SQLException {
        return new Curso(
                rs.getInt("id_curso"),
                rs.getString("descripcion"),
                rs.getInt("area_tematica_id"));
    }

    @Override
    public void setAddParameters(PreparedStatement stm,
            Integer id, Curso c)
            throws SQLException {
        stm.setInt(1, id);
        stm.setString(2, c.getDescripcion());
        stm.setInt(3, c.getArea_tematica_id());
    }

    @Override
    public void setUpdateParameters(PreparedStatement stm,
            Integer id, Curso c)
            throws SQLException {
        stm.setString(1, c.getDescripcion());
        stm.setInt(2, c.getArea_tematica_id());
        stm.setInt(3, id);
    }
}