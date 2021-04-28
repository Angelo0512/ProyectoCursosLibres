package cursosLibres.modelo;

import java.io.Serializable;

public class Administrador implements Serializable {
    
    //Metodos

    public Administrador() {
    }
    
    public Administrador(int id_administrador, String usuario_id, String apellido1, String apellido2, String nombre, String telefono, String e_mail) {
        this.id_administrador = id_administrador;
        this.usuario_id = usuario_id;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.nombre = nombre;
        this.telefono = telefono;
        this.e_mail = e_mail;
    }

    public int getId_administrador() {
        return id_administrador;
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
        return String.format("{%d, %s, %s, %s, %s, %s, %s}", getId_administrador(), getUsuario_id(),
                getApellido1(), getApellido2(),
                getNombre(), getTelefono(), getE_mail());
    }
    
    public String toStringHTML(){
        StringBuilder r = new StringBuilder();
        r.append("\t\t\t<tr>\n");

        r.append(String.format("\t\t\t\t<td>%d</td>\n", getId_administrador()));
        r.append(String.format("\t\t\t\t<td>%s</td>\n", getUsuario_id()));
        r.append(String.format("\t\t\t\t<td>%s</td>\n", getApellido1()));
        r.append(String.format("\t\t\t\t<td>%s</td>\n", getApellido2()));
        r.append(String.format("\t\t\t\t<td>%s</td>\n", getNombre()));
        r.append(String.format("\t\t\t\t<td>%s</td>\n", getTelefono()));
        r.append(String.format("\t\t\t\t<td>%s</td>\n", getE_mail()));

        r.append("\t\t\t</tr>\n");
        return r.toString();
    }
    
    //Atributos
    
    private int id_administrador;
    private String usuario_id;
    private String apellido1;
    private String apellido2;
    private String nombre;
    private String telefono;
    private String e_mail;
}
