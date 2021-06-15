package dev.mathews.shared.repository;

import org.jetbrains.annotations.NotNull;

public interface Repository<K, V> {

    void insert(@NotNull K key, @NotNull V value);

    void delete(@NotNull K key);
}