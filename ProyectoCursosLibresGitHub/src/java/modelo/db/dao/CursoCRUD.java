package modelo.db.dao;

import modelo.db.AbstractCRUD;

/**
 *
 * @authores Luis Restrepo V. Angelo Calvo M. Daniel Sánchez S.
 * @version 1.0
 */
public class CursoCRUD extends AbstractCRUD {

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
            = "SELECT id_curso, descripcion, area_tematica_id FROM curso ORDER BY id_curso; ";
    protected static final String CMD_ADD
            = "INSERT INTO curso (id_curso, descripcion, area_tematica_id) VALUES (?, ?, ?); ";
    protected static final String CMD_RETRIEVE
            = "SELECT id_curso, descripcion, area_tematica_id FROM curso WHERE id_curso=?; ";
    protected static final String CMD_UPDATE
            = "UPDATE curso SET descripcion=?, area_tematica_id=? WHERE id_curso=?; ";
    protected static final String CMD_DELETE
            = "DELETE FROM curso WHERE id_curso=?; ";
}