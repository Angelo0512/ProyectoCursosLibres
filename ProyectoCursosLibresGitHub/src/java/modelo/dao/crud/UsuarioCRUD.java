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
public class UsuarioCRUD extends AbstractCRUD{

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
            + "id_usuario, rol_id, clave, ultimo_aceso,_activo "
            + "FROM eif209_2021_01.usuario ORDER BY id_usuario; ";
    
    protected static final String ADD_CMD
            = "INSERT INTO eif209_2021_01.usuario "
            + "id_usuario, rol_id, clave, ultimo_aceso, activo "
            + "VALUES (?, ?, ?, ?, ?); ";
    protected static final String RETRIEVE_CMD
            = "SELECT "
            + "id_usuario, rol_id, clave, ultimo_aceso,_activo "
            + "FROM eif209_2021_01.usuario WHERE id_usuario = ?; ";
    protected static final String UPDATE_CMD
            = "UPDATE eif209_2021_01.usuario "
            + "SET rol_id = ?, clave = ?, ultimo_aceso = ?, activo = ?"
            + "WHERE id_usuario = ?; ";
    protected static final String DELETE_CMD
            = "DELETE FROM eif209_2021_01.usuario "
            + "WHERE id_usuario = ?; ";
}
