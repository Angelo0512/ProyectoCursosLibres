/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.beans;

import java.io.Serializable;

public class Curso implements Serializable {

    public Curso() {
    }

    public Curso(int id_curso, String descripcion, int area_tematica_id) {
        this.id_curso = id_curso;
        this.descripcion = descripcion;
        this.area_tematica_id = area_tematica_id;
    }

    public int getId_curso() {
        return id_curso;
    }

    public void setId_curso(int id_curso) {
        this.id_curso = id_curso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getArea_tematica_id() {
        return area_tematica_id;
    }

    public void setArea_tematica_id(int area_tematica_id) {
        this.area_tematica_id = area_tematica_id;
    }

    @Override
    public String toString() {
        return String.format("{%d, %s, %d}", getId_curso(), getDescripcion(),
                getArea_tematica_id());
    }

    public String toStringHTML() {
        StringBuilder r = new StringBuilder();
        r.append("\t\t\t<tr>\n");

        r.append(String.format("\t\t\t\t<td>%d</td>\n", getId_curso()));
        r.append(String.format("\t\t\t\t<td>%s</td>\n", getDescripcion()));
        r.append(String.format("\t\t\t\t<td>%d</td>\n", getArea_tematica_id()));

        r.append(String.format(
                "\t\t\t\t<td><form action='%s'><button name='grupos' value='%d'>%s</button></td></form>\n",
                "",
                getId_curso(),
                "Ver"));

        r.append("\t\t\t</tr>\n");
        return r.toString();
    }

    private int id_curso;
    private String descripcion;
    private int area_tematica_id;
}
