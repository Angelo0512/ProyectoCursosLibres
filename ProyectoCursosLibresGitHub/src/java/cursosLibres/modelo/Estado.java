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
public class Estado implements Serializable{

    public Estado() {
    }

    public Estado(int id_estado, String descripcion) {
        this.id_estado = id_estado;
        this.descripcion = descripcion;
    }

    public int getId_estado() {
        return id_estado;
    }

    public void setId_estado(int id_estado) {
        this.id_estado = id_estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    @Override
    public String toString() {
        return String.format("{%d, %s}", getId_estado(), getDescripcion());
    }
    
    public String toStringHTML() {
        StringBuilder r = new StringBuilder();
        r.append("\t\t\t<tr>\n");

        r.append(String.format("\t\t\t\t<td>%d</td>\n", getId_estado()));
        r.append(String.format("\t\t\t\t<td>&s</td>\n", getDescripcion()));

        r.append("\t\t\t</tr>\n");
        return r.toString();
    }
    
    private int id_estado;
    private String descripcion;
}
