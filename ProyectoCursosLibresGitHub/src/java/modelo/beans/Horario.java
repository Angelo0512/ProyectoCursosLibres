package modelo.beans;

import java.io.Serializable;

/**
 *
 * @authores Luis Restrepo V. Angelo Calvo M. Daniel Sánchez S.
 * @version 1.0
 */
public class Horario implements Serializable{

    public Horario() {
    }

    public Horario(int seq, int grupo_num, int curso_id, int dia, int hora) {
        this.seq = seq;
        this.grupo_num = grupo_num;
        this.curso_id = curso_id;
        this.dia = dia;
        this.hora = hora;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
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

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }
    
    @Override
    public String toString() {
        return String.format("{%d, %d, %d, %d, %d}",
                getSeq(), getGrupo_num(),
                getCurso_id(), getDia(),
                getHora());
    }
    
    public String toStringHTML() {
        StringBuilder r = new StringBuilder();
        r.append("\t\t\t<tr>\n");

        r.append(String.format("\t\t\t\t<td>%d</td>\n", getSeq()));
        r.append(String.format("\t\t\t\t<td>%d</td>\n", getGrupo_num()));
        r.append(String.format("\t\t\t\t<td>%d</td>\n", getCurso_id()));
        r.append(String.format("\t\t\t\t<td>%d</td>\n", getDia()));
        r.append(String.format("\t\t\t\t<td>%d</td>\n", getHora()));
        
        r.append("\t\t\t</tr>\n");
        return r.toString();
    }
    
    private int seq;
    private int grupo_num;
    private int curso_id;
    private int dia;
    private int hora;
}
