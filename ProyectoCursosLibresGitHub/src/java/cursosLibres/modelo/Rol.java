package cursosLibres.modelo;

import java.io.Serializable;

public class Rol implements Serializable {

    public Rol(int id_rol, String descripcion) {
        this.id_rol = id_rol;
        this.descripcion = descripcion;
    }

    public int id_rol() {
        return id_rol;
    }

    public String descripcion() {
        return descripcion;
    }

    private final int id_rol;
    private final String descripcion;

}
