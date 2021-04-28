/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursosLibres.modelo;

import java.io.Serializable;

/**
 *
 * @author Angelo
 */
public class Especialidad implements Serializable{

    public Especialidad() {
    }

    public Especialidad(int profesor_id_profesor, int area_tematica_id) {
        this.profesor_id_profesor = profesor_id_profesor;
        this.area_tematica_id = area_tematica_id;
    }

    public int getProfesor_id_profesor() {
        return profesor_id_profesor;
    }

    public void setProfesor_id_profesor(int profesor_id_profesor) {
        this.profesor_id_profesor = profesor_id_profesor;
    }

    public int getArea_tematica_id() {
        return area_tematica_id;
    }

    public void setArea_tematica_id(int area_tematica_id) {
        this.area_tematica_id = area_tematica_id;
    }
    
    @Override
    public String toString() {
        return String.format("{%d, %d}", getProfesor_id_profesor(), getArea_tematica_id(),
                getArea_tematica_id());
    }
    
    public String toStringHTML() {
        StringBuilder r = new StringBuilder();
        r.append("\t\t\t<tr>\n");

        r.append(String.format("\t\t\t\t<td>%d</td>\n", getProfesor_id_profesor()));
        r.append(String.format("\t\t\t\t<td>%d</td>\n", getArea_tematica_id()));

        r.append("\t\t\t</tr>\n");
        return r.toString();
    }
    
    private int profesor_id_profesor;
    private int area_tematica_id;
}
