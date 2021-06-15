package dev.mathews.shared;

import dev.mathews.storage.database.StorageEntity;
import dev.mathews.storage.exception.ConnectionValidationException;
import dev.mathews.storage.factory.StorageFactory;

import javax.sql.DataSource;
import java.sql.SQLException;

public class SqlORM {

    private static final StorageFactory FACTORY = new StorageFactory();

    public static void create(DataSource dataSource, StorageEntity storageEntity)
      throws ConnectionValidationException, SQLException {
        FACTORY.createDefaultConnection(dataSource, storageEntity);
    }

    public static void create(DataSource dataSource, StorageEntity storageEntity, boolean testQuery)
      throws ConnectionValidationException, SQLException {
        FACTORY.createDefaultConnection(dataSource, storageEntity, testQuery);
    }

    public static void closeConnection() throws SQLException {
        FACTORY.closeConnection();
    }

    public DataSource getDataSource() {
        return FACTORY.getDataSource();
    }
}