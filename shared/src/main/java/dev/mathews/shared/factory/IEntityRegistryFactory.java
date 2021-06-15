package dev.mathews.shared.factory;

import dev.mathews.shared.entity.IEntitySubscription;
import dev.mathews.shared.entity.IEntitySubscriptionService;
import dev.mathews.shared.executor.TransactionExecutor;
import org.jetbrains.annotations.NotNull;

public interface IEntityRegistryFactory {

    /**
     * meu pau
     * @return
     */

    @NotNull IEntitySubscriptionService createEntitySubscriptionService();

    /**
     *
     * @param clazz
     * @return
     */
    @NotNull
    IEntitySubscription createEntitySubscription(@NotNull Class<?> clazz);

    /**
     *
     * @param transaction
     * @param executor
     */

    void execute(@NotNull IEntitySubscription transaction, TransactionExecutor executor);

    /**
     *
     */

    void close();
}