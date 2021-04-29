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
import modelo.dao.EspecialidadDAO;

/**
 *
 * @author Angelo
 */
 
@XmlRootElement(name = "lista-especialidades")
public class ConjuntoEspecialidades {

    public ConjuntoEspecialidades() {
        this.especialidades = null;
        try{
            this.especialidades = new EspecialidadDAO();
        } catch(Exception ex){                        
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }
    
    public List<Especialidad> getListaEspecialidades() {
        try {
            return especialidades.listAll();
        } catch (IOException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
            return new ArrayList<>();
        }
    }
    
    public void add(Especialidad e) throws SQLException, IOException{
        especialidades.add(e.getProfesor_id_profesor(), e);
        
    }
    
    public Especialidad retrieve(int id) throws SQLException, IOException{
        try{
        return especialidades.retrieve(id);
        } catch (IOException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
            return new Especialidad();
        }
    }
    
    public void update(int id, Especialidad e) throws SQLException, IOException{
        especialidades.update(id, e);
    }
    
    public void delete(int id) throws SQLException, IOException{
        especialidades.delete(id);
    }
    
    public void borrarTodos() {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public String toString() {
        StringBuilder r = new StringBuilder();
        r.append("[\n");
        List<Especialidad> t = getListaEspecialidades();
        for (Especialidad c : t) {
            
            r.append(String.format("\t%s,%n", c));
        }
        r.append("]");
        return r.toString();
    }

    public String toStringHTML() {
        
        StringBuilder r = new StringBuilder();
        r.append("\t<table class=\"tablaEspecialidades\">\n");
        r.append("\t\t<caption>ESPECIALIDADES</caption>");
        r.append("\t\t<thead>\n");
        r.append("\t\t\t<tr>\n");
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Id Profesor"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Id Area Tematica"));
        r.append("\t\t\t<tr>\n");
        r.append("\t\t</thead>\n");

        r.append("\t\t<tbody>\n");
        List<Especialidad> t = getListaEspecialidades();
        for (Especialidad c : t) {
            
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
    private EspecialidadDAO especialidades;
}