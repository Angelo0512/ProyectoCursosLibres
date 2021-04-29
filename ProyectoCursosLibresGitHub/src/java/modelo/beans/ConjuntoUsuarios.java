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
    
    public List<Usuario> getListaAdministrador() {
        try {
            return usuarios.listAll();
        } catch (IOException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
            return new ArrayList<>();
        }
    }
    
    public void add(Usuario usuario) throws SQLException, IOException{
        
        Integer id = Integer.parseInt(usuario.getId_usuario());
        usuarios.add(id, usuario);
        
    }
    
    public Usuario get(int id) throws SQLException, IOException{
        try{
        return usuarios.retrieve(id);
        } catch (IOException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
            return new Usuario();
        }
    }
    
    public void update(int id, Usuario us) throws SQLException, IOException{
        usuarios.update(id, us);
    }
    
    public void delete(int id) throws SQLException, IOException{
        usuarios.delete(id);
    }
    
    public void borrarTodos() {
        throw new UnsupportedOperationException();
    }
    
    @XmlTransient
    private UsuarioDAO usuarios;
}
