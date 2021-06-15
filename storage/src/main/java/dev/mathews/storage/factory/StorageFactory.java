package dev.mathews.storage.factory;

import dev.mathews.storage.IStorage;
import dev.mathews.storage.database.StorageEntity;
import dev.mathews.storage.exception.ConnectionValidationException;
import dev.mathews.storage.validator.impl.ConnectionValidator;
import dev.mathews.storage.validator.IConnectionValidator;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.sql.DataSource;
import java.sql.SQLException;

@Getter
public class StorageFactory implements IStorage {

    private DataSource dataSource;
    private StorageEntity storageEntity;

    private final IConnectionValidator validator = new ConnectionValidator();

    @Override
    public void createDefaultConnection(@NotNull DataSource dataSource, @NotNull StorageEntity entity)
      throws ConnectionValidationException, SQLException {
        this.dataSource = dataSource;
        this.storageEntity = entity;

        validator.validate(dataSource);
    }

    @Override
    public void createDefaultConnection(
      @NotNull DataSource dataSource, @NotNull StorageEntity entity, boolean testQuery
    ) throws ConnectionValidationException, SQLException {
        if (testQuery) validator.testConnection(dataSource);

        validator.validate(dataSource);
    }

    @Override
    public void closeConnection() throws SQLException {
        dataSource.getConnection().close();
    }

    @Override
    public @Nullable
    DataSource getDataSource() {
        return dataSource;
    }
}