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
public class MatriculaCRUD extends AbstractCRUD{

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
            + "estudiante_id, grupo_num, curso_id, estado_id, nota "
            + "FROM eif209_2021_01.matricula ORDER BY estudiante_id; ";
    
    protected static final String ADD_CMD
            = "INSERT INTO eif209_2021_01.matricula "
            + "(estudiante_id, grupo_num, curso_id, estado_id, nota) "
            + "VALUES (?, ?, ?, ?, ?); ";
    protected static final String RETRIEVE_CMD
            = "SELECT "
            + "estudiante_id, grupo_num, curso_id, estado_id, nota "
            + "FROM eif209_2021_01.matricula WHERE estudiante_id = ? and grupo_num = ?; ";
    protected static final String UPDATE_CMD
            = "UPDATE eif209_2021_01.matricula "
            + "SET grupo_num = ?, curso_id = ?, estado_id = ?, nota = ? "
            + "WHERE estudiante_id = ? and grupo_num = ? and curso_id = ?; ";
    protected static final String DELETE_CMD
            = "DELETE FROM eif209_2021_01.matricula "
            + "WHERE estudiante_id = ?; ";
}
