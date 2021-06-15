package dev.mathews.shared.transaction.service;

import dev.mathews.shared.entity.IEntitySubscription;
import dev.mathews.shared.transaction.ITransaction;
import dev.mathews.shared.transaction.type.TransactionType;
import org.jetbrains.annotations.NotNull;

import java.lang.annotation.Annotation;

public interface ITransactionService {

    /**
     *
     * @param subscription
     * @param type
     * @return
     */
    ITransaction create(@NotNull IEntitySubscription subscription, @NotNull TransactionType type);

    /**
     *
     * @param clazz
     * @param annotations
     * @return
     */
    ITransaction create(@NotNull Class<?> clazz, @NotNull Annotation[] annotations);

    /**
     *
     * @param clazz
     * @return
     */

    ITransaction findByClassSubscription(@NotNull Class<?> clazz);

    /**
     *
     * @param subscription
     * @return
     */

    ITransaction findBySubscription(@NotNull IEntitySubscription subscription);
}