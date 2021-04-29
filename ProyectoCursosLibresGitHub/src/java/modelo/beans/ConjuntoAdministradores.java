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
import modelo.dao.AdministradorDAO;


/**
 *
 * @author Angelo
 */

@XmlRootElement(name = "lista-administradores")
public class ConjuntoAdministradores implements Serializable{
    
    public ConjuntoAdministradores() {
        this.admins = null;
        try{
            this.admins = new AdministradorDAO();
        } catch(Exception ex){                        
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }
    
    public List<Administrador> getListaAdministrador() {
        try {
            return admins.listAll();
        } catch (IOException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
            return new ArrayList<>();
        }
    }
    
    public void add(Administrador admin) throws SQLException, IOException{
        admins.add(admin.getId_administrador(), admin);
        
    }
    
    public Administrador get(int id) throws SQLException, IOException{
        try{
        return admins.retrieve(id);
        } catch (IOException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
            return new Administrador();
        }
    }
    
    public void update(int id, Administrador admin) throws SQLException, IOException{
        admins.update(id, admin);
    }
    
    public void delete(int id) throws SQLException, IOException{
        admins.delete(id);
    }
    
    public void borrarTodos() {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public String toString() {
        StringBuilder r = new StringBuilder();
        r.append("[\n");
        List<Administrador> t = getListaAdministrador();
        for (Administrador c : t) {
            
            r.append(String.format("\t%s,%n", c));
        }
        r.append("]");
        return r.toString();
    }

    public String toStringHTML() {
        
        StringBuilder r = new StringBuilder();
        r.append("\t<table class=\"tablaAdministradores\">\n");
        r.append("\t\t<caption>ADMINISTRADORES</caption>");
        r.append("\t\t<thead>\n");
        r.append("\t\t\t<tr>\n");
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Id Administrador"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Id Usuario"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Apellido 1"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Apellido 2"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Nombre"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Telefono"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Email"));
        r.append("\t\t\t<tr>\n");
        r.append("\t\t</thead>\n");

        r.append("\t\t<tbody>\n");
        List<Administrador> t = getListaAdministrador();
        for (Administrador c : t) {
            
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
    private AdministradorDAO admins;
}
