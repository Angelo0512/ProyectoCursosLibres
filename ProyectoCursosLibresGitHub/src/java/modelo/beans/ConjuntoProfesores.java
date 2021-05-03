/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.beans;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import modelo.dao.ProfesorDAO;


/**
 *
 * @author Angelo
 */

@XmlRootElement(name = "lista-profesores")
public class ConjuntoProfesores implements Serializable{
    
    public ConjuntoProfesores() {
        this.profes = null;
        try{
            this.profes = new ProfesorDAO();
        } catch(Exception ex){                        
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }
    
    public List<Profesor> getListaProfesores() {
        try {
            return profes.listAll();
        } catch (IOException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
            return new ArrayList<>();
        }
    }
    
    public void add(Profesor prof) throws SQLException, IOException{
        profes.add(prof.getId_profesor(), prof);
        
    }
    
    public Profesor get(int id) throws SQLException, IOException{
        try{
        return profes.retrieve(id);
        } catch (IOException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
            return new Profesor();
        }
    }
    
    public void update(int id, Profesor prof) throws SQLException, IOException{
        profes.update(id, prof);
    }
    
    public void delete(int id) throws SQLException, IOException{
        profes.delete(id);
    }
    
    public void borrarTodos() {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public String toString() {
        StringBuilder r = new StringBuilder();
        r.append("[\n");
        List<Profesor> t = getListaProfesores();
        for (Profesor c : t) {
            
            r.append(String.format("\t%s,%n", c));
        }
        r.append("]");
        return r.toString();
    }

    public String toStringHTML() {
        
        StringBuilder r = new StringBuilder();
        r.append("\t<table class=\"tablaProfesor\">\n");
        r.append("\t\t<caption>PROFESORES</caption>");
        r.append("\t\t<thead>\n");
        r.append("\t\t\t<tr>\n");
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Id Profesor"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Id Usuario"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Apellido 1"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Apellido 2"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Nombre"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Telefono"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Email"));
        r.append("\t\t\t<tr>\n");
        r.append("\t\t</thead>\n");

        r.append("\t\t<tbody>\n");
        List<Profesor> t = getListaProfesores();
        for (Profesor c : t) {
            
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
    private ProfesorDAO profes;
}
