package modelo.beans;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import modelo.dao.EstadoDAO;

@XmlRootElement(name = "lista-estados")
public class ConjuntoEstados implements Serializable {

    public ConjuntoEstados() {
        this.estados = null;
        try {
            this.estados = new EstadoDAO();
        } catch (Exception ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }

    public List<Estado> getListaEstados() {
        try {
            return estados.listAll();
        } catch (IOException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
            return new ArrayList<>();
        }
    }
        
    public void add(Estado est) throws SQLException, IOException {
        estados.add(est.getId_estado(), est);
    }
    
    public Estado retrieve(int id) throws SQLException, IOException{
        try{
        return estados.retrieve(id);
        } catch (IOException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
            return new Estado();
        }
    }
    
    public void update(int id, Estado est) throws SQLException, IOException{
        estados.update(id, est);
    }
    
    public void delete(int id) throws SQLException, IOException{
        estados.delete(id);
    }

    public void borrarTodos() {
        throw new UnsupportedOperationException();
    }

    @XmlTransient
    private EstadoDAO estados;
}