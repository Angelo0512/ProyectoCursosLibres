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
public class GrupoCRUD extends AbstractCRUD{

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
            + "num_grupo, curso_id, profesor_id "
            + "FROM eif209_2021_01.grupo ORDER BY num_grupo; ";
    
    protected static final String ADD_CMD
            = "INSERT INTO eif209_2021_01.grupo "
            + "(num_grupo, curso_id, profesor_id) "
            + "VALUES (?, ?, ?); ";
    protected static final String RETRIEVE_CMD
            = "SELECT "
            + "num_grupo, curso_id, profesor_id "
            + "FROM eif209_2021_01.grupo WHERE num_grupo = ?; ";
    protected static final String UPDATE_CMD
            = "UPDATE eif209_2021_01.grupo "
            + "SET curso_id = ?, profesor_id = ?"
            + "WHERE num_grupo = ?; ";
    protected static final String DELETE_CMD
            = "DELETE FROM eif209_2021_01.grupo "
            + "WHERE num_grupo = ?; ";
}
