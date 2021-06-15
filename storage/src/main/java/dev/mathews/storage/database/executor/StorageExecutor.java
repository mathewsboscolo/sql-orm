package dev.mathews.storage.database.executor;

import dev.mathews.storage.database.StorageEntity;
import lombok.NonNull;

@FunctionalInterface
public interface StorageExecutor {
    void apply(@NonNull StorageEntity storageEntity);
}