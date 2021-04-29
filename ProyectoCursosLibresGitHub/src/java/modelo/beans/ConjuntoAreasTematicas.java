/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.beans;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import modelo.dao.Area_tematicaDAO;
/**
 *
 * @author Angelo
 */

@XmlRootElement(name = "lista-areas_tematicas")
public class ConjuntoAreasTematicas {

    public ConjuntoAreasTematicas() {
        this.areas = null;
        try{
            this.areas = new Area_tematicaDAO();
        } catch(Exception ex){                        
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }
    
    public List<Area_tematica> getListaAreasTematicas() {
        try {
            return areas.listAll();
        } catch (IOException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
            return new ArrayList<>();
        }
    }
    
    public void add(Area_tematica area) throws SQLException, IOException{
        areas.add(area.getId_area(), area);
        
    }
    
    public Area_tematica retrieve(int id) throws SQLException, IOException{
        try{
        return areas.retrieve(id);
        } catch (IOException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
            return new Area_tematica();
        }
    }
    
    public void update(int id, Area_tematica area) throws SQLException, IOException{
        areas.update(id, area);
    }
    
    public void delete(int id) throws SQLException, IOException{
        areas.delete(id);
    }
    
    public void borrarTodos() {
        throw new UnsupportedOperationException();
    }
    
    
    @XmlTransient
    private Area_tematicaDAO areas;
}
