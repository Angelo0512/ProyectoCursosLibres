package cursosLibres.modelo;

/**
 *
 * @authores Luis Restrepo V. Angelo Calvo M. Daniel Sánchez S.
 * @version 1.0
 */
public class Horario {

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

    public int getGrupo_num() {
        return grupo_num;
    }

    public int getCurso_id() {
        return curso_id;
    }

    public int getDia() {
        return dia;
    }

    public int getHora() {
        return hora;
    }

    private final int seq;
    private final int grupo_num;
    private final int curso_id;
    private final int dia;
    private final int hora;
}
