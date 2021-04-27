/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursosLibres.modelo;

public class Curso {

    public Curso(int id_curso, String descripcion, int area_tematica_id) {
        this.id_curso = id_curso;
        this.descripcion = descripcion;
        this.area_tematica_id = area_tematica_id;
    }

    public String toStringHTML() {
        StringBuilder r = new StringBuilder();
        r.append("\t\t\t<tr>\n");

        r.append(String.format("\t\t\t\t<td>%d</td>\n", getId_curso()));
        r.append(String.format("\t\t\t\t<td>%s</td>\n", getDescripcion()));
        r.append(String.format("\t\t\t\t<td>%s</td>\n", getArea_tematica_id()));

        r.append("\t\t\t</tr>\n");
        return r.toString();
    }

    public int getId_curso() {
        return id_curso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getArea_tematica_id() {
        return area_tematica_id;
    }

    private final int id_curso;
    private final String descripcion;
    private final int area_tematica_id;
}
