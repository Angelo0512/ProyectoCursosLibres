package cursosLibres.modelo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Usuario implements Serializable{

    public Usuario() {
    }

    public Usuario(String id_usuario, int rol_id, String clave, Date ultimo_acceso, boolean activo) {
        this.id_usuario = id_usuario;
        this.rol_id = rol_id;
        this.clave = clave;
        this.ultimo_acceso = ultimo_acceso;
        this.activo = activo;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getRol_id() {
        return rol_id;
    }

    public void setRol_id(int rol_id) {
        this.rol_id = rol_id;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Date getUltimo_acceso() {
        return ultimo_acceso;
    }

    public void setUltimo_acceso(Date ultimo_acceso) {
        this.ultimo_acceso = ultimo_acceso;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        
        String estado = "No activo";
        if(activo) estado = "Activo";
        
        return String.format("{%s, %d, %s, %s, %s}",
                getId_usuario(), getRol_id(),
                getClave(),
                new SimpleDateFormat("yyyy-MM-dd").format(getUltimo_acceso()),
                estado);
    }
    
    public String toStringHTML() {
        
        String estado = "No activo";
        if(activo) estado = "Activo";
        
        StringBuilder r = new StringBuilder();
        r.append("\t\t\t<tr>\n");

        r.append(String.format("\t\t\t\t<td>%d</td>\n", getId_usuario()));
        r.append(String.format("\t\t\t\t<td>%d</td>\n", getRol_id()));
        r.append(String.format("\t\t\t\t<td>&s</td>\n", new SimpleDateFormat("yyyy-MM-dd").format(getUltimo_acceso())));
        r.append(String.format("\t\t\t\t<td>&s</td>\n", estado));

        r.append("\t\t\t</tr>\n");
        return r.toString();
    }
        
    private String id_usuario;
    private int rol_id;
    private String clave;
    private java.util.Date ultimo_acceso;
    private boolean activo;
}