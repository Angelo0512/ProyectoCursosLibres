
package modelo.db.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.db.AbstractCRUD;
import modelo.db.AbstractDAO;
import cursosLibres.modelo.Area_tematica;
import modelo.db.Database;

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
   public List<Area_tematica> listAll() throws SQLException, IOException {
        List<Area_tematica> listaArea_tematica = new ArrayList<>();
        try (Connection cnx = Database.getInstance().getConnection();
                Statement stm = cnx.createStatement();
                ResultSet rs = stm.executeQuery(Area_tematicaCRUD.CMD_LIST)) {
            while (rs.next()) {
                listaArea_tematica.add(new Area_tematica(
                        rs.getInt("id_area"),
                        rs.getString("descripcion")
                ));
            }
        } catch (SQLException ex) {
            System.err.printf("Excepción de: '%s'%n", ex.getMessage());
        }
        return listaArea_tematica;
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
