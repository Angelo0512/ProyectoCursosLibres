package cursosLibres.modelo;

import java.io.Serializable;

public class Profesor extends Usuario implements Serializable {

    public Profesor(int id_profesor, String usuario_id, String apellido1, String apellido2, String nombre, String telefono, String e_mail) {
        //el rol dos es profesor
        super(usuario_id, 2, "", 0, false);
        
        this.id_profesor = id_profesor;
        this.usuario_id = usuario_id;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.nombre = nombre;
        this.telefono = telefono;
        this.e_mail = e_mail;
    }
    
    public Profesor(int id_profesor, String usuario_id, String apellido1, String apellido2, String nombre, String telefono, String e_mail, String clave, int ultimo_acceso, boolean activo) {
        //el rol dos es profesor
        super(usuario_id, 2, clave, ultimo_acceso, activo);  
        
        this.id_profesor = id_profesor;
        this.usuario_id = usuario_id;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.nombre = nombre;
        this.telefono = telefono;
        this.e_mail = e_mail;
    }

    @Override
    public String toString() {
        return String.format("{%s, %s, %s, %s, %s, %s, %s}", getId_profesor(), getUsuario_id(), getApellido1(), getApellido2(), getNombre(), getTelefono(), getE_mail());
    }

    public int getId_profesor() {
        return id_profesor;
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

    private final int id_profesor;
    private final String usuario_id;
    private final String apellido1;
    private final String apellido2;
    private final String nombre;
    private final String telefono;
    private final String e_mail;
}
