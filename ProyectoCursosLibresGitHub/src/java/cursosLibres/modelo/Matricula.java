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
public class Matricula implements Serializable{

    public Matricula() {
    }

    public int getEstudiante_id() {
        return estudiante_id;
    }

    public void setEstudiante_id(int estudiante_id) {
        this.estudiante_id = estudiante_id;
    }

    public int getGrupo_num() {
        return grupo_num;
    }

    public void setGrupo_num(int grupo_num) {
        this.grupo_num = grupo_num;
    }

    public int getCurso_id() {
        return curso_id;
    }

    public void setCurso_id(int curso_id) {
        this.curso_id = curso_id;
    }

    public int getEstado_id() {
        return estado_id;
    }

    public void setEstado_id(int estado_id) {
        this.estado_id = estado_id;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }
    
    @Override
    public String toString() {
        return String.format("{%d, %d, %d, %d, %d}", 
                getEstudiante_id(), getGrupo_num(),
                getCurso_id(), getEstado_id(),
                getNota());
    }
    
    public String toStringHTML() {
        StringBuilder r = new StringBuilder();
        r.append("\t\t\t<tr>\n");

        r.append(String.format("\t\t\t\t<td>%d</td>\n", getEstudiante_id()));
        r.append(String.format("\t\t\t\t<td>%d</td>\n", getGrupo_num()));
        r.append(String.format("\t\t\t\t<td>%d</td>\n", getCurso_id()));
        r.append(String.format("\t\t\t\t<td>%d</td>\n", getEstado_id()));
        r.append(String.format("\t\t\t\t<td>%d</td>\n", getNota()));

        r.append("\t\t\t</tr>\n");
        return r.toString();
    }
    
    private int estudiante_id;
    private int grupo_num;
    private int curso_id;
    private int estado_id;
    private int nota;
}
