package cursolibres.db.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @authores Luis Restrepo V. Angelo Calvo M. Daniel Sánchez S.
 * @version 1.0
 */
public interface DAO<K, V> { // DAO (Data Access Object Interface)

    public List<V> listAll() throws SQLException, IOException;

    public void add(K id, V value) throws SQLException, IOException;

    public V retrieve(K id) throws SQLException, IOException;

    public void update(K id, V value) throws SQLException, IOException;

    public void delete(K id) throws SQLException, IOException;

}
