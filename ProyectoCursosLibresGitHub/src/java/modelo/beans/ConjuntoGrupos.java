package modelo.beans;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import modelo.dao.GrupoDAO;

@XmlRootElement(name = "lista-grupos")
public class ConjuntoGrupos implements Serializable {

    public ConjuntoGrupos() {
        this.grupos = null;
        try {
            this.grupos = new GrupoDAO();
        } catch (Exception ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }

    public List<Grupo> getListaGrupos() {
        try {
            return grupos.listAll();
        } catch (IOException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
            return new ArrayList<>();
        }
    }
        
    public void add(Grupo gru) throws SQLException, IOException {
        grupos.add(gru.getNum_grupo(), gru);
    }
    
    public Grupo retrieve(int id) throws SQLException, IOException{
        try{
        return grupos.retrieve(id);
        } catch (IOException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
            return new Grupo();
        }
    }
    
    public void update(int id, Grupo gru) throws SQLException, IOException{
        grupos.update(id, gru);
    }
    
    public void delete(int id) throws SQLException, IOException{
        grupos.delete(id);
    }

    public void borrarTodos() {
        throw new UnsupportedOperationException();
    }

    @XmlTransient
    private GrupoDAO grupos;
}