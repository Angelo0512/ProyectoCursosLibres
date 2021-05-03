package modelo.beans;

import java.io.Serializable;

/**
 *
 * @authores Luis Restrepo V. Angelo Calvo M. Daniel Sánchez S.
 * @version 1.0
 */
public class Grupo implements Serializable {

    public Grupo() {
    }

    public Grupo(int num_grupo, int curso_id, int profesor_id) {
        this.num_grupo = num_grupo;
        this.curso_id = curso_id;
        this.profesor_id = profesor_id;

    }

    public int getNum_grupo() {
        return num_grupo;
    }

    public void setNum_grupo(int num_grupo) {
        this.num_grupo = num_grupo;
    }
    
    public static void setNum_grupo(Grupo instancia, int num_grupo) {
        instancia.setNum_grupo(num_grupo);
    }

    public int getCurso_id() {
        return curso_id;
    }

    public void setCurso_id(int curso_id) {
        this.curso_id = curso_id;
    }
    
    public static void setCurso_id(Grupo instancia, int curso_id) {
        instancia.setCurso_id(curso_id);
    }

    public int getProfesor_id() {
        return profesor_id;
    }

    public void setProfesor_id(int profesor_id) {
        this.profesor_id = profesor_id;
    }
  
    public static void setProfesor_id(Grupo instancia, int profesor_id) {
        instancia.setProfesor_id(profesor_id);
    }

    @Override
    public String toString() {
        return String.format("{%d, %d, %d}", getNum_grupo(), getCurso_id(),
                getProfesor_id());
    }

    public String toStringHTML() {
        StringBuilder r = new StringBuilder();
        r.append("\t\t\t<tr>\n");

        r.append(String.format("\t\t\t\t<td>%d</td>\n", getNum_grupo()));
        r.append(String.format("\t\t\t\t<td>%d</td>\n", getCurso_id()));
        r.append(String.format("\t\t\t\t<td>%d</td>\n", getProfesor_id()));

        r.append(String.format(
                "\t\t\t\t<td><form method='%s' action='%s'><button name='grupo' value='%d'>%s</button></form></td>\n",
                "GET",
                "ServicioMatricula",
                getNum_grupo(),
                "Matricular"));
        r.append("\t\t\t</tr>\n");
        return r.toString();
    }
    
    public String toStringHTMLCarga() {
        StringBuilder r = new StringBuilder();
        r.append("\t\t\t<tr>\n");

        r.append(String.format("\t\t\t\t<td>%d</td>\n", getNum_grupo()));
        r.append(String.format("\t\t\t\t<td>%d</td>\n", getCurso_id()));
        r.append(String.format("\t\t\t\t<td>%d</td>\n", getProfesor_id()));
        
        r.append(String.format(
                "\t\t\t\t<td><form method='%s' action='%s'><button name='grupoModificar' value='%d'>%s</button></form></td>\n",
                "GET",
                "ServicioRegistro",
                getNum_grupo(),
                "Modificar"));
        r.append("\t\t\t</tr>\n");
        r.append("\t\t\t</tr>\n");
        return r.toString();
    }

    private int num_grupo;
    private int curso_id;
    private int profesor_id;
}
