package modelo.db.dao;

import modelo.db.AbstractCRUD;

/**
 *
 * @authores Luis Restrepo V. Angelo Calvo M. Daniel Sánchez S.
 * @version 1.0
 */
public class EstudianteCRUD extends AbstractCRUD {

    @Override
    public String getListAllCmd() {
        return CMD_LIST;
    }

    @Override
    public String getAddCmd() {
        return CMD_ADD;
    }

    @Override
    public String getRetrieveCmd() {
        return CMD_RETRIEVE;
    }

    @Override
    public String getUpdateCmd() {
        return CMD_UPDATE;
    }

    @Override
    public String getDeleteCmd() {
        return CMD_DELETE;
    }

    protected static final String CMD_LIST
            = "SELECT id_estudiante, usuario_id, apellido1, apellido2, nombre, telefono, e_mail FROM estudiante ORDER BY apellido1; ";
    protected static final String CMD_ADD
            = "INSERT INTO estudiante (id_estudiante, usuario_id, apellido1, apellido2, nombre, telefono, e_mail) VALUES (?, ?, ?, ?, ?, ?, ?); ";
    protected static final String CMD_RETRIEVE
            = "SELECT id_estudiante, usuario_id, apellido1, apellido2, nombre, telefono, e_mail FROM estudiante WHERE id_estudiante=?; ";
    protected static final String CMD_UPDATE
            = "UPDATE estudiante SET apellido1=?, apellido2=?, nombre=?, telefono=?, e_mail=? WHERE id_estudiante=?; ";
    protected static final String CMD_DELETE
            = "DELETE FROM estudiante WHERE id_estudiante=?; ";
}