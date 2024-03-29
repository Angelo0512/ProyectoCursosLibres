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
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Modificar nota"));  
        r.append("\t\t\t<tr>\n");
        r.append("\t\t</thead>\n");

        r.append("\t\t<tbody>\n");
        List<Grupo> t = getListaGrupos();
        for (Grupo c : t) {
            if (c.getProfesor_id() == profesor_id){
                r.append(c.toStringHTMLCarga());
            }
        }
        r.append("\t\t</tbody>\n");

        r.append("\t\t<tfoot></tfoot>\n");
        r.append("\t</table>\n");

        return r.toString();
    }    
    
    public String toStringHTMLCurso(int curso_id) {
        
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
            if (c.getCurso_id()== curso_id){
                r.append(c.toStringHTMLCarga());
                r.append(String.format(
                "\t\t\t\t<td><form method='%s' action='%s'><button name='grupoModificar' value='%d'>%s</button></form></td>\n",
                "GET",
                "ServicioRegistro",
                c.getNum_grupo(),
                "Modificar"));
            }
        }
        r.append("\t\t</tbody>\n");

        r.append("\t\t<tfoot></tfoot>\n");
        r.append("\t</table>\n");

        return r.toString();
    }  
   
    //muestra la tabla de carga de los profesores
    public String getTablaCarga(int id) { 
        return toStringHTMLCarga(id);
    }
     
    public static String getTablaCarga(ConjuntoGrupos instancia, String id) {
        return instancia.getTablaCarga(Integer.parseInt(id));
    }
    
    //muestra la tabla de grupos de un curso
    public String getTablaCurso(int id) { 
        return toStringHTMLCurso(id);
    }
     
    public static String getTablaCurso(ConjuntoGrupos instancia, String id) {
        return instancia.getTablaCurso(Integer.parseInt(id));
    }
    
      //muestra la tabla de grupos sin matriucla
    
    public String toStringHTMLSinMatricula() {
        
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
            r.append(c.toStringHTMLSinMatricula());
        }
        r.append("\t\t</tbody>\n");

        r.append("\t\t<tfoot></tfoot>\n");
        r.append("\t</table>\n");

        return r.toString();
    }
    
    public String getTablaSinMatricula() {
        return toStringHTMLSinMatricula();
    }

    
    @XmlTransient
    private GrupoDAO grupos;
}