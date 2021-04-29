package modelo.beans;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import modelo.dao.EstudianteDAO;

@XmlRootElement(name = "lista-estudiantes")
public class ConjuntoEstudiantes implements Serializable {

    public ConjuntoEstudiantes() {
        this.estudiantes = null;
        try {
            this.estudiantes = new EstudianteDAO();
        } catch (Exception ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }

    public List<Estudiante> getListaEstudiantes() {
        try {
            return estudiantes.listAll();
        } catch (IOException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
            return new ArrayList<>();
        }
    }
        
    public void add(Estudiante nuevoEstudiante) throws SQLException, IOException {
        estudiantes.add(nuevoEstudiante.getId_estudiante(), nuevoEstudiante);
    }
    
    public Estudiante retrieve(int id) throws SQLException, IOException{
        try{
        return estudiantes.retrieve(id);
        } catch (IOException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
            return new Estudiante();
        }
    }
    
    public void update(int id, Estudiante estudiante) throws SQLException, IOException{
        estudiantes.update(id, estudiante);
    }
    
    public void delete(int id) throws SQLException, IOException{
        estudiantes.delete(id);
    }

    public void borrarTodos() {
        throw new UnsupportedOperationException();
    }

    @XmlTransient
    private EstudianteDAO estudiantes;
}