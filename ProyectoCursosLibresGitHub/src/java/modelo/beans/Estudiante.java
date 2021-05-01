package modelo.beans;

import java.io.Serializable;

public class Estudiante implements Serializable{

    public Estudiante() {
    }

    public Estudiante(int id_estudiante, String usuario_id, String apellido1, String apellido2, String nombre, String telefono, String e_mail) {
        //el rol tres es estudiante
        this.id_estudiante = id_estudiante;
        this.usuario_id = usuario_id;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.nombre = nombre;
        this.telefono = telefono;
        this.e_mail = e_mail;
    }

    public void setId_estudiante(int id_estudiante) {
        this.id_estudiante = id_estudiante;
    }

    public void setUsuario_id(String usuario_id) {
        this.usuario_id = usuario_id;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public int getId_estudiante() {
        return id_estudiante;
    }

    public String getUsuario_id() {
        return usuario_id;
    }

    public String getApellido1() {
        return apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getE_mail() {
        return e_mail;
    }
    @Override
    public String toString() {
        return String.format("{%d, %s, %s, %s, %s, %s, %s}",
                getId_estudiante(), getUsuario_id(),
                getApellido1(), getApellido2(),
                getNombre(), getTelefono(),
                getE_mail());
    }
    
    public String toStringHTML() {
        StringBuilder r = new StringBuilder();
        r.append("\t\t\t<tr>\n");

        r.append(String.format("\t\t\t\t<td>%d</td>\n", getId_estudiante()));
        r.append(String.format("\t\t\t\t<td>&s</td>\n", getUsuario_id()));
        r.append(String.format("\t\t\t\t<td>&s</td>\n", getApellido1()));
        r.append(String.format("\t\t\t\t<td>&s</td>\n", getApellido2()));
        r.append(String.format("\t\t\t\t<td>&s</td>\n", getNombre()));
        r.append(String.format("\t\t\t\t<td>&s</td>\n", getTelefono()));
        r.append(String.format("\t\t\t\t<td>&s</td>\n", getE_mail()));

        r.append("\t\t\t</tr>\n");
        return r.toString();
    }

    private int id_estudiante;
    private String usuario_id;
    private String apellido1;
    private String apellido2;
    private String nombre;
    private String telefono;
    private String e_mail;
}
