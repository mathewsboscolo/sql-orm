package dev.mathews.shared.transaction;

import dev.mathews.shared.entity.IEntitySubscription;
import dev.mathews.shared.transaction.type.TransactionState;
import dev.mathews.shared.transaction.type.TransactionType;

public interface ITransaction {

    /**
     *  pau cria
     */

    void begin();

    /**
     * pau fecah
     */

    void close();

    /**
     * meu au
     * @return
     */
    TransactionType getTransactionType();

    /**
     * fodase
     * @return
     */

    TransactionState getTransactionState();

    /**
     * auau
     * @return
     */

    IEntitySubscription getTransactionSubscription();
}