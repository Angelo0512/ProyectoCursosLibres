
package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import cursolibres.db.dao.crud.AbstractCRUD;
import cursolibres.db.dao.AbstractDAO;
import modelo.beans.Area_tematica;
import modelo.dao.crud.Area_tematicaCRUD;

/**
 *
 * @authores Luis Restrepo V. Angelo Calvo M. Daniel Sánchez S.
 * @version 1.0
 */
public class Area_tematicaDAO extends AbstractDAO<Integer, Area_tematica>{
    
    public Area_tematicaDAO(){
        super(new Area_tematicaCRUD());
    }
        
    public Area_tematicaDAO(AbstractCRUD crud) {
        super(crud);
    }  

    @Override
    public Area_tematica getRecord(ResultSet rs)
            throws SQLException {
        return new Area_tematica(
                rs.getInt("id_area"),
                rs.getString("descripcion")
        );
    }

    @Override
    public void setAddParameters(PreparedStatement stm,
            Integer id_area, Area_tematica area_tematica)
            throws SQLException {
        stm.setInt(1, id_area);
        stm.setString(2, area_tematica.getDescripcion());
    }

    @Override
    public void setUpdateParameters(PreparedStatement stm,
            Integer id_area, Area_tematica area_tematica)
            throws SQLException {
        stm.setString(1, area_tematica.getDescripcion());
        stm.setInt(2, id_area);
    }
    
}
