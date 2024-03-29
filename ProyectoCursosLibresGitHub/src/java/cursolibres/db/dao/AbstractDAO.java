package cursolibres.db.dao;

import cursolibres.db.dao.crud.AbstractCRUD;
import cursolibres.db.Database;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDAO<K, V> implements DAO<K, V> {

    public AbstractDAO(AbstractCRUD crud) {
        this.crud = crud;
    }

    @Override
    public List<V> listAll() throws SQLException, IOException {
        List<V> r = new ArrayList<>();
        try (Connection cnx = Database.getInstance().getConnection();
                Statement stm = cnx.createStatement();
                ResultSet rs = stm.executeQuery(getCRUD().getListAllCmd())) {
            while (rs.next()) {
                r.add(getRecord(rs));
            }
        }
        return r;
    }

    @Override
    public void add(K id, V value) throws SQLException, IOException {
        try (Connection cnx = Database.getInstance().getConnection();
                PreparedStatement stm = cnx.prepareStatement(getCRUD().getAddCmd())) {
            stm.clearParameters();
            setAddParameters(stm, id, value);
            if (stm.executeUpdate() != 1) {
                throw new IllegalArgumentException();
            }
        }
    }

    @Override
    public V retrieve(K id) throws SQLException, IOException {
        V r = null;
        try (Connection cnx = Database.getInstance().getConnection();
                PreparedStatement stm = cnx.prepareStatement(getCRUD().getRetrieveCmd())) {
            stm.clearParameters();
            stm.setObject(1, id);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    r = getRecord(rs);
                } else {
                    throw new IllegalArgumentException();
                }
            }
        }
        return r;
    }

    @Override
    public void update(K id, V value) throws SQLException, IOException {
        try (Connection cnx = Database.getInstance().getConnection();
                PreparedStatement stm = cnx.prepareStatement(getCRUD().getUpdateCmd())) {
            stm.clearParameters();
            setUpdateParameters(stm, id, value);
            if (stm.executeUpdate() != 1) {
                throw new IllegalArgumentException();
            }
        }
    }

    @Override
    public void delete(K id) throws SQLException, IOException {
        try (Connection cnx = Database.getInstance().getConnection();
                PreparedStatement stm = cnx.prepareStatement(getCRUD().getDeleteCmd())) {
            stm.clearParameters();
            stm.setObject(1, id);
            if (stm.executeUpdate() != 1) {
                throw new IllegalArgumentException();
            }
        }
    }

    public abstract V getRecord(ResultSet rs) throws SQLException;

    public abstract void setAddParameters(PreparedStatement stm, K id, V value)
            throws SQLException;

    public abstract void setUpdateParameters(PreparedStatement stm, K id, V value)
            throws SQLException;

    public AbstractCRUD getCRUD() {
        return crud;
    }

    private final AbstractCRUD crud;
}
