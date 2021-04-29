package modelo.dao.crud;

import cursolibres.db.dao.crud.AbstractCRUD;

/**
 *
 * @authores Luis Restrepo V. Angelo Calvo M. Daniel Sánchez S.
 * @version 1.0
 */
public class EstudianteCRUD extends AbstractCRUD {

    @Override
    public String getListAllCmd() {
        return LIST_CMD;
    }

    @Override
    public String getAddCmd() {
        return ADD_CMD;
    }

    @Override
    public String getRetrieveCmd() {
        return RETRIEVE_CMD;
    }

    @Override
    public String getUpdateCmd() {
        return UPDATE_CMD;
    }

    @Override
    public String getDeleteCmd() {
        return DELETE_CMD;
    } 
    
    protected static final String LIST_CMD
            = "SELECT "
            + "id_estudiante, usuario_id, apellido1, apellido2, nombre, telefono, e_mail "
            + "FROM eif209_2021_01.estudiante ORDER BY id_estudiante; ";
    
    protected static final String ADD_CMD
            = "INSERT INTO eif209_2021_01.estudiante "
            + "(id_estudiante, usuario_id, apellido1, apellido2, nombre, telefono, e_mail) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?); ";
    protected static final String RETRIEVE_CMD
            = "SELECT "
            + "id_estudiante, usuario_id, apellido1, apellido2, nombre, telefono, e_mail "
            + "FROM eif209_2021_01.estudiante WHERE id_estudiante = ?; ";
    protected static final String UPDATE_CMD
            = "UPDATE eif209_2021_01.estudiante "
            + "SET apellido1 = ?, apellido2 = ?, nombre = ?, telefono = ?, e_mail = ? "
            + "WHERE id_estudiante = ?; ";
    protected static final String DELETE_CMD
            = "DELETE FROM eif209_2021_01.estudiante "
            + "WHERE id_estudiante = ?; ";
}