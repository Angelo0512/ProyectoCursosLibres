/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.beans;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import modelo.dao.MatriculaDAO;


/**
 *
 * @author Angelo
 */

@XmlRootElement(name = "lista-matriculas")
public class ConjuntoMatricula implements Serializable{
    
    public ConjuntoMatricula() {
        this.matriculas = null;
        try{
            this.matriculas = new MatriculaDAO();
        } catch(Exception ex){                        
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }
    
    public List<Matricula> getListaMatriculas() {
        try {
            return matriculas.listAll();
        } catch (IOException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
            return new ArrayList<>();
        }
    }
    
    public void add(Matricula matricula) throws SQLException, IOException{
        matriculas.add(matricula.getEstudiante_id(), matricula);
        
    }
    
    public Matricula get(int id) throws SQLException, IOException{
        try{
        return matriculas.retrieve(id);
        } catch (IOException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
            return new Matricula();
        }
    }
    
    public void update(int id, Matricula mat) throws SQLException, IOException{
        matriculas.update(id, mat);
    }
    
    public void delete(int id) throws SQLException, IOException{
        matriculas.delete(id);
    }
    
    public void borrarTodos() {
        throw new UnsupportedOperationException();
    }
    
            @Override
        public String toString() {
        StringBuilder r = new StringBuilder();
        r.append("[\n");
        List<Matricula> t = getListaMatriculas();
        for (Matricula c : t) {
            
            r.append(String.format("\t%s,%n", c));
        }
        r.append("]");
        return r.toString();
    }

    public String toStringHTML() {
        
        StringBuilder r = new StringBuilder();
        r.append("\t<table class=\"tablaMatriculas\">\n");
        r.append("\t\t<caption>MATRICULAS</caption>");
        r.append("\t\t<thead>\n");
        r.append("\t\t\t<tr>\n");
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Id Estudiante"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Numero Grupo"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Id Curso"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Id Estado"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Nota"));
        r.append("\t\t\t<tr>\n");
        r.append("\t\t</thead>\n");

        r.append("\t\t<tbody>\n");
        List<Matricula> t = getListaMatriculas();
        for (Matricula c : t) {
            
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
    private MatriculaDAO matriculas;
}
