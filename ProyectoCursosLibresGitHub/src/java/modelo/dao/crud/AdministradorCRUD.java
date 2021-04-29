/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao.crud;

import cursolibres.db.dao.crud.AbstractCRUD;

/**
 *
 * @author Angelo
 */
public class AdministradorCRUD extends AbstractCRUD{

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
            + "id_administrador, usuario_id, apellido1, apellido2, nombre, telefono, e_mail "
            + "FROM eif209_2021_01.administrador ORDER BY id_administrador; ";
    
    protected static final String ADD_CMD
            = "INSERT INTO eif209_2021_01.administrador "
            + "(id_administrador, usuario_id, apellido1, apellido2, nombre, telefono, e_mail) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?); ";
    protected static final String RETRIEVE_CMD
            = "SELECT "
            + "id_administrador, usuario_id, apellido1, apellido2, nombre, telefono, e_mail "
            + "FROM eif209_2021_01.administrador WHERE id_administrador = ?; ";
    protected static final String UPDATE_CMD
            = "UPDATE eif209_2021_01.administrador "
            + "SET apellido1 = ?, apellido2 = ?, nombre = ?, telefono = ?, e_mail = ? "
            + "WHERE id_administrador = ?; ";
    protected static final String DELETE_CMD
            = "DELETE FROM eif209_2021_01.administrador "
            + "WHERE id_administrador = ?; ";
}
