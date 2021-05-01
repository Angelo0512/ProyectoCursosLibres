/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import cursolibres.db.dao.AbstractDAO;
import cursolibres.db.dao.crud.AbstractCRUD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.beans.Administrador;
import modelo.beans.Curso;
import modelo.beans.servicios.AdministradorCRUD;

/**
 *
 * @author Angelo
 */
public class AdministradorDAO  extends AbstractDAO<Integer, Administrador>{
    
    public AdministradorDAO() throws Exception {
        super(new AdministradorCRUD());
    }
    
    public AdministradorDAO(AbstractCRUD crud) throws Exception {
        super(crud);
    }
    
    @Override
    public Administrador getRecord(ResultSet rs)
            throws SQLException {
        return new Administrador(
                rs.getInt("id_administrador"),
                rs.getString("usuario_id"),
                rs.getString("apellido1"),
                rs.getString("apellido2"),
                rs.getString("nombre"),
                rs.getString("telefono"),
                rs.getString("e_mail"));
    }

    @Override
    public void setAddParameters(PreparedStatement stm,
            Integer id, Administrador a)
            throws SQLException {
        stm.setInt(1, id);
        stm.setString(2, a.getUsuario_id());
        stm.setString(3, a.getApellido1());
        stm.setString(4, a.getApellido2());
        stm.setString(5, a.getNombre());
        stm.setString(6, a.getTelefono());
        stm.setString(7, a.getE_mail());
    }

    @Override
    public void setUpdateParameters(PreparedStatement stm,
            Integer id, Administrador a)
            throws SQLException {
        stm.setString(1, a.getUsuario_id());
        stm.setString(2, a.getApellido1());
        stm.setString(3, a.getApellido2());
        stm.setString(4, a.getNombre());
        stm.setString(5, a.getTelefono());
        stm.setString(6, a.getE_mail());
        stm.setInt(7, id);
    }
}
