package dev.mathews.shared.transaction;

import dev.mathews.shared.entity.IEntitySubscription;
import dev.mathews.shared.transaction.type.TransactionState;
import dev.mathews.shared.transaction.type.TransactionType;

public interface ITransaction {

    void begin();

    void close();

    TransactionType getTransactionType();

    TransactionState getTransactionState();

    IEntitySubscription getTransactionSubscription();
}