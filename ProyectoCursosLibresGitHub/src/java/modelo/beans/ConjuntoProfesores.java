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
    
    @XmlTransient
    private ProfesorDAO profes;
}
