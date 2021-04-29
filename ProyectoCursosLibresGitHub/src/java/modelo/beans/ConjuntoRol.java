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
    
    @Override
    public String toString() {
        StringBuilder r = new StringBuilder();
        r.append("[\n");
        List<Rol> t = getListaRoles();
        for (Rol c : t) {
            
            r.append(String.format("\t%s,%n", c));
        }
        r.append("]");
        return r.toString();
    }

    public String toStringHTML() {
        
        StringBuilder r = new StringBuilder();
        r.append("\t<table class=\"tablaRoles\">\n");
        r.append("\t\t<caption>ROLES</caption>");
        r.append("\t\t<thead>\n");
        r.append("\t\t\t<tr>\n");
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Id Rol"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Descripcion"));
        r.append("\t\t\t<tr>\n");
        r.append("\t\t</thead>\n");

        r.append("\t\t<tbody>\n");
        List<Rol> t = getListaRoles();
        for (Rol c : t) {
            
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
    private RolDAO roles;
}
