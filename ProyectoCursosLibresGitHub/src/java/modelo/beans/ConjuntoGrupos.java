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

        @Override
    public String toString() {
        StringBuilder r = new StringBuilder();
        r.append("[\n");
        List<Grupo> t = getListaGrupos();
        for (Grupo c : t) {
            
            r.append(String.format("\t%s,%n", c));
        }
        r.append("]");
        return r.toString();
    }

    public String toStringHTML() {
        
        StringBuilder r = new StringBuilder();
        r.append("\t<table class=\"tablaGrupos\">\n");
        r.append("\t\t<caption>GRUPOS</caption>");
        r.append("\t\t<thead>\n");
        r.append("\t\t\t<tr>\n");
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Numero Grupo"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Id Curso"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Id Profesor"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Matricula"));
        r.append("\t\t\t<tr>\n");
        r.append("\t\t</thead>\n");

        r.append("\t\t<tbody>\n");
        List<Grupo> t = getListaGrupos();
        for (Grupo c : t) {
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
    
    public String toStringHTMLCarga(int profesor_id) {
        
        StringBuilder r = new StringBuilder();
        r.append("\t<table class=\"tablaGrupos\">\n");
        r.append("\t\t<caption>GRUPOS</caption>");
        r.append("\t\t<thead>\n");
        r.append("\t\t\t<tr>\n");
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Numero Grupo"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Id Curso"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Id Profesor"));
        r.append("\t\t\t<tr>\n");
        r.append("\t\t</thead>\n");

        r.append("\t\t<tbody>\n");
        List<Grupo> t = getListaGrupos();
        for (Grupo c : t) {
            if (c.getProfesor_id() == profesor_id){
                r.append(c.toStringHTML());
            }
        }
        r.append("\t\t</tbody>\n");

        r.append("\t\t<tfoot></tfoot>\n");
        r.append("\t</table>\n");

        return r.toString();
    }    
    
    //muestra la tabla de carga de los profesores
     public String getTablaCarga() { 
        return toStringHTMLCarga(321);
    }
    
    @XmlTransient
    private GrupoDAO grupos;
}