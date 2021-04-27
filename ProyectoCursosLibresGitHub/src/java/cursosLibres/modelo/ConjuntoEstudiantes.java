package cursosLibres.modelo;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import modelo.db.dao.EstudianteDAO;

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

    public void agregar(Estudiante nuevoEstudiante) throws SQLException, IOException {
        estudiantes.add(nuevoEstudiante.getId_estudiante(), nuevoEstudiante);
    }

    public void borrarTodos() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        StringBuilder r = new StringBuilder();
        r.append("[\n");
        List<Estudiante> t = getListaEstudiantes();
        for (Estudiante e : t) {
            r.append(String.format("\t%s,%n", e));
        }
        r.append("]");
        return r.toString();
    }

    public List<Estudiante> getListaEstudiantes() {
        try {
            return estudiantes.listAll();
        } catch (IOException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
            return new ArrayList<>();
        }
    }

    @XmlTransient
    private EstudianteDAO estudiantes;
}