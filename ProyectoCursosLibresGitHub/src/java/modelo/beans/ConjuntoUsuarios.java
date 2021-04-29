/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.beans;

import java.io.IOException;
import java.io.Serializable;
import static java.lang.System.out;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import modelo.dao.UsuarioDAO;


/**
 *
 * @author Angelo
 */

@XmlRootElement(name = "lista-usuarios")
public class ConjuntoUsuarios implements Serializable{
    
    public ConjuntoUsuarios() {
        this.usuarios = null;
        try{
            this.usuarios = new UsuarioDAO();
        } catch(Exception ex){                        
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }
    
    public List<Usuario> getListaUsuarios() {
        try {
            return usuarios.listAll();
        } catch (IOException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
            return new ArrayList<>();
        }
    }
    
    public void add(Usuario usuario) throws SQLException, IOException{
        
        //Integer id = Integer.parseInt(usuario.getId_usuario());
        usuarios.add(usuario.getId_usuario(), usuario);
        
    }
    
    public Usuario retrieve(String id) throws SQLException, IOException{
        try{
        return usuarios.retrieve(id);
        } catch (IOException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
            return new Usuario();
        }
    }
    
    public void update(String id, Usuario us) throws SQLException, IOException{
        usuarios.update(id, us);
    }
    
    public void delete(String id) throws SQLException, IOException{
        usuarios.delete(id);
    }
    
    public void borrarTodos() {
        throw new UnsupportedOperationException();
    }
    
        @Override
    public String toString() {
        StringBuilder r = new StringBuilder();
        r.append("[\n");
        List<Usuario> t = getListaUsuarios();
        for (Usuario c : t) {
            
            r.append(String.format("\t%s,%n", c));
        }
        r.append("]");
        return r.toString();
    }

    public String toStringHTML() {
        
        StringBuilder r = new StringBuilder();
        r.append("\t<table class=\"tablaUsuarios\">\n");
        r.append("\t\t<caption>USUARIOS</caption>");
        r.append("\t\t<thead>\n");
        r.append("\t\t\t<tr>\n");
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Id Usuario"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Id Rol"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Clave"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Ultimo Acceso"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Estado"));
        r.append("\t\t\t<tr>\n");
        r.append("\t\t</thead>\n");

        r.append("\t\t<tbody>\n");
        List<Usuario> t = getListaUsuarios();
        for (Usuario c : t) {
            
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
    private UsuarioDAO usuarios;
}
