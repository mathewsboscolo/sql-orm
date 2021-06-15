package dev.mathews.shared.executor;

import dev.mathews.shared.transaction.ITransaction;

@FunctionalInterface
public interface TransactionExecutor {
    void apply(ITransaction transaction);
}
