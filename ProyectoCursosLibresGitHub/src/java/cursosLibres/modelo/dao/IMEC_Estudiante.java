package cursosLibres.modelo.dao;

public enum IMEC_Estudiante {
    INSERTAR("INSERT INTO estudiante (id_estudiante, usuario_id, apellido1, apellido2, nombre, telefono, e_mail) VALUES (?, ?, ?, ?, ?, ?, ?); "),
    MODIFICAR("UPDATE estudiante SET apellido1=?, apellido2=?, nombre=?, telefono=?, e_mail=? WHERE id_estudiante=?; "),
    EXCLUIR("DELETE FROM estudiante WHERE id_estudiante=?; "),
    CONSULTAR("SELECT id_estudiante, usuario_id, apellido1, apellido2, nombre, telefono, e_mail FROM estudiante WHERE id_estudiante=?; "),
    LISTAR("SELECT id_estudiante, usuario_id, apellido1, apellido2, nombre, telefono, e_mail FROM estudiante ORDER BY apellido1; ");

    IMEC_Estudiante(String comando) {
        this.comando = comando;
    }

    public String obtenerComando() {
        return comando;
    }

    private final String comando;
}
