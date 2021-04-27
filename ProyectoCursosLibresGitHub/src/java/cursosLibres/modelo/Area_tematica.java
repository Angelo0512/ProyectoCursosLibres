
package cursosLibres.modelo;

/**
 *
 * @authores Luis Restrepo V. Angelo Calvo M. Daniel Sánchez S.
 * @version 1.0
 */
public class Area_tematica {

    public Area_tematica(int id_area, String descripcion) {
        this.id_area = id_area;
        this.descripcion = descripcion;
    }

    public int getId_area() {
        return id_area;
    }

    public String getDescripcion() {
        return descripcion;
    }    
    
    private final int id_area;
    private final String descripcion;
}
