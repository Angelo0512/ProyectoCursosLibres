package modelo.db;

import cursosLibres.modelo.Area_tematica;
import java.io.IOException;
import java.sql.SQLException;
import modelo.db.dao.Area_tematicaDAO;

/**
 *
 * @authores Luis Restrepo V. Angelo Calvo M. Daniel Sánchez S.
 * @version 1.0
 */
public class ServicioDB {

    public ServicioDB() {
        areas_tematicas = new Area_tematicaDAO();
    }

    public void addArea_tematica(Area_tematica area_tematica) throws SQLException, IOException{   
        areas_tematicas.add(area_tematica.getId_area(), area_tematica);
    }
        
    private final Area_tematicaDAO areas_tematicas;
}
