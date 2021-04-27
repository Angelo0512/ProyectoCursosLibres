package cursosLibres.modelo;

import java.io.Serializable;

public class Usuario implements Serializable{

    public Usuario(String id_usuario, int rol_id, String clave, int ultimo_acceso, boolean activo) {
    this.id_usuario = id_usuario;
    this.rol_id = rol_id;
    this.clave = clave;
    this.ultimo_acceso = ultimo_acceso;
    this.activo = activo;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public int getRol_id() {
        return rol_id;
    }

    public String getClave() {
        return clave;
    }

    public int getUltimo_acceso() {
        return ultimo_acceso;
    }

    public boolean getActivo() {
        return activo;
    }
        
    private final String id_usuario;
    private final int rol_id;
    private final String clave;
    private final int ultimo_acceso;
    private final boolean activo;
}