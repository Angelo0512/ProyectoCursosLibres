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
    
    @Override
    public String toString() {
        StringBuilder r = new StringBuilder();
        r.append("[\n");
        List<Area_tematica> t = getListaAreasTematicas();
        for (Area_tematica c : t) {
            
            r.append(String.format("\t%s,%n", c));
        }
        r.append("]");
        return r.toString();
    }

    public String toStringHTML() {
        
        StringBuilder r = new StringBuilder();
        r.append("\t<table class=\"tablaAreasTematicas\">\n");
        r.append("\t\t<caption>AREAS TEMATICAS</caption>");
        r.append("\t\t<thead>\n");
        r.append("\t\t\t<tr>\n");
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Id Area Tematica"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Descripcion"));
        r.append("\t\t\t<tr>\n");
        r.append("\t\t</thead>\n");

        r.append("\t\t<tbody>\n");
        List<Area_tematica> t = getListaAreasTematicas();
        for (Area_tematica c : t) {
            
            r.append(c.toStringHTML());
        }
        r.append("\t\t</tbody>\n");

        r.append("\t\t<tfoot></tfoot>\n");
        r.append("\t</table>\n");

        return r.toString();
    }



    public String getTabla() {
        return toStringHTML();
    }
    
    @XmlTransient
    private Area_tematicaDAO areas;
}
