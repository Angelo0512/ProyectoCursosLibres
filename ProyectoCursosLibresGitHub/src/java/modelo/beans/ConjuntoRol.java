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
import modelo.dao.RolDAO;


/**
 *
 * @author Angelo
 */

@XmlRootElement(name = "lista-roles")
public class ConjuntoRol implements Serializable{
    
    public ConjuntoRol() {
        this.roles = null;
        try{
            this.roles = new RolDAO();
        } catch(Exception ex){                        
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }
    
    public List<Rol> getListaRoles() {
        try {
            return roles.listAll();
        } catch (IOException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
            return new ArrayList<>();
        }
    }
    
    public void add(Rol rol) throws SQLException, IOException{
        roles.add(rol.getId_rol(), rol);
        
    }
    
    public Rol get(int id) throws SQLException, IOException{
        try{
        return roles.retrieve(id);
        } catch (IOException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
            return new Rol();
        }
    }
    
    public void update(int id, Rol rol) throws SQLException, IOException{
        roles.update(id, rol);
    }
    
    public void delete(int id) throws SQLException, IOException{
        roles.delete(id);
    }
    
    public void borrarTodos() {
        throw new UnsupportedOperationException();
    }
    
    @XmlTransient
    private RolDAO roles;
}
