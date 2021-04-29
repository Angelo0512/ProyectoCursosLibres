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
    
    
    @XmlTransient
    private EspecialidadDAO especialidades;
}