package dev.mathews.storage.database.type;

import dev.mathews.storage.database.StorageCredentials;
import dev.mathews.storage.database.StorageEntity;
import dev.mathews.storage.database.executor.StorageExecutor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Getter
@RequiredArgsConstructor
public enum StorageType {

    MYSQL(
      "com.mysql.jdbc.Driver",
      configuration -> format("mysql", configuration)
    ),
    POSTGRESQL(
      "org.postgresql.Driver",
      configuration -> format("postgresql", configuration)
    );

    private final String driverClass;
    private final StorageExecutor storageExecutor;

    private static String format(@NotNull String driver, @NotNull StorageEntity storageEntity) {
        final StorageCredentials credentials = storageEntity.getCredentials();

        return String.format("jdbc:%s::/%s:%d/%s",
          driver, credentials.getHost(),
          credentials.getPort(),
          credentials.getDatabase()
        );
    }
}
