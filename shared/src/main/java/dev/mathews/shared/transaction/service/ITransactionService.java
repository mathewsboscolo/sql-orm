package dev.mathews.shared.transaction.service;

import dev.mathews.shared.entity.IEntitySubscription;
import dev.mathews.shared.transaction.ITransaction;
import dev.mathews.shared.transaction.type.TransactionType;
import org.jetbrains.annotations.NotNull;

import java.lang.annotation.Annotation;

public interface ITransactionService {

    ITransaction create(@NotNull IEntitySubscription subscription, @NotNull TransactionType type);

    ITransaction create(@NotNull Class<?> clazz, @NotNull Annotation[] annotations);

    ITransaction findByClassSubscription(@NotNull Class<?> clazz);

    ITransaction findBySubscription(@NotNull IEntitySubscription subscription);
}