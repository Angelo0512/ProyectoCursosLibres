package cursosLibres.modelo;

/**
 *
 * @authores Luis Restrepo V. Angelo Calvo M. Daniel Sánchez S.
 * @version 1.0
 */
public class Grupo {

    Grupo(int num_grupo, int curso_id, int profesor_id) {
        this.num_grupo = num_grupo;
        this.curso_id = curso_id;
        this.profesor_id = profesor_id;

    }

    public int getNum_grupo() {
        return num_grupo;
    }

    public int getCurso_id() {
        return curso_id;
    }

    public int getProfesor_id() {
        return profesor_id;
    }
    
    private final int num_grupo;
    private final int curso_id;
    private final int profesor_id;
}
