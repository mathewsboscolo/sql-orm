package dev.mathews.storage.database;

import dev.mathews.storage.database.type.StorageType;
import lombok.Data;

@Data
public class StorageCredentials {

    private final String host, database;
    private final String username, password;

    private final StorageType storageType;

    private final int port;
}