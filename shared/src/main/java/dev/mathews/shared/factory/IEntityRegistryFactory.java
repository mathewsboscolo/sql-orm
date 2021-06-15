package dev.mathews.shared.factory;

import dev.mathews.shared.entity.IEntitySubscription;
import dev.mathews.shared.entity.IEntitySubscriptionService;
import dev.mathews.shared.executor.TransactionExecutor;
import org.jetbrains.annotations.NotNull;

public interface IEntityRegistryFactory {

    @NotNull IEntitySubscriptionService createEntitySubscriptionService();

    @NotNull
    IEntitySubscription createEntitySubscription(@NotNull Class<?> clazz);

    void execute(@NotNull IEntitySubscription transaction, TransactionExecutor executor);

    void close();
}