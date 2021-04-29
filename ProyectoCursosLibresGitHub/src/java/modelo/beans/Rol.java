package modelo.beans;

import java.io.Serializable;

public class Rol implements Serializable {

    public Rol() {
    }

    public Rol(int id_rol, String descripcion) {
        this.id_rol = id_rol;
        this.descripcion = descripcion;
    }

    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return String.format("{%d, %s}", getId_rol(), getDescripcion());
    }
    
    public String toStringHTML() {
        StringBuilder r = new StringBuilder();
        r.append("\t\t\t<tr>\n");

        r.append(String.format("\t\t\t\t<td>%d</td>\n", getId_rol()));
        r.append(String.format("\t\t\t\t<td>&s</td>\n", getDescripcion()));

        r.append("\t\t\t</tr>\n");
        return r.toString();
    }

    private int id_rol;
    private String descripcion;

}
