package dev.mathews.shared;

import dev.mathews.storage.database.StorageEntity;
import dev.mathews.storage.exception.ConnectionValidationException;
import dev.mathews.storage.factory.StorageFactory;

import javax.sql.DataSource;
import java.sql.SQLException;

public class SqlORM {

    private static final StorageFactory FACTORY = new StorageFactory();

    /**
     *
     * @param dataSource
     * @param storageEntity
     * @throws ConnectionValidationException
     * @throws SQLException
     */

    public static void create(DataSource dataSource, StorageEntity storageEntity)
      throws ConnectionValidationException, SQLException {
        FACTORY.createDefaultConnection(dataSource, storageEntity);
    }

    /**
     *
     * @param dataSource
     * @param storageEntity
     * @param testQuery
     * @throws ConnectionValidationException
     * @throws SQLException
     */

    public static void create(DataSource dataSource, StorageEntity storageEntity, boolean testQuery)
      throws ConnectionValidationException, SQLException {
        FACTORY.createDefaultConnection(dataSource, storageEntity, testQuery);
    }

    /**
     *
     * @throws SQLException
     */

    public static void closeConnection() throws SQLException {
        FACTORY.closeConnection();
    }

    /**
     *
     * @return
     */

    public DataSource getDataSource() {
        return FACTORY.getDataSource();
    }
}