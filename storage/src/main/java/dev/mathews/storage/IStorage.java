package dev.mathews.storage;

import dev.mathews.storage.database.StorageEntity;
import dev.mathews.storage.exception.ConnectionValidationException;
import lombok.NonNull;

import javax.sql.DataSource;
import java.sql.SQLException;

public interface IStorage {

    /**
     *
     * @param dataSource
     * @param entity
     */

    void createDefaultConnection(@NonNull DataSource dataSource, @NonNull StorageEntity entity)
      throws ConnectionValidationException, SQLException;

    /**
     *
     * @param dataSource
     * @param entity
     * @param testQuery
     */

    void createDefaultConnection(@NonNull DataSource dataSource, @NonNull StorageEntity entity, boolean testQuery)
      throws ConnectionValidationException, SQLException;

    /**
     *
     */

    void closeConnection() throws SQLException;

    /**
     *
     * @return
     */

    DataSource getDataSource();
}