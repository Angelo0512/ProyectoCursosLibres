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
    
        @Override
        public String toString() {
        StringBuilder r = new StringBuilder();
        r.append("[\n");
        List<Horario> t = getListaHorarios();
        for (Horario c : t) {
            
            r.append(String.format("\t%s,%n", c));
        }
        r.append("]");
        return r.toString();
    }

    public String toStringHTML() {
        
        StringBuilder r = new StringBuilder();
        r.append("\t<table class=\"tablaHorarios\">\n");
        r.append("\t\t<caption>HORARIOS</caption>");
        r.append("\t\t<thead>\n");
        r.append("\t\t\t<tr>\n");
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Sequencia"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Numero Grupo"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Id Curso"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Dia"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Hora"));
        r.append("\t\t\t<tr>\n");
        r.append("\t\t</thead>\n");

        r.append("\t\t<tbody>\n");
        List<Horario> t = getListaHorarios();
        for (Horario c : t) {
            
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
    private HorarioDAO horarios;
}