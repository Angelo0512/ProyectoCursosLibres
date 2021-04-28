
package cursosLibres.modelo;

import java.io.Serializable;

/**
 *
 * @authores Luis Restrepo V. Angelo Calvo M. Daniel Sánchez S.
 * @version 1.0
 */
public class Area_tematica implements Serializable{

    public Area_tematica() {
    }

    public Area_tematica(int id_area, String descripcion) {
        this.id_area = id_area;
        this.descripcion = descripcion;
    }

    public int getId_area() {
        return id_area;
    }

    public void setId_area(int id_area) {
        this.id_area = id_area;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

        @Override
    public String toString() {
        return String.format("{%d, %s}", getId_area(), getDescripcion());
    }
    
    public String toStringHTML(){
        StringBuilder r = new StringBuilder();
        r.append("\t\t\t<tr>\n");

        r.append(String.format("\t\t\t\t<td>%d</td>\n", getId_area()));
        r.append(String.format("\t\t\t\t<td>%s</td>\n", getDescripcion()));

        r.append("\t\t\t</tr>\n");
        return r.toString();
    }
    
    private int id_area;
    private String descripcion;
}
