package modelo.db.dao;

import modelo.db.AbstractCRUD;

/**
 *
 * @authores Luis Restrepo V. Angelo Calvo M. Daniel Sánchez S.
 * @version 1.0
 */
public class Area_tematicaCRUD extends AbstractCRUD {

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
            = "SELECT id_area, descripcion FROM area_tematica "
            + "ORDER BY id_area, descripcion; ";
    protected static final String CMD_ADD
            = "INSERT INTO area_tematica (id_area, descripcion) "
            + "VALUES (?, ?); ";
    protected static final String CMD_RETRIEVE
            = "SELECT id_area, descripcion FROM area_tematica "
            + "WHERE id_area = ?; ";
    protected static final String CMD_UPDATE
            = "UPDATE area_tematica SET descripcion = ? "
            + "WHERE id_area = ?; ";
    protected static final String CMD_DELETE
            = "DELETE FROM area_tematica "
            + "WHERE id_area = ?; ";
}
