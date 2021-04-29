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

        @Override
    public String toString() {
        StringBuilder r = new StringBuilder();
        r.append("[\n");
        List<Estudiante> t = getListaEstudiantes();
        for (Estudiante c : t) {
            
            r.append(String.format("\t%s,%n", c));
        }
        r.append("]");
        return r.toString();
    }

    public String toStringHTML() {
        
        StringBuilder r = new StringBuilder();
        r.append("\t<table class=\"tablaEstudiante\">\n");
        r.append("\t\t<caption>ESTUDIANTES</caption>");
        r.append("\t\t<thead>\n");
        r.append("\t\t\t<tr>\n");
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Id Estudiante"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Id Usuario"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Apellido 1"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Apellido 2"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Nombre"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Telefono"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Email"));
        r.append("\t\t\t<tr>\n");
        r.append("\t\t</thead>\n");

        r.append("\t\t<tbody>\n");
        List<Estudiante> t = getListaEstudiantes();
        for (Estudiante c : t) {
            
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
    private EstudianteDAO estudiantes;
}