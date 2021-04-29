package modelo.beans;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import modelo.dao.HorarioDAO;

@XmlRootElement(name = "lista-horarios")
public class ConjuntoHorarios implements Serializable {

    public ConjuntoHorarios() {
        this.horarios = null;
        try {
            this.horarios = new HorarioDAO();
        } catch (Exception ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }

    public List<Horario> getListaHorarios() {
        try {
            return horarios.listAll();
        } catch (IOException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
            return new ArrayList<>();
        }
    }
        
    public void add(Horario hor) throws SQLException, IOException {
        horarios.add(hor.getSeq(), hor);
    }
    
    public Horario retrieve(int id) throws SQLException, IOException{
        try{
        return horarios.retrieve(id);
        } catch (IOException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
            return new Horario();
        }
    }
    
    public void update(int id, Horario hor) throws SQLException, IOException{
        horarios.update(id, hor);
    }
    
    public void delete(int id) throws SQLException, IOException{
        horarios.delete(id);
    }

    public void borrarTodos() {
        throw new UnsupportedOperationException();
    }

    @XmlTransient
    private HorarioDAO horarios;
}