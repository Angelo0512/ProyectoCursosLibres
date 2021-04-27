package cursosLibres.modelo;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import modelo.db.dao.CursoDAO;
import modelo.db.dao.EstudianteDAO;

@XmlRootElement(name = "lista-cursos")
public class ConjuntoCursos implements Serializable {

    public ConjuntoCursos() {
        this.cursos = null;
        try {
            this.cursos = new CursoDAO();
        } catch (Exception ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }

    public void agregar(Curso nuevoCurso) throws SQLException, IOException {
        cursos.add(nuevoCurso.getId_curso(), nuevoCurso);
    }

    public void borrarTodos() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        StringBuilder r = new StringBuilder();
        r.append("[\n");
        List<Curso> t = getListaCursos();
        for (Curso c : t) {
            r.append(String.format("\t%s,%n", c));
        }
        r.append("]");
        return r.toString();
    }

    public String toStringHTML() {
        StringBuilder r = new StringBuilder();
        r.append("\t<table class=\"tablaCursos\">\n");
        r.append("\t\t<caption>CURSOS</caption>");
        r.append("\t\t<thead>\n");
        r.append("\t\t\t<tr>\n");
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "id_curso"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "descripcion"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "area_tematica_id"));
        r.append("\t\t\t<tr>\n");
        r.append("\t\t</thead>\n");

        r.append("\t\t<tbody>\n");
        List<Curso> t = getListaCursos();
        for (Curso c : t) {
            r.append(c.toStringHTML());
        }
        r.append("\t\t</tbody>\n");

        r.append("\t\t<tfoot></tfoot>\n");
        r.append("\t</table>\n");

        return r.toString();
    }

    public List<Curso> getListaCursos() {
        try {
            return cursos.listAll();
        } catch (IOException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
            return new ArrayList<>();
        }
    }

    public String getTabla() {
        return toStringHTML();
    }

    @XmlTransient
    private CursoDAO cursos;
}