package dev.mathews.storage.database;

import lombok.Data;
import javax.sql.DataSource;

@Data
public class StorageEntity {

    private final DataSource dataSource;
    private final StorageCredentials credentials;

    public StorageEntity(DataSource dataSource, StorageCredentials credentials) {
        this.dataSource = dataSource;
        this.credentials = credentials;
    }
}