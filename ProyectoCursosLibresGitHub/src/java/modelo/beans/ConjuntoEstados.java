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
    
    @Override
    public String toString() {
        StringBuilder r = new StringBuilder();
        r.append("[\n");
        List<Estado> t = getListaEstados();
        for (Estado c : t) {
            
            r.append(String.format("\t%s,%n", c));
        }
        r.append("]");
        return r.toString();
    }

    public String toStringHTML() {
        
        StringBuilder r = new StringBuilder();
        r.append("\t<table class=\"tablaEstados\">\n");
        r.append("\t\t<caption>ESTADOS</caption>");
        r.append("\t\t<thead>\n");
        r.append("\t\t\t<tr>\n");
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Id Estado"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Descripcion"));
        r.append("\t\t\t<tr>\n");
        r.append("\t\t</thead>\n");

        r.append("\t\t<tbody>\n");
        List<Estado> t = getListaEstados();
        for (Estado c : t) {
            
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
    private EstadoDAO estados;
}